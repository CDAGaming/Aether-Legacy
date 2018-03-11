package com.legacy.aether.world.gen;

import com.google.common.collect.Sets;
import com.legacy.aether.world.gen.components.ComponentBronzeDungeon;
import com.legacy.aether.world.gen.components.ComponentBronzeDungeonRoom;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureStart;

import java.util.Random;
import java.util.Set;

public class MapGenBronzeDungeon extends MapGenStructure {

    public MapGenBronzeDungeon() {
    }

    @Override
    public String getStructureName() {
        return "aether_legacy:bronze_dungeon";
    }

    @Override
    public BlockPos getNearestStructurePos(World worldIn, BlockPos pos, boolean findUnexplored) {
        this.world = worldIn;

        int j = pos.getX() >> 4;
        int k = pos.getZ() >> 4;

        for (int l = 0; l <= 1000; ++l) {
            for (int i1 = -l; i1 <= l; ++i1) {
                boolean flag = i1 == -l || i1 == l;

                for (int j1 = -l; j1 <= l; ++j1) {
                    boolean flag1 = j1 == -l || j1 == l;

                    if (flag || flag1) {
                        int k1 = j + i1;
                        int l1 = k + j1;

                        if (this.canSpawnStructureAtCoords(k1, l1) && (!findUnexplored || !worldIn.isChunkGeneratedAt(k1, l1))) {
                            return new BlockPos((k1 << 4) + 8, 64, (l1 << 4) + 8);
                        }
                    }
                }
            }
        }

        return null;
    }

    @Override
    protected boolean canSpawnStructureAtCoords(int chunkX, int chunkZ) {
        return this.rand.nextInt(2) == 0;
    }

    @Override
    protected StructureStart getStructureStart(int chunkX, int chunkZ) {
        return new Start(this.world, this.rand, chunkX, chunkZ);
    }

    public static class Start extends StructureStart {
        private final Set<ChunkPos> processed = Sets.<ChunkPos>newHashSet();
        private boolean wasCreated;

        private int firstStaircaseZ, secondStaircaseZ, finalStaircaseZ;
        private int xTendency, zTendency;

        public Start() {
        }

        public Start(World worldIn, Random random, int chunkX, int chunkZ) {
            super(chunkX, chunkZ);
            this.create(worldIn, random, chunkX, chunkZ);
        }

        private void create(World worldIn, Random random, int chunkX, int chunkZ) {
            random.setSeed(worldIn.getSeed());
            long i = random.nextLong();
            long j = random.nextLong();
            long k = (long) chunkX * i;
            long l = (long) chunkZ * j;
            random.setSeed(k ^ l ^ worldIn.getSeed());

            ComponentBronzeDungeon dungeon = new ComponentBronzeDungeon((chunkX << 4) + 2, random.nextInt(42) + 22, (chunkZ << 4) + 2);

            ComponentBronzeDungeonRoom firstRoom = new ComponentBronzeDungeonRoom((chunkX << 4) + 2, dungeon.getBoundingBox().minY, (chunkZ << 4) + 2, 30, 10, 12, 0);
            ComponentBronzeDungeonRoom secondRoom = new ComponentBronzeDungeonRoom((chunkX << 4) + 2, dungeon.getBoundingBox().minY, (chunkZ << 4) + 2, firstRoom.xOffset, firstRoom.yOffset, firstRoom.zOffset, 0);
            ComponentBronzeDungeonRoom thirdRoom = new ComponentBronzeDungeonRoom((chunkX << 4) + 2, dungeon.getBoundingBox().minY, (chunkZ << 4) + 2, secondRoom.xOffset, secondRoom.yOffset, secondRoom.zOffset, 0);
            ComponentBronzeDungeonRoom fourthRoom = new ComponentBronzeDungeonRoom((chunkX << 4) + 2, dungeon.getBoundingBox().minY, (chunkZ << 4) + 2, thirdRoom.xOffset, thirdRoom.yOffset, thirdRoom.zOffset, 0);

            this.components.add(dungeon);
            this.components.add(firstRoom);
            this.components.add(secondRoom);
            this.components.add(thirdRoom);
            this.components.add(fourthRoom);

            /*ComponentSilverDungeon dungeon = new ComponentSilverDungeon((chunkX << 4) + 2, (chunkZ << 4) + 2);

            this.firstStaircaseZ = random.nextInt(3);
            this.secondStaircaseZ = random.nextInt(3);
            this.finalStaircaseZ = random.nextInt(3);

            this.xTendency = random.nextInt(3) - 1;
            this.zTendency = random.nextInt(3) - 1;

            dungeon.setStaircasePosition(this.firstStaircaseZ, this.secondStaircaseZ, this.finalStaircaseZ);
            dungeon.setCloudTendencies(this.xTendency, this.zTendency);

            this.components.add(dungeon);*/
            this.updateBoundingBox();
            this.wasCreated = true;
        }

        @Override
        public void generateStructure(World worldIn, Random rand, StructureBoundingBox structurebb) {
            if (!this.wasCreated) {
                this.components.clear();
                this.create(worldIn, rand, this.getChunkPosX(), this.getChunkPosZ());
            }

            super.generateStructure(worldIn, rand, structurebb);
        }

        @Override
        public boolean isValidForPostProcess(ChunkPos pair) {
            return this.processed.contains(pair) ? false : super.isValidForPostProcess(pair);
        }

        @Override
        public void notifyPostProcessAt(ChunkPos pair) {
            super.notifyPostProcessAt(pair);
            this.processed.add(pair);
        }

        @Override
        public void writeToNBT(NBTTagCompound tagCompound) {
            super.writeToNBT(tagCompound);

            NBTTagList nbttaglist = new NBTTagList();

            for (ChunkPos chunkpos : this.processed) {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setInteger("X", chunkpos.x);
                nbttagcompound.setInteger("Z", chunkpos.z);
                nbttaglist.appendTag(nbttagcompound);
            }

            tagCompound.setTag("Processed", nbttaglist);

            tagCompound.setInteger("firstStaircaseZ", this.firstStaircaseZ);
            tagCompound.setInteger("secondStaircaseZ", this.secondStaircaseZ);
            tagCompound.setInteger("finalStaircaseZ", this.finalStaircaseZ);
            tagCompound.setInteger("xTendency", this.xTendency);
            tagCompound.setInteger("zTendency", this.zTendency);
        }

        @Override
        public void readFromNBT(NBTTagCompound tagCompound) {
            super.readFromNBT(tagCompound);

            if (tagCompound.hasKey("Processed", 9)) {
                NBTTagList nbttaglist = tagCompound.getTagList("Processed", 10);

                for (int i = 0; i < nbttaglist.tagCount(); ++i) {
                    NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
                    this.processed.add(new ChunkPos(nbttagcompound.getInteger("X"), nbttagcompound.getInteger("Z")));
                }
            }

            this.firstStaircaseZ = tagCompound.getInteger("firstStaircaseZ");
            this.secondStaircaseZ = tagCompound.getInteger("secondStaircaseZ");
            this.finalStaircaseZ = tagCompound.getInteger("finalStaircaseZ");
            this.xTendency = tagCompound.getInteger("zTendency");
            this.zTendency = tagCompound.getInteger("zTendency");
        }

    }

}
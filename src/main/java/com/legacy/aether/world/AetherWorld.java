package com.legacy.aether.world;

import com.legacy.aether.AetherConfig;
import com.legacy.aether.world.biome.AetherBiome;
import com.legacy.aether.world.gen.*;
import com.legacy.aether.world.gen.components.*;
import net.minecraft.world.DimensionType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.structure.MapGenStructureIO;
import net.minecraftforge.common.DimensionManager;

public class AetherWorld
{

	public static Biome aether_biome = new AetherBiome();

	public static DimensionType aether_dimension_type;

	public static void initialization()
	{
		MapGenStructureIO.registerStructure(MapGenBronzeDungeon.Start.class, "aether_legacy:bronze_dungeon_start");
		MapGenStructureIO.registerStructure(MapGenSilverDungeon.Start.class, "aether_legacy:silver_dungeon_start");
		MapGenStructureIO.registerStructure(MapGenGoldenDungeon.Start.class, "aether_legacy:golden_dungeon_start");

		MapGenStructureIO.registerStructure(MapGenColdAercloud.Start.class, "aether_legacy:cold_aercloud_start");
		MapGenStructureIO.registerStructure(MapGenBlueAercloud.Start.class, "aether_legacy:blue_aercloud_start");
		MapGenStructureIO.registerStructure(MapGenGoldenAercloud.Start.class, "aether_legacy:golden_aercloud_start");

		MapGenStructureIO.registerStructureComponent(ComponentColdAercloud.class, "aether_legacy:cold_aercloud_component");
		MapGenStructureIO.registerStructureComponent(ComponentBlueAercloud.class, "aether_legacy:blue_aercloud_component");
		MapGenStructureIO.registerStructureComponent(ComponentGoldenAercloud.class, "aether_legacy:golden_aercloud_component");

		MapGenStructureIO.registerStructureComponent(ComponentBronzeDungeon.class, "aether_legacy:bronze_dungeon_component");
		MapGenStructureIO.registerStructureComponent(ComponentBronzeDungeonRoom.class, "aether_legacy:bronze_dungeon_room_component");

		MapGenStructureIO.registerStructureComponent(ComponentSilverDungeon.class, "aether_legacy:silver_dungeon_component");

		MapGenStructureIO.registerStructureComponent(ComponentGoldenDungeon.class, "aether_legacy:golden_dungeon_component");
		MapGenStructureIO.registerStructureComponent(ComponentGoldenIsland.class, "aether_legacy:golden_island_component");
		MapGenStructureIO.registerStructureComponent(ComponentGoldenIsland.class, "aether_legacy:golden_island_component");
		MapGenStructureIO.registerStructureComponent(ComponentGoldenIslandStub.class, "aether_legacy:golden_island_stub_component");

		aether_dimension_type = DimensionType.register("AetherI", "_aetherI", AetherConfig.getAetherDimensionID(), AetherWorldProvider.class, false);

		DimensionManager.registerDimension(AetherConfig.getAetherDimensionID(), aether_dimension_type);
	}

}
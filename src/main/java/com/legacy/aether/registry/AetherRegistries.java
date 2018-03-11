package com.legacy.aether.registry;

import com.legacy.aether.api.accessories.AccessoryType;
import com.legacy.aether.api.accessories.AetherAccessory;
import com.legacy.aether.api.enchantments.AetherEnchantment;
import com.legacy.aether.api.enchantments.AetherEnchantmentFuel;
import com.legacy.aether.api.freezables.AetherFreezable;
import com.legacy.aether.api.freezables.AetherFreezableFuel;
import com.legacy.aether.blocks.BlocksAether;
import com.legacy.aether.items.ItemsAether;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.registries.IForgeRegistry;

public class AetherRegistries {

    public static IForgeRegistry<IRecipe> craftingRegistry;

    public static void initializeAccessories(IForgeRegistry<AetherAccessory> registry) {
        registry.register(new AetherAccessory(ItemsAether.leather_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.iron_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.golden_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.chain_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.diamond_gloves, AccessoryType.GLOVE));

        registry.register(new AetherAccessory(ItemsAether.zanite_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.gravitite_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.neptune_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.phoenix_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.obsidian_gloves, AccessoryType.GLOVE));
        registry.register(new AetherAccessory(ItemsAether.valkyrie_gloves, AccessoryType.GLOVE));

        registry.register(new AetherAccessory(ItemsAether.iron_ring, AccessoryType.RING));
        registry.register(new AetherAccessory(ItemsAether.golden_ring, AccessoryType.RING));
        registry.register(new AetherAccessory(ItemsAether.zanite_ring, AccessoryType.RING));
        registry.register(new AetherAccessory(ItemsAether.ice_ring, AccessoryType.RING));

        registry.register(new AetherAccessory(ItemsAether.iron_pendant, AccessoryType.PENDANT));
        registry.register(new AetherAccessory(ItemsAether.golden_pendant, AccessoryType.PENDANT));
        registry.register(new AetherAccessory(ItemsAether.zanite_pendant, AccessoryType.PENDANT));
        registry.register(new AetherAccessory(ItemsAether.ice_pendant, AccessoryType.PENDANT));

        registry.register(new AetherAccessory(ItemsAether.red_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.blue_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.yellow_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.white_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.swet_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.invisibility_cape, AccessoryType.CAPE));
        registry.register(new AetherAccessory(ItemsAether.agility_cape, AccessoryType.CAPE));

        registry.register(new AetherAccessory(ItemsAether.golden_feather, AccessoryType.MISC));
        registry.register(new AetherAccessory(ItemsAether.regeneration_stone, AccessoryType.MISC));
        registry.register(new AetherAccessory(ItemsAether.iron_bubble, AccessoryType.MISC));

        registry.register(new AetherAccessory(ItemsAether.repulsion_shield, AccessoryType.SHIELD));
    }

    public static void initializeEnchantments(IForgeRegistry<AetherEnchantment> registry) {
        registry.register(new AetherEnchantment(ItemsAether.skyroot_pickaxe, 225));
        registry.register(new AetherEnchantment(ItemsAether.skyroot_axe, 225));
        registry.register(new AetherEnchantment(ItemsAether.skyroot_shovel, 225));
        registry.register(new AetherEnchantment(ItemsAether.skyroot_sword, 225));

        registry.register(new AetherEnchantment(ItemsAether.holystone_pickaxe, 550));
        registry.register(new AetherEnchantment(ItemsAether.holystone_axe, 550));
        registry.register(new AetherEnchantment(ItemsAether.holystone_shovel, 550));
        registry.register(new AetherEnchantment(ItemsAether.holystone_sword, 550));

        registry.register(new AetherEnchantment(ItemsAether.zanite_pickaxe, 2250));
        registry.register(new AetherEnchantment(ItemsAether.zanite_axe, 2250));
        registry.register(new AetherEnchantment(ItemsAether.zanite_shovel, 2250));
        registry.register(new AetherEnchantment(ItemsAether.zanite_sword, 2250));

        registry.register(new AetherEnchantment(ItemsAether.gravitite_pickaxe, 5500));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_axe, 5500));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_shovel, 5500));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_sword, 5500));

        registry.register(new AetherEnchantment(ItemsAether.zanite_helmet, 6000));
        registry.register(new AetherEnchantment(ItemsAether.zanite_chestplate, 6000));
        registry.register(new AetherEnchantment(ItemsAether.zanite_leggings, 6000));
        registry.register(new AetherEnchantment(ItemsAether.zanite_boots, 6000));

        registry.register(new AetherEnchantment(ItemsAether.gravitite_helmet, 13000));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_chestplate, 13000));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_leggings, 13000));
        registry.register(new AetherEnchantment(ItemsAether.gravitite_boots, 13000));

        registry.register(new AetherEnchantment(ItemsAether.dart, new ItemStack(ItemsAether.dart, 1, 2), 250));
        registry.register(new AetherEnchantment(ItemsAether.dart_shooter, new ItemStack(ItemsAether.dart_shooter, 1, 2), 500));

        registry.register(new AetherEnchantment(new ItemStack(ItemsAether.skyroot_bucket, 1, 2), new ItemStack(ItemsAether.skyroot_bucket, 1, 3), 1000));

        registry.register(new AetherEnchantment(BlocksAether.holystone, ItemsAether.healing_stone, 750));
        registry.register(new AetherEnchantment(BlocksAether.gravitite_ore, BlocksAether.enchanted_gravitite, 1000));
        registry.register(new AetherEnchantment(BlocksAether.quicksoil, BlocksAether.quicksoil_glass, 250));

        registry.register(new AetherEnchantment(ItemsAether.blue_berry, ItemsAether.enchanted_blueberry, 300));

        registry.register(new AetherEnchantment(Items.BOW, 4000));
        registry.register(new AetherEnchantment(Items.FISHING_ROD, 600));

        registry.register(new AetherEnchantment(Items.RECORD_11, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_13, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_BLOCKS, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_CAT, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_FAR, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_MALL, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_MELLOHI, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_STAL, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_STRAD, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_WAIT, ItemsAether.aether_tune, 2500));
        registry.register(new AetherEnchantment(Items.RECORD_WARD, ItemsAether.aether_tune, 2500));

        registry.register(new AetherEnchantment(Items.WOODEN_PICKAXE, 225));
        registry.register(new AetherEnchantment(Items.WOODEN_AXE, 225));
        registry.register(new AetherEnchantment(Items.WOODEN_SHOVEL, 225));
        registry.register(new AetherEnchantment(Items.WOODEN_HOE, 225));

        registry.register(new AetherEnchantment(Items.STONE_PICKAXE, 550));
        registry.register(new AetherEnchantment(Items.STONE_AXE, 550));
        registry.register(new AetherEnchantment(Items.STONE_SHOVEL, 550));
        registry.register(new AetherEnchantment(Items.STONE_HOE, 550));

        registry.register(new AetherEnchantment(Items.IRON_PICKAXE, 2250));
        registry.register(new AetherEnchantment(Items.IRON_AXE, 2250));
        registry.register(new AetherEnchantment(Items.IRON_SHOVEL, 2250));
        registry.register(new AetherEnchantment(Items.IRON_HOE, 2250));

        registry.register(new AetherEnchantment(Items.DIAMOND_PICKAXE, 5500));
        registry.register(new AetherEnchantment(Items.DIAMOND_AXE, 5500));
        registry.register(new AetherEnchantment(Items.DIAMOND_SHOVEL, 5500));
        registry.register(new AetherEnchantment(Items.DIAMOND_HOE, 5500));

        registry.register(new AetherEnchantment(Items.LEATHER_HELMET, 550));
        registry.register(new AetherEnchantment(Items.LEATHER_CHESTPLATE, 550));
        registry.register(new AetherEnchantment(Items.LEATHER_LEGGINGS, 550));
        registry.register(new AetherEnchantment(Items.LEATHER_BOOTS, 550));

        registry.register(new AetherEnchantment(Items.IRON_HELMET, 6000));
        registry.register(new AetherEnchantment(Items.IRON_CHESTPLATE, 6000));
        registry.register(new AetherEnchantment(Items.IRON_LEGGINGS, 6000));
        registry.register(new AetherEnchantment(Items.IRON_BOOTS, 6000));

        registry.register(new AetherEnchantment(Items.GOLDEN_HELMET, 2250));
        registry.register(new AetherEnchantment(Items.GOLDEN_CHESTPLATE, 2250));
        registry.register(new AetherEnchantment(Items.GOLDEN_LEGGINGS, 2250));
        registry.register(new AetherEnchantment(Items.GOLDEN_BOOTS, 2250));

        registry.register(new AetherEnchantment(Items.CHAINMAIL_HELMET, 2250));
        registry.register(new AetherEnchantment(Items.CHAINMAIL_CHESTPLATE, 2250));
        registry.register(new AetherEnchantment(Items.CHAINMAIL_LEGGINGS, 2250));
        registry.register(new AetherEnchantment(Items.CHAINMAIL_BOOTS, 2250));

        registry.register(new AetherEnchantment(Items.DIAMOND_HELMET, 10000));
        registry.register(new AetherEnchantment(Items.DIAMOND_CHESTPLATE, 10000));
        registry.register(new AetherEnchantment(Items.DIAMOND_LEGGINGS, 10000));
        registry.register(new AetherEnchantment(Items.DIAMOND_BOOTS, 10000));
    }

    public static void initializeEnchantmentFuel(IForgeRegistry<AetherEnchantmentFuel> registry) {
        registry.register(new AetherEnchantmentFuel(ItemsAether.ambrosium_shard, 500));
    }

    public static void initializeFreezables(IForgeRegistry<AetherFreezable> registry) {
        registry.register(new AetherFreezable(BlocksAether.aercloud, new ItemStack(BlocksAether.aercloud, 1, 1), 100));
        registry.register(new AetherFreezable(BlocksAether.aether_leaves, BlocksAether.crystal_leaves, 150));
        registry.register(new AetherFreezable(new ItemStack(ItemsAether.skyroot_bucket, 1, 1), Blocks.ICE, 500));
        registry.register(new AetherFreezable(ItemsAether.ascending_dawn, ItemsAether.welcoming_skies, 800));
        registry.register(new AetherFreezable(Blocks.ICE, Blocks.PACKED_ICE, 750));
        registry.register(new AetherFreezable(Items.WATER_BUCKET, Blocks.ICE, 500));
        registry.register(new AetherFreezable(Items.LAVA_BUCKET, Blocks.OBSIDIAN, 500));
        registry.register(new AetherFreezable(ItemsAether.iron_ring, ItemsAether.ice_ring, 2500));
        registry.register(new AetherFreezable(ItemsAether.golden_ring, ItemsAether.ice_ring, 2500));
        registry.register(new AetherFreezable(ItemsAether.iron_pendant, ItemsAether.ice_pendant, 2500));
        registry.register(new AetherFreezable(ItemsAether.golden_pendant, ItemsAether.ice_pendant, 2500));
    }

    public static void initializeFreezableFuel(IForgeRegistry<AetherFreezableFuel> registry) {
        registry.register(new AetherFreezableFuel(BlocksAether.icestone, 500));
    }

    public static void registerRecipes() {
        //initializeRecipes();
        //initializeShapelessRecipes();

        FurnaceRecipes.instance().addSmeltingRecipeForBlock(BlocksAether.aether_log, new ItemStack(Items.COAL, 1, 1), 0.15F);
    }

	/*private static void initializeShapelessRecipes()
	{
		registerShapeless("blue_cape", new ItemStack(ItemsAether.blue_cape), Ingredient.fromItem(ItemsAether.white_cape), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 4)));
		registerShapeless("red_cape", new ItemStack(ItemsAether.red_cape), Ingredient.fromItem(ItemsAether.white_cape), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 1)));
		registerShapeless("yellow_cape", new ItemStack(ItemsAether.yellow_cape), Ingredient.fromItem(ItemsAether.white_cape), Ingredient.fromStacks(new ItemStack(Items.DYE, 1, 11)));
		registerShapeless("poison_dart_shooter", new ItemStack(ItemsAether.dart_shooter, 1, 1), Ingredient.fromStacks(new ItemStack(ItemsAether.dart_shooter, 1, 0), new ItemStack(ItemsAether.skyroot_bucket, 1, 2)));
		registerShapeless("purple_dye", new ItemStack(Items.DYE, 2, 5), Ingredient.fromItem(Item.getItemFromBlock(BlocksAether.purple_flower)));
		registerShapeless("skyroot_plank", new ItemStack(BlocksAether.skyroot_plank, 4), Ingredient.fromItem(Item.getItemFromBlock(BlocksAether.aether_log)));
	}

	private static void initializeRecipes()
	{
		register("nature_staf", new ItemStack(ItemsAether.nature_staff), "Y", "X", 'Y', ItemsAether.zanite_gemstone, 'X', ItemsAether.skyroot_stick);
		register("skyroot_stick", new ItemStack(ItemsAether.skyroot_stick, 4), "X", "X", 'X', BlocksAether.skyroot_plank);
		register("trapdoor", new ItemStack(Blocks.TRAPDOOR, 2), "XXX", "XXX", 'X', BlocksAether.skyroot_plank);
		register("holystone_brick", new ItemStack(BlocksAether.holystone_brick, 4), "XX", "XX", 'X', BlocksAether.holystone);
		register("zanite_block", new ItemStack(BlocksAether.zanite_block), "XXX", "XXX", "XXX", 'X', ItemsAether.zanite_gemstone);
		register("zanite_gemstone", new ItemStack(ItemsAether.zanite_gemstone, 9), "X", 'X', BlocksAether.zanite_block);
		register("golden_dart_shooter", new ItemStack(ItemsAether.dart_shooter, 1), "X  ", " Y ", "  Y", 'X', ItemsAether.golden_amber, 'Y', BlocksAether.skyroot_plank);
		register("golden_dart", new ItemStack(ItemsAether.dart, 1), "X", "Y", "Z", 'X', Items.FEATHER, 'Y', ItemsAether.skyroot_stick, 'Z', ItemsAether.golden_amber);
		//register(new ItemStack(ItemsAether.dart_shooter, 1, 1), "X", "Y", 'X', new ItemStack(ItemsAether.dart_shooter, 1), 'Y', new ItemStack(ItemsAether.skyroot_bucket, 1, 2));
		register("poison_dart", new ItemStack(ItemsAether.dart, 8, 1), "XXX", "XYX", "XXX", 'X', new ItemStack(ItemsAether.dart, 1), 'Y', new ItemStack(ItemsAether.skyroot_bucket, 1, 2));
		register("incubator", new ItemStack(BlocksAether.incubator), "XXX", "XZX", "XXX", 'X', BlocksAether.holystone, 'Z', BlocksAether.ambrosium_torch);
		register("freezer", new ItemStack(BlocksAether.freezer), "XXX", "XYX", "ZZZ", 'X', BlocksAether.holystone, 'Y', BlocksAether.icestone, 'Z', BlocksAether.skyroot_plank);
		register("enchanter", new ItemStack(BlocksAether.enchanter), "XXX", "XYX", "XXX", 'X', BlocksAether.holystone, 'Y', ItemsAether.zanite_gemstone);
		register("ladder", new ItemStack(Blocks.LADDER, 4), "X X", "XXX", "X X", 'X', ItemsAether.skyroot_stick);
		register("jukebox", new ItemStack(Blocks.JUKEBOX), "XXX", "XYX", "XXX", 'X', BlocksAether.skyroot_plank, 'Y', BlocksAether.enchanted_gravitite);
		register("oak_door", new ItemStack(Items.OAK_DOOR, 3), "XX", "XX", "XX", 'X', BlocksAether.skyroot_plank);
		register("sign", new ItemStack(Items.SIGN, 3), "XXX", "XXX", " Y ", 'X', BlocksAether.skyroot_plank, 'Y', ItemsAether.skyroot_stick);
		register("ambrosium_torch", new ItemStack(BlocksAether.ambrosium_torch, 2), "Z", "Y", 'Z', ItemsAether.ambrosium_shard, 'Y', ItemsAether.skyroot_stick);
        register("lead", new ItemStack(Items.LEAD, 2), new Object[] {"YY ", "YX ", "  Y", 'Y', Items.STRING, 'X', ItemsAether.swetty_ball});
		
		register("cloud_parachute", new ItemStack(ItemsAether.cloud_parachute, 1), "XX", "XX", 'X', new ItemStack(BlocksAether.aercloud, 1));
		register("golden_parachute", new ItemStack(ItemsAether.golden_parachute, 1), "XX", "XX", 'X', new ItemStack(BlocksAether.aercloud, 1, 2));
		register("saddle", new ItemStack(Items.SADDLE, 1), "XXX", "XZX", 'X', Items.LEATHER, 'Z', Items.STRING);
		register("chest", new ItemStack(Blocks.CHEST, 1), "XXX", "X X", "XXX", 'X', BlocksAether.skyroot_plank);
		register("skyroot_bucket", new ItemStack(ItemsAether.skyroot_bucket, 1, 0), "Z Z", " Z ", 'Z', BlocksAether.skyroot_plank);
		register("crafting_table", new ItemStack(Blocks.CRAFTING_TABLE, 1), "XX", "XX", 'X', BlocksAether.skyroot_plank);

		register("gravitite_helmet", new ItemStack(ItemsAether.gravitite_helmet, 1), "XXX", "X X", 'X', BlocksAether.enchanted_gravitite);
		register("gravitite_chestplate", new ItemStack(ItemsAether.gravitite_chestplate, 1), "X X", "XXX", "XXX", 'X', BlocksAether.enchanted_gravitite);
		register("gravitite_leggings", new ItemStack(ItemsAether.gravitite_leggings, 1), "XXX", "X X", "X X", 'X', BlocksAether.enchanted_gravitite);
		register("gravitite_boots", new ItemStack(ItemsAether.gravitite_boots, 1), "X X", "X X", 'X', BlocksAether.enchanted_gravitite);
		register("zanite_helmet", new ItemStack(ItemsAether.zanite_helmet, 1), "XXX", "X X", 'X', ItemsAether.zanite_gemstone);
		register("zanite_chestplate", new ItemStack(ItemsAether.zanite_chestplate, 1), "X X", "XXX", "XXX", 'X', ItemsAether.zanite_gemstone);
		register("zanite_leggings", new ItemStack(ItemsAether.zanite_leggings, 1), "XXX", "X X", "X X", 'X', ItemsAether.zanite_gemstone);
		register("zanite_boots", new ItemStack(ItemsAether.zanite_boots, 1), "X X", "X X", 'X', ItemsAether.zanite_gemstone);

		register("skyroot_pickaxe", new ItemStack(ItemsAether.skyroot_pickaxe, 1), "ZZZ", " Y ", " Y ", 'Z', BlocksAether.skyroot_plank, 'Y', ItemsAether.skyroot_stick);
		register("holystone_pickaxe", new ItemStack(ItemsAether.holystone_pickaxe, 1), "ZZZ", " Y ", " Y ", 'Z', BlocksAether.holystone, 'Y', ItemsAether.skyroot_stick);
		register("zanite_pickaxe", new ItemStack(ItemsAether.zanite_pickaxe, 1), "ZZZ", " Y ", " Y ", 'Z', ItemsAether.zanite_gemstone, 'Y', ItemsAether.skyroot_stick);
		register("gravitite_pickaxe", new ItemStack(ItemsAether.gravitite_pickaxe, 1), "ZZZ", " Y ", " Y ", 'Z', BlocksAether.enchanted_gravitite, 'Y', ItemsAether.skyroot_stick);
		register("skyroot_axe", new ItemStack(ItemsAether.skyroot_axe, 1), "ZZ", "ZY", " Y", 'Z', BlocksAether.skyroot_plank, 'Y', ItemsAether.skyroot_stick);
		register("holystone_axe", new ItemStack(ItemsAether.holystone_axe, 1), "ZZ", "ZY", " Y", 'Z', BlocksAether.holystone, 'Y', ItemsAether.skyroot_stick);
		register("zanite_axe", new ItemStack(ItemsAether.zanite_axe, 1), "ZZ", "ZY", " Y", 'Z', ItemsAether.zanite_gemstone, 'Y', ItemsAether.skyroot_stick);
		register("gravitite_axe", new ItemStack(ItemsAether.gravitite_axe, 1), "ZZ", "ZY", " Y", 'Z', BlocksAether.enchanted_gravitite, 'Y', ItemsAether.skyroot_stick);
		register("skyroot_shovel", new ItemStack(ItemsAether.skyroot_shovel, 1), "Z", "Y", "Y", 'Z', BlocksAether.skyroot_plank, 'Y', ItemsAether.skyroot_stick);
		register("holystone_shovel", new ItemStack(ItemsAether.holystone_shovel, 1), "Z", "Y", "Y", 'Z', BlocksAether.holystone, 'Y', ItemsAether.skyroot_stick);
		register("zanite_shovel", new ItemStack(ItemsAether.zanite_shovel, 1), "Z", "Y", "Y", 'Z', ItemsAether.zanite_gemstone, 'Y', ItemsAether.skyroot_stick);
		register("gravitite_shovel", new ItemStack(ItemsAether.gravitite_shovel, 1), "Z", "Y", "Y", 'Z', BlocksAether.enchanted_gravitite, 'Y', ItemsAether.skyroot_stick);
		register("skyroot_sword", new ItemStack(ItemsAether.skyroot_sword, 1), "Z", "Z", "Y", 'Z', BlocksAether.skyroot_plank, 'Y', ItemsAether.skyroot_stick);
		register("holystone_sword", new ItemStack(ItemsAether.holystone_sword, 1), "Z", "Z", "Y", 'Z', BlocksAether.holystone, 'Y', ItemsAether.skyroot_stick);
		register("zanite_sword", new ItemStack(ItemsAether.zanite_sword, 1), "Z", "Z", "Y", 'Z', ItemsAether.zanite_gemstone, 'Y', ItemsAether.skyroot_stick);
		register("gravitite_sword", new ItemStack(ItemsAether.gravitite_sword, 1), "Z", "Z", "Y", 'Z', BlocksAether.enchanted_gravitite, 'Y', ItemsAether.skyroot_stick);

		register("white_cape", new ItemStack(ItemsAether.white_cape), "ZZ", "ZZ", "ZZ", 'Z', new ItemStack(Blocks.WOOL, 1, 0));
		register("blue_cape", new ItemStack(ItemsAether.blue_cape), "ZZ", "ZZ", "ZZ", 'Z', new ItemStack(Blocks.WOOL, 1, 11));
		register("yellow_cape", new ItemStack(ItemsAether.yellow_cape), "ZZ", "ZZ", "ZZ", 'Z', new ItemStack(Blocks.WOOL, 1, 4));
		register("red_cape", new ItemStack(ItemsAether.red_cape), "ZZ", "ZZ", "ZZ", 'Z', new ItemStack(Blocks.WOOL, 1, 14));

		register("leather_gloves", new ItemStack(ItemsAether.leather_gloves), "C C", 'C', Items.LEATHER);
		register("iron_gloves", new ItemStack(ItemsAether.iron_gloves), "C C", 'C', Items.IRON_INGOT);
		register("golden_gloves", new ItemStack(ItemsAether.golden_gloves), "C C", 'C', Items.GOLD_INGOT);
		register("diamond_gloves", new ItemStack(ItemsAether.diamond_gloves), "C C", 'C', Items.DIAMOND);
		register("zanite_gloves", new ItemStack(ItemsAether.zanite_gloves), "C C", 'C', ItemsAether.zanite_gemstone);
		register("gravitite_gloves", new ItemStack(ItemsAether.gravitite_gloves), "C C", 'C', BlocksAether.enchanted_gravitite);

		register("skyroot_fence", new ItemStack(BlocksAether.skyroot_fence, 3), "ZXZ", "ZXZ", 'Z', new ItemStack(BlocksAether.skyroot_plank), 'X', new ItemStack(ItemsAether.skyroot_stick));
		register("skyroot_fence_gate", new ItemStack(BlocksAether.skyroot_fence_gate), "ZXZ", "ZXZ", 'X', new ItemStack(BlocksAether.skyroot_plank), 'Z', new ItemStack(ItemsAether.skyroot_stick));

		register("carved_stone_slab", new ItemStack(BlocksAether.carved_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 0));
		register("angelic_stone_slab", new ItemStack(BlocksAether.angelic_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 2));
		register("hellfire_stone_slab", new ItemStack(BlocksAether.hellfire_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 4));
		register("holystone_slab", new ItemStack(BlocksAether.holystone_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.holystone, 1, 1));
		register("mossy_holystone_slab", new ItemStack(BlocksAether.mossy_holystone_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.mossy_holystone, 1, 1));
		register("holystone_brick_slab", new ItemStack(BlocksAether.holystone_brick_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.holystone_brick, 1));
		register("skyroot_slab", new ItemStack(BlocksAether.skyroot_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.skyroot_plank));
		register("aerogel_slab", new ItemStack(BlocksAether.aerogel_slab, 6), "ZZZ", 'Z', new ItemStack(BlocksAether.aerogel));

		register("carved_stone_wall", new ItemStack(BlocksAether.carved_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 0));
		register("angelic_stone_wall", new ItemStack(BlocksAether.angelic_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 2));
		register("hellfire_stone_wall", new ItemStack(BlocksAether.hellfire_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 4));
		register("holystone_wall", new ItemStack(BlocksAether.holystone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.holystone, 1, 1));
		register("mossy_holystone_wall", new ItemStack(BlocksAether.mossy_holystone_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.mossy_holystone, 1, 1));
		register("holystone_brick_wall", new ItemStack(BlocksAether.holystone_brick_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.holystone_brick, 1));
		register("aerogel_wall", new ItemStack(BlocksAether.aerogel_wall, 6), "ZZZ", "ZZZ", 'Z', new ItemStack(BlocksAether.aerogel, 1));

		
		register("carved_stone_stairs", new ItemStack(BlocksAether.carved_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 0));
		register("angelic_stone_stairs", new ItemStack(BlocksAether.angelic_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 2));
		register("hellfire_stone_stairs", new ItemStack(BlocksAether.hellfire_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.dungeon_block, 1, 4));
		register("holystone_stairs", new ItemStack(BlocksAether.holystone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.holystone, 1, 1));
		register("mossy_holystone_stairs", new ItemStack(BlocksAether.mossy_holystone_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.mossy_holystone, 1, 1));
		register("holystone_brick_stairs", new ItemStack(BlocksAether.holystone_brick_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.holystone_brick, 1));
		register("skyroot_stairs", new ItemStack(BlocksAether.skyroot_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.skyroot_plank));
		register("aerogel_stairs", new ItemStack(BlocksAether.aerogel_stairs, 4), "Z  ", "ZZ ", "ZZZ", 'Z', new ItemStack(BlocksAether.aerogel));

	}

	private static void register(String name, ItemStack stack, Object... recipe)
	{
		ResourceLocation group = Aether.locate(name);
        ShapedPrimer primer = CraftingHelper.parseShaped(recipe);

        craftingRegistry.register(new ShapedRecipes(group == null ? "" : group.toString(), primer.width, primer.height, primer.input, stack).setRegistryName(Aether.locate(name)));
	}

	private static void registerShapeless(String name, ItemStack stack, Ingredient... recipe)
	{
		ResourceLocation group = Aether.locate(name);
        NonNullList<Ingredient> lst = NonNullList.create();

        for (Ingredient i : recipe)
        {
            lst.add(i);
        }

        craftingRegistry.register(new ShapelessRecipes(group == null ? "" : group.toString(), stack, lst).setRegistryName(Aether.locate(name)));
	}*/

}
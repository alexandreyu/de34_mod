package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.item.SteelBowItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ItemInit {
	private ItemInit() {
	}

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, DE34M.MODID);

	// Items
	public static final RegistryObject<Item> CHROMIUM_INGOT = ITEMS.register("chromium_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<Item> RAW_HEMATITE = ITEMS.register("raw_hematite",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<Item> LIGNITE_CHUNK = ITEMS.register("lignite_chunk",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<Item> TUNGSTEN_INGOT = ITEMS.register("tungsten_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).fireResistant()));

	public static final RegistryObject<BucketItem> OIL_BUCKET = ITEMS.register("oil_bucket",
			() -> new BucketItem(FluidInit.OIL, (new Item.Properties()).tab(DE34M.DE34_TAB).stacksTo(1)));

	public static final RegistryObject<Item> ELERIUM_SHARD = ITEMS.register("elerium_shard", () -> new Item(
			new Item.Properties().tab(DE34M.DE34_TAB).fireResistant().stacksTo(16).rarity(Rarity.UNCOMMON)));

	// Composites
	public static final RegistryObject<Item> TUNGSTEN_CARBIDE_INGOT = ITEMS.register("tungsten_carbide_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> BLACK_STEEL_INGOT = ITEMS.register("black_steel_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> WCR_INGOT = ITEMS.register("wcr_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> CHROMIUM_CARBIDE_INGOT = ITEMS.register("chromium_carbide_ingot",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).fireResistant().rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<Item> ELERIUM_PLATE = ITEMS.register("elerium_plate",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<Item> ACTIVATED_ELERIUM = ITEMS.register("activated_elerium",
			() -> new Item(new Item.Properties().tab(DE34M.DE34_TAB).stacksTo(16).rarity(Rarity.RARE)));

	// Ores
	public static final RegistryObject<BlockItem> CHROMIUM_ORE_BLOCK_ITEM = ITEMS.register("chromium_ore",
			() -> new BlockItem(BlockInit.CHROMIUM_ORE.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> HEMATITE_ORE_BLOCK_ITEM = ITEMS.register("hematite_ore",
			() -> new BlockItem(BlockInit.HEMATITE_ORE.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> LIGNITE_ORE_BLOCK_ITEM = ITEMS.register("lignite_ore",
			() -> new BlockItem(BlockInit.LIGNITE_ORE.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> TUNGSTEN_ORE_BLOCK_ITEM = ITEMS.register("tungsten_ore",
			() -> new BlockItem(BlockInit.TUNGSTEN_ORE.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).fireResistant()));

	public static final RegistryObject<BlockItem> OIL_BLOCK_ITEM = ITEMS.register("oil",
			() -> new BlockItem(BlockInit.OIL.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> ELERIUM_ORE_BLOCK_ITEM = ITEMS.register("elerium_ore",
			() -> new BlockItem(BlockInit.ELERIUM_ORE.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	// BlockItems
	public static final RegistryObject<BlockItem> CHROMIUM_BLOCK_ITEM = ITEMS.register("chromium_block",
			() -> new BlockItem(BlockInit.CHROMIUM_BLOCK.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> HEMATITE_BLOCK_ITEM = ITEMS.register("hematite_block",
			() -> new BlockItem(BlockInit.HEMATITE_BLOCK.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> LIGNITE_BLOCK_ITEM = ITEMS.register("lignite_block",
			() -> new BlockItem(BlockInit.LIGNITE_BLOCK.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> TUNGSTEN_BLOCK_ITEM = ITEMS.register("tungsten_block",
			() -> new BlockItem(BlockInit.TUNGSTEN_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).fireResistant()));

	public static final RegistryObject<BlockItem> OIL_BARREL_BLOCK_ITEM = ITEMS.register("oil_barrel",
			() -> new BlockItem(BlockInit.OIL_BARREL.get(), new Item.Properties().tab(DE34M.DE34_TAB)));

	public static final RegistryObject<BlockItem> ELERIUM_BLOCK_ITEM = ITEMS.register("elerium_block",
			() -> new BlockItem(BlockInit.ELERIUM_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	// Composites
	public static final RegistryObject<BlockItem> TUNGSTEN_CARBIDE_BLOCK_ITEM = ITEMS.register("tungsten_carbide_block",
			() -> new BlockItem(BlockInit.TUNGSTEN_CARBIDE_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<BlockItem> STEEL_BLOCK_ITEM = ITEMS.register("steel_block",
			() -> new BlockItem(BlockInit.STEEL_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<BlockItem> DARK_STEEL_BLOCK_ITEM = ITEMS.register("black_steel_block",
			() -> new BlockItem(BlockInit.BLACK_STEEL_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<BlockItem> WCR_BLOCK_ITEM = ITEMS.register("wcr_block",
			() -> new BlockItem(BlockInit.WCR_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<BlockItem> CHROMIUM_CARBIDE_BLOCK_ITEM = ITEMS.register("chromium_carbide_block",
			() -> new BlockItem(BlockInit.CHROMIUM_CARBIDE_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.UNCOMMON)));

	public static final RegistryObject<BlockItem> ACTIVATED_ELERIUM_BLOCK = ITEMS.register("activated_elerium_block",
			() -> new BlockItem(BlockInit.ACTIVATED_ELERIUM_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	// Special
	public static final RegistryObject<BlockItem> HIGH_TEMPERATURE_FURNACE_BLOCK_ITEM = ITEMS
			.register("high_temperature_furnace", () -> new BlockItem(BlockInit.HIGH_TEMPERATURE_FURNACE.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<BlockItem> GAMMA_ACTIVATOR_BLOCK_ITEM = ITEMS.register("gamma_activator",
			() -> new BlockItem(BlockInit.GAMMA_ACTIVATOR.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<BlockItem> CROWN_BLOCK_ITEM = ITEMS.register("crown",
			() -> new BlockItem(BlockInit.CROWN.get(), new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.EPIC)));

	public static final RegistryObject<BlockItem> PHASED_ELERIUM_BLOCK_ITEM = ITEMS.register("phased_elerium_block",
			() -> new BlockItem(BlockInit.PHASED_ELERIUM_BLOCK.get(),
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.EPIC)));

	// Equipment
	public static final RegistryObject<SwordItem> BLACK_STEEL_SWORD = ITEMS.register("black_steel_sword",
			() -> new SwordItem(ToolMaterialInit.BLACK_STEEL_TIER, 4, 1f,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<PickaxeItem> TUNGSTEN_CARBIDE_PICKAXE = ITEMS
			.register("tungsten_carbide_pickaxe", () -> new PickaxeItem(ToolMaterialInit.TUNGSTEN_CARBIDE_TIER, 5, 1f,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<AxeItem> CHROMIUM_CARBIDE_AXE = ITEMS.register("chromium_carbide_axe",
			() -> new AxeItem(ToolMaterialInit.CHROMIUM_CARBIDE_TIER, 2, 1f,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<ShovelItem> WCR_SHOVEL = ITEMS.register("wcr_shovel",
			() -> new ShovelItem(ToolMaterialInit.WCR_TIER, 2, 1f,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<SteelBowItem> STEEL_BOW = ITEMS.register("steel_bow",
			() -> new SteelBowItem(new Item.Properties().tab(DE34M.DE34_TAB).stacksTo(1).rarity(Rarity.RARE)));

	public static final RegistryObject<ArmorItem> ELERIUM_HELMET = ITEMS.register("elerium_helmet",
			() -> new ArmorItem(ArmorMaterialInit.ELERIUM_ARMOR_MATERIAL, EquipmentSlot.HEAD,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<ArmorItem> ELERIUM_CHESTPLATE = ITEMS.register("elerium_chestplate",
			() -> new ArmorItem(ArmorMaterialInit.ELERIUM_ARMOR_MATERIAL, EquipmentSlot.CHEST,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<ArmorItem> ELERIUM_LEGGINGS = ITEMS.register("elerium_leggings",
			() -> new ArmorItem(ArmorMaterialInit.ELERIUM_ARMOR_MATERIAL, EquipmentSlot.LEGS,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<ArmorItem> ELERIUM_BOOTS = ITEMS.register("elerium_boots",
			() -> new ArmorItem(ArmorMaterialInit.ELERIUM_ARMOR_MATERIAL, EquipmentSlot.FEET,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.RARE)));

	public static final RegistryObject<SwordItem> BAD_PLAYER_NO_COOKIE = ITEMS.register("bad_player_no_cookie",
			() -> new SwordItem(ToolMaterialInit.BLACK_STEEL_TIER, 791, 96f,
					new Item.Properties().tab(DE34M.DE34_TAB).rarity(Rarity.EPIC)));
}

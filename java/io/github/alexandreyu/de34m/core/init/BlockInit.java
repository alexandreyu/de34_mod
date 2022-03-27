package io.github.alexandreyu.de34m.core.init;

import io.github.alexandreyu.de34m.DE34M;
import io.github.alexandreyu.de34m.common.block.CrownBlock;
import io.github.alexandreyu.de34m.common.block.GammaActivatorBlock;
import io.github.alexandreyu.de34m.common.block.HighTemperatureFurnaceBlock;
import io.github.alexandreyu.de34m.common.block.PhasedEleriumBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class BlockInit {
	private BlockInit() {
	}

	public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, DE34M.MODID);

	// Ores
	public static final RegistryObject<Block> CHROMIUM_ORE = BLOCKS.register("chromium_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_BLUE)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<Block> HEMATITE_ORE = BLOCKS.register("hematite_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_RED)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<Block> LIGNITE_ORE = BLOCKS.register("lignite_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<Block> TUNGSTEN_ORE = BLOCKS.register("tungsten_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_LIGHT_GRAY)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<LiquidBlock> OIL = BLOCKS.register("oil",
			() -> new LiquidBlock(FluidInit.OIL, BlockBehaviour.Properties.of(Material.WATER).noCollission()
					.strength(100.0F).noDrops()));

	public static final RegistryObject<Block> ELERIUM_ORE = BLOCKS.register("elerium_ore",
			() -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.COLOR_BLUE)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	// Blocks
	public static final RegistryObject<Block> CHROMIUM_BLOCK = BLOCKS.register("chromium_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_LIGHT_BLUE)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<Block> HEMATITE_BLOCK = BLOCKS.register("hematite_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_RED)
					.requiresCorrectToolForDrops().strength(6.0F, 3.0F)));

	public static final RegistryObject<Block> LIGNITE_BLOCK = BLOCKS.register("lignite_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLACK)
					.requiresCorrectToolForDrops().strength(3.0F, 3.0F)));

	public static final RegistryObject<Block> TUNGSTEN_BLOCK = BLOCKS.register("tungsten_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> OIL_BARREL = BLOCKS.register("oil_barrel",
			() -> new Block(BlockBehaviour.Properties.of(Material.WOOL, MaterialColor.COLOR_BLACK)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> ELERIUM_BLOCK = BLOCKS.register("elerium_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.COLOR_BLUE)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	// Composites
	public static final RegistryObject<Block> TUNGSTEN_CARBIDE_BLOCK = BLOCKS.register("tungsten_carbide_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> STEEL_BLOCK = BLOCKS.register("steel_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> BLACK_STEEL_BLOCK = BLOCKS.register("black_steel_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> WCR_BLOCK = BLOCKS.register("wcr_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> CHROMIUM_CARBIDE_BLOCK = BLOCKS.register("chromium_carbide_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_GRAY)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<Block> ACTIVATED_ELERIUM_BLOCK = BLOCKS.register("activated_elerium_block",
			() -> new Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_LIGHT_BLUE)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F).lightLevel((lightLevel) -> {
						return 8;
					})));

	public static final RegistryObject<PhasedEleriumBlock> PHASED_ELERIUM_BLOCK = BLOCKS.register(
			"phased_elerium_block",
			() -> new PhasedEleriumBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLUE)
					.strength(-1.0F, 3600000.0F).lightLevel((lightLevel) -> {
						return 15;
					})));

	// Special
	public static final RegistryObject<HighTemperatureFurnaceBlock> HIGH_TEMPERATURE_FURNACE = BLOCKS
			.register("high_temperature_furnace", () -> new HighTemperatureFurnaceBlock(BlockBehaviour.Properties
					.of(Material.METAL, MaterialColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<GammaActivatorBlock> GAMMA_ACTIVATOR = BLOCKS.register("gamma_activator",
			() -> new GammaActivatorBlock(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.COLOR_BLACK)
					.requiresCorrectToolForDrops().strength(8.0F, 3.0F)));

	public static final RegistryObject<CrownBlock> CROWN = BLOCKS.register("crown",
			() -> new CrownBlock(BlockBehaviour.Properties.of(Material.AMETHYST, MaterialColor.GOLD)
					.requiresCorrectToolForDrops().strength(12.0F, 50.0F).lightLevel((lightLevel) -> {
						return 15;
					})));

}

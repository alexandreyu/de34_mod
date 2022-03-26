package io.github.alexandreyu.de34m;

import io.github.alexandreyu.de34m.core.init.BlockInit;
import io.github.alexandreyu.de34m.core.init.EntityInit;
import io.github.alexandreyu.de34m.core.init.FluidInit;
import io.github.alexandreyu.de34m.core.init.ItemInit;
import net.minecraft.core.Direction;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DE34M.MODID)
public class DE34M {
	public static final String MODID = "de34m";
	
	public DE34M() {
		var bus = FMLJavaModLoadingContext.get().getModEventBus();
		
		BlockInit.BLOCKS.register(bus);
		ItemInit.ITEMS.register(bus);
		EntityInit.ENTITIES.register(bus);
		FluidInit.FLUIDS.register(bus);
	}
	
	public static final CreativeModeTab DE34_TAB = new CreativeModeTab(MODID + ".de34_tab") {
		@Override
		public ItemStack makeIcon() {
			return ItemInit.CROWN_BLOCK_ITEM.get().getDefaultInstance();
		}
	};
	
	public static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
		VoxelShape[] buffer = new VoxelShape[] {shape, Shapes.empty()};
		
		int times = (to.get2DDataValue() - Direction.NORTH.get2DDataValue() + 4) % 4;
		for (int i = 0; i < times; i++) {
			buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.or(buffer[1],
					Shapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX)));
			buffer[0] = buffer[1];
			buffer[1] = Shapes.empty();
			
		}
		
		return buffer[0];
		
	}
}
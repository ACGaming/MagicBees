package magicbees.integration.vanilla;

import elec332.core.api.module.ElecModule;
import magicbees.MagicBees;
import magicbees.api.ITransmutationHandler;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

/**
 * Created by Elec332 on 15-5-2017.
 */
@ElecModule(owner = MagicBees.modid, name = "Vanilla Module")
public class IntegrationVanilla {

	@ElecModule.EventHandler
	public void init(FMLInitializationEvent event){
		MagicBees.transmutationController.addTransmutationHandler(new ITransmutationHandler() {

			@Override
			public boolean transmute(World world, BlockPos pos, ItemStack block, Biome biome) {
				boolean ret = false;
				if (BiomeDictionary.hasType(biome, BiomeDictionary.Type.SANDY) && block.getItem() == Item.getItemFromBlock(Blocks.SAND) && block.getMetadata() == 0) {
					world.setBlockState(pos, Blocks.SANDSTONE.getDefaultState());
					ret = true;
				}
				return ret;
			}

		});
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.STONE), new ItemStack(Blocks.COBBLESTONE));
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.COBBLESTONE), new ItemStack(Blocks.MOSSY_COBBLESTONE));
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.STONEBRICK, 1, 0), new ItemStack(Blocks.STONEBRICK, 1, 2));
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.STONEBRICK, 1, 2), new ItemStack(Blocks.STONEBRICK, 1, 1));
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.COBBLESTONE_WALL), new ItemStack(Blocks.COBBLESTONE_WALL, 1, 1));
		MagicBees.crumblingHandler.addCrumblingHandler(new ItemStack(Blocks.GRAVEL), new ItemStack(Blocks.SAND));
	}

}

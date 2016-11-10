package magicbees.client.gui;

import magicbees.tileentity.TileEntityEffectJar;
import magicbees.tileentity.TileEntityMagicApiary;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GUIHandler implements IGuiHandler
{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		Object value = null;

		if (ID == UIScreens.EFFECT_JAR.ordinal())
		{
			value = new ContainerEffectJar((TileEntityEffectJar)world.getTileEntity(new BlockPos(x, y, z)), player);
		}
        else if (ID == UIScreens.THAUMIC_APIARY.ordinal())
        {
            TileEntityMagicApiary tileEntityThaumicApiary = (TileEntityMagicApiary) world.getTileEntity(new BlockPos(x, y, z));
            value = new ContainerMagicApiary(player.inventory, tileEntityThaumicApiary);
        }
		
		return value;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		Object value = null;
		
		if (ID == UIScreens.EFFECT_JAR.ordinal())
		{
			value = new GUIEffectJar((TileEntityEffectJar)world.getTileEntity(new BlockPos(x, y, z)), player);
		}else if (ID == UIScreens.THAUMIC_APIARY.ordinal())
        {
            TileEntityMagicApiary tileEntityThaumicApiary = (TileEntityMagicApiary) world.getTileEntity(new BlockPos(x, y, z));
            value = new GuiMagicApiary(player.inventory, tileEntityThaumicApiary);
        }
		
		return value;
	}

}

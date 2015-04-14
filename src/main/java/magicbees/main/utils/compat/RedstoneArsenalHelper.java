package magicbees.main.utils.compat;

import cpw.mods.fml.common.Loader;
import magicbees.main.Config;
import magicbees.main.utils.ItemInterface;
import net.minecraft.item.ItemStack;

public class RedstoneArsenalHelper
{
	public enum MiscResource
	{
		FLUXED_ELECTRUMBLOCK,;
	}

	public enum NuggetType
	{
		ELECTRUMFLUX,;
	}


	public static final String Name = "RedstoneArsenal";
	private static boolean isRedstoneArsenalPresent = false;

	public static boolean isActive()
	{
		return isRedstoneArsenalPresent;
	}

	public static void preInit()
	{
		if (Loader.isModLoaded(Name) && Config.redstoneArsenalActive)
		{
			isRedstoneArsenalPresent = true;
		}
		else
		{
			// Switch off RSA-dependant items.

		}
	}

	public static void init()
	{
		if (isActive())
		{
			getBlocks();
			getItems();
			setupCrafting();
		}
	}

	public static void postInit()
	{
		// if (isActive()) { }
	}


	private static void getBlocks()
	{
		Config.rsaFluxBlock = ItemInterface.getItemStack("RedstoneArsenal", "blockElectrumFlux", 1);
	}

	private static void getItems()
	{
		Config.rsaFluxNugget = ItemInterface.getItemStack("RedstoneArsenal", "nuggetElectrumFlux", 1);
	}


	private static void setupCrafting()
	{
		ItemStack input, output;


	}

	;

}


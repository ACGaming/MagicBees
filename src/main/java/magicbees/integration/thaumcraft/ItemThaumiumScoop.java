package magicbees.integration.thaumcraft;

import forestry.api.core.IToolScoop;
import magicbees.MagicBees;
import magicbees.util.MagicBeesResourceLocation;
import magicbees.util.Utils;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.Thaumcraft;
import thaumcraft.api.ThaumcraftMaterials;

public class ItemThaumiumScoop extends Item implements IToolScoop
{
	public ItemThaumiumScoop()
	{
		setRegistryName(new MagicBeesResourceLocation("thaumiumscoop"));
		this.setMaxStackSize(1);
		this.setMaxDamage(30);
		this.setCreativeTab(MagicBees.creativeTab);
		Utils.setUnlocalizedName(this);
		this.setHarvestLevel("scoop", 3);
	}

	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
	{
		stack.damageItem(1, entityLiving);
		return true;
	}
	
	/**
	 * Return the enchantability factor of the item, most of the time is based on material.
	 */
	@Optional.Method(modid = Thaumcraft.MODID)
	public int getItemEnchantability()
	{
		return ThaumcraftMaterials.TOOLMAT_THAUMIUM.getEnchantability();
	}

	/**
	 * Return the name for this tool's material.
	 */
	@Optional.Method(modid = Thaumcraft.MODID)
	public String getToolMaterialName()
	{
		return ThaumcraftMaterials.TOOLMAT_THAUMIUM.toString();
	}

	/**
	 * Return whether this item is repairable in an anvil.
	 */
	@Optional.Method(modid = Thaumcraft.MODID)
	public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
	{
		return OreDictionary.itemMatches(ThaumcraftMaterials.TOOLMAT_THAUMIUM.getRepairItemStack(), par2ItemStack, true)
				|| super.getIsRepairable(par1ItemStack, par2ItemStack);
	}
}
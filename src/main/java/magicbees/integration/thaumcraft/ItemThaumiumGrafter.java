package magicbees.integration.thaumcraft;

import forestry.api.arboriculture.IToolGrafter;
import forestry.core.utils.Translator;
import magicbees.MagicBees;
import magicbees.util.MagicBeesResourceLocation;
import magicbees.util.Utils;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Optional;
import net.minecraftforge.oredict.OreDictionary;
import thaumcraft.Thaumcraft;
import thaumcraft.api.ThaumcraftMaterials;

import javax.annotation.Nonnull;
import java.util.List;

public class ItemThaumiumGrafter extends Item implements IToolGrafter
{
	public ItemThaumiumGrafter()
	{
		super();
		setRegistryName(new MagicBeesResourceLocation("thaumiumgrafter"));
		this.setMaxStackSize(1);
		this.setMaxDamage(15);
		this.setCreativeTab(MagicBees.creativeTab);
		Utils.setUnlocalizedName(this);
		setHarvestLevel("grafter", 3);
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

	@Override
	public float getSaplingModifier(@Nonnull ItemStack stack, @Nonnull World world, @Nonnull EntityPlayer player, @Nonnull BlockPos pos) {
		return 100.0f;
	}

	@Override
	public void addInformation(ItemStack stack, World playerIn, List<String> tooltip, ITooltipFlag advanced) {
		super.addInformation(stack, playerIn, tooltip, advanced);
		if (!stack.isItemDamaged()) {
			tooltip.add(Translator.translateToLocalFormatted("item.for.uses", stack.getMaxDamage() + 1));
		}
	}
}
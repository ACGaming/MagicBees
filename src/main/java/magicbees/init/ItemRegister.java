package magicbees.init;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import forestry.api.storage.BackpackManager;
import forestry.api.storage.EnumBackpackType;
import forestry.storage.BackpackDefinition;
import magicbees.MagicBees;
import magicbees.bees.EnumBeeModifiers;
import magicbees.elec332.corerepack.item.ItemEnumBased;
import magicbees.integration.thaumcraft.ItemThaumiumGrafter;
import magicbees.integration.thaumcraft.ItemThaumiumScoop;
import magicbees.item.*;
import magicbees.item.types.*;
import magicbees.util.MagicBeesResourceLocation;
import magicbees.util.Utils;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

import java.awt.*;
import java.util.Collections;
import java.util.Map;
import java.util.function.Predicate;

/**
 * Created by Elec332 on 4-3-2017.
 */
public final class ItemRegister {

    public static ItemEnumBased<EnumCombType> combItem;
    public static ItemEnumBased<EnumDropType> dropItem;
    public static ItemEnumBased<EnumPollenType> pollenItem;
    public static ItemEnumBased<EnumPropolisType> propolisItem;
    public static ItemEnumBased<EnumWaxType> waxItem;
    public static ItemEnumBased<EnumResourceType> resourceItem;
    public static ItemEnumBased<EnumNuggetType> orePartItem;
    //frames
    public static ItemMagicBeesFrame magicFrame, resilientFrame, gentleFrame, metabolicFrame, necroticFrame, temporalFrame, oblivionFrame;
    public static Item moonDial, ironNugget;
    public static Item manasteelgrafter, manasteelScoop;
    public static Item thaumiumgrafter, thaumiumScoop;
    public static ItemMysteriousMagnet mysteriousMagnet;

    public static ItemFood jellyBaby;

    public static Item thaumaturgeBackpackT1, thaumaturgeBackpackT2;
    public static Predicate<ItemStack> tcBackpackFilter = s -> true;

    private static Map<EnumBeeModifiers, ItemMagicBeesFrame> frames;

    public static void preInit() {
        combItem = new ItemEnumBased<>(new MagicBeesResourceLocation("beeComb"), EnumCombType.class);
        dropItem = new ItemEnumBased<>(new MagicBeesResourceLocation("drop"), EnumDropType.class);
        pollenItem = new ItemEnumBased<>(new MagicBeesResourceLocation("pollen"), EnumPollenType.class);
        propolisItem = new ItemEnumBased<>(new MagicBeesResourceLocation("propolis"), EnumPropolisType.class);
        waxItem = new ItemEnumBased<>(new MagicBeesResourceLocation("wax"), EnumWaxType.class);
        resourceItem = new ItemEnumBased<>(new MagicBeesResourceLocation("resource"), EnumResourceType.class);
        orePartItem = new ItemEnumBased<>(new MagicBeesResourceLocation("orepart"), EnumNuggetType.class);

        Map<EnumBeeModifiers, ItemMagicBeesFrame> framez = Maps.newHashMap();
        framez.put(EnumBeeModifiers.MAGIC, magicFrame = new ItemMagicBeesFrame(EnumBeeModifiers.MAGIC));
        framez.put(EnumBeeModifiers.RESILIENT, resilientFrame = new ItemMagicBeesFrame(EnumBeeModifiers.RESILIENT));
        framez.put(EnumBeeModifiers.GENTLE, gentleFrame = new ItemMagicBeesFrame(EnumBeeModifiers.GENTLE));
        framez.put(EnumBeeModifiers.METABOLIC, metabolicFrame = new ItemMagicBeesFrame(EnumBeeModifiers.METABOLIC));
        framez.put(EnumBeeModifiers.NECROTIC, necroticFrame = new ItemMagicBeesFrame(EnumBeeModifiers.NECROTIC));
        framez.put(EnumBeeModifiers.TEMPORAL, temporalFrame = new ItemMagicBeesFrame(EnumBeeModifiers.TEMPORAL));
        framez.put(EnumBeeModifiers.OBLIVION, oblivionFrame = new ItemMagicBeesFrame(EnumBeeModifiers.OBLIVION));
        frames = Collections.unmodifiableMap(framez);

        mysteriousMagnet = new ItemMysteriousMagnet();
        moonDial = new ItemMoonDial();

        manasteelgrafter = new ItemManaSteelGrafter();
        manasteelScoop = new ItemManaSteelScoop();

        thaumiumgrafter = new ItemThaumiumGrafter();
        thaumiumScoop = new ItemThaumiumScoop();

        String backpackUid = "backpack.thaumaturge";
        BackpackDefinition def = new BackpackDefinition(new Color(0x8700C6), new Color(0xFFFFFF), tcBackpackFilter);
        BackpackManager.backpackInterface.registerBackpackDefinition(backpackUid, def);
        thaumaturgeBackpackT1 = BackpackManager.backpackInterface.createBackpack(backpackUid, EnumBackpackType.NORMAL);
        thaumaturgeBackpackT1.setRegistryName(new MagicBeesResourceLocation("backpack_thaumaturge_t1"));
        thaumaturgeBackpackT1.setTranslationKey("backpack.thaumaturgeT1");
        thaumaturgeBackpackT1.setCreativeTab(MagicBees.creativeTab);
        thaumaturgeBackpackT2 = BackpackManager.backpackInterface.createBackpack(backpackUid, EnumBackpackType.WOVEN);
        thaumaturgeBackpackT2.setRegistryName(new MagicBeesResourceLocation("backpack_thaumaturge_t2"));
        thaumaturgeBackpackT2.setTranslationKey("backpack.thaumaturgeT2");
        thaumaturgeBackpackT2.setCreativeTab(MagicBees.creativeTab);

        jellyBaby = new ItemFood(1, false).setAlwaysEdible().setPotionEffect(new PotionEffect(MobEffects.SPEED, 5, 1), 1f);
        jellyBaby.setCreativeTab(MagicBees.creativeTab);
        jellyBaby.setRegistryName(new MagicBeesResourceLocation("jelly_babies"));
        Utils.setUnlocalizedName(jellyBaby);

        fixIronNuggetStuff();

    }

    public static void registerOreDictionary() {
        for (EnumCombType comb : EnumCombType.values()) {
            OreDictionary.registerOre("beeComb", combItem.getStackFromType(comb));
        }
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(combItem, dropItem, pollenItem, propolisItem, waxItem, resourceItem, orePartItem);
        event.getRegistry().registerAll(mysteriousMagnet, moonDial);
        event.getRegistry().registerAll(manasteelgrafter, manasteelScoop);
        event.getRegistry().registerAll(thaumiumgrafter, thaumiumScoop);
        event.getRegistry().registerAll(thaumaturgeBackpackT1, thaumaturgeBackpackT2);
        event.getRegistry().registerAll(jellyBaby);
        for (Item item : getBeeFrames().values()) {
            event.getRegistry().register(item);
        }


    }

    public static Map<EnumBeeModifiers, ItemMagicBeesFrame> getBeeFrames() {
        return frames;
    }

    private static void fixIronNuggetStuff() {
        ironNugget = Preconditions.checkNotNull(Items.IRON_NUGGET);
    }

}

package magicbees.init;

import magicbees.MagicBees;
import magicbees.block.BlockEffectJar;
import magicbees.block.BlockHive;
import magicbees.util.MagicBeesResourceLocation;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.registry.GameRegistry;


/**
 * Created by Elec332 on 4-3-2017.
 */
public final class BlockRegister {

    public static BlockHive hiveBlock;
    public static Block effectJar;

    public static void init(){
        hiveBlock = new BlockHive().register(new MagicBeesResourceLocation("hiveBlock"));
        hiveBlock.setCreativeTab(MagicBees.creativeTab);
        effectJar = GameRegistry.register(new BlockEffectJar(), new MagicBeesResourceLocation("effectJar")).setCreativeTab(MagicBees.creativeTab);
    }

}

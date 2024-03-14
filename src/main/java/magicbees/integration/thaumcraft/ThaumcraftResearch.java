package magicbees.integration.thaumcraft;

import magicbees.util.MagicBeesResourceLocation;
import net.minecraft.util.ResourceLocation;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.AspectList;
import thaumcraft.api.research.ResearchCategories;

/**
 * Created by Elec332 on 17-8-2019
 */
public class ThaumcraftResearch {

    public static final String CATEGORY = "MAGICBEES";

    static void setupResearch() {
        //ResearchCategories.registerCategory(CATEGORY, );
        ThaumcraftApi.registerResearchLocation(new MagicBeesResourceLocation("research/magicbees"));
        ResearchCategories.registerCategory("MAGICBEES", "UNLOCKARTIFICE",
                new AspectList(),
                new ResourceLocation("magicbees", "textures/items/beezard.png"),
                new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_3.jpg"),
                new ResourceLocation("thaumcraft", "textures/gui/gui_research_back_over.png"));
    }
}

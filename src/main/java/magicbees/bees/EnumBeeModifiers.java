package magicbees.bees;

import forestry.api.apiculture.IBeeGenome;
import forestry.api.apiculture.IBeeModifier;

import javax.annotation.Nonnull;

/**
 * Created by Elec332 on 21-8-2016.
 */
public enum EnumBeeModifiers implements IBeeModifier {

    MAGIC("Magic", 240, 1.0F, 1.0F, 1.0F, 2.0F, 0.6F),
    RESILIENT("Resilient", 800, 1.0F, 1.0F, 1.0F, 2.0F, 0.5F),
    GENTLE("Gentle", 200, 1.0F, 0.7F, 1.5F, 1.4F, 0.01F),
    METABOLIC("Metabolic", 130, 1.0F, 1.8F, 1.0F, 1.2F, 1.0F),
    NECROTIC("Necrotic", 280, 1.0F, 1.0F, 0.3F, 0.75F, 1.2F),
    TEMPORAL("Temporal", 300, 1.0F, 1.0F, 2.5F, 1.0F, 0.8F),
    OBLIVION("Oblivion", 50, 1.0F, 1.0F, 1.0E-4F, 0.0F, 1.0F);

    EnumBeeModifiers(String name, int damage, float territory, float mutation, float lifespan, float production, float geneticDecay) {
        this(name, damage, territory, mutation, lifespan, production, 1.0F, geneticDecay, false, false, false, false);
    }

    EnumBeeModifiers(String name, int damage, float territory, float mutation, float lifespan, float production, float flowering, float geneticDecay, boolean sealed, boolean lit, boolean sunlit, boolean hellish) {
        this.frameName = name;
        this.maxDamage = damage;
        this.territoryMod = territory;
        this.mutationMod = mutation;
        this.lifespanMod = lifespan;
        this.productionMod = production;
        this.floweringMod = flowering;
        this.geneticDecayMod = geneticDecay;
        this.isSealed = sealed;
        this.isLit = lit;
        this.isSunlit = sunlit;
        this.isHellish = hellish;
    }

    private final String frameName;
    private final int maxDamage;
    private final float territoryMod, mutationMod, lifespanMod, productionMod, floweringMod, geneticDecayMod;
    private final boolean isSealed, isLit, isSunlit, isHellish;

    public String getName() {
        return this.frameName;
    }

    public int getMaxDamage(){
        return this.maxDamage;
    }

    @Override
    public float getTerritoryModifier(@Nonnull IBeeGenome genome, float currentModifier) {
        return this.territoryMod;
    }

    @Override
    public float getMutationModifier(@Nonnull IBeeGenome genome, @Nonnull IBeeGenome mate, float currentModifier) {
        return this.mutationMod;
    }

    @Override
    public float getLifespanModifier(@Nonnull IBeeGenome genome, IBeeGenome mate, float currentModifier) {
        return this.lifespanMod;
    }

    @Override
    public float getProductionModifier(@Nonnull IBeeGenome genome, float currentModifier) {
        return this.productionMod;
    }

    @Override
    public float getFloweringModifier(@Nonnull IBeeGenome genome, float currentModifier) {
        return this.floweringMod;
    }

    @Override
    public float getGeneticDecay(@Nonnull IBeeGenome genome, float currentModifier) {
        return this.geneticDecayMod;
    }

    @Override
    public boolean isSealed() {
        return this.isSealed;
    }

    @Override
    public boolean isSelfLighted() {
        return this.isLit;
    }

    @Override
    public boolean isSunlightSimulated() {
        return this.isSunlit;
    }

    @Override
    public boolean isHellish() {
        return this.isHellish;
    }

}

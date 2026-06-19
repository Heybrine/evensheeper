package net.heybrine.evensheeper.common.level.entities.animal;

import com.blackgear.platform.core.BuiltInCoreRegistry;
import com.blackgear.vanillabackport.common.api.variant.ModelAndTexture;
import com.blackgear.vanillabackport.common.api.variant.spawn.SpawnPrioritySelectors;
import com.blackgear.vanillabackport.common.api.variant.spawn.check.raw.RawBiomeCheck;
import net.heybrine.evensheeper.common.level.entities.animal.SheepVariant.ModelType;
import com.blackgear.vanillabackport.core.data.tags.ModBiomeTags;
import net.heybrine.evensheeper.core.registries.ModBuiltinRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class SV2 {
    public static final BuiltInCoreRegistry<SheepVariant> REGISTRY = ModBuiltinRegistries.SHEEP_VARIANTS;

    public static final ResourceKey<SheepVariant> TEMPERATE = register(
            "temperate",
            ModelType.NORMAL,
            "sheep",
            SpawnPrioritySelectors.fallback(0)
    );

    public static final ResourceKey<SheepVariant> WARM = register(
            "warm",
            ModelType.WARM,
            "warm_sheep",
            ModBiomeTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS
    );

    public static final ResourceKey<SheepVariant> COLD = register(
            "cold",
            ModelType.COLD,
            "cold_sheep",
            ModBiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS
    );

    private static ResourceKey<SheepVariant> register(String key, ModelType type, String textureId, String underWoolTextureId, String woolTextureId, TagKey<Biome> biome) {
        return register(key, type, textureId, underWoolTextureId, woolTextureId, SpawnPrioritySelectors.single(new RawBiomeCheck(biome), 1));
    }

    private static ResourceKey<SheepVariant> register(String key, ModelType type, String textureId, String underWoolTextureId, String woolTextureId, SpawnPrioritySelectors selectors) {
        ResourceLocation texture = new ResourceLocation("entity/sheep/" + textureId);
        ResourceLocation underWoolTexture = new ResourceLocation("entity/sheep/" + underWoolTextureId);
        ResourceLocation woolTexture = new ResourceLocation("entity/sheep/" + woolTextureId);
        SheepVariant variant = new SheepVariant(new ModelAndTexture<>(type, texture), new ClientAsset(underWoolTexture), new ClientAsset(woolTexture), selectors);
        return REGISTRY.resource(key, variant);
    }
}

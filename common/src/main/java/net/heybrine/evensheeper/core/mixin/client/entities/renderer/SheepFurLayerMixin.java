package net.heybrine.evensheeper.core.mixin.client.entities.renderer;

import com.blackgear.vanillabackport.common.api.variant.VariantDataHolder;
import net.heybrine.evensheeper.common.level.entities.animal.SheepVariant;
import net.minecraft.client.renderer.entity.layers.SheepFurLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Sheep;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(SheepFurLayer.class)
public class SheepFurLayerMixin {

    @Shadow @Final private static ResourceLocation SHEEP_FUR_LOCATION;

    @Redirect(
            method = "render",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/client/renderer/entity/layers/SheepFurLayer;SHEEP_FUR_LOCATION:Lnet/minecraft/resources/ResourceLocation;"
            )
    )
    private ResourceLocation vb$replaceWoolTexture(Sheep sheep) {

        if (sheep instanceof VariantDataHolder<?> holder) {
            return holder.getVariantData()
                    .map(v -> ((SheepVariant) v).wool().path())
                    .orElse(SHEEP_FUR_LOCATION);
        }

        return SHEEP_FUR_LOCATION;
    }
}

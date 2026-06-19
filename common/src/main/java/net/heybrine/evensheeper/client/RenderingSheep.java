package net.heybrine.evensheeper.client;

import com.blackgear.platform.client.GameRendering;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.heybrine.evensheeper.client.level.entities.model.sheep.WarmSheepModel;
import net.heybrine.evensheeper.client.registries.ModModelLayers;

@Environment(EnvType.CLIENT)
public class RenderingSheep {
    public static void modelLayers(GameRendering.ModelLayerEvent event) {
        event.register(ModModelLayers.WARM_SHEEP, WarmSheepModel::createBodyLayer);
    }
}

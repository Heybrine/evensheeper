package net.heybrine.evensheeper.core;

import com.blackgear.platform.core.Environment;
import com.blackgear.platform.core.ModInstance;
import com.blackgear.platform.core.api.registrar.Registrar;
import com.blackgear.platform.core.util.config.ConfigLoader;
import com.blackgear.platform.core.util.config.ModConfig;
import com.blackgear.vanillabackport.core.registries.ModBuiltinRegistries;
import com.mojang.logging.LogUtils;
import net.heybrine.evensheeper.common.level.entities.animal.SheepVariants;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EvenSheeper {
    public static final String MOD_ID = "evensheeper";
    public static final String NAMESPACE = "minecraft";
    public static final Logger LOGGER = LogUtils.getLogger();
    //public static final ClientConfig CLIENT_CONFIG = Environment.registerConfig(MOD_ID, ModConfig.Type.CLIENT, ClientConfig::new);
    //public static final CommonConfig COMMON_CONFIG = Environment.registerConfig(MOD_ID, ModConfig.Type.COMMON, CommonConfig::new);
    public static final ModInstance INSTANCE = ModInstance.create(MOD_ID).build();
            /*.client(ClientSetup::setup)
            .postClient(ClientSetup::asyncSetup)
            .common(CommonSetup::setup)
            .postCommon(CommonSetup::asyncSetup)
            .build();*/
    //public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Shearing sheaps...I mean sheeps");
    }
    public static void bootstrap() {
        INSTANCE.bootstrap();
        ConfigLoader.bootstrap();

        SheepVariants.REGISTRY.register();
    }

    public static ResourceLocation resource(String path) {
        return new ResourceLocation(MOD_ID, path);
        }
}

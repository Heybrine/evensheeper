package net.heybrine.evensheeper.forge;

//import com.blackgear.platform.core.Environment;
import dev.architectury.platform.forge.EventBuses;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import net.heybrine.evensheeper.EvenSheeper;

@Mod(EvenSheeper.MOD_ID)
public final class EvenSheeperForge {
    public EvenSheeperForge() {
        /*EvenSheeper.bootstrap();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(this::commonSetup);*/
        // Submit our event bus to let Architectury API register our content on the right time.
        EventBuses.registerModEventBus(EvenSheeper.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());

        // Run our common setup.
        EvenSheeper.init();
    }
}

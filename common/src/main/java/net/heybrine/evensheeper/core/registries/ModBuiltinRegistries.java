package net.heybrine.evensheeper.core.registries;

import com.blackgear.platform.core.BuiltInCoreRegistry;
import net.heybrine.evensheeper.common.level.entities.animal.SheepVariant;
import net.heybrine.evensheeper.core.EvenSheeper;
import com.blackgear.vanillabackport.core.VanillaBackport;

public class ModBuiltinRegistries {
    public static final BuiltInCoreRegistry<SheepVariant> SHEEP_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.SHEEP_VARIANT.get(), VanillaBackport.NAMESPACE);
}

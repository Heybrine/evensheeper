package net.heybrine.evensheeper.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class EvenSheeper {
    public static final String MOD_ID = "evensheeper";
    public static final String NAMESPACE = "minecraft";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.
        LOGGER.info("Shearing sheaps...I mean sheeps");
    }
}

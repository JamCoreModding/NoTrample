package com.jamalam360;

import com.oroarmor.config.Config;
import com.oroarmor.config.command.ConfigCommand;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.command.CommandSource;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class NoTrample implements ModInitializer {
    public static final Config CONFIG = new NoTrampleConfig();

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "notramplefabric";
    public static final String MOD_NAME = "NoTrample";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");

        CONFIG.readConfigFromFile();
        ServerLifecycleEvents.SERVER_STOPPED.register(instance -> CONFIG.saveConfigToFile());
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> new ConfigCommand(CONFIG).register(dispatcher, p -> ((CommandSource) p).hasPermissionLevel(2)));
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}
package com.jamalam360;

import com.oroarmor.config.BooleanConfigItem;
import com.oroarmor.config.Config;
import com.oroarmor.config.ConfigItemGroup;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class NoTrampleConfig extends Config {
    public static final ConfigItemGroup mainGroup = new ConfigGroupLevel1();

    public static final List<ConfigItemGroup> configs = Collections.singletonList(mainGroup);

    public NoTrampleConfig() {
        super(configs, new File(FabricLoader.getInstance().getConfigDir().toFile(), "notrampleconfig.json"), "notrampleconfig");
    }

    public static class ConfigGroupLevel1 extends ConfigItemGroup {
        public static final BooleanConfigItem testItem = new BooleanConfigItem("requires_feather_falling", true, "Requires Feather Falling");

        public ConfigGroupLevel1() {
            super(Collections.singletonList(testItem), "options");
        }
    }
}

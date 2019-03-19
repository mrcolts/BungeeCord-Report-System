package ru.mrcolt.znbungeereport.api;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import ru.mrcolt.znbungeereport.utils.ConfigUtil;

import java.util.List;

public class ConfigAPI {

    private static Plugin current;
    private static ConfigUtil configUtil;

    public static void init(Plugin plugin) {
        current = plugin;
        configUtil = new ConfigUtil(current);
    }

    public static void load() {
        configUtil.load();
    }

    private static Configuration getConfiguation() {
        return configUtil.getConfiguration();
    }

    public static String getMYSQL(String type) {
        return getConfiguation().getString("mysql." + type);
    }

    public static String getPasswordHash() {
        return getConfiguation().getString("password-hash");
    }

    public static List<String> getServers(String type) {
        return getConfiguation().getStringList("servers." + type);
    }
}

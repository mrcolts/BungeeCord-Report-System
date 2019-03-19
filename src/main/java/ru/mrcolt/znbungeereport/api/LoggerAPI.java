package ru.mrcolt.znbungeereport.api;

import net.md_5.bungee.api.plugin.Plugin;

public class LoggerAPI {
    private static Plugin current;

    public static void init(Plugin plugin) {
        current = plugin;
    }

    public static void info(String message) {
        current.getLogger().info(message);
    }

    public static void warning(String message) {
        current.getLogger().info(message);
    }
}

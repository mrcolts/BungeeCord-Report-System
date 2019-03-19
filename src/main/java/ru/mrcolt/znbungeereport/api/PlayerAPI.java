package ru.mrcolt.znbungeereport.api;

import net.md_5.bungee.api.plugin.Plugin;

public class PlayerAPI {
    private static Plugin current;

    public static void init(Plugin plugin) {
        current = plugin;
    }

    public static boolean isExist(String nickname) {
        return current.getProxy().getPlayer(nickname) != null;
    }

}

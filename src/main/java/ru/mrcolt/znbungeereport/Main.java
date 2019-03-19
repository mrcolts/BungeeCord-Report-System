package ru.mrcolt.znbungeereport;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.api.plugin.PluginManager;
import net.md_5.bungee.config.Configuration;
import ru.mrcolt.znbungeereport.api.ConfigAPI;
import ru.mrcolt.znbungeereport.api.LoggerAPI;
import ru.mrcolt.znbungeereport.api.MySQLAPI;
import ru.mrcolt.znbungeereport.api.PlayerAPI;
import ru.mrcolt.znbungeereport.commands.ReportCommand;

import java.sql.Connection;

public final class Main extends Plugin {

    public static Configuration configuration;
    public static Connection database;

    @Override
    public void onEnable() {
        PluginManager pluginManager = getProxy().getPluginManager();
        pluginManager.registerCommand(this, new ReportCommand());
        LoggerAPI.init(this);
        PlayerAPI.init(this);
        ConfigAPI.init(this);
        ConfigAPI.load();
        MySQLAPI.connect();
        getLogger().info("I'm enabled!");
    }

    @Override
    public void onDisable() {
        MySQLAPI.disconnect();
        getLogger().info("I'm disabled!");
    }
}

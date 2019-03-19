package ru.mrcolt.znbungeereport.utils;

import net.md_5.bungee.api.plugin.Plugin;
import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;
import ru.mrcolt.znbungeereport.api.LoggerAPI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

public class ConfigUtil {
    private static Plugin current;
    private static Configuration configuration;

    public ConfigUtil(Plugin plugin) {
        current = plugin;
    }

    public Configuration getConfiguration() {
        return configuration;
    }

    public void load() {
        try {
            if (!current.getDataFolder().exists()) current.getDataFolder().mkdirs();
            File file = new File(current.getDataFolder(), "config.yml");
            if (!file.exists()) {
                InputStream inputStream = current.getResourceAsStream("config.yml");
                Files.copy(inputStream, file.toPath());
            }
            configuration = ConfigurationProvider.getProvider(YamlConfiguration.class).load(new File(current.getDataFolder(), "config.yml"));
        } catch (IOException e) {
            LoggerAPI.warning(e.getMessage());
        }
    }

}

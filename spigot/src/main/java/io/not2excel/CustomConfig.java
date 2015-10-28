package io.not2excel;
/*
 * Copyright (C) 2013-Current Carter Gale (Ktar5) <buildfresh@gmail.com>
 * 
 * This file is part of HelixLib.
 * 
 * HelixLib can not be copied and/or distributed without the express
 * permission of the aforementioned owner.
 */

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author Ktar5, not2excel
 */
public class CustomConfig {
    private static final JavaPlugin PLUGIN = JavaPlugin.getProvidingPlugin(CustomConfig.class);
    private String fileName;
    private FileConfiguration config;
    private File configFile;

    public CustomConfig(File folder, String fileName) {
        this.fileName = fileName;
        configFile = new File(folder, fileName);
        reloadConfig();
    }

    public CustomConfig(Player player) {
        this(player.getUniqueId());
    }

    public CustomConfig(UUID uuid) {
        File dir = new File(PLUGIN.getDataFolder(), "players");
        dir.mkdir();
        this.fileName = uuid.toString();
        if (!fileName.endsWith(".yml")) {
            fileName += ".yml";
        }
        configFile = new File(dir, fileName);
        reloadConfigPlayer();
    }

    public static boolean doesConfigExist(UUID uuid) {
        File dir = new File(PLUGIN.getDataFolder(), "players");
        dir.mkdir();
        String fileName = uuid.toString();
        if (!fileName.endsWith(".yml")) {
            fileName += ".yml";
        }
        return new File(dir, fileName).exists();
    }

    public void reloadConfigPlayer() {
        if (!configFile.exists()) {
            try {
                configFile.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public String getFileName() {
        return fileName;
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public File getConfigFile() {
        return configFile;
    }

    public void reloadConfig() {
        if (!configFile.exists()) {
            PLUGIN.getLogger().info("Attempting to save resource: " + configFile.getName());
            PLUGIN.saveResource(fileName, true);
        }
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void saveConfig() {
        try {
            config.save(configFile);
        } catch (Exception e) {
            PLUGIN.getLogger().severe(String.format("Couldn't save '%s', because: '%s'", fileName,
                    e.getMessage()));
        }
        reloadConfig();
    }

    public void set(String path, Object value, boolean save) {
        config.set(path, value);
        if (save) {
            saveConfig();
        }
    }

    public void set(String path, Object value) {
        set(path, value, false);
    }

    public Set<String> getKeys(boolean deep) {
        return this.config.getKeys(deep);
    }

    public ConfigurationSection getConfigurationSection(String path) {
        return this.config.getConfigurationSection(path);
    }

    public boolean has(String path) {
        return config.contains(path);
    }

    public <T> T get(String path, Class<T> tClass) {
        if (tClass.isPrimitive()) {
            throw new IllegalArgumentException(tClass + " is of a primitive type. Disallowed type.");
        }
        if (!has(path)) {
            throw new IllegalArgumentException(path + " does not exist.");
        }
        Object object = config.get(path);
        if (object == null) {
            return null;
        }
        if (!tClass.isInstance(object)) {
            throw new IllegalArgumentException(path + " is not of type " + tClass.getSimpleName());
        }
        return tClass.cast(object);
    }

    public <T> T get(String path, Class<T> tClass, T tDefault) {
        if (tClass.isPrimitive()) {
            throw new IllegalArgumentException(tClass + " is of a primitive type. Disallowed type.");
        }
        if (!has(path)) {
            return tDefault;
        }
        Object object = config.get(path);
        if (object == null) {
            return tDefault;
        }
        if (!tClass.isInstance(object)) {
            throw new IllegalArgumentException(path + " is not of type " + tClass.getSimpleName());
        }
        return tClass.cast(object);
    }

    public List<String> getStringList(String path) {
        if (!has(path)) {
            return new ArrayList<>();
        }
        return config.getStringList(path);
    }
}

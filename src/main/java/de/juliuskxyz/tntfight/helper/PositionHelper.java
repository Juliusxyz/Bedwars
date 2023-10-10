package de.juliuskxyz.tntfight.helper;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class PositionHelper {

    private static File file;
    private static FileConfiguration customFile;

    public static void setup() {
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("TNTFight").getDataFolder(), "locations.yml");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var1) {
                Bukkit.getLogger().warning("Die Datei 'locations.yml' konnte nicht erstellt werden!");
                Bukkit.getLogger().warning("The file 'locations.yml' could not be created!");
            }
        }

        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get() {
        return customFile;
    }

    public static void save() {
        try {
            customFile.save(file);
        } catch (IOException var1) {
            Bukkit.getLogger().warning("Die datei 'locations.yml' konnte nicht gesichert werden!");
            Bukkit.getLogger().warning("The file 'locations.yml' could not be saved!");
        }
    }

    public static void reload() {
        customFile = YamlConfiguration.loadConfiguration(file);
    }

}

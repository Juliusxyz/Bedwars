package de.juliuskxyz.bedwars.utils;

import de.juliuskxyz.bedwars.helper.PositionHelper;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ItemSpawner {

    public static Boolean gameIsRunning = false;

    public static void ironSpawner(Plugin plugin) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (gameIsRunning) {
                    if (PositionHelper.get().getLocation("blue.spawner.iron") != null) {
                        Location loc = PositionHelper.get().getLocation("blue.spawner.iron");
                        ItemStack iron = new ItemStack(Material.IRON_INGOT);
                        plugin.getServer().getWorld("world").dropItem(loc, iron);
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 25);
    }
}

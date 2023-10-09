package de.juliuskxyz.tntfight.listeners;

import de.juliuskxyz.tntfight.TNTFight;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.FallingBlock;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

public class SandBotListener implements Listener {

    private BukkitTask task;
    private int keepToSpawn = 0;

    private final TNTFight plugin;
    public SandBotListener(TNTFight plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlaceSandbot(org.bukkit.event.block.BlockPlaceEvent e) {
        Material spawnType = e.getBlockPlaced().getType(); // get placed block
        if(!spawnType.equals(Material.SEA_LANTERN)) // in your case, be sure it's sea lantern
            return;
        keepToSpawn = 5; // amount of spawned item
        Location loc = e.getBlock().getLocation(); // location where entity will spawn
        task = Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            // each 0.5s, we made spawn a falling block of given type
            run(loc, spawnType);
            if(keepToSpawn == 0)
                task.cancel();
            keepToSpawn--;
        }, 10, 10); // 10 ticks = 0.5 seconds
    }

    @SuppressWarnings("deprecation")
    private void run(Location loc, Material type) {
        FallingBlock falling = loc.getWorld().spawnFallingBlock(loc, Material.SAND, (byte) 0);
        falling.setDropItem(true);
        falling.setVelocity(new Vector(0, -0.5, 0)); // set the velicoty of the block
    }

}

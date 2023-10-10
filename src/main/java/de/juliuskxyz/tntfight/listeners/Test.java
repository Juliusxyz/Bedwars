package de.juliuskxyz.tntfight.listeners;

import de.juliuskxyz.tntfight.TNTFight;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class Test implements Listener {

    private static TNTFight plugin;
    public Test(TNTFight plugin) {
        this.plugin = plugin;
    }

    int countdown = plugin.getConfig().getInt("deathCoolDown");

    @EventHandler
    public void Death(PlayerDeathEvent event) {
        DeathCountDown(event.getPlayer());
    }

    public static String getString(String path) {
        return plugin.getConfig().getString(path);
    }

    public void DeathCountDown(Player p) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (countdown > 0) {
                    countdown--;
                    p.sendTitle(getString("messages.player.title"), getString("messages.player.title").replaceAll("%time%", String.valueOf((countdown + 1))), 0, 20, 10);
                }else {
                    p.setInvisible(false);
                    p.setFlying(false);
                    p.setAllowFlight(false);
                    p.sendMessage(getString("messages.player.respawnMessage"));
                    p.setGameMode(GameMode.SURVIVAL);
                    cancel();
                    countdown = plugin.getConfig().getInt("deathCoolDown");
                }
            }
        }.runTaskTimer(plugin, 0, 20);

    }

}

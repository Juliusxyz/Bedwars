package de.juliuskxyz.bedwars.utils;

import de.juliuskxyz.bedwars.Bedwars;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerDeathCountdown {

    private static Bedwars plugin;
    public PlayerDeathCountdown(Bedwars plugin) {
        this.plugin = plugin;
    }

    private static String getString(String path) {
        return plugin.getConfig().getString(path);
    }

    public static void DeathCountDown(Player p) {
        new BukkitRunnable() {

            int countdown = plugin.getConfig().getInt("deathCoolDown");

            @Override
            public void run() {
                if (countdown > 0) {
                    countdown--;
                    p.sendTitle(getString("title.death.title"), getString("title.death.subtitle").replaceAll("%time%", String.valueOf((countdown + 1))), 0, 20, 10);
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

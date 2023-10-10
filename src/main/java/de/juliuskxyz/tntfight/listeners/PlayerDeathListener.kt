package de.juliuskxyz.tntfight.listeners

import de.juliuskxyz.tntfight.TNTFight
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.scheduler.BukkitRunnable

class PlayerDeathListener(private val plugin: TNTFight) : Listener {

    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        e.isCancelled = true
        e.player.gameMode = GameMode.SPECTATOR
        for (allPlayers in Bukkit.getOnlinePlayers()) {
            plugin.config.getString("messages.player.eliminated")?.let { allPlayers.sendMessage(it.replace("%player%".toRegex(), e.player.name)) }
        }
    }
}

package de.juliuskxyz.tntfight.listeners

import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerDeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        val p = e.player
        e.player.gameMode = GameMode.SPECTATOR
    }
}
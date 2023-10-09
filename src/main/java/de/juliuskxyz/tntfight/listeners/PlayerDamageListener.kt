package de.juliuskxyz.tntfight.listeners

import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent


class PlayerDamageListener : Listener {
    @EventHandler
    fun onDeath(e: PlayerDeathEvent) {
        val player = e.player
        e.player.gameMode = GameMode.SPECTATOR
    }
}
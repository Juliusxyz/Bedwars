package de.juliuskxyz.tntfight.listeners

import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class PlayerDeathListener : Listener {
    @EventHandler
    fun onPlayerDeath(e: EntityDamageEvent) {
        if (e.entity is Player) {
            val p = e.entity as Player
            if (p.health <= 0) {
                p.gameMode = GameMode.SPECTATOR
            }
        }
    }
}

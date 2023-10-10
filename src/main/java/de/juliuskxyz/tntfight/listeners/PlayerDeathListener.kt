package de.juliuskxyz.tntfight.listeners

import de.juliuskxyz.tntfight.TNTFight
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeathListener(private val plugin: TNTFight) : Listener {

    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {
        e.isCancelled = true;
        e.player.gameMode = GameMode.SPECTATOR;

    }
}

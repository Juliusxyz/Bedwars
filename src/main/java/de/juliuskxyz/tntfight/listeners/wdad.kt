package de.juliuskxyz.tntfight.listeners

import de.juliuskxyz.tntfight.TNTFight
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class wdad(private val plugin: TNTFight) : Listener {
    @EventHandler
    fun PlayerDeathEvent(event: PlayerDeathEvent) {
        event.isCancelled = true
        event.player.gameMode = GameMode.SPECTATOR
        for (allPlayers in Bukkit.getOnlinePlayers()) {
            allPlayers.sendMessage("HALLO %s".replace("%s".toRegex(), "hallo"))
        }
    }
}

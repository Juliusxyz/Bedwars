package de.juliuskxyz.tntfight.listeners

import de.juliuskxyz.tntfight.TNTFight
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener(private val plugin: TNTFight) : Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        e.joinMessage = plugin.config.getString("player.join.message")!!.replace("%player%".toRegex(), e.player.name)
    }
}
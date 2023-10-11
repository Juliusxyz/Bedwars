package de.juliuskxyz.bedwars.listeners

import de.juliuskxyz.bedwars.Bedwars
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

class PlayerJoinListener(private val plugin: Bedwars) : Listener {
    @EventHandler
    fun onPlayerJoin(e: PlayerJoinEvent) {
        e.joinMessage = plugin.config.getString("messages.player.join")!!.replace("%player%".toRegex(), e.player.name)
    }
}
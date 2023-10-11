package de.juliuskxyz.bedwars.listeners

import de.juliuskxyz.bedwars.Bedwars
import de.juliuskxyz.bedwars.utils.PlayerDeathCountdown
import org.bukkit.Bukkit
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.PlayerDeathEvent

class PlayerDeathListener(private val plugin: Bedwars) : Listener {

    @EventHandler
    fun onPlayerDeath(e: PlayerDeathEvent) {

        //Cancel the event and changes the Players property
        e.isCancelled = true
        e.player.gameMode = GameMode.SPECTATOR

        // Sends the death message to everyone
        for (allPlayers in Bukkit.getOnlinePlayers()) {
            plugin.config.getString("messages.player.eliminated")?.let { allPlayers.sendMessage(it.replace("%player%".toRegex(), e.player.name)) }
        }

        // Starts the Countdown for the People
        PlayerDeathCountdown.DeathCountDown(e.player);
    }
}

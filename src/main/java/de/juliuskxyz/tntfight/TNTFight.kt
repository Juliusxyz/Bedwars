package de.juliuskxyz.tntfight

import de.juliuskxyz.tntfight.commands.SetLocation
import de.juliuskxyz.tntfight.commands.StartGame
import de.juliuskxyz.tntfight.commands.StopGame
import de.juliuskxyz.tntfight.commands.TeleportTo
import de.juliuskxyz.tntfight.helper.PositionHelper
import de.juliuskxyz.tntfight.listeners.PlayerDeathListener
import de.juliuskxyz.tntfight.listeners.PlayerJoinListener
import de.juliuskxyz.tntfight.tabcompleter.SetLocationTabCompleter
import de.juliuskxyz.tntfight.tabcompleter.TeleportToTabCompleter
import org.bukkit.plugin.java.JavaPlugin

class TNTFight : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        println("------------------")
        println("TNT Fight enabled!")
        println("------------------")
        logger.info("Hello World!")

        config.options().copyDefaults()
        saveDefaultConfig()
        PositionHelper.setup()

        server.pluginManager.registerEvents(PlayerDeathListener(this), this)
        server.pluginManager.registerEvents(PlayerJoinListener(this), this)

        getCommand("setlocation")?.setExecutor(SetLocation(this))
        getCommand("setlocation")?.setTabCompleter(SetLocationTabCompleter())

        getCommand("teleportto")?.setExecutor(TeleportTo(this))
        getCommand("teleportto")?.setTabCompleter(TeleportToTabCompleter())

        getCommand("start")?.setExecutor(StartGame(this))

        getCommand("stopGame")?.setExecutor(StopGame())
    }
    override fun onDisable() {
        // Plugin shutdown logic
        println("------------------")
        println("TNT Fight disabled!")
        println("------------------")
    }
}

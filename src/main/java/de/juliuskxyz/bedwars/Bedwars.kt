package de.juliuskxyz.bedwars

import de.juliuskxyz.bedwars.commands.SetLocation
import de.juliuskxyz.bedwars.commands.StartGame
import de.juliuskxyz.bedwars.commands.StopGame
import de.juliuskxyz.bedwars.commands.TeleportTo
import de.juliuskxyz.bedwars.helper.PositionHelper
import de.juliuskxyz.bedwars.listeners.PlayerDeathListener
import de.juliuskxyz.bedwars.listeners.PlayerJoinListener
import de.juliuskxyz.bedwars.tabcompleter.SetLocationTabCompleter
import de.juliuskxyz.bedwars.tabcompleter.TeleportToTabCompleter
import org.bukkit.plugin.java.JavaPlugin

class Bedwars : JavaPlugin() {

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

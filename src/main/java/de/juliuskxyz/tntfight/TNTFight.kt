package de.juliuskxyz.tntfight

import de.juliuskxyz.tntfight.commands.vanish
import de.juliuskxyz.tntfight.listeners.PlayerDeathListener
import de.juliuskxyz.tntfight.listeners.PlayerJoinListener
import de.juliuskxyz.tntfight.listeners.Test
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

        server.pluginManager.registerEvents(PlayerDeathListener(this), this)
        server.pluginManager.registerEvents(PlayerJoinListener(this), this)

        server.pluginManager.registerEvents(Test(this), this)

        getCommand("vanish")?.setExecutor(vanish())
    }
    override fun onDisable() {
        // Plugin shutdown logic
        println("------------------")
        println("TNT Fight disabled!")
        println("------------------")
    }
}

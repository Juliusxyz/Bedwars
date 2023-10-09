package de.juliuskxyz.tntfight

import de.juliuskxyz.tntfight.listeners.PlayerDamageListener
import de.juliuskxyz.tntfight.listeners.PlayerJoinListener
import org.bukkit.plugin.java.JavaPlugin

class TNTFight : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        println("------------------")
        println("TNT Fight enabled!")
        println("------------------")
        logger.info("Hello World!")

        server.pluginManager.registerEvents(PlayerDamageListener(), this)
        server.pluginManager.registerEvents(PlayerJoinListener(), this)
    }
    override fun onDisable() {
        // Plugin shutdown logic
        println("------------------")
        println("TNT Fight disabled!")
        println("------------------")
    }

}
package de.juliuskxyz.tntfight

import de.juliuskxyz.tntfight.listeners.EntityShootBowEvent
import de.juliuskxyz.tntfight.listeners.PlayerBreakBlockEvent
import de.juliuskxyz.tntfight.listeners.PlayerDeathListener
import de.juliuskxyz.tntfight.listeners.PlayerJoinListener
import org.bukkit.plugin.java.JavaPlugin

class TNTFight : JavaPlugin() {

    override fun onEnable() {
        // Plugin startup logic
        println("------------------")
        println("TNT Fight enabled!")
        println("------------------")
        logger.info("Hello World!")

        server.pluginManager.registerEvents(PlayerDeathListener(), this)
        server.pluginManager.registerEvents(PlayerBreakBlockEvent(), this)
        server.pluginManager.registerEvents(PlayerJoinListener(this), this)
        server.pluginManager.registerEvents(EntityShootBowEvent(this), this)

        config.options().copyDefaults()
        saveDefaultConfig()
    }
    override fun onDisable() {
        // Plugin shutdown logic
        println("------------------")
        println("TNT Fight disabled!")
        println("------------------")
    }
}

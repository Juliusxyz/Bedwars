package de.juliuskxyz.tntfight

import de.juliuskxyz.tntfight.listeners.PlayerBreakBlockEvent
import de.juliuskxyz.tntfight.listeners.PlayerDeathListener
import de.juliuskxyz.tntfight.listeners.PlayerJoinListener
import de.juliuskxyz.tntfight.listeners.SandBotListener
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

        config.options().copyDefaults()
        saveDefaultConfig()

        instance = this // here set the instance of this, so as the current object

        // it will make this object available for everyone
        // it will make this object available for everyone
        server.pluginManager.registerEvents(SandBotListener(this), this);

    }
    override fun onDisable() {
        // Plugin shutdown logic
        println("------------------")
        println("TNT Fight disabled!")
        println("------------------")
    }

    private var instance // create variable that is "static".
            : TNTFight? = null

    // It means it not depend to an object to get it
    fun getInstance(): TNTFight? { // get the object instance, so the plugin instance
        return instance
    }
}

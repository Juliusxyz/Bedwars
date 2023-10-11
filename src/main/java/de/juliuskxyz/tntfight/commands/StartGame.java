package de.juliuskxyz.tntfight.commands;

import de.juliuskxyz.tntfight.TNTFight;
import de.juliuskxyz.tntfight.utils.ItemSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StartGame implements CommandExecutor {

    private final TNTFight plugin;
    public StartGame(TNTFight plugin) {
        this.plugin = plugin;
    }

    Boolean haveBeenTriggertBefore = false;

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        ItemSpawner.gameIsRunning = true;
        if (haveBeenTriggertBefore == false) {
            haveBeenTriggertBefore = true;
            ItemSpawner.ironSpawner(plugin);
        }

        commandSender.sendMessage("§aThe Game is starting now!");

        return false;
    }
}

package de.juliuskxyz.bedwars.commands;

import de.juliuskxyz.bedwars.Bedwars;
import de.juliuskxyz.bedwars.utils.ItemSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StartGame implements CommandExecutor {

    private final Bedwars plugin;
    public StartGame(Bedwars plugin) {
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

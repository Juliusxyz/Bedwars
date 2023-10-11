package de.juliuskxyz.bedwars.commands;

import de.juliuskxyz.bedwars.utils.ItemSpawner;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StopGame implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        ItemSpawner.gameIsRunning = false;

        commandSender.sendMessage("§cThe Game is stopped now!");

        return false;
    }
}

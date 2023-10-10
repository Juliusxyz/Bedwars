package de.juliuskxyz.tntfight.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class vanish implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;

            if (p.isInvisible()) {
                p.setInvisible(false);
                p.setAllowFlight(false);
                p.setFlying(false);
                p.sendMessage("§cDu bist nicht mehr unsichtbar");
            }else {
                p.setInvisible(true);
                p.setAllowFlight(true);
                p.setFlying(true);
                p.sendMessage("§aDu bist jetzt unsichtbar");
            }

        }

        return false;
    }
}

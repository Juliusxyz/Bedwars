package de.juliuskxyz.tntfight.commands;

import de.juliuskxyz.tntfight.TNTFight;
import de.juliuskxyz.tntfight.helper.PositionHelper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class TeleportTo implements CommandExecutor {

    private static TNTFight plugin;
    public TeleportTo(TNTFight plugin) {
        this.plugin = plugin;
    }

    private static String getString(String path) {
        return plugin.getConfig().getString(path);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player))  {return false;}

        Player p = (Player) commandSender;

        if (args.length == 1) {
            if (PositionHelper.get().getLocation("lobby") != null) {
                Location loc = PositionHelper.get().getLocation("lobby");
                p.teleport(loc);
            }
        }

        if (args.length == 2) {
            if (PositionHelper.get().getLocation(args[0].toLowerCase() + "." + args[1].toLowerCase()) != null) {
                Location loc = PositionHelper.get().getLocation(args[0].toLowerCase() + "." + args[1].toLowerCase());
                p.teleport(loc);
            }
        }else if (args.length == 3) {
            if (PositionHelper.get().getLocation(args[0].toLowerCase() + "." + args[1].toLowerCase() + "." + args[2].toLowerCase()) != null) {
                Location loc = PositionHelper.get().getLocation(args[0].toLowerCase() + "." + args[1].toLowerCase() + "." + args[2].toLowerCase());
                p.teleport(loc);
            }
        }else {
            p.sendMessage("§cThis Location is not available");
        }

        return false;
    }
}

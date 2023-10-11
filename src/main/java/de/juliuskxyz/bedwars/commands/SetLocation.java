package de.juliuskxyz.bedwars.commands;

import de.juliuskxyz.bedwars.Bedwars;
import de.juliuskxyz.bedwars.helper.PositionHelper;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetLocation implements CommandExecutor {

    private static Bedwars plugin;
    public SetLocation(Bedwars plugin) {
        this.plugin = plugin;
    }

    private static String getString(String path) {
        return plugin.getConfig().getString(path);
    }

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {

        if (!(commandSender instanceof Player)) {return false;}

        Player p = (Player) commandSender;

        if (args.length == 1) {

            if (args[0].toLowerCase().equals("lobby")) {
                Location loc = p.getLocation();
                PositionHelper.get().set(args[0], loc);
                PositionHelper.save();
                p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase()));

            }else {
                p.sendMessage(getString("command.noAvailableArgu"));
            }
        } else if (args.length == 2) {

            if (args[0].toLowerCase().equals("red") && args[1].toLowerCase().equals("spawnpoint")) {
                Location loc = p.getLocation();
                PositionHelper.get().set(args[0] + "." + args[1], loc);
                PositionHelper.save();
                p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase()));
            }else if (args[0].toLowerCase().equals("blue") && args[1].toLowerCase().equals("spawnpoint")) {
                Location loc = p.getLocation();
                PositionHelper.get().set(args[0] + "." + args[1], loc);
                PositionHelper.save();
                p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase()));
            }else {
                p.sendMessage(getString("command.noAvailableArgu"));
            }
        }else if (args.length == 3) {
            if (args[0].toLowerCase().equals("red") && args[1].toLowerCase().equals("spawner")) {
                if (args[2].toLowerCase().equals("iron")) {
                    Location loc = p.getLocation();
                    PositionHelper.get().set(args[0] + "." + args[1] + "." + args[2], loc);
                    PositionHelper.save();
                    p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase() + " " + args[2].toLowerCase()));
                }else if (args[2].toLowerCase().equals("gold")) {
                    Location loc = p.getLocation();
                    PositionHelper.get().set(args[0] + "." + args[1] + "." + args[2], loc);
                    PositionHelper.save();
                    p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase() + " " + args[2].toLowerCase()));
                }else {
                    p.sendMessage(getString("command.noAvailableArgu"));
                }
            }else if (args[0].toLowerCase().equals("blue") && args[1].toLowerCase().equals("spawner")) {
                if (args[2].toLowerCase().equals("iron")) {
                    Location loc = p.getLocation();
                    PositionHelper.get().set(args[0] + "." + args[1] + "." + args[2], loc);
                    PositionHelper.save();
                    p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase() + " " + args[2].toLowerCase()));
                }else if (args[2].toLowerCase().equals("gold")) {
                    Location loc = p.getLocation();
                    PositionHelper.get().set(args[0] + "." + args[1] + "." + args[2], loc);
                    PositionHelper.save();
                    p.sendMessage(getString("command.setLocation").replaceAll("%locationName%", args[0].toLowerCase() + " " + args[1].toLowerCase() + " " + args[2].toLowerCase()));
                }else {
                    p.sendMessage(getString("command.noAvailableArgu"));
                }
            }else {
                p.sendMessage(getString("command.noAvailableArgu"));
            }
        }else {
            p.sendMessage(getString("command.noAvailableArgu"));
        }

        return false;
    }
}

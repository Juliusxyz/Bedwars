package de.juliuskxyz.tntfight.tabcompleter;

import de.juliuskxyz.tntfight.helper.PositionHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TeleportToTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String arg = args[0].toLowerCase();
            if ("red".startsWith(arg)) {
                if (PositionHelper.get().getString("red") != null) {
                    completions.add("red");
                }
            }
            if ("blue".startsWith(arg)) {
                if (PositionHelper.get().getString("blue") != null) {
                    completions.add("blue");
                }
            }

            if ("lobby".startsWith(arg)){
                if (PositionHelper.get().getString("lobby") != null) {
                    completions.add("lobby");
                }
            }
        }

        if (args.length == 2) {
            String arg = args[0].toLowerCase();
            if ("spawner".startsWith(arg) && args[0].equalsIgnoreCase("red")) {
                if (PositionHelper.get().getString("red.spawner") != null) {
                    completions.add("spawner");
                }
            }

            if ("spawnpoint".startsWith(arg) && args[0].equalsIgnoreCase("red")) {
                if (PositionHelper.get().getString("red.spawnpoint") != null) {
                    completions.add("spawnpoint");
                }
            }

            if ("spawner".startsWith(arg) && args[0].equalsIgnoreCase("blue")) {
                if (PositionHelper.get().getString("blue.spawner") != null) {
                    completions.add("spawner");
                }
            }

            if ("spawnpoint".startsWith(arg) && args[0].equalsIgnoreCase("blue")) {
                if (PositionHelper.get().getString("blue.spawnpoint") != null) {
                    completions.add("spawnpoint");
                }
            }

        }

        if (args.length == 3 && args[1].equalsIgnoreCase("spawner")) {
            String arg = args[2].toLowerCase();
            if ("iron".startsWith(arg) && args[0].equalsIgnoreCase("red") && args[1].equalsIgnoreCase("spawner")) {
                if (PositionHelper.get().getLocation("red.spawner.iron") != null) {
                    completions.add("iron");
                }
            }
            if ("gold".startsWith(arg) && args[0].equalsIgnoreCase("red") && args[1].equalsIgnoreCase("spawner")) {
                if (PositionHelper.get().getLocation("red.spawner.gold") != null) {
                    completions.add("gold");
                }
            }

            if ("iron".startsWith(arg) && args[0].equalsIgnoreCase("blue") && args[1].equalsIgnoreCase("spawner")) {
                if (PositionHelper.get().getLocation("blue.spawner.iron") != null) {
                    completions.add("iron");
                }
            }
            if ("gold".startsWith(arg) && args[0].equalsIgnoreCase("blue") && args[1].equalsIgnoreCase("spawner")) {
                if (PositionHelper.get().getLocation("blue.spawner.gold") != null) {
                    completions.add("gold");
                }
            }
        }


        return completions;
    }

}

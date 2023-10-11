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


        if (args.length > 1) {
            if (args[0].equalsIgnoreCase("red")) {
                if (args.length == 1) {
                    String arg = args[0].toLowerCase();
                    if ("red".startsWith(arg)) {
                        if (PositionHelper.get().getString("red") != null) {
                            completions.add("red");
                        }
                    }
                }
                if (args.length == 2) {

                    String arg = args[1].toLowerCase();
                    if ("spawnpoint".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("red.spawnpoint") != null) {
                            completions.add("spawnpoint");
                        }
                    }
                    if ("spawner".startsWith(arg)) {
                        if (PositionHelper.get().getString("red.spawner") != null) {
                            completions.add("spawner");
                        }
                    }
                }
                if (args.length == 3) {
                    String arg = args[2].toLowerCase();
                    if ("iron".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("red.spawner.iron") != null) {
                            completions.add("iron");
                        }
                    }
                    if ("gold".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("red.spawner.gold") != null) {
                            completions.add("gold");
                        }
                    }
                }
            }
            if (args[0].equalsIgnoreCase("blue")) {
                if (args.length == 1) {
                    String arg = args[0].toLowerCase();
                    if ("blue".startsWith(arg)) {
                        if (PositionHelper.get().getString("blue") != null) {
                            completions.add("blue");
                        }
                    }
                }
                if (args.length == 2) {

                    String arg = args[1].toLowerCase();
                    if ("spawnpoint".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("blue.spawnpoint") != null) {
                            completions.add("spawnpoint");
                        }
                    }
                    if ("spawner".startsWith(arg)) {
                        if (PositionHelper.get().getString("blue.spawner") != null) {
                            completions.add("spawner");
                        }
                    }
                }
                if (args.length == 3) {
                    String arg = args[2].toLowerCase();
                    if ("iron".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("blue.spawner.iron") != null) {
                            completions.add("iron");
                        }
                    }
                    if ("gold".startsWith(arg)) {
                        if (PositionHelper.get().getLocation("blue.spawner.gold") != null) {
                            completions.add("gold");
                        }
                    }
                }
            }
        }

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
        }

        if (args.length == 2) {

        }

        if (args.length == 3 && args[1].equalsIgnoreCase("spawner")) {

        }


        return completions;
    }

}

package de.juliuskxyz.bedwars.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SetLocationTabCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        List<String> completions = new ArrayList<>();

        if (args.length == 1) {
            String arg = args[0].toLowerCase();
            if ("red".startsWith(arg)) {
                completions.add("red");
            }
            if ("blue".startsWith(arg)) {
                completions.add("blue");
            }
            if ("lobby".startsWith(arg)) {
                completions.add("lobby");
            }
        }

        if (args.length == 2) {
            String arg = args[1].toLowerCase();
            if ("spawnpoint".startsWith(arg)) {
                completions.add("spawnpoint");
            }
            if ("spawner".startsWith(arg)) {
                completions.add("spawner");
            }
        }

        if (args.length == 3 && args[1].equalsIgnoreCase("spawner")) {
            String arg = args[2].toLowerCase();
            if ("iron".startsWith(arg)) {
                completions.add("iron");
            }
            if ("gold".startsWith(arg)) {
                completions.add("gold");
            }
        }

        return completions;
    }

}

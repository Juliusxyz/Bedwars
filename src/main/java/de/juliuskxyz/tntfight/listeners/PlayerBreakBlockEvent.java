package de.juliuskxyz.tntfight.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakBlockEvent implements Listener {

    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent event) {
        if (event.getBlock().getType() == Material.NOTE_BLOCK) {
            event.setCancelled(true);
            event.getBlock().setType(Material.AMETHYST_BLOCK);
        }
    }

}

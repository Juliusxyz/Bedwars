package de.juliuskxyz.tntfight.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerBreakBlockEvent implements Listener {


    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.NOTE_BLOCK) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);
            e.getPlayer().getInventory().addItem(new ItemStack(Material.DIAMOND_BLOCK));
        }
    }

}

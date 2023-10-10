package de.juliuskxyz.tntfight.listeners;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerBreakBlockEvent implements Listener {


    @EventHandler
    public void BlockBreakEvent(BlockBreakEvent e) {
        if (e.getBlock().getType() == Material.NOTE_BLOCK) {
            e.setCancelled(true);
            e.getBlock().setType(Material.AIR);

            ItemStack TNTtoShoot = new ItemStack(Material.TNT);
            ItemMeta TNTtoShootMeta = TNTtoShoot.getItemMeta();
            TNTtoShootMeta.setDisplayName("§cTNT");
            TNTtoShoot.setItemMeta(TNTtoShootMeta);
            e.getPlayer().getInventory().addItem(TNTtoShoot);
        }
    }

}

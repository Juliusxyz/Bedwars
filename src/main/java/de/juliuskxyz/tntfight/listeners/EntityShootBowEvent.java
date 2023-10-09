package de.juliuskxyz.tntfight.listeners;

import de.juliuskxyz.tntfight.TNTFight;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.util.BlockIterator;

import java.util.List;

public class EntityShootBowEvent implements Listener {

    private final TNTFight plugin;
    private String MasterBow = "Master Bow";
    private String ExplodingArrows = "Exploding Arrows";

    public EntityShootBowEvent(TNTFight plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onFireBow(org.bukkit.event.entity.EntityShootBowEvent e) {

        Player p = (Player) e.getEntity();
        Object getItemNameInHand = p.getItemInHand().getItemMeta().getDisplayName();
        List<String> getItemLoreInHand = p.getItemInHand().getItemMeta().getLore();

        if (e.getEntityType() == EntityType.PLAYER) {
            if (MasterBow.equals(getItemNameInHand)) {
                if (getItemLoreInHand.contains(ExplodingArrows)) {
                    if (!p.getInventory().contains(Material.TNT)) {
                        e.setCancelled(true);
                        p.sendMessage(plugin.getConfig().getString("player.notEnoughTNT.message"));
                    } else {
                        Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                            public void run() {
                                TNTPrimed tnt = p.getWorld().spawn(e.getProjectile().getLocation().add(0, 1, 0), TNTPrimed.class);

                                tnt.setIsIncendiary(false);
                                tnt.setTicksLived(5);
                                tnt.setFuseTicks(2000);
                                e.getProjectile().setPassenger(tnt);

                                if (e.getProjectile().getHeight() > 10){
                                    e.getProjectile().remove();
                                }

                            }
                        }, 5L);
                    }
                }
            }
        }
    }

    @EventHandler
    public void onProjectileHit2(ProjectileHitEvent event) {
        Projectile projectile = event.getEntity();

        if (!(projectile instanceof Arrow)) { /* do nothing */ } else {
            Arrow arrowProj = (Arrow) projectile;
            Player player = (Player) arrowProj.getShooter();
            World world = arrowProj.getWorld();
            BlockIterator bi = new BlockIterator(world, arrowProj.getLocation().toVector(), arrowProj.getVelocity().normalize(), 0, 4);
            Block hit = null;
            Location loc = null;

            if ((event.getEntity().getShooter() instanceof Player)) {
                Object getItemNameInHand = player.getItemInHand().getItemMeta().getDisplayName();
                List<String> getItemLoreInHand = player.getItemInHand().getItemMeta().getLore();

                while (bi.hasNext()) {
                    hit = bi.next();
                    loc = hit.getLocation();
                    int x = loc.getBlockX();
                    int y = loc.getBlockY();
                    int z = loc.getBlockZ();

                    if (MasterBow.equals(getItemNameInHand)) {
                        if (getItemLoreInHand.contains(ExplodingArrows)) {
                            arrowProj.getPassenger().remove();
                            arrowProj.remove();
                            arrowProj.getWorld().createExplosion(x, y, z, 4, false, true);
                        }
                    }
                    break;
                }
            }
        }
    }
}

package com.titongames.titonplus;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlusListener implements Listener {
    public Main plugin;

    public PlusListener(Main tplus) {
        plugin = tplus;
    }

    // pipe smokin' with bonemeal!
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent pipesmoke) {
        if (pipesmoke.hasItem() && (pipesmoke.getAction().equals(Action.RIGHT_CLICK_AIR) || pipesmoke.getAction().equals(Action.RIGHT_CLICK_BLOCK))) {
            if (pipesmoke.getItem().getType().equals(Material.INK_SACK) && pipesmoke.getItem().getDurability() == 15) {
                if (pipesmoke.getPlayer().isSneaking()) {
                    double distance = 0.7;
                    Location player_loc = pipesmoke.getPlayer().getLocation();
                    double rot_x = (player_loc.getYaw() + 90) % 360;
                    double rot_y = player_loc.getPitch() * -1;
                    double rot_ycos = Math.cos(Math.toRadians(rot_y));
                    double rot_ysin = Math.sin(Math.toRadians(rot_y));
                    double rot_xcos = Math.cos(Math.toRadians(rot_x));
                    double rot_xsin = Math.sin(Math.toRadians(rot_x));

                    double h_length = (distance * rot_ycos);
                    double y_offset = (distance * rot_ysin);
                    double x_offset = (h_length * rot_xcos);
                    double z_offset = (h_length * rot_xsin);

                    double target_x = x_offset + player_loc.getX();
                    double target_y = y_offset + player_loc.getY() + 1.65;
                    double target_z = z_offset + player_loc.getZ();

                    pipesmoke.getPlayer().getWorld()
                            .playEffect(new Location(player_loc.getWorld(), target_x, target_y, target_z), Effect.SMOKE, getSmokeDir(player_loc.getYaw()));
                } else {
                    double distance = 0.7;
                    Location player_loc = pipesmoke.getPlayer().getLocation();
                    double rot_x = (player_loc.getYaw() + 90) % 360;
                    double rot_y = player_loc.getPitch() * -1;
                    double rot_ycos = Math.cos(Math.toRadians(rot_y));
                    double rot_ysin = Math.sin(Math.toRadians(rot_y));
                    double rot_xcos = Math.cos(Math.toRadians(rot_x));
                    double rot_xsin = Math.sin(Math.toRadians(rot_x));

                    double h_length = (distance * rot_ycos);
                    double y_offset = (distance * rot_ysin);
                    double x_offset = (h_length * rot_xcos);
                    double z_offset = (h_length * rot_xsin);

                    double target_x = x_offset + player_loc.getX();
                    double target_y = y_offset + player_loc.getY() + 1.65;
                    double target_z = z_offset + player_loc.getZ();

                    pipesmoke.getPlayer().getWorld().playEffect(new Location(player_loc.getWorld(), target_x, target_y, target_z), Effect.SMOKE, 4);
                }
            }
        }
    }

    public static int getSmokeDir(float yaw) { // 0 - west 90 - north 180 - east
        // 270 - south
        if (yaw < 0) {
            yaw += 360;
        }
        if (yaw >= 0) {
            if (yaw <= 22.5) {
                return 7;
            }
            if (yaw <= 77.5) {
                return 6;
            }
            if (yaw <= 112.5) {
                return 3;
            }
            if (yaw <= 157.5) {
                return 0;
            }
            if (yaw <= 202.5) {
                return 1;
            }
            if (yaw <= 247.5) {
                return 2;
            }
            if (yaw <= 292.5) {
                return 5;
            }
            if (yaw <= 337.5) {
                return 8;
            } else {
                return 7;
            }
        }
        return 4;
    }
}

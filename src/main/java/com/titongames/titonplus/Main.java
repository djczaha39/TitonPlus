package com.titongames.titonplus;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class Main extends JavaPlugin {
    private PlusListener plistener;
    public static final String PLUGIN_NAME = "TitonGuest";

    @Override
    public void onDisable() {
        getLogger().info("Starting " + PLUGIN_NAME);
    }

    @Override
    public void onEnable() {
        plistener = new PlusListener(this);
        Bukkit.getPluginManager().registerEvents(plistener, this);
        getLogger().info("Disabling " + PLUGIN_NAME);
    }

    // test command, to be removed later
    @Override
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
        String commandName = command.getName().toLowerCase();

        // thelm code
        if (commandName.equalsIgnoreCase("thelm")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (args.length >= 2) {
                    player.sendMessage("Too many arguements!");
                } else {
                    int thelmid = Integer.parseInt(args[0]);
                    ItemStack thelmstack = new ItemStack(thelmid);
                    player.getInventory().setHelmet(thelmstack);
                    player.sendMessage("You have something on your head. LOL!");
                    return true;
                }
                return true;
            }
            return true;
        }

        // tsit code
        if (commandName.equalsIgnoreCase("tsit")) {
            if (sender instanceof Player && sender.hasPermission("titonplus.tsit")) {
                Player player = (Player) sender;
                Player sittingPlayer = null;

                if (args.length > 0) {
                    sittingPlayer = Bukkit.getServer().getPlayer(args[0]);
                }

                if (args.length >= 2) {
                    player.sendMessage("Too Many Arguements!");
                } else {
                    if (sittingPlayer == null) {
                        player.sendMessage(ChatColor.GOLD + "Player was not found!");
                    } else if (sittingPlayer.getPassenger() == sittingPlayer) {
                        sittingPlayer.eject();
                        sittingPlayer.sendMessage(ChatColor.GOLD + "You are no longer sitting!");
                    } else if (sittingPlayer.getPassenger() == null) {
                        sittingPlayer.setPassenger(sittingPlayer);
                        player.sendMessage(ChatColor.GOLD + args[0] + " is now sitting!");
                        sittingPlayer.sendMessage(ChatColor.GOLD + "You are now sitting!");
                        return true;
                    }
                    return true;
                }
                return true;
            }
            return true;
        }
        return false;
    }
}

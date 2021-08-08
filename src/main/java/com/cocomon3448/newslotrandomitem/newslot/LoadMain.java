package com.cocomon3448.newslotrandomitem.newslot;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class LoadMain extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[NEW SLOT] PLUGIN LOADED!");
        Bukkit.getPluginManager().registerEvents(new EventLoader(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // TODO Auto-generated method stub
        if(command.getName().equalsIgnoreCase("resetplayer")) {
            if(sender instanceof Player) {
                Player player = (Player) sender;
                for(int i = 1; i<36; i++) {
                    player.getInventory().setItem(i, new ItemStack(Material.BARRIER, 1));
                }
                for(int i = 36; i<40; i++) {
                    player.getInventory().setItem(i, new ItemStack(Material.BARRIER, 1));
                }
                player.getInventory().setItem(40, new ItemStack(Material.BARRIER, 1));
                return false;
            }
            sender.sendMessage("플레이어가 쳐주셔야됩니다.");
            return false;
        }
        if(command.getName().equalsIgnoreCase("minseokbabo")) {
            Player p = (Player) sender;
            p.kickPlayer("킥 ㅅㄱ");
            return false;
        }
        return true;
    }

}

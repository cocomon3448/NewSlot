package com.cocomon3448.newslotrandomitem.newslot;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;


public class EventLoader implements Listener {
    Material[] materialsLst = new Material[]{Material.OAK_LOG, Material.STONE, Material.COAL_ORE, Material.IRON_ORE};

    @EventHandler
    public void isBlockBreak(BlockBreakEvent e) {
        if(check(materialsLst,e.getBlock().getType())) {
            Player p = e.getPlayer();
            int getIndex = check_int(materialsLst, e.getBlock().getType());
            if(p.getInventory().getItem(getIndex+1).equals(new ItemStack(Material.BARRIER))) {
                p.getInventory().setItem(getIndex+1, new ItemStack(Material.GOLDEN_APPLE, 1));
                p.sendMessage(ChatColor.GRAY+p.getName()+"이(가) 아이템을 알아냈습니다.");
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        if(e.getItemDrop().getItemStack().getType() == Material.BARRIER)
        {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {

        if (e.getCurrentItem().getType() == Material.BARRIER) {
            e.setCancelled(true);
        }
    }
    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {
        if(e.getBlock().getType() == Material.BARRIER) {
            e.setCancelled(true);
        }
    }

    public static boolean check(Material[] arr, Material toCheckValue)
    {
        boolean test = false;
        for (Material element : arr) {
            if (element == toCheckValue) {
                test = true;
                break;
            }
        }
        return test;
    }

    public static int check_int(Material[] arr, Material toCheckValue) {
        int i = 0;
        for (Material element : arr) {
            if (element == toCheckValue) {
                break;
            }
            i++;
        }
        return i;
    }
}
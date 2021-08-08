package com.cocomon3448.newslotrandomitem.newslot;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;


public class EventLoader implements Listener {
    Material[] materialsLst = new Material[] {
            Material.OAK_LOG, Material.STONE, Material.COAL_ORE, Material.IRON_ORE, Material.GOLD_ORE,
            Material.REDSTONE_ORE, Material.LAPIS_ORE, Material.DIAMOND_ORE, Material.ANCIENT_DEBRIS, Material.RED_CONCRETE,
            Material.OBSIDIAN, Material.BROWN_MUSHROOM_BLOCK, Material.ACACIA_BUTTON, Material.AMETHYST_BLOCK, Material.TRAPPED_CHEST,
            Material.ANVIL, Material.ENCHANTING_TABLE, Material.BARREL, Material.BASALT, Material.DRAGON_HEAD,
            Material.BLACK_STAINED_GLASS, Material.BLUE_WALL_BANNER, Material.CAULDRON, Material.DRIPSTONE_BLOCK, Material.STRIPPED_BIRCH_LOG,
            Material.PRISMARINE_BRICK_SLAB, Material.SEA_LANTERN, Material.DEEPSLATE_EMERALD_ORE, Material.NETHER_GOLD_ORE, Material.END_ROD,
            Material.BUBBLE_CORAL_BLOCK, Material.SHULKER_BOX, Material.CHEST,Material.ENDER_CHEST,Material.DEEPSLATE_BRICK_WALL
    };

    Material[] armorSlot = new Material[] {
            Material.COAL_BLOCK,Material.IRON_BLOCK,Material.DIAMOND_BLOCK, Material.LAPIS_BLOCK
    };

    Material[] leftHandSlot = new Material[] {
            Material.EMERALD_BLOCK
    };

    @EventHandler
    public void isBlockBreak(BlockBreakEvent e) {
        if(check(materialsLst,e.getBlock().getType())) {
            Player p = e.getPlayer();
            int getIndex = check_int(materialsLst, e.getBlock().getType());
            if(p.getInventory().getItem(getIndex+1).equals(new ItemStack(Material.BARRIER))) {
                p.getInventory().setItem(getIndex+1, new ItemStack(Material.GOLDEN_APPLE, 1));
                p.sendMessage(ChatColor.RED+p.getName()+ChatColor.GRAY+"님이 "+ChatColor.GOLD + "MINECRAFT:" +materialsLst[getIndex].toString()+ChatColor.GRAY+" 블럭을 파괴하여 인벤토리 한 칸이 잠금해제 되었습니다!");
            }
        }
        if(check(armorSlot,e.getBlock().getType())) {
            Player p = e.getPlayer();
            int getIndex = check_int(armorSlot, e.getBlock().getType());
            if(p.getInventory().getItem(getIndex+36).equals(new ItemStack(Material.BARRIER))) {
                p.getInventory().setItem(getIndex+36, new ItemStack(Material.GOLDEN_APPLE, 1));
                p.sendMessage(ChatColor.RED+p.getName()+"님이 "+ChatColor.GOLD + "MINECRAFT:" +armorSlot[getIndex].toString()+ChatColor.GRAY+" 블럭을 파괴하여 인벤토리 한 칸이 잠금해제 되었습니다!");
            }
        }
        if(check(leftHandSlot,e.getBlock().getType())) {
            Player p = e.getPlayer();
            int getIndex = check_int(leftHandSlot, e.getBlock().getType());
            if(p.getInventory().getItem(getIndex+40).equals(new ItemStack(Material.BARRIER))) {
                p.getInventory().setItem(getIndex+40, new ItemStack(Material.GOLDEN_APPLE, 1));
                p.sendMessage(ChatColor.RED+p.getName()+"님이 "+ChatColor.GOLD + "MINECRAFT:" +leftHandSlot[getIndex].toString()+ChatColor.GRAY+" 블럭을 파괴하여 인벤토리 한 칸이 잠금해제 되었습니다!");
            }
        }
    }

    @EventHandler
    public void onSwitch(PlayerSwapHandItemsEvent e) {
        if(e.getMainHandItem().equals(new ItemStack(Material.BARRIER)) || e.getOffHandItem().equals(new ItemStack(Material.BARRIER))) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        e.getItemDrop().getItemStack();
        if(e.getItemDrop().getItemStack().getType() == Material.BARRIER)
        {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void OnInventoryClick(InventoryClickEvent e) {
        if(e.getCurrentItem() != null) {
            if (e.getCurrentItem().getType() == Material.BARRIER) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void blockPlace(BlockPlaceEvent e) {
        e.getBlock().getType();
        if (e.getBlock().getType() == Material.BARRIER) {
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
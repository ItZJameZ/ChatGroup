package io.github.itzjamez.chatgroup.listener;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import io.github.itzjamez.chatgroup.Channel;
import io.github.itzjamez.chatgroup.util.Config;

public class ChatListener implements Listener
{
    @EventHandler
    public void speak(AsyncPlayerChatEvent e)
    {
        Player player = e.getPlayer();
        UUID uuid = player.getUniqueId();
        
        if (!Channel.ChannelData.containsKey(uuid))
        {
            Channel.setChannel(uuid, Channel.GLOBAL);
        }
        
        if (Channel.getChannel(uuid) != Channel.GLOBAL)
        {
            sendAll(player, e.getMessage());
            e.setCancelled(true);
        }
    }

    public void sendAll(Player player, String message)
    {
        Channel senderChannel = Channel.getChannel(player.getUniqueId());
        if (senderChannel == Channel.LOCAL)
        {
            for (Entity entity : player.getLocation().getWorld().getEntities())
            {
                if (isInBorder(player.getLocation(), entity.getLocation()))
                {
                    if (entity instanceof Player)
                    {
                        Player near = (Player) entity;
                        near.sendMessage(formatMessage(player, message));
                    }
                }
            }
        } 
        else
        {
            for (Player p : Bukkit.getOnlinePlayers())
            {
                Channel targetChannel = Channel.getChannel(p.getUniqueId());
                if (targetChannel == senderChannel)
                {
                    p.sendMessage(formatMessage(p, message));
                }
            }
        }
    }

    private String formatMessage(Player player, String message)
    {
        String format = Config.CHAT_FORMAT(Channel.getChannel(player.getUniqueId()));
        format = format.replaceAll("%PLAYER%", player.getDisplayName());
        format = format.replaceAll("%MESSAGE%", message);
        return format;
    }

    public static boolean isInBorder(Location center, Location notCenter)
    {
        int range = Config.LOCAL_RANGE;
        int x = center.getBlockX();
        int z = center.getBlockZ();
        int x1 = notCenter.getBlockX();
        int z1 = notCenter.getBlockZ();
  
        if (x1 >= x + range || z1 >= z + range || x1 <= x - range || z1 <= z - range)
        {
            return false;
        }
        return true;
    }
}
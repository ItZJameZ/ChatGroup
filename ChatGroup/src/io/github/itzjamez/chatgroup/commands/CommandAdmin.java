package io.github.itzjamez.chatgroup.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import io.github.itzjamez.chatgroup.Channel;
import io.github.itzjamez.chatgroup.util.Config;

public class CommandAdmin implements CommandExecutor
{
    public boolean onCommand(CommandSender s, Command cmd, String cL, String[] args)
    {
        
        if (!(s instanceof Player))
        {
            s.sendMessage("/" + cL + " is a player only command");
            return true;
        }
        
        Player player = (Player) s;
        
        if (!player.hasPermission("player.chat.admin"))
        {
            player.sendMessage(Config.COMMAND_NO_PERMISSION);
            return true;
        }
        
        Channel.setChannel(player.getUniqueId(), Channel.ADMIN);
        player.sendMessage(Config.COMMAND_ADMIN_MSG);
        return false;
    }
}
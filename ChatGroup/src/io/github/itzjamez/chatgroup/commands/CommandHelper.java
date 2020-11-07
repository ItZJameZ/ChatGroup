package io.github.itzjamez.chatgroup.commands;

import io.github.itzjamez.chatgroup.Channel;
import io.github.itzjamez.chatgroup.util.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandHelper implements CommandExecutor
{
    public boolean onCommand(CommandSender s, Command cmd, String cL, String[] args)
    {
        if (!(s instanceof Player))
        {
            s.sendMessage("/" + cL + " is a player only command");
            return true;
        }
 
        Player player = (Player) s;
        Channel.setChannel(player.getUniqueId(), Channel.HELPER);
        player.sendMessage(Config.COMMAND_HELPER_MSG);
        return false;
    }
}
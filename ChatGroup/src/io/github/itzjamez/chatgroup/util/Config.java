package io.github.itzjamez.chatgroup.util;

import org.bukkit.ChatColor;

import io.github.itzjamez.chatgroup.Channel;

public class Config
{
    public static _File configFile = new _File("plugins/ChatGroup/config.yml");

    public static String COMMAND_NO_PERMISSION = color(configFile.getString("message.no_permission"));

    public static String COMMAND_ADMIN_MSG = color(configFile.getString("message.admin"));
    public static String COMMAND_GLOBAL_MSG = color(configFile.getString("message.global"));
    public static String COMMAND_HELPER_MSG = color(configFile.getString("message.helper"));
    public static String COMMAND_LOCAL_MSG = color(configFile.getString("message.local"));
    public static String COMMAND_MOD_MSG = color(configFile.getString("message.mod"));

    public static int LOCAL_RANGE = configFile.getInt("range");

    public static String CHAT_FORMAT(Channel channel)
    {
        return color(configFile.getString("chat." + channel.name().toLowerCase()));
    }

    public static String color(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
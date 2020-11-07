package io.github.itzjamez.chatgroup;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.itzjamez.chatgroup.commands.CommandAdmin;
import io.github.itzjamez.chatgroup.commands.CommandGlobal;
import io.github.itzjamez.chatgroup.commands.CommandHelper;
import io.github.itzjamez.chatgroup.commands.CommandLocal;
import io.github.itzjamez.chatgroup.commands.CommandMod;
import io.github.itzjamez.chatgroup.listener.ChatListener;
import io.github.itzjamez.chatgroup.util._File;

public class ChatGroup extends JavaPlugin
{
    public void onEnable()
    {
        getCommand("admin").setExecutor(new CommandAdmin());
        getCommand("global").setExecutor(new CommandGlobal());
        getCommand("helper").setExecutor(new CommandHelper());
        getCommand("local").setExecutor(new CommandLocal());
        getCommand("mod").setExecutor(new CommandMod());
     
        Bukkit.getPluginManager().registerEvents(new ChatListener(), this);
        if (createFile()) getLogger().info("Generated new Config File because it didn't exist.");
    }

    private Boolean createFile()
    {
        _File file = new _File("plugins/ChatGroup/config.yml");
    
        if (!file.exists())
        {
            file.createFile();
            file.set("range", Integer.valueOf(50));
            file.set("chat.admin", "[ADMIN] %PLAYER% > %MESSAGE%");
            file.set("chat.mod", "[MOD] %PLAYER% > %MESSAGE%");
            file.set("chat.helper", "[HELPER] %PLAYER% > %MESSAGE%");
            file.set("chat.local", "[LOCAL] %PLAYER% > %MESSAGE%");
            file.set("chat.global", "[GLOBAL] %PLAYER% > %MESSAGE%");
            file.set("message.no_permission", "No permission");
            file.set("message.admin", "Chat has been set to Admin");
            file.set("message.mod", "Chat has been set to Mod");
            file.set("message.helper", "Chat has been set to Helper");
            file.set("message.local", "Chat has been set to Local");
            file.set("message.global", "Chat has been set to Global");
            return true;
        }
        return false;
    }
}
package io.github.itzjamez.chatgroup.util;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.configuration.file.YamlConfigurationOptions;

public class _File
{
    private File file = null;

    private YamlConfiguration yaml = new YamlConfiguration();

    public _File(File file)
    {
        this.file = file;
        load();
    }

    public _File(String path)
    {
        this.file = new File(path);
        load();
    }

    public void createFile()
    {
        if (!this.file.exists())
            try
            {
                this.file.createNewFile();
            } 
            catch (IOException iOException)
            {
            }
    }

    private void load()
    {
        try
        {
            this.yaml.load(this.file);
        } 
        catch (Exception exception)
        {
        }
    }

    public void save()
    {
        try
        {
            this.yaml.save(this.file);
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void delete()
    {
        try
        {
            this.file.delete();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public final File getFile(String PlayerName)
    {
        return this.file;
    }

    public int getInt(String s)
    {
        return this.yaml.getInt(s);
    }

    public void reload()
    {
        save();
        load();
    }

    public String getString(String s)
    {
        return this.yaml.getString(s);
    }

    public Long getLong(String s)
    {
        return Long.valueOf(this.yaml.getString(s));
    }

    public Object get(String s)
    {
        return this.yaml.get(s);
    }

    public boolean getBoolean(String s)
    {
        return this.yaml.getBoolean(s);
    }

    public void add(String s, Object o)
    {
        if (!contains(s))
        {
            set(s, o);
            save();
        }
    }

    public void addToStringList(String s, String o)
    {
        this.yaml.getStringList(s).add(o);
        save();
    }

    public void removeFromStringList(String s, String o)
    {
        this.yaml.getStringList(s).remove(o);
        save();
    }

    public List<String> getStringList(String s)
    {
        return this.yaml.getStringList(s);
    }

    public void addToIntegerList(String s, int o)
    {
        this.yaml.getIntegerList(s).add(Integer.valueOf(o));
        save();
    }

    public void removeFromIntegerList(String s, int o)
    {
        this.yaml.getIntegerList(s).remove(o);
        save();
    }

    public List<Integer> getIntegerList(String s)
    {
        return this.yaml.getIntegerList(s);
    }

    public void createNewStringList(String s, List<String> list)
    {
        this.yaml.set(s, list);
        save();
    }

    public void createNewIntegerList(String s, List<Integer> list)
    {
        this.yaml.set(s, list);
        save();
    }

    public void remove(String s)
    {
        set(s, null);
        save();
    }

    public boolean contains(String s)
    {
        return this.yaml.contains(s);
    }

    public double getDouble(String s)
    {
        return this.yaml.getDouble(s);
    }

    public void set(String s, Object o)
    {
        this.yaml.set(s, o);
        save();
    }

    public ConfigurationSection getConfigurationSection(String s)
    {
        return this.yaml.getConfigurationSection(s);
    }

    public void createConfigurationSection(String s)
    {
        this.yaml.createSection(s);
        save();
    }

    public void increment(String s)
    {
        this.yaml.set(s, Integer.valueOf(getInt(s) + 1));
        save();
    }

    public void decrement(String s)
    {
        this.yaml.set(s, Integer.valueOf(getInt(s) - 1));
        save();
    }

    public void increment(String s, int i)
    {
        this.yaml.set(s, Integer.valueOf(getInt(s) + i));
        save();
    }

    public void increment(String s, Double d)
    {
        this.yaml.set(s, Double.valueOf(getDouble(s) + d.doubleValue()));
        save();
    }

    public void decrement(String s, int i)
    {
        this.yaml.set(s, Integer.valueOf(getInt(s) - i));
        save();
    }

    public void decrement(String s, Double d)
    {
        this.yaml.set(s, Double.valueOf(getDouble(s) - d.doubleValue()));
        save();
    }

    public YamlConfigurationOptions options()
    {
        return this.yaml.options();
    }

    public boolean exists()
    {
        return this.file.exists();
    }
}
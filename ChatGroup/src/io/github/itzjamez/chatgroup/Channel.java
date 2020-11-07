package io.github.itzjamez.chatgroup;

import java.util.HashMap;
import java.util.UUID;

public enum Channel
{
    LOCAL, ADMIN, MOD, HELPER, GLOBAL;

    public static HashMap<UUID, Channel> ChannelData = new HashMap<>();
    
    public static Channel getChannel(UUID uuid)
    {
        if (ChannelData.get(uuid) == null)
            setChannel(uuid, GLOBAL);
        return ChannelData.get(uuid);
    }

    public static void setChannel(UUID uuid, Channel channel)
    {
        ChannelData.put(uuid, channel);
    }
}

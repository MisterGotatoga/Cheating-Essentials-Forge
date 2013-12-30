package net.cheatingessentials.util;

import net.minecraft.entity.Entity;

public class Watcher
{
    public Watcher(Entity entity, long time)
    {
        this.entity = entity;
        this.time = time;
        delay = 250;
    }

    public boolean matches(Entity other, long now)
    {
        return (other.getUniqueID() == entity.getUniqueID()
                && (time > (now - delay))
                && (other.getClass() == entity.getClass()));
    }

    private final Entity entity;
    private final long time;
    public static int delay;
}

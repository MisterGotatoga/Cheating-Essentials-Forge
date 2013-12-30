package net.cheatingessentials.client.event;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventHandler
{
    private HashMap < Class < ? extends Event > , CopyOnWriteArrayList< Listener >> eventMap;
    private static volatile EventHandler instance;

    
    public EventHandler()
    {
        eventMap = new HashMap < Class < ? extends Event > , CopyOnWriteArrayList< Listener >> ();
        eventMap.put(EventRender.class, new CopyOnWriteArrayList< Listener >());
        eventMap.put(EventTick.class, new CopyOnWriteArrayList<Listener>());
    }

    public void registerListener(Class < ? extends Event > c, Listener m)
    {
        if (eventMap.containsKey(c))
        {
            List l = eventMap.get(c);

            if (!l.contains(m))
            {
                l.add(m);
            }
        }
    }

    public void unRegisterListener(Class < ? extends Event > c, Listener m)
    {
        if (eventMap.containsKey(c))
        {
            List l = eventMap.get(c);

            if (l.contains(m))
            {
                l.remove(m);
            }
        }
    }

    public Event call(Event e)
    {
        if (eventMap.containsKey(e.getClass()))
        {
            List< Listener > l = eventMap.get(e.getClass());

            for (Listener m : l)
            {
                try
                {
                    m.onEvent(e);
                }
                catch (Exception e1)
                {
                    e1.printStackTrace();
                }
            }
        }
        else
        {
            System.out.println("Event not supported: " + e.toString() + ". Add event into eventMap.");
        }

        return e;
    }
    
    public static EventHandler getInstance() {
        if (instance == null) {
                instance = new EventHandler();
        }
        return instance;
}
}

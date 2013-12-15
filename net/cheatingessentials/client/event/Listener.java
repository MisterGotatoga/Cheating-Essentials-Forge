package net.cheatingessentials.client.event;

import java.util.EventListener;

public interface Listener extends EventListener
{
    public void onEvent(Event event);
}

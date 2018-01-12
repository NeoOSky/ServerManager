package eu.servermanager.dev.spigot.events;

import eu.servermanager.dev.spigot.Variables;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class EventDebug implements Listener {

    @EventHandler
    public void onEvent(Event e){
        if(Variables.debugmod){
            System.out.println("[ServerManager] [DEBUG] EVENT : "+e.getEventName());

        }
    }

}

package eu.servermanager.dev.spigot.events;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.Variables;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EvenstChat implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();
        if(Variables.nickname.containsKey(p)){
            e.setFormat(Main.getInstance().getConfig().getString(Variables.lang+".Nick.format").replace("&", "§").replace("%player%", Variables.nickname.get(p)).replace("%message%", message));
        }
    }
}

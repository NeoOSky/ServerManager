package eu.servermanager.dev.spigot.events;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.Variables;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventsChat implements Listener {


    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String message = e.getMessage();
        if(Variables.nickname.containsKey(p)){
           e.setFormat(Main.getInstance().getConfig().getString(Variables.lang+".Nick.format").replace("&", "§").replace("%player%", Variables.nickname.get(p)).replace("%message%", message));
        }else{
            if(p.getName().equalsIgnoreCase("NeoOSky") || p.getName().equalsIgnoreCase("_Anto") ||p.getName().equalsIgnoreCase("Palamix")){
                if(!Main.getInstance().getConfig().getBoolean("customRankForDev")) return;
                e.setFormat("§7[§cServerManager Owner§7] "+p.getName()+"§f: §b"+e.getMessage());
            }else if(p.getName().equalsIgnoreCase("Xeinel") || p.getName().equalsIgnoreCase("Youko_TV")){
                if(!Main.getInstance().getConfig().getBoolean("customRankForDev")) return;
                e.setFormat("§7[§9ServerManager Developper§7] "+p.getName()+"§f: "+e.getMessage());
            }
        }
    }
}

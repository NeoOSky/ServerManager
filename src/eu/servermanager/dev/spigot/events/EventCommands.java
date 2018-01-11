package eu.servermanager.dev.spigot.events;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.Variables;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

public class EventCommands implements Listener {

    public HashMap<Player, Boolean> pass = new HashMap<>();
    public HashMap<Player, Boolean> passT = new HashMap<>();
    public String password = Main.getInstance().getConfig().getString("CommandsBlocked.password");

    @EventHandler
    public void onGamemode(PlayerCommandPreprocessEvent e){
        Player p = e.getPlayer();
        for(String s : Main.getInstance().getConfig().getStringList("CommandsBlocked.blocked_cmd")){
            if(e.getMessage().startsWith("/"+s)){
                if(!pass.get(p)){
                    e.setCancelled(true);
                    passT.put(p, true);
                    p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.setpassword").replace("&", "§"));
                }
            }
        }
        //if(getConfig().getStringList("commands").contains("/"+e.getMessage())){

    }
    //}
    @EventHandler (priority = EventPriority.HIGHEST)
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        pass.put(p, false);
        passT.put(p, false);
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(passT.get(p)){
            e.setCancelled(true);
            passT.put(p, false);
            if(e.getMessage().equalsIgnoreCase(password)){
                pass.put(p, true);
                p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.sucess").replace("&", "§"));

            }else{
                p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.wrongpassword").replace("&", "§"));

            }
        }

    }
}

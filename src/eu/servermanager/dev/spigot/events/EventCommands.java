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

import java.util.HashMap;

public class EventCommands implements Listener {

    private HashMap<Player, String> modPassword = new HashMap<>();

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player p = event.getPlayer();
        String cmd = event.getMessage();
        if(Variables.getBlockedsCommands().contains(cmd.replaceFirst("/", ""))){
            for(String s : Variables.getBlockedsCommands()){
                if(s.replaceFirst("/", "").equalsIgnoreCase(cmd.replaceFirst("/", ""))){
                    if(Main.getInstance().getConfig().getBoolean("CommandsBlocked.opBypass")){
                        if(!p.isOp()){
                            p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.setpassword").replace("&", "§"));
                            modPassword.put(p, cmd);
                            for(Player pp : Bukkit.getOnlinePlayers()){
                                if(pp.isOp()){
                                    pp.sendMessage(Variables.getPrefixCommand()+"§c"+p.getName()+":§b /"+modPassword.get(p));
                                    if(Variables.debugmod.containsKey(pp)){
                                        pp.sendMessage("DEBUG: \""+p.getName()+"\" -> /"+cmd);
                                    }
                                }
                            }
                        }
                    }

                }
            }

        }
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(modPassword.containsKey(p)){
            if(e.getMessage().equals(Main.getInstance().getConfig().getString("CommandsBlocked.password"))){
                p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.sucess").replace("&", "§"));

            }else{
                p.sendMessage(Main.getInstance().getConfig().getString("CommandsBlocked.Messages.wrongpassword").replace("&", "§"));
                for(Player pp : Bukkit.getOnlinePlayers()){
                    if(pp.isOp()){
                        pp.sendMessage(Variables.getPrefixCommand()+"§c"+p.getName()+":§b Wrong password!");

                    }
                }
            }
        }
    }
}

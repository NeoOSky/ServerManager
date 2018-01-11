package eu.servermanager.dev.spigot.commands;

import eu.servermanager.dev.spigot.Variables;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DebugMod implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender.isOp()){
            if(sender instanceof Player){
                Player p = (Player)sender;
                if(Variables.debugmod.containsKey(p)){
                    Variables.debugmod.remove(p);
                    p.sendMessage("DEBUG: OFF");
                }else if(!Variables.debugmod.containsKey(p)){

                    Variables.debugmod.put(p, true);
                    p.sendMessage("DEBUG: ON");
                }

            }
        }

        return false;
    }
}

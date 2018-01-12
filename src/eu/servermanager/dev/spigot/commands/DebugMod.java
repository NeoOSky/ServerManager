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
                if(Variables.debugmod){
                    Variables.debugmod = false;
                    p.sendMessage("DEBUG: OFF");
                }else{

                    Variables.debugmod = true;
                    p.sendMessage("DEBUG: ON");
                }

            }
        }

        return false;
    }
}

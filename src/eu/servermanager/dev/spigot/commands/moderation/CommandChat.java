package eu.servermanager.dev.spigot.commands.moderation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandChat implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(sender.hasPermission("PERM")){
            if(args.length == 0){
                sender.sendMessage("ERROR ARG");
            }else{
                if(args[0].equalsIgnoreCase("on")){

                    

                }else if(){

                }else if(){

                }else{

                }
            }
        }


        return false;
    }
}

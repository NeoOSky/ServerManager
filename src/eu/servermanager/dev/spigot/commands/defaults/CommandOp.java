package eu.servermanager.dev.spigot.commands.defaults;

import eu.servermanager.dev.spigot.Variables;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandOp implements CommandExecutor {

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {

        if(sender.hasPermission("minecraft.command.op")){

            if(args.length == 0){
                sender.sendMessage(Variables.getPrefixError()+" "+Variables.getNoPlayer());
            }else{
                if(Bukkit.getOfflinePlayer(args[0]) != null){
                    if(!Bukkit.getOfflinePlayer(args[0]).isOp()){
                        Bukkit.getOfflinePlayer(args[0]).setOp(true);
                    }else{

                    }
                }else{
                    sender.sendMessage(Variables.getPrefixError()+" "+Variables.getNeverPlayed());
                }
            }

        }else{
            sender.sendMessage(Variables.getPrefixError()+" "+Variables.getNoPerm());
        }

        return false;
    }

}
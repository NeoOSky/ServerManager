package eu.dev.servermanager.spigot.commands.defaults;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import eu.dev.servermanager.spigot.Variables;

public class CommandOp implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender.hasPermission("minecraft.command.op")){
			
			if(args.length == 0){
				sender.sendMessage(Variables.prefix_error+" "+Variables.noplayer);
			}else{
				if(Bukkit.getOfflinePlayer(args[0]) != null){
					if(!Bukkit.getOfflinePlayer(args[0]).isOp()){
						Bukkit.getOfflinePlayer(args[0]).setOp(true);
					}else{

					}
				}else{
					sender.sendMessage(Variables.prefix_error+" "+Variables.neverplayed);
					
				}
			}
			
		}else{
			sender.sendMessage(Variables.prefix_error+" "+Variables.noperm);
		}
		
		return false;
	}

}

package eu.dev.servermanager.spigot.commands.defaults;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class CommandClear implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
       
		if(cmd.getName().equalsIgnoreCase("clear")) {
			
			if(args.length == 0) {
				sender.sendMessage("Incorect Usage : /clear <player>");
			}
			
			if(args.length == 1) {
				Player p = Bukkit.getPlayer(args[0]);
				String name = p.getName();
				p.getInventory().clear();
				sender.sendMessage(ChatColor.RED +"L'inventaire de "+name+ " a bien été clear !");
			}
			
			if(args.length >= 2) {
				Player p = Bukkit.getPlayer(args[0]);
				String name = p.getName();
				p.getInventory().clear();
				sender.sendMessage(ChatColor.RED +"L'inventaire de "+name+ " a bien été clear !");
				StringBuilder msg = new StringBuilder();
				
				for(int i= 1; i < args.length; i++) {
					
						String m = args[i];
						msg.append(m + "");
	
					
				}
				
				p.sendMessage(ChatColor.GREEN +msg.toString());
			}
			
		}
		return false;
	}

}

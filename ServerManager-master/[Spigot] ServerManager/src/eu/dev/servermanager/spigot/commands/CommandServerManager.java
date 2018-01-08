package eu.dev.servermanager.spigot.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import eu.dev.servermanager.spigot.Main;
import eu.dev.servermanager.spigot.Variables;
import eu.dev.servermanager.spigot.utils.ServerManager;
import eu.dev.servermanager.spigot.utils.ServerModule;

public class CommandServerManager implements CommandExecutor {

	
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
		
		if(sender instanceof Player){
			Player p = (Player) sender;
			if(p.hasPermission(Main.getInstance().getConfig().getString("Permissions.servermanager"))){
				
				if(args.length == 0){
					p.sendMessage("§7§m-------------------------");
					p.sendMessage("§c§lServerManager§f - §cv"+Main.getInstance().getDescription().getVersion());
					p.sendMessage(" ");
					p.sendMessage("§7/servermanager help");
					p.sendMessage("§7/servermanager reload");
					p.sendMessage("§7/servermanager dev");
					p.sendMessage("§7§m-------------------------");
				}else if(args.length == 1){
					if(args[0].equalsIgnoreCase("help")){
						p.sendMessage("§7§m-------------------------");
						p.sendMessage("§c§lServerManager§f - §7Help 1§8/§71");
						p.sendMessage(" ");
						p.sendMessage("§7/servermanager reload§f - reload plugin & config.");
						p.sendMessage("§7/servermanager modules§f - view all commands and modules.");
						p.sendMessage("§7/servermanager info <module>§f - get information for a module.");
						p.sendMessage("§7/servermanager dev§f - view developpers of ServerManager.");
						p.sendMessage("§7/servermanager partner§f - view partners of ServerManager.");
						p.sendMessage("§7§m-------------------------");
					}else if(args[0].equalsIgnoreCase("reload")){
						p.sendMessage(Variables.prefix+" "+"§f reloading...");
						Main.getInstance().reloadConfig();
						Bukkit.getPluginManager().disablePlugin(Main.getInstance());
						Bukkit.getPluginManager().enablePlugin(Main.getInstance());
						p.sendMessage(Variables.prefix+" "+"§f plugin has been reloaded !");

					}else if(args[0].equalsIgnoreCase("dev")){
						p.sendMessage("§7§m-------------------------");
						p.sendMessage("§c§lServerManager§f - §7Developers");
						p.sendMessage(" ");
						p.sendMessage("§c§nProject Owners: §fNeoOSky & Anto_");
						p.sendMessage(" ");
						p.sendMessage("§c§nProject Developers: §fXeinel, Palamix, Youko");
						p.sendMessage(" ");
						p.sendMessage("§c§nProject Partners:");
						p.sendMessage(" ");
						p.sendMessage("§fDiscord Server of §bSkript - Minecraft§f.");
						p.sendMessage("§7§m-------------------------");
					}else if(args[0].equalsIgnoreCase("partner")){
						p.sendMessage("§7§m-------------------------");
						p.sendMessage("§c§lServerManager§f - §7Partners");
						p.sendMessage(" ");
						p.sendMessage("§c#1: §f[Discord] §bSkript - Minecraft§c (§b§nhttps://discord.gg/FX5sQPr§c)");
						p.sendMessage(" ");
						p.sendMessage("§7§m-------------------------");
					}else if(args[0].equalsIgnoreCase("modules")){
						p.sendMessage("§7§m-------------------------");
						p.sendMessage("§c§lServerManager§f - §7Modules");
						p.sendMessage(" ");
						p.sendMessage("§cModules: §7(§c"+ServerManager.getInstance().modules.size()+"§7):");
						for(ServerModule mod : ServerManager.getInstance().modules){
							p.sendMessage("§7- "+mod.getName()+" §fv"+mod.getVersion());
						}
						p.sendMessage(" ");
						p.sendMessage("§7§m-------------------------");
					}else if(args[0].equalsIgnoreCase("info")){
						p.sendMessage(Variables.prefix+" "+"§f Command: /servermanager info <module>");
					
					}
				}else{
					if(args[0].equalsIgnoreCase("info")){
						ServerModule mod = null;
						for(ServerModule md : ServerManager.getInstance().modules){
							if(md.getName().equalsIgnoreCase(args[1])){
								mod = md;
								break;
							}
						}
						if(mod.getName().equalsIgnoreCase(args[1])){
							p.sendMessage("§7§m-------------------------");
							p.sendMessage("§c§lServerManager§f - §7Module "+mod.getName());
							p.sendMessage(" ");
							p.sendMessage("§cServerManager version "+mod.getVersion());
							for(String s : mod.getDescription()){
								p.sendMessage("§7"+s);
							}
							
					/*	p.sendMessage("§7ServerManager is \"a modern Essentials\"."); 
							p.sendMessage("§7Customize your server is really easy with him.");
							p.sendMessage("§7You can block commands with password, report cheaters and bad players, set the motd, the tablist,");
							p.sendMessage("§7join messages, title on join ...");
							p.sendMessage("§7blablabla, it's too long of say all functionnalities of ServerManager !");
						p.sendMessage("§7i just saying \"ServerManager, customize your server!\" ");
			*/			  
							p.sendMessage(" ");
							p.sendMessage("§7§m-------------------------");
						}else{
							p.sendMessage("§7§m-------------------------");
							p.sendMessage("§c§lServerManager§f - §7Module Error");
							p.sendMessage(" ");
							p.sendMessage("§cThis module doesn't exist !");
							  
							p.sendMessage(" ");
							p.sendMessage("§7§m-------------------------");
						}

					
					}
				}
			
			}else{
				p.sendMessage(Variables.prefix_error+" "+Variables.noperm);
			}
			
		}
		
		
		
		
		return false;
	}

}

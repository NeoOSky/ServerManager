package eu.dev.servermanager.spigot;

import java.util.Arrays;

import org.bukkit.plugin.java.JavaPlugin;

import eu.dev.servermanager.spigot.commands.CommandServerManager;
import eu.dev.servermanager.spigot.commands.defaults.CommandClear;
import eu.dev.servermanager.spigot.commands.defaults.CommandOp;
import eu.dev.servermanager.spigot.utils.ServerManager;
import eu.dev.servermanager.spigot.utils.ServerModule;

public class Main extends JavaPlugin{
	
	private static Main instance;
	public static ServerManager srv;
	
	public static Main getInstance(){
		return instance;
	}
	
	
	@Override
	public void onEnable() {
		instance = this;
		srv = new ServerManager();
		saveDefaultConfig();		
		getCommand("servermanager").setExecutor(new CommandServerManager());
		getCommand("op").setExecutor(new CommandOp());
		System.out.println(getConfig().getString(Variables.lang+".Prefix.prefix"));
		getCommand("clear").setExecutor(new CommandClear());
		ServerModule mod = new ServerModule(getDescription().getName(), Arrays.asList("�7ServerManager is \"a modern Essentials\".", "�7Customize your server is really easy with him.", "�7You can block commands with password, report cheaters and bad players, set the motd, the tablist,", "�7join messages, title on join ...", "�7blablabla, it's too long of say all functionnalities of ServerManager !", "�7I just saying \"ServerManager, customize your server!\" "), getDescription().getVersion(), getDescription().getAuthors());
		mod.init();
		ServerModule cmd = new ServerModule("ServerManagerCommands", Arrays.asList("Replace defaults minecraft commands."), getDescription().getVersion(), getDescription().getAuthors());
		cmd.init();
		getServer().getConsoleSender().sendMessage("�e========================================");
		getServer().getConsoleSender().sendMessage("�c�l             ServerManager");
		getServer().getConsoleSender().sendMessage("�aEnabling:");
		getServer().getConsoleSender().sendMessage("�aServerManager has been enabled !");
		getServer().getConsoleSender().sendMessage("�c         By _Anto and NeoOSky");
		getServer().getConsoleSender().sendMessage("�e========================================");
        get
	}
	@Override
	public void onDisable() {
		getServer().getConsoleSender().sendMessage("�e========================================");
		getServer().getConsoleSender().sendMessage("�c�l             ServerManager");
		getServer().getConsoleSender().sendMessage("�aDisabling:");
		getServer().getConsoleSender().sendMessage("�aServerManager has been disabled !");
		getServer().getConsoleSender().sendMessage("�c         By _Anto and NeoOSky");
		getServer().getConsoleSender().sendMessage("�e========================================");

    public static String getLang(){
         String l = getConfig().getString("Lang");
         return l;


		}

	}
	
	
}

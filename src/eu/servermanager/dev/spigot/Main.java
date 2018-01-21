package eu.servermanager.dev.spigot;

import java.util.Arrays;

import eu.servermanager.dev.spigot.commands.CommandMaintenance;
import eu.servermanager.dev.spigot.commands.CommandNick;
import eu.servermanager.dev.spigot.commands.CommandServerManager;
import eu.servermanager.dev.spigot.commands.defaults.CommandClear;
import eu.servermanager.dev.spigot.commands.moderation.CommandChat;
import eu.servermanager.dev.spigot.events.EventsChat;
import eu.servermanager.dev.spigot.events.EventCommands;
import eu.servermanager.dev.spigot.utils.*;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin{

    private static Main instance;
    public static ServerManager srv;
    public static Utils utils;

    public static Main getInstance(){
        return instance;
    }


    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();
        instance = this;
        srv = new ServerManager();
        utils = new Utils();
        saveDefaultConfig();
        getCommand("servermanager").setExecutor(new CommandServerManager());
        getCommand("maintenance").setExecutor(new CommandMaintenance());
        getCommand("clear").setExecutor(new CommandClear());
        getCommand("chat").setExecutor(new CommandChat());
        getCommand("nick").setExecutor(new CommandNick());
        pm.registerEvents(new EventsChat(), this);
        pm.registerEvents(new EventCommands(), this);
        ServerModule commands = new ServerModule("ServerManagerCommands", Arrays.asList("All commands of ServerManager."), "Alpha 1.0", Arrays.asList("Palamix", "_Anto"));
        ServerManager.getInstance().registerModule(commands);
        ServerModule events = new ServerModule("ServerManagerEvents", Arrays.asList("All events of ServerManager."), "Alpha 1.0", Arrays.asList("NeoOSky", "Palamix", "_Anto"));
        ServerManager.getInstance().registerModule(events);

        SuperServerModules ServerManager = new SuperServerModules("ServerManager", Arrays.asList("§7ServerManager is \"a modern Essentials\".", "§7Customize your server is really easy with him.", "§7You can block commands with password, report cheaters and bad players, set the motd, the tablist,", "§7join messages, title on join ...", "§7blablabla, it's too long of say all functionnalities of ServerManager !", "§7I just saying \"ServerManager, customize your server!\"", ""), "Alpha 1.0", Arrays.asList("NeoOSky", "Palamix", "_Anto", "Youko", "Xeinel", "MembersOfSkriptMC"), Arrays.asList(commands, events));
        ServerManager.activateSuperModule();



        getServer().getConsoleSender().sendMessage("§e========================================");
        getServer().getConsoleSender().sendMessage("§c§l             ServerManager");
        getServer().getConsoleSender().sendMessage("§aEnabling:");
        getServer().getConsoleSender().sendMessage("§aServerManager has been enabled !");
        getServer().getConsoleSender().sendMessage("§e========================================");
        getLogger().info("All modules are activated !");
    }
    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("§e========================================");
        getServer().getConsoleSender().sendMessage("§c§l             ServerManager");
        getServer().getConsoleSender().sendMessage("§aDisabling:");
        getServer().getConsoleSender().sendMessage("§aServerManager has been disabled !");
        getServer().getConsoleSender().sendMessage("§e========================================");

    }


}
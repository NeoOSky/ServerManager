package eu.servermanager.dev.spigot;

import eu.servermanager.dev.spigot.commands.CommandTestConfig;
import eu.servermanager.dev.spigot.utils.ServerManager;
import eu.servermanager.dev.spigot.utils.ServerModule;
import eu.servermanager.dev.spigot.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class Main extends JavaPlugin {

    private static Main instance;
    public static Main getInstance(){
        return instance;
    }
    public static ServerManager srv;
    public static Utils utils;




    public String initVariables(String s, Player p) {
        return s.replace("%online%", "" + Bukkit.getOnlinePlayers().size()).replace("%player xp to lvl%", "" + p.getExpToLevel()).replace("%player xp%", "" + p.getExp()).replace("%player fly%", "" + p.getFlySpeed()).replace("%player health%", "" + p.getHealth()).replace("%player gamemode%", "" + p.getGameMode()).replace("%player kills%", "" + p.getStatistic(Statistic.PLAYER_KILLS)).replace("%player deaths%", "" + p.getStatistic(Statistic.DEATHS)).replace("%player location%", p.getLocation().getX() + " " + p.getLocation().getY() + " " + p.getLocation().getZ() + " " + p.getLocation().getYaw() + " " + p.getLocation().getPitch() + " ").replace("%player display name%", p.getDisplayName()).replace("%player%", p.getName());
    }
    public String initVariables(String s){
        return s.replace("&", "§").replace("%online%", ""+getServer().getOnlinePlayers().size());
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        instance = this;
        srv = new ServerManager();
        utils = new Utils();




        ServerModule mod = new ServerModule(this.getDescription().getName(), Arrays.asList("ServerManager is \"a modern Essentials\".", "Customize your server is really easy with him.", "You can block commands with password, report cheaters and bad players, set the motd, the tablist,", "join messages, title on join ...", "blablabla, it's too long of say all functionnalities of ServerManager !", "I just saying \"ServerManager, customize your server!\" "), this.getDescription().getVersion(), this.getDescription().getAuthors());
        ServerManager.getInstance().registerModule(mod);

        getCommand("testconfig").setExecutor(new CommandTestConfig());

        getServer().getConsoleSender().sendMessage("[ServerManager] ServerManager has been enabled!");

    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage("[ServerManager] ServerManager has been disabled!");
    }
}


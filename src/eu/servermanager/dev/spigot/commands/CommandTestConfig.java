package eu.servermanager.dev.spigot.commands;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.utils.ServerManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTestConfig implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String msg, String[] args) {
        if(!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        sender.sendMessage(ServerManager.getInstance().config_prefix);
        ServerManager.getInstance().getUtils().sendTitle(p, "§c§lServerManager", "§eCustomize your server !", 40);

        return false;
    }
}

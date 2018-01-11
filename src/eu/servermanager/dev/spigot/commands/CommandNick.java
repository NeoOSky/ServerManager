package eu.servermanager.dev.spigot.commands;

import eu.servermanager.dev.spigot.Variables;
import eu.servermanager.dev.spigot.utils.PseudoGenerator;
import eu.servermanager.dev.spigot.utils.ServerManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandNick implements CommandExecutor {
    boolean console;

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if ((sender instanceof Player)) {
            this.console = false;
        } else {
            this.console = true;
        }
        if (!this.console)
        {
            Player p = (Player)sender;
            if (!p.hasPermission("servermanager.commands.nick"))
            {
                p.sendMessage("§cNo Perm.");
                return true;
            }
            if(Variables.nickname.containsKey(p)){
                p.sendMessage("§6[NickName]§f Vous avez retrouvé votre pseudo.");
                Variables.nickname.remove(p);
                return true;

            }

            String nick = PseudoGenerator.generateName();
            p.sendMessage("§6[NickName]§f Votre nouveau pseudo : §b"+nick);
            Variables.nickname.put(p, nick);

        }


        return false;
    }

}

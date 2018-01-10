package eu.servermanager.dev.spigot.commands;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.utils.ServerManager;
import eu.servermanager.dev.spigot.utils.ServerModule;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandServerManager implements CommandExecutor {

    private int helppage = 0;
    private int helpmax = 2;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String msg, String[] args) {

        if(args.length == 0){
            sender.sendMessage("§8§m----------------------------------------");
            sender.sendMessage("§c§l                 ServerManager");
            sender.sendMessage("§7Version: §c"+ Main.getInstance().getDescription().getVersion());
            sender.sendMessage("§7Authors: §cNeoOSky§7, §c_Anto§7, §cPalamix§7,§c Youko§7, §cXeinel");
            sender.sendMessage("§7Discord:§c§n discord.gg/xsRTXwT");
            sender.sendMessage("§7/servermanager help");
            sender.sendMessage("§8§m----------------------------------------");
        }else if(args.length == 1){
            if(args[0].equalsIgnoreCase("help")){
                helppage = 1;
                sender.sendMessage("§8§m----------------------------------------");
                sender.sendMessage("§c§lServerManager§7 - Help "+helppage+"/"+helpmax);
                sender.sendMessage("§7/servermanager modules§F - view all modules");
                sender.sendMessage("§7/servermanager dev§F - view project contributors");
                sender.sendMessage("§7/servermanager pub§f - active the pub");
                sender.sendMessage("§7/servermanager help");

                TextComponent json = new TextComponent("§b[<] Previous Page");
                json.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("This is the first page!").create()));

                TextComponent json2 = new TextComponent("§b[>] Next Page");
                json2.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/servermanager help "+helppage+1));
                json2.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Next page").create()));


                if(sender instanceof Player){
                    ((Player) sender).spigot().sendMessage(json);
                    ((Player) sender).spigot().sendMessage(json2);
                }
                sender.sendMessage("§8§m----------------------------------------");
            }
            if(args[0].equalsIgnoreCase("modules")){
                sender.sendMessage("§8§m----------------------------------------");
                sender.sendMessage("§c§lServerManager§7 - Modules");
                sender.sendMessage("§7Actives Modules (§c"+ ServerManager.getInstance().modules.size()+"§7):");
                for(ServerModule module : ServerManager.getInstance().modules){
                    sender.sendMessage("§c- "+module.getName()+"§7 version "+module.getVersion()+"§7by §b"+module.getAuthors().toString());
                }
                sender.sendMessage("§8§m----------------------------------------");
            }
            if(args[0].equalsIgnoreCase("pub")){
                Bukkit.broadcastMessage("§8§m----------------------------------------");
                Bukkit.broadcastMessage("§c§lServerManager");
                Bukkit.broadcastMessage("§7This is a good server because Staff active us pub.");
                Bukkit.broadcastMessage("§7Join ServerManager's Discord here: §b§n§odiscord.gg/xsRTXwT");
                Bukkit.broadcastMessage("§8§m----------------------------------------");
            }
            if(args[0].equalsIgnoreCase("dev")){
                sender.sendMessage("§8§m----------------------------------------");
                sender.sendMessage("§c§lServerManager§7 - Developers");
                sender.sendMessage("§cOwners: §fNeoOSky, _Anto, Palamix");
                sender.sendMessage("§9Developers: §fXeinel, Youko");
                sender.sendMessage("§bHelpers: §fYouke_TV, Dylan Brown");
                sender.sendMessage("§8§m----------------------------------------");
            }
        }



        return false;
    }
}

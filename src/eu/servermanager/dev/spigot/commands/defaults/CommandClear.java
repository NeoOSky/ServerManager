package eu.servermanager.dev.spigot.commands.defaults;

import eu.servermanager.dev.spigot.Main;
import eu.servermanager.dev.spigot.Variables;
import eu.servermanager.dev.spigot.utils.Lang;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class CommandClear implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


            if(!sender.hasPermission(getPerm())) {
                sender.sendMessage(Variables.getPrefixError() + Variables.getNoPerm());
            }else{
                if(args.length == 0) {
                    if(sender instanceof Player){
                        Player p = (Player)sender;
                        String name = p.getName();
                        p.getInventory().clear();

                        p.sendMessage(getClearMessageToSender() + name);

                    }




                }

                if(args.length == 1) {
                    Player p = Bukkit.getPlayer(args[0]);
                    String name = p.getName();
                    p.getInventory().clear();


                    sender.sendMessage(getClearMessageToSender() + name);

                }

                if(args.length >= 2) {
                    Player p = Bukkit.getPlayer(args[0]);
                    String name = p.getName();
                    p.getInventory().clear();
                    sender.sendMessage(getClearMessageToSender() + name);
                    StringBuilder msg = new StringBuilder();

                    for(int i= 1; i < args.length; i++) {

                        String m = args[i];
                        msg.append(m + "");


                    }

                    p.sendMessage(getClearMessage() + msg.toString());


                }



        }
        return false;
    }

    public static String getClearMessage() {
        String clearmsg = Main.getInstance().getConfig().getString(Lang.getLang()+"."+"Clear.clearmsg").replace('&', '§');
        return clearmsg;
    }

    public static String getClearMessageToSender() {
        String clearmsgsender = Main.getInstance().getConfig().getString(Lang.getLang()+"."+"Clear.clearmsgsender").replace('&', '§');
        return clearmsgsender;
    }

    public static String getPerm() {
        String per = Main.getInstance().getConfig().getString(Lang.getLang()+"."+"Clear.clearperm");
        return per;
    }

	/*public static String getErreurMsg() {
		String err = Main.getInstance().getConfig().getString(Lang.getLang() + "." + "Clear.clearpb");
		return err;
	}*/

}
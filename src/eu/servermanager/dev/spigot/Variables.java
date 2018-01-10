package eu.servermanager.dev.spigot;

import eu.servermanager.dev.spigot.utils.Lang;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class Variables {

    public static String lang = Lang.getLang();
    public static HashMap<Player, Boolean> debugmod = new HashMap<>();

    public static List<String> getBlockedsCommands(){
        List<String> blockeds_cmd = Main.getInstance().getConfig().getStringList("CommandsBlocked.blocked_cmd");
        return blockeds_cmd;
    }
    public static String getPrefix() {
        String prefix = Main.getInstance().getConfig().getString(lang+".Prefix.prefix").replace("&", "§");
        return prefix;
    }

    public static String getPrefixMaintenance() {
        String prefix_maintenance = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_maintenance").replace("&", "§");
        return prefix_maintenance;
    }
    public static String getPrefixChat() {
        String prefix_chat = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_chat").replace("&", "§");
        return prefix_chat;
    }
    public static String getPrefixModeration() {
        String prefix_moderation = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_moderation").replace("&", "§");
        return prefix_moderation;
    }
    public static String getPrefixAdministration() {
        String prefix_administration = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_administration").replace("&", "§");
        return prefix_administration;
    }
    public static String getPrefixMoeny() {
        String prefix_money = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_money").replace("&", "§");
        return prefix_money;
    }
    public static String getPrefixError() {
        String prefix_error = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_error").replace("&", "§");
        return prefix_error;
    }
    public static String getPrefixSucess() {
        String prefix_sucess = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_sucess").replace("&", "§");
        return prefix_sucess;
    }
    public static String getPrefixCommand() {
        String prefix_command = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_command").replace("&", "§");
        return prefix_command;
    }
    public static String getPrefixReport() {
        String prefix_report = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_report").replace("&", "§");
        return prefix_report;
    }
    public static String getOn() {
        String on = Main.getInstance().getConfig().getString(lang+".Prefix.on").replace("&", "§");
        return on;
    }
    public static String getOff() {
        String off = Main.getInstance().getConfig().getString(lang+".Prefix.off").replace("&", "§");
        return off;
    }
    public static String getNoPerm() {
        String noperm = Main.getInstance().getConfig().getString(lang+".Messages.noperm").replace("&", "§");
        return noperm;
    }
    public static String getOfflinePlayer() {
        String offlineplayer = Main.getInstance().getConfig().getString(lang+".Messages.offlineplayer").replace("&", "§");
        return offlineplayer;
    }
    public static String getNoPlayer() {
        String noplayer = Main.getInstance().getConfig().getString(lang+".Messages.noplayer").replace("&", "§");
        return noplayer;
    }
    public static String getMaintenance() {
        String maintenance = Main.getInstance().getConfig().getString(lang+".Messages.maintenance").replace("&", "§");
        return maintenance;
    }
    public static String getMaintenanceDefaultKick() {
        String maintenancedefaultkick = Main.getInstance().getConfig().getString(lang+".Messages.maintenancedefaultkick").replace("&", "§");
        return maintenancedefaultkick;
    }
    public static String getMaintenanceAlReady() {
        String maintenancealready = Main.getInstance().getConfig().getString(lang+".Messages.maintenancealready").replace("&", "§");
        return maintenancealready;
    }
    public static String getChat() {
        String chat = Main.getInstance().getConfig().getString(lang+".Messages.chat").replace("&", "§");
        return chat;
    }
    public static String getChatTalk() {
        String chattalk = Main.getInstance().getConfig().getString(lang+".Messages.chattalk").replace("&", "§");
        return chattalk;
    }
    public static String getChatalReady() {
        String chatalready = Main.getInstance().getConfig().getString(lang+".Messages.chatalready").replace("&", "§");
        return chatalready;
    }
    public static String getNeverPlayed() {
        String neverplayed = Main.getInstance().getConfig().getString(lang+".Messages.neverplayed").replace("&", "§");
        return neverplayed;
    }
}
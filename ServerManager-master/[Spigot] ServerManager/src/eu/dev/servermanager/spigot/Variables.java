package eu.dev.servermanager.spigot;

public class Variables {
	public static String lang = Main.getInstance().getConfig().getString("Lang");

	public static String prefix = Main.getInstance().getConfig().getString(lang+".Prefix.prefix").replace("&", "�");
	public static String prefix_maintenance = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_maintenance").replace("&", "�");
	public static String prefix_chat = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_chat").replace("&", "�");
	public static String prefix_moderation = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_moderation").replace("&", "�");
	public static String prefix_administration = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_administration").replace("&", "�");
	public static String prefix_money = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_money").replace("&", "�");
	public static String prefix_error = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_error").replace("&", "�");
	public static String prefix_sucess = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_sucess").replace("&", "�");
	public static String prefix_command = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_command").replace("&", "�");
	public static String prefix_report = Main.getInstance().getConfig().getString(lang+".Prefix.prefix_report").replace("&", "�");
	public static String on = Main.getInstance().getConfig().getString(lang+".Prefix.on").replace("&", "�");
	public static String off = Main.getInstance().getConfig().getString(lang+".Prefix.off").replace("&", "�");

	public static String noperm = Main.getInstance().getConfig().getString(lang+".Messages.noperm").replace("&", "�");
	public static String offlineplayer = Main.getInstance().getConfig().getString(lang+".Messages.offlineplayer").replace("&", "�");
	public static String noplayer = Main.getInstance().getConfig().getString(lang+".Messages.noplayer").replace("&", "�");
	public static String maintenance = Main.getInstance().getConfig().getString(lang+".Messages.maintenance").replace("&", "�");
	public static String maintenancedefaultkick = Main.getInstance().getConfig().getString(lang+".Messages.maintenancedefaultkick").replace("&", "�");
	public static String maintenancealready = Main.getInstance().getConfig().getString(lang+".Messages.maintenancealready").replace("&", "�");
	public static String chat = Main.getInstance().getConfig().getString(lang+".Messages.chat").replace("&", "�");
	public static String chattalk = Main.getInstance().getConfig().getString(lang+".Messages.chattalk").replace("&", "�");
	public static String chatalready = Main.getInstance().getConfig().getString(lang+".Messages.chatalready").replace("&", "�");
	public static String neverplayed = Main.getInstance().getConfig().getString(lang+".Messages.neverplayed").replace("&", "�");
	public static String lang = Main.getLang();


}

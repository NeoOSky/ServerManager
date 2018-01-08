package eu.servermanager.dev.spigot.utils;


import eu.servermanager.dev.spigot.Main;

public class Lang {

    public static String getLang() {
        String l = Main.getInstance().getConfig().getString("Lang");
        return l;
    }

	/*public static boolean isFr() {
		if(Lang.getLang().equalsIgnoreCase("fr"))
			return true;
		else
			return false;
	}

	public static boolean isEn() {
		if(Lang.getLang().equalsIgnoreCase("en"))
			return true;
		else
			return false;
	}*/


}
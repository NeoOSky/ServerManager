package eu.servermanager.dev.spigot.utils;

import eu.servermanager.dev.spigot.Main;
import net.minecraft.server.v1_8_R3.*;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class Utils {
    public Utils() {
    }

    public String transformTableToString(String[] args) {
        String text = "";
        String[] var3 = args;
        int var4 = args.length;

        for(int var5 = 0; var5 < var4; ++var5) {
            String argument = var3[var5];
            text = text + argument;
            text = text + " ";
        }

        return text;
    }

    public void sendTitle(Player player, String title, String subtitle, int ticks) {
        IChatBaseComponent chatTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        IChatBaseComponent chatsubTitle = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle titre = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chatTitle, 0, ticks, 0);
        PacketPlayOutTitle soustitre = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chatsubTitle, 0, ticks, 0);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(titre);
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(soustitre);
    }
    public boolean isStringValide(String s){
        if(s == null) return false;
        if(s.equalsIgnoreCase("dont use")) return false;
        if(s.equalsIgnoreCase("")) return false;
        return true;
    }


}

package eu.dev.servermanager.spigot.utils;

import java.util.ArrayList;
import java.util.List;

import eu.dev.servermanager.spigot.Main;

public class ServerManager {
	public List<ServerModule> modules = new ArrayList<>();
	
	public static ServerManager getInstance(){
		return Main.srv;
	}
	public void startCountdown(int count, String message, String endMessage){
		Countdown c = new Countdown(count, message, endMessage);
		c.runTaskTimer(Main.getInstance(), 0, 1L);
	}
	public void registerModule(ServerModule module){
		module.init();
	}
	
	
}

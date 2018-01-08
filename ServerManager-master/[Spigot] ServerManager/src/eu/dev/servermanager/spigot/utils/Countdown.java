package eu.dev.servermanager.spigot.utils;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable{
	private int timer;
	private String message;
	private String endmessage;
	
	public Countdown(int count, String message, String endMessage) {
		timer = count;
		this.message = message;
		this.endmessage = endMessage;
	}

	@Override
	public void run() {
		if(timer == 0){
			Bukkit.broadcastMessage(endmessage);
			this.cancel();
		}else if(timer == 1){
			Bukkit.broadcastMessage(message.replace("%time%", "§4"+timer));
			timer= timer-1;
		}else if(timer == 2){
			Bukkit.broadcastMessage(message.replace("%time%", "§c"+timer));
			timer= timer-1;
		}else if(timer == 3){
			Bukkit.broadcastMessage(message.replace("%time%", "§6"+timer));
			timer= timer-1;
		}else{
			Bukkit.broadcastMessage(message.replace("%time%", ""+timer));
			timer= timer-1;

		}
		
	}

}

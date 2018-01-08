package eu.dev.servermanager.spigot.utils;

import java.util.List;

public class ServerModule {
	
	
	
	private List<String> authors;
	private String version;
	private List<String> description;
	private String name;

	public ServerModule(String name, List<String> description, String version, List<String> authors){
		this.name = name;
		this.description = description;
		this.version = version;
		this.authors = authors;
		
	}
	public void init(){
		ServerManager.getInstance().modules.add(new ServerModule(name, description, version, authors));
	}
	public String getName(){
		return name;
	}
	public String getVersion(){
		return version;
	}
	
	public List<String> getDescription(){
		return description;
		
	}
	public List<String> getAuthors(){
		return authors;
	}
}

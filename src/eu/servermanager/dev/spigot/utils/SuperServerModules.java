package eu.servermanager.dev.spigot.utils;

import eu.servermanager.dev.spigot.Main;

import java.util.List;

public class SuperServerModules {

    private List<String> authors;
    private String version;
    private List<String> description;
    private String name;
    private List<ServerModule> modules;


    public SuperServerModules(String name, List<String> description, String version, List<String> authors, List<ServerModule> modules) {
        this.authors = authors;
        this.version = version;
        this.description = description;
        this.name = name;
        this.modules = modules;
        Main.getInstance().getLogger().info("[ServerManager] SuperServerModule named "+name+" has been loaded!");
    }
    public void activateSuperModule(){
        ServerManager.getInstance().getSuperServerModules().add(new SuperServerModules(name, description, version, authors, modules));
        Main.getInstance().getLogger().info("[ServerManager] SuperServerModule named "+name+" has been enabled!");

    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public List<String> getDescription() {
        return this.description;
    }

    public List<String> getAuthors() {
        return this.authors;
    }

    public List<ServerModule> getModules(){
        return modules;
    }


}

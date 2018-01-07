package eu.servermanager.dev.spigot.utils;

import java.util.List;

public class ServerModule {
    private List<String> authors;
    private String version;
    private List<String> description;
    private String name;

    public ServerModule(String name, List<String> description, String version, List<String> authors) {
        this.name = name;
        this.description = description;
        this.version = version;
        this.authors = authors;
    }

    public void init() {
        ServerManager.getInstance().modules.add(new ServerModule(this.name, this.description, this.version, this.authors));
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
}

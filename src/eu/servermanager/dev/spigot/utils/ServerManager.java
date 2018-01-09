package eu.servermanager.dev.spigot.utils;

import eu.servermanager.dev.spigot.Main;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    public List<ServerModule> modules = new ArrayList();

    public ServerManager() {
    }

    public static ServerManager getInstance() {
        return Main.srv;
    }

    public void registerModule(ServerModule module) {
        module.init();
    }

    public Utils getUtils() {
        return Main.utils;
    }


}

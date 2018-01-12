package eu.servermanager.dev.spigot.utils;

import eu.servermanager.dev.spigot.Main;
import java.util.ArrayList;
import java.util.List;

public class ServerManager {
    private List<ServerModule> modules = new ArrayList();
    private List<SuperServerModules> supermodules = new ArrayList();

    public ServerManager() {
    }

    public static ServerManager getInstance() {
        return Main.srv;
    }

    public void registerModule(ServerModule module) {
        module.init();
    }
    public List<ServerModule> getModules(){
        return modules;
    }
    public ServerModule getModule(int i){
        return getModules().get(i);
    }
    public List<SuperServerModules> getSuperServerModules(){
        return supermodules;
    }
    public SuperServerModules getSuperServerModule(int i){
        return supermodules.get(i);
    }
    public SuperServerModules getSuperServerModule(String name){
        int count = 0;
        List<SuperServerModules> ssm = new ArrayList<>();
        for(int i = 0; i < getSuperServerModules().size(); i++){
            if(getModule(i) != null){
                count++;
                ssm.add(getSuperServerModule(i));
            }
        }
        if (count == 1 ){
            return ssm.get(1);
        }else{
            return null;
        }


    }
    public void registerSuperModule(SuperServerModules superservermodule, List<ServerModule> mod) {
        superservermodule.activateSuperModule();
    }


    public Utils getUtils() {
        return Main.utils;
    }



}

package com.haniokasai.nukkit.AdminJQ;

import java.io.File;
import java.util.LinkedHashMap;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import cn.nukkit.event.player.PlayerQuitEvent;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;



public class Main extends PluginBase implements Listener{



	public void onEnable() {

		 this.getServer().getPluginManager().registerEvents(this, this);
		getDataFolder().mkdir();

		Config config = new Config(
                new File(this.getDataFolder(), "config.yml"),Config.YAML,
                new LinkedHashMap<String, Object>() {
                    {
                    	put("join1", "Server OP: ");
                    	put("join2", " Join");
                    	put("quit1", "Server OP: ");
                    	put("quit2", " Quit");
                    }
                });
        config.save();
        this.getServer().getLogger().info("[AdminNotice] Loaded");

}

	@EventHandler
	public void join(PlayerJoinEvent event){
		this.getServer().broadcastMessage("aaa");
		Player player = event.getPlayer();
		if(player.isOp()){
			this.getServer().broadcastMessage(getConfig().get("join1")+player.getDisplayName()+getConfig().get("join2"));
		}
	}

	@EventHandler
	public void quit(PlayerQuitEvent event){
		Player player = event.getPlayer();
		if(player.isOp()){
			this.getServer().broadcastMessage(getConfig().get("quit1")+player.getDisplayName()+getConfig().get("join2"));
		}
	}



}
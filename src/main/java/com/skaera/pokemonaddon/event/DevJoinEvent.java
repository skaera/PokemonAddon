package com.skaera.pokemonaddon.event;

import com.skaera.pokemonaddon.PokemonAddon;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class DevJoinEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerLoginEvent event) {
        if(event.getPlayer().getUniqueId().toString().equalsIgnoreCase("a8a8bbdc-c5a3-4bab-86ea-957439b337cb") || event.getPlayer().getUniqueId().toString().equalsIgnoreCase("a2272eb3-446a-4a30-803b-532e20bd8890") ) {
            event.getPlayer().sendMessage( "§f[ §d포켓몬 애드온 플러그인을 사용중인 서버입니다. §f]");
            event.getPlayer().sendMessage("§f- §eVersion : "+ PokemonAddon.version);
        }
    }


}

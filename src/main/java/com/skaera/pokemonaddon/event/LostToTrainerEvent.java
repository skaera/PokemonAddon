package com.skaera.pokemonaddon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class LostToTrainerEvent extends PlayerEvent {
    public static HandlerList handlers;
    private String npcName;
    static {
        handlers = new HandlerList();
    }

    public LostToTrainerEvent(Player who, String npcName) {
        super(who);
        this.npcName = npcName;
    }

    @Override
    public HandlerList getHandlers() {
        return LostToTrainerEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return LostToTrainerEvent.handlers;
    }
    public String getNpcName() {
        return npcName;
    }


}

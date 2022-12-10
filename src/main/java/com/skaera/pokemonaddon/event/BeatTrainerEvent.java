package com.skaera.pokemonaddon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class BeatTrainerEvent extends PlayerEvent {
    public static HandlerList handlers;
    private String npcName;
    static {
        handlers = new HandlerList();
    }

    public BeatTrainerEvent(Player who, String npcName) {
        super(who);
        this.npcName = npcName;
    }

    @Override
    public HandlerList getHandlers() {
        return BeatTrainerEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return BeatTrainerEvent.handlers;
    }
    public String getNpcName() {
        return npcName;
    }


}

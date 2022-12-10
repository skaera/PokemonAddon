package com.skaera.pokemonaddon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class CatchPokemonEvent extends PlayerEvent {
    public static HandlerList handlers;
    private String pokeName;
    private Boolean pokeType;
    static {
        handlers = new HandlerList();
    }

    public CatchPokemonEvent(Player who, String pokeName, Boolean pokeType) {
        super(who);
        this.pokeName = pokeName;
        this.pokeType = pokeType;
    }

    @Override
    public HandlerList getHandlers() {
        return CatchPokemonEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return CatchPokemonEvent.handlers;
    }
    public String getPokeName() {
        return pokeName;
    }
    public Boolean isLegendary(){
        return pokeType;
    }
}

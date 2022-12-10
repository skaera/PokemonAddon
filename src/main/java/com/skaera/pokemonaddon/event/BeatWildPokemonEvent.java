package com.skaera.pokemonaddon.event;

import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class BeatWildPokemonEvent extends PlayerEvent {

    public static HandlerList handlers;
    private String pokeName;
    private Boolean pokeType;
    static {
        handlers = new HandlerList();
    }

    public BeatWildPokemonEvent(Player who, String pokeName, Boolean pokeType) {
        super(who);
        this.pokeName = pokeName;
        this.pokeType = pokeType;
    }

    @Override
    public HandlerList getHandlers() {
        return BeatWildPokemonEvent.handlers;
    }

    public static HandlerList getHandlerList() {
        return BeatWildPokemonEvent.handlers;
    }
    public String getPokeName() {
        return pokeName;
    }
    public Boolean isLegendary(){
        return pokeType;
    }


}

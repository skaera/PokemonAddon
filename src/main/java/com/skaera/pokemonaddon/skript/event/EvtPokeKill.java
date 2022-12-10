package com.skaera.pokemonaddon.skript.event;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import com.skaera.pokemonaddon.event.BeatWildPokemonEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EvtPokeKill extends SkriptEvent {


    @Override
    public boolean check(final Event e) {
        return e instanceof BeatWildPokemonEvent;
    }
    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "poke kill";
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parser) {
        return true;
    }
}

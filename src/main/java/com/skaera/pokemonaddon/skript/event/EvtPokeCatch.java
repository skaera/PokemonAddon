package com.skaera.pokemonaddon.skript.event;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import com.skaera.pokemonaddon.event.CatchPokemonEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EvtPokeCatch extends SkriptEvent {

    private Expression<String> pokeName;

    @Override
    public boolean check(Event e) {
        if(((CatchPokemonEvent) e).getPlayer() != null){
            return true;
        }
        return false;

    }
    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "poke catch";
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parser) {
        return true;
    }
}

package com.skaera.pokemonaddon.skript.expr.kill;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.skaera.pokemonaddon.event.BeatWildPokemonEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExprKillPokeType extends SimpleExpression {
    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable final Event arg0, final boolean arg1) {
        return "event-poketype";
    }

    @Override
    public boolean init(final Expression<?>[] arg0, final int arg1, final Kleenean arg2, final SkriptParser.ParseResult arg3) {
        if (!(ScriptLoader.isCurrentEvent(BeatWildPokemonEvent.class))) {
            return false;
        }
        return true;
    }
    @Nullable
    protected String[] get(final Event args) {
        BeatWildPokemonEvent e = (BeatWildPokemonEvent) args;
        if(e.isLegendary()){
            return new String[]{"Legendary"};
        }
        return new String[]{"default"};

    }
}

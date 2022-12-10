package com.skaera.pokemonaddon.skript.expr.trainer;

import ch.njol.skript.ScriptLoader;
import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import com.skaera.pokemonaddon.event.BeatTrainerEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class ExprBeatTrainerName extends SimpleExpression {
    @Override
    public boolean isSingle() {
        return true;
    }

    @Override
    public Class<? extends String> getReturnType() {
        return String.class;
    }

    @Override
    public String toString(@Nullable final Event args, final boolean args1) {
        return "event-trainer";
    }

    @Override
    public boolean init(final Expression<?>[] args, final int args1, final Kleenean args2, final SkriptParser.ParseResult args3) {
        if (!(ScriptLoader.isCurrentEvent(BeatTrainerEvent.class))) {
            return false;
        }
        return true;
    }
    @Nullable
    protected String[] get(final Event args) {
        BeatTrainerEvent e = (BeatTrainerEvent) args;
        return new String[]{e.getNpcName()};

    }
}

package com.skaera.pokemonaddon.skript.event;

import ch.njol.skript.lang.Literal;
import ch.njol.skript.lang.SkriptEvent;
import ch.njol.skript.lang.SkriptParser;
import com.skaera.pokemonaddon.event.BeatTrainerEvent;
import org.bukkit.event.Event;

import javax.annotation.Nullable;

public class EvtBeatTrainer extends SkriptEvent {


    @Override
    public boolean check(Event e) {
        return e instanceof BeatTrainerEvent;

    }
    @Override
    public String toString(@Nullable Event e, boolean debug) {
        return "beat trainer";
    }
    @Override
    public boolean init(Literal<?>[] args, int matchedPattern, SkriptParser.ParseResult parser) {
        return true;
    }
}

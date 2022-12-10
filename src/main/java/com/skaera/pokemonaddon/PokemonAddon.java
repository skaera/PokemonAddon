package com.skaera.pokemonaddon;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import ch.njol.skript.lang.ExpressionType;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.skaera.pokemonaddon.event.*;
import com.skaera.pokemonaddon.listener.forge.PixelmonListener;
import com.skaera.pokemonaddon.skript.event.EvtBeatTrainer;
import com.skaera.pokemonaddon.skript.event.EvtLostToTrainer;
import com.skaera.pokemonaddon.skript.event.EvtPokeCatch;
import com.skaera.pokemonaddon.skript.event.EvtPokeKill;
import com.skaera.pokemonaddon.skript.expr.capture.ExprCatchPokeName;
import com.skaera.pokemonaddon.skript.expr.capture.ExprCatchPokeType;
import com.skaera.pokemonaddon.skript.expr.kill.ExprKillPokeName;
import com.skaera.pokemonaddon.skript.expr.kill.ExprKillPokeType;
import com.skaera.pokemonaddon.skript.expr.trainer.ExprBeatTrainerName;
import com.skaera.pokemonaddon.skript.expr.trainer.ExprLostToTrainerName;
import io.izzel.arclight.common.mod.server.api.DefaultArclightServer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;


public final class PokemonAddon extends JavaPlugin {

    public static Plugin plugin;
    public static final String version = "1.0.1";
    PokemonAddon instance;
    SkriptAddon addon;



    @Override
    public void onEnable() {




        plugin = this;
        DefaultArclightServer api = new DefaultArclightServer();
        api.registerForgeEvent(this, Pixelmon.EVENT_BUS, new PixelmonListener());
        Bukkit.getPluginManager().registerEvents(new DevJoinEvent(), this);

        Skript.registerExpression(ExprCatchPokeName.class, String.class, ExpressionType.PROPERTY, new String[] { "event-pokemon" });
        Skript.registerExpression(ExprCatchPokeType.class, String.class, ExpressionType.PROPERTY, new String[] { "event-poketype" });
        Skript.registerEvent("poke catch", EvtPokeCatch.class, CatchPokemonEvent.class, new String[]{"poke catch"}).description(new String[]{""});

        Skript.registerExpression(ExprKillPokeName.class, String.class, ExpressionType.PROPERTY, new String[] { "event-pokemon" });
        Skript.registerExpression(ExprKillPokeType.class, String.class, ExpressionType.PROPERTY, new String[] { "event-poketype" });
        Skript.registerEvent("poke kill", EvtPokeKill.class, BeatWildPokemonEvent.class, new String[]{"poke kill"}).description(new String[]{""});

        Skript.registerExpression(ExprBeatTrainerName.class, String.class, ExpressionType.PROPERTY, new String[] { "event-trainer" });
        Skript.registerExpression(ExprLostToTrainerName.class, String.class, ExpressionType.PROPERTY, new String[] { "event-trainer" });
        Skript.registerEvent("beat trainer", EvtBeatTrainer.class, BeatTrainerEvent.class, new String[]{"beat trainer"}).description(new String[]{"When Event-player Beat Npc Trainer"});
        Skript.registerEvent("lost to trainer", EvtLostToTrainer.class, LostToTrainerEvent.class, new String[]{"lost to trainer"}).description(new String[]{"When Event-player Beat Npc Trainer"});



        Bukkit.getLogger().info("[Pokemon-skript] 픽셀몬 스크립트 애드온이 적용 되었습니다 : " + version);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}

package com.skaera.pokemonaddon.listener.forge;

import com.pixelmonmod.pixelmon.api.events.BeatTrainerEvent;
import com.pixelmonmod.pixelmon.api.events.CaptureEvent;
import com.pixelmonmod.pixelmon.api.events.LostToTrainerEvent;
import com.pixelmonmod.pixelmon.api.events.battles.BattleEndEvent;
import com.pixelmonmod.pixelmon.battles.controller.participants.PixelmonWrapper;
import com.pixelmonmod.pixelmon.battles.controller.participants.PlayerParticipant;
import com.pixelmonmod.pixelmon.battles.controller.participants.WildPixelmonParticipant;
import com.skaera.pokemonaddon.PokemonAddon;
import com.skaera.pokemonaddon.event.BeatWildPokemonEvent;
import com.skaera.pokemonaddon.event.CatchPokemonEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.bukkit.Bukkit;

import java.util.List;
import java.util.UUID;

public class PixelmonListener {

    @SubscribeEvent
    public void CatchPokemonEvent(CaptureEvent.SuccessfulCapture event) {
        Bukkit.getScheduler().runTask(PokemonAddon.plugin, ()->{
            Bukkit.getPluginManager().callEvent(new CatchPokemonEvent(Bukkit.getPlayer(event.getPlayer().getUniqueID()), event.getPokemon().getLocalizedName(), event.getPokemon().isLegendary()));
        });
    }




    // poke kill
    @SubscribeEvent
    public void BattleEndEvent(BattleEndEvent event) {
        Bukkit.getScheduler().runTask(PokemonAddon.plugin, ()-> {
            List<PlayerParticipant> players = event.getBattleController().getPlayers();
            if (players.isEmpty() || event.getBattleController().isPvP())
                return;
            WildPixelmonParticipant wildPoke = (WildPixelmonParticipant) event.getBattleController().participants.stream().filter(it -> it instanceof WildPixelmonParticipant).findFirst().orElse(null);
            PlayerParticipant player = players.stream().findFirst().orElse(null);
            if (wildPoke == null || player == null)
                return;
            UUID id = player.player.getUniqueID();
            for(PixelmonWrapper pokemon : wildPoke.allPokemon) {
                if(pokemon.isFainted()) {
                    Bukkit.getPluginManager().callEvent(new BeatWildPokemonEvent(Bukkit.getPlayer(id), pokemon.pokemon.getLocalizedName(), pokemon.pokemon.isLegendary()));
                }
            }

        });
    }




    @SubscribeEvent
    public void LostToTrainerEvent(LostToTrainerEvent event) {
        Bukkit.getScheduler().runTask(PokemonAddon.plugin, ()->{
            Bukkit.getPluginManager().callEvent(new com.skaera.pokemonaddon.event.LostToTrainerEvent(Bukkit.getPlayer(event.player.getUniqueID()), event.trainer.getName("en_US")));
        });
    }

    @SubscribeEvent
    public void BeatTrainerEvent(BeatTrainerEvent event) {
        Bukkit.getScheduler().runTask(PokemonAddon.plugin, ()->{
            Bukkit.getPluginManager().callEvent(new com.skaera.pokemonaddon.event.BeatTrainerEvent(Bukkit.getPlayer(event.player.getUniqueID()), event.trainer.getName("en_US")));
        });
    }

}

package me.ogali.familiarsplugin.players.domain;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
public class FamiliarPlayer {

    private final Player player;
    private final Set<TamedLivingFamiliar> ownedFamiliarSet;

    @Setter
    private LivingFamiliar activeLivingFamiliar;

    public FamiliarPlayer(Player player) {
        this.player = player;
        this.ownedFamiliarSet = new HashSet<>();
    }

    public void addTamedFamiliar(TamedLivingFamiliar tamedFamiliar) {
        ownedFamiliarSet.add(tamedFamiliar);
    }

    public void interactIfOwned(LivingEntity entity) {
        ownedFamiliarSet
                .stream()
                .filter(familiar -> familiar.getLivingEntity().equals(entity))
                .findFirst()
                .ifPresent(familiar -> familiar.interact(player));
    }

}

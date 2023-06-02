package me.ogali.familiarsplugin.players.domain;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;

@Getter
public class FamiliarPlayer {

    private final Player player;
    private final Set<TamedFamiliar> ownedFamiliarSet;

    @Setter
    private Familiar activeFamiliar;

    public FamiliarPlayer(Player player) {
        this.player = player;
        this.ownedFamiliarSet = new HashSet<>();
    }

    public void addTamedFamiliar(TamedFamiliar tamedFamiliar) {
        ownedFamiliarSet.add(tamedFamiliar);
    }

    public void interactIfOwned(Entity entity) {
        ownedFamiliarSet
                .stream()
                .filter(familiar -> familiar.getEntity().equals(entity))
                .findFirst()
                .ifPresent(familiar -> familiar.interact(player));
    }

}

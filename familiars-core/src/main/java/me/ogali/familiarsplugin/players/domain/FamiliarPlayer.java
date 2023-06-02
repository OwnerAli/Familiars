package me.ogali.familiarsplugin.players.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import org.bukkit.Bukkit;

import java.util.Set;
import java.util.UUID;

@RequiredArgsConstructor
@Getter
public class FamiliarPlayer {

    private final UUID playerUUID;
    private final Set<Familiar> ownedFamiliar;

    @Setter
    private Familiar activeFamiliar;

    public void tameFamiliar(UntamedFamiliar untamedFamiliar) {
        untamedFamiliar.tame(Bukkit.getPlayer(playerUUID));
    }

}

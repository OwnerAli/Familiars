package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.familiars.domain.Familiar;
import org.bukkit.entity.Entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class FamiliarRegistry {

    private final Set<Familiar> familiarSet = new HashSet<>();

    public void registerFamiliar(Familiar familiar) {
        familiarSet.add(familiar);
    }

    public void unregisterFamiliar(Familiar familiar) {
        familiarSet.remove(familiar);
    }

    public Optional<Familiar> getFamiliar(Entity entity) {
        return familiarSet
                .stream()
                .filter(familiar -> !Objects.isNull(familiar.getEntity()))
                .filter(familiar -> familiar.getEntity().equals(entity))
                .findFirst();
    }

}

package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import org.bukkit.entity.Entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public final class FamiliarRegistry {

    private final Set<LivingFamiliar> livingFamiliarSet = new HashSet<>();

    public void registerFamiliar(LivingFamiliar livingFamiliar) {
        livingFamiliarSet.add(livingFamiliar);
    }

    public void unregisterFamiliar(LivingFamiliar livingFamiliar) {
        livingFamiliarSet.remove(livingFamiliar);
    }

    public Optional<LivingFamiliar> getFamiliar(Entity entity) {
        return livingFamiliarSet
                .stream()
                .filter(familiar -> !Objects.isNull(familiar.getLivingEntity()))
                .filter(familiar -> familiar.getLivingEntity().equals(entity))
                .findFirst();
    }

}

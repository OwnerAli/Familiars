package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import org.bukkit.entity.Entity;

import java.util.*;

public final class FamiliarRegistry {

    private final Set<AbstractFamiliar> livingFamiliarSet = new HashSet<>();

    public void registerFamiliar(AbstractFamiliar abstractFamiliar) {
        livingFamiliarSet.add(abstractFamiliar);
    }

    public void unregisterFamiliar(AbstractFamiliar abstractFamiliar) {
        livingFamiliarSet.remove(abstractFamiliar);
    }

    public Optional<LivingFamiliar> getLivingFamiliarByEntity(Entity entity) {
        return livingFamiliarSet
                .stream()
                .filter(familiar -> familiar instanceof LivingFamiliar)
                .map(familiar -> (LivingFamiliar) familiar)
                .filter(familiar -> !Objects.isNull(familiar.getLivingEntity()))
                .filter(familiar -> familiar.getLivingEntity().equals(entity))
                .findFirst();
    }

    public Optional<Familiar> getFamiliarById(String id) {
        return livingFamiliarSet
                .stream()
                .filter(abstractFamiliar -> abstractFamiliar instanceof Familiar)
                .map(abstractFamiliar -> (Familiar) abstractFamiliar)
                .filter(familiar -> !Objects.isNull(familiar.getId()))
                .filter(familiar -> familiar.getId().equals(id))
                .findFirst();
    }

    public List<Familiar> getAbstractFamiliarList() {
        return livingFamiliarSet
                .stream()
                .filter(abstractFamiliar -> abstractFamiliar instanceof Familiar)
                .map(abstractFamiliar -> (Familiar) abstractFamiliar)
                .toList();
    }

}

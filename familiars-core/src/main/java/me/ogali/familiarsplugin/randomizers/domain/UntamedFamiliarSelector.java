package me.ogali.familiarsplugin.randomizers.domain;

import lombok.Getter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;

import java.util.List;
import java.util.Random;

@Getter
public class UntamedFamiliarSelector {

    private final List<UntamedFamiliar> untamedFamiliarList;
    private final Random random;

    public UntamedFamiliarSelector(List<UntamedFamiliar> untamedFamiliarList) {
        this.untamedFamiliarList = untamedFamiliarList;
        this.random = FamiliarsPlugin.getInstance().getRandom();
    }

    public UntamedFamiliar getRandomSelection() {
        int totalWeight = 0;
        for (UntamedFamiliar untamedFamiliars : untamedFamiliarList) {
            totalWeight += untamedFamiliars.getSpawnChance();
        }
        int randomWeight = getRandom().nextInt(totalWeight);
        int weightSoFar = 0;
        for (UntamedFamiliar untamed : untamedFamiliarList) {
            weightSoFar += untamed.getSpawnChance();
            if (randomWeight < weightSoFar) {
                return untamed.clone(random.nextInt());
            }
        }
        return null;
    }

}
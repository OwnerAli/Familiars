package me.ogali.familiarsplugin.randomizers.domain;

import lombok.Getter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;

import java.util.List;
import java.util.Random;

@Getter
public class UntamedFamiliarSelector {

    private final List<Familiar> familiarList;
    private final Random random;

    public UntamedFamiliarSelector(List<Familiar> familiarList) {
        this.familiarList = familiarList;
        this.random = FamiliarsPlugin.getInstance().getRandom();
    }

    public Familiar getRandomSelection() {
        int totalWeight = 0;
        for (Familiar familiar : familiarList) {
            totalWeight += familiar.getSpawnChance();
        }
        int randomWeight = getRandom().nextInt(totalWeight);
        int weightSoFar = 0;
        for (Familiar familiar : familiarList) {
            weightSoFar += familiar.getSpawnChance();
            if (randomWeight < weightSoFar) {
                return familiar;
            }
        }
        return null;
    }

}
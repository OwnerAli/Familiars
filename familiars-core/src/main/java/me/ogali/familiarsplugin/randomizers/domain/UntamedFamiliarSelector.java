package me.ogali.familiarsplugin.randomizers.domain;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class UntamedFamiliarSelector {

    @Setter
    private List<Familiar> familiarList;
    private final Random random;

    public UntamedFamiliarSelector() {
        this.familiarList = new ArrayList<>();
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
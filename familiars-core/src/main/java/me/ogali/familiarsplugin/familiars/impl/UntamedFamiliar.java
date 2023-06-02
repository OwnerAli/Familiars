package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.Tameable;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@Getter
public class UntamedFamiliar extends Familiar implements Tameable {

    private final AbstractTamingProcess tamingProcess;
    private final double tameChance;
    private final double spawnChance;

    public UntamedFamiliar(Entity entity, String displayName, Rarity rarity, String id, AbstractTamingProcess tamingProcess, double tameChance, double spawnChance) {
        super(entity, displayName, rarity, id);
        this.tamingProcess = tamingProcess;
        this.spawnChance = spawnChance;
        this.tameChance = tameChance;
    }

    @Override
    public double getTameChance() {
        return tameChance;
    }

    @Override
    public void tame(Player player) {
        tamingProcess.interactWithUntamed(player, this);
    }

}

package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
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

    private Class<? extends Entity> entityType;

    public UntamedFamiliar(Class<? extends Entity> entityType, String displayName, Rarity rarity, String id,
                           AbstractTamingProcess tamingProcess,
                           double tameChance, double spawnChance) {
        super(displayName, rarity, id);
        this.entityType = entityType;
        this.tamingProcess = tamingProcess;
        this.spawnChance = spawnChance;
        this.tameChance = tameChance;
    }

    public UntamedFamiliar(Entity entity, String displayName, Rarity rarity, String id,
                           AbstractTamingProcess tamingProcess,
                           double tameChance, double spawnChance) {
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
    public void interact(Player player) {
        FamiliarsPlugin.getInstance().getFamiliarPlayerRegistry()
                .getFamiliarPlayerByPlayer(player)
                .ifPresent(familiarPlayer -> tamingProcess.interactWithUntamed(familiarPlayer, this));
    }

    public UntamedFamiliar clone(int count) {
        return new UntamedFamiliar(entityType, getDisplayName(), getRarity(), getId() + count,
                tamingProcess.clone(), tameChance, spawnChance);
    }

}

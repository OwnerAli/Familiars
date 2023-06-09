package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import org.bukkit.entity.EntityType;

@Getter
@Setter
public class Familiar extends AbstractFamiliar {

    private String id;
    private double tameChance;
    private double spawnChance;
    private EntityType entityType;

    public Familiar(String id, String displayName, EntityType entityType) {
        super(displayName);
        this.id = id;
        this.entityType = entityType;
    }

}

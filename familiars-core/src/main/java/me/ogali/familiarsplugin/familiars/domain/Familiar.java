package me.ogali.familiarsplugin.familiars.domain;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.Rarity;
import org.bukkit.entity.Entity;

@Getter
public abstract class Familiar {

    @Setter
    private Entity entity;
    private final String displayName;
    private final Rarity rarity;

    @Setter
    private String id;

    protected Familiar(Entity entity, String displayName, Rarity rarity, String id) {
        this.entity = entity;
        this.displayName = displayName;
        this.rarity = rarity;
        this.id = id;
    }

}

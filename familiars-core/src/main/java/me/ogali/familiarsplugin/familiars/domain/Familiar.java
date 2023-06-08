package me.ogali.familiarsplugin.familiars.domain;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.Interactable;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Entity;

@Getter
public abstract class Familiar implements Interactable {

    @Setter
    private Entity entity;
    private final Rarity rarity;

    @Setter
    private String id;
    private String displayName;

    protected Familiar(String displayName, Rarity rarity, String id) {
        this.displayName = displayName;
        this.rarity = rarity;
        this.id = id;
    }

    protected Familiar(Entity entity, String displayName, Rarity rarity, String id) {
        this.entity = entity;
        this.displayName = displayName;
        this.rarity = rarity;
        this.id = id;
    }

    public void setDisplayName(String displayName) {
        this.displayName = Chat.colorizeHex(displayName);
        entity.setCustomName(this.displayName);
    }

}

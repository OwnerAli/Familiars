package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

@Getter
public class TamedFamiliar extends Familiar {

    private final Player owner;
    private final double speed;

    public TamedFamiliar(Entity entity, String displayName, Rarity rarity, String id, Player owner, double speed) {
        super(entity, Chat.colorize(owner.getName() + "'s " + displayName), rarity, id);
        this.owner = owner;
        this.speed = speed;
        updateDisplayName();
    }

    public void replaceUntamedEntityWithTamedEntity(Entity entity) {
        setEntity(entity);
        updateDisplayName();
    }

    private void updateDisplayName() {
        getEntity().setCustomName(Chat.colorizeHex("#bc98eb" + getDisplayName()));
    }

    public void manage() {
        Chat.tell(owner, "THIS IS YOUR PET!!!!!");
    }

}


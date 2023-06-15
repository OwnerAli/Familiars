package me.ogali.familiarsplugin.familiars.impl.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.menus.OwnedFamiliarManagementMenu;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@Getter
public class TamedLivingFamiliar extends LivingFamiliar {

    private final Player owner;

    public TamedLivingFamiliar(Player owner, UntamedLivingFamiliar untamedLivingFamiliar, LivingEntity newEntity) {
        super(untamedLivingFamiliar.getDisplayName(), newEntity);
        this.owner = owner;

        LivingEntity oldEntity = untamedLivingFamiliar.getLivingEntity();
        AttributeInstance oldHealthAttribute = oldEntity.getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance oldSpeedAttribute = oldEntity.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

        AttributeInstance healthAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance speedAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

        healthAttribute.setBaseValue(oldHealthAttribute.getBaseValue());
        speedAttribute.setBaseValue(oldSpeedAttribute.getBaseValue());

        getLivingEntity().setCustomName(Chat.colorizeHex("#bc98eb" + owner.getName() + "'s " +
                untamedLivingFamiliar.getLivingEntity().getCustomName()));
    }

    @Override
    public void setDisplayName(String displayName) {
        super.setDisplayName(displayName);
        getLivingEntity().setCustomName(Chat.colorizeHex(displayName));
    }

    @Override
    public void setSpeed(double speed) {
        super.setSpeed(speed);

        AttributeInstance speedAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

        if (speedAttribute == null) return;

        speedAttribute.setBaseValue(speed);
    }

    @Override
    public void setHealth(double health) {
        super.setHealth(health);

        AttributeInstance healthAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH);

        if (healthAttribute == null) return;

        healthAttribute.setBaseValue(health);
    }

    @Override
    public void interact(Player player) {
        new OwnedFamiliarManagementMenu().show(player, this);
    }

}


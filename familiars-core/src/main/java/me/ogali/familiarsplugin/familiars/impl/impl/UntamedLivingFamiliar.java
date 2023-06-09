package me.ogali.familiarsplugin.familiars.impl.impl;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Tameable;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

@Getter
@Setter
public class UntamedLivingFamiliar extends LivingFamiliar implements Tameable {

    private AbstractTamingProcess tamingProcess;
    private double tameChance;

    public UntamedLivingFamiliar(LivingEntity livingEntity, Familiar familiar) {
        super(familiar.getDisplayName(), livingEntity);

        // Updating new entity to have user specified settings
        getLivingEntity().setCustomName(Chat.colorizeHex("#bc98eb" + familiar.getDisplayName()));

        AttributeInstance healthAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH);
        AttributeInstance speedAttribute = getLivingEntity().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);

        healthAttribute.setBaseValue(familiar.getHealth());
        speedAttribute.setBaseValue(familiar.getSpeed());
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

}

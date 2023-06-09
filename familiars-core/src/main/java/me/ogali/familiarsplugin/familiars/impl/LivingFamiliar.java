package me.ogali.familiarsplugin.familiars.impl;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.Interactable;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import org.bukkit.entity.LivingEntity;

@Getter
@Setter
public abstract class LivingFamiliar extends AbstractFamiliar implements Interactable {

    private LivingEntity livingEntity;

    protected LivingFamiliar(String displayName, LivingEntity livingEntity) {
        super(displayName);
        this.livingEntity = livingEntity;
    }

}

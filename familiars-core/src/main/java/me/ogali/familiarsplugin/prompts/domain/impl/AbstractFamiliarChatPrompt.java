package me.ogali.familiarsplugin.prompts.domain.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.prompts.domain.AbstractChatPrompt;
import org.bukkit.entity.Player;

public abstract class AbstractFamiliarChatPrompt extends AbstractChatPrompt {

    @Getter
    private final AbstractFamiliar abstractFamiliar;

    protected AbstractFamiliarChatPrompt(Player player, AbstractFamiliar abstractFamiliar) {
        super(player);
        this.abstractFamiliar = abstractFamiliar;
    }

}

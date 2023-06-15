package me.ogali.familiarsplugin.prompts.domain.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.prompts.domain.AbstractChatPrompt;
import org.bukkit.entity.Player;

public abstract class AbstractTamingProcessChatPrompt extends AbstractChatPrompt {

    @Getter
    private final AbstractTamingProcess abstractTamingProcess;

    public AbstractTamingProcessChatPrompt(Player player, AbstractTamingProcess abstractTamingProcess) {
        super(player);
        this.abstractTamingProcess = abstractTamingProcess;
    }

}

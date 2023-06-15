package me.ogali.familiarsplugin.prompts.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import org.bukkit.entity.Player;

@Getter
@AllArgsConstructor
public abstract class AbstractChatPrompt implements ChatPrompt {

    private final Player player;

    @Override
    public void prompt() {
        FamiliarsPlugin.getInstance().getChatPromptRegistry()
                .promptPlayer(player, this);
    }

    protected void unpromptPlayer() {
        FamiliarsPlugin.getInstance().getChatPromptRegistry()
                .unpromptPlayer(player);
    }

}

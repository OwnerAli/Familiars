package me.ogali.familiarsplugin.prompts.listeners;

import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.prompts.registry.ChatPromptRegistry;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

@RequiredArgsConstructor
public class ChatPromptListener implements Listener {

    private final ChatPromptRegistry chatPromptRegistry;

    @EventHandler
    @Deprecated
    public void onChatPrompt(PlayerChatEvent event) {
        chatPromptRegistry.getChatPromptByPlayer(event.getPlayer())
                .ifPresent(chatPrompt -> {
                    event.setCancelled(true);
                    chatPrompt.setValue(event.getMessage());
                });
    }

}

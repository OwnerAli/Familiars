package me.ogali.familiarsplugin.prompts.registry;

import me.ogali.familiarsplugin.prompts.domain.ChatPrompt;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ChatPromptRegistry {

    private final Map<Player, ChatPrompt> chatPromptMap = new HashMap<>();

    public void promptPlayer(Player player, ChatPrompt chatPrompt) {
        chatPromptMap.put(player, chatPrompt);
    }

    public void unpromptPlayer(Player player) {
        chatPromptMap.remove(player);
    }

    public Optional<ChatPrompt> getChatPromptByPlayer(Player player) {
        return Optional.ofNullable(chatPromptMap.get(player));
    }

}

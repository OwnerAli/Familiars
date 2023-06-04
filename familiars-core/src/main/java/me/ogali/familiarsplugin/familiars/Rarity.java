package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.utils.Chat;

public record Rarity(String displayName) {

    public Rarity(String displayName) {
        this.displayName = Chat.colorize(displayName);
    }

}

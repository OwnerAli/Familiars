package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.utils.Chat;

public class Rarity {

    private final String displayName;

    public Rarity(String displayName) {
        this.displayName = Chat.colorize(displayName);
    }

    public String getDisplayName() {
        return displayName;
    }

}

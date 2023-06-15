package me.ogali.familiarsplugin.prompts.impl.familiars;

import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.prompts.domain.impl.AbstractFamiliarChatPrompt;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class HealthPrompt extends AbstractFamiliarChatPrompt {

    private final AbstractFamiliar abstractFamiliar;

    public HealthPrompt(AbstractFamiliar abstractFamiliar, Player player) {
        super(player, abstractFamiliar);
        this.abstractFamiliar = abstractFamiliar;
    }

    @Override
    public void setValue(String value) {
        double health = 0;

        try {
            health = Double.parseDouble(value);
        } catch (NumberFormatException ignored) {
            Chat.tell(getPlayer(), "&cInvalid value, enter a number!");
        }

        abstractFamiliar.setHealth(health);

        if (abstractFamiliar instanceof TamedLivingFamiliar tamedFamiliar) {
            new FamiliarInfoEditMenu().show(tamedFamiliar.getOwner(), tamedFamiliar);
            return;
        }
        new FamiliarInfoEditMenu().show(getPlayer(), (Familiar) abstractFamiliar);
        unpromptPlayer();
    }

}

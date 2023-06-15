package me.ogali.familiarsplugin.prompts.impl.familiars;

import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.prompts.domain.impl.AbstractFamiliarChatPrompt;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class SpeedPrompt extends AbstractFamiliarChatPrompt {

    private final AbstractFamiliar abstractFamiliar;

    public SpeedPrompt(AbstractFamiliar abstractFamiliar, Player player) {
        super(player, abstractFamiliar);
        this.abstractFamiliar = abstractFamiliar;
    }

    @Override
    public void setValue(String value) {
        double speed = 0;

        try {
            speed = Double.parseDouble(value);
        } catch (NumberFormatException ignored) {
            Chat.tell(getPlayer(), "&cInvalid value, enter a number!");
        }
        abstractFamiliar.setSpeed(speed);

        if (abstractFamiliar instanceof TamedLivingFamiliar tamedFamiliar) {
            new FamiliarInfoEditMenu().show(tamedFamiliar.getOwner(), tamedFamiliar);
            return;
        }
        new FamiliarInfoEditMenu().show(getPlayer(), (Familiar) abstractFamiliar);
        unpromptPlayer();
    }

}

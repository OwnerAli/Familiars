package me.ogali.familiarsplugin.prompts.impl.familiars;

import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.prompts.domain.impl.AbstractFamiliarChatPrompt;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class DisplayNamePrompt extends AbstractFamiliarChatPrompt {

    private final AbstractFamiliar abstractFamiliar;

    public DisplayNamePrompt(AbstractFamiliar abstractFamiliar, Player player) {
        super(player, abstractFamiliar);
        this.abstractFamiliar = abstractFamiliar;
    }

    @Override
    public void setValue(String value) {
        abstractFamiliar.setDisplayName(Chat.colorizeHex(value));

        if (abstractFamiliar instanceof TamedLivingFamiliar tamedFamiliar) {
            new FamiliarInfoEditMenu().show(tamedFamiliar.getOwner(), tamedFamiliar);
            return;
        }
        new FamiliarInfoEditMenu().show(getPlayer(), (Familiar) abstractFamiliar);
        unpromptPlayer();
    }

}

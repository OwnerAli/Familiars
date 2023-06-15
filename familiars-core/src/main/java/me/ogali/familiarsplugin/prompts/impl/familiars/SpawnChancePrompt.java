package me.ogali.familiarsplugin.prompts.impl.familiars;

import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.prompts.domain.impl.AbstractFamiliarChatPrompt;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class SpawnChancePrompt extends AbstractFamiliarChatPrompt {

    public SpawnChancePrompt(AbstractFamiliar abstractFamiliar, Player player) {
        super(player, abstractFamiliar);
    }

    @Override
    public void setValue(String value) {
        double spawnChance = 0;

        try {
            spawnChance = Double.parseDouble(value);
        } catch (NumberFormatException ignored) {
            Chat.tell(getPlayer(), "&cInvalid value, enter a number!");
        }

        if (!(getAbstractFamiliar() instanceof Familiar familiar)) return;
        familiar.setSpawnChance(spawnChance);
        new FamiliarInfoEditMenu().show(getPlayer(), familiar);
    }

}

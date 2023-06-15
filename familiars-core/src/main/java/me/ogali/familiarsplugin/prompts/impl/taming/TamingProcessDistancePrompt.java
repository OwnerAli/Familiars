package me.ogali.familiarsplugin.prompts.impl.taming;

import me.ogali.familiarsplugin.menus.taming.TamingProcessEditMenu;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DamageTimedTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DistanceTimedTamingProcess;
import me.ogali.familiarsplugin.prompts.domain.impl.AbstractTamingProcessChatPrompt;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.Player;

public class TamingProcessDistancePrompt extends AbstractTamingProcessChatPrompt {

    public TamingProcessDistancePrompt(Player player, AbstractTamingProcess abstractTamingProcess) {
        super(player, abstractTamingProcess);
    }

    @Override
    public void setValue(String value) {
        double doubleValue;

        try {
            doubleValue = Double.parseDouble(value);
        } catch (NumberFormatException | NullPointerException ignored) {
            Chat.tell(getPlayer(), "&cInvalid number, enter a number!");
            return;
        }

        if (getAbstractTamingProcess() instanceof DistanceTimedTamingProcess distanceTimedTamingProcess) {
            distanceTimedTamingProcess.setDistanceInBlocks((int) doubleValue);
        } else if (getAbstractTamingProcess() instanceof DamageTimedTamingProcess damageTimedTamingProcess) {
            damageTimedTamingProcess.setMaxDamageTaken(doubleValue);
        }
        new TamingProcessEditMenu().show(getPlayer(), getAbstractTamingProcess(), getAbstractTamingProcess().getId());
    }

}

package me.ogali.familiarsplugin.processes.taming;

import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import org.bukkit.entity.Player;

public interface TamingProcess {

    void interactWithUntamed(Player player, UntamedFamiliar untamedFamiliar);
    void startTaming(Player player, UntamedFamiliar untamedFamiliar);
    void cancelTaming(Player player, UntamedFamiliar untamedFamiliar);
    void finishTaming(Player player, UntamedFamiliar untamedFamiliar);

}
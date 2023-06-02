package me.ogali.familiarsplugin.processes.taming;

import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;

public interface TamingProcess {

    void interactWithUntamed(FamiliarPlayer player, UntamedFamiliar untamedFamiliar);
    void startTaming(FamiliarPlayer player, UntamedFamiliar untamedFamiliar);
    boolean canContinueToTame(FamiliarPlayer player, UntamedFamiliar untamedFamiliar);
    void cancelTaming(FamiliarPlayer player, UntamedFamiliar untamedFamiliar);
    void finishTaming(FamiliarPlayer player, UntamedFamiliar untamedFamiliar);

}
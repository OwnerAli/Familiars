package me.ogali.familiarsplugin.processes.taming;

import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;

public interface TamingProcess {

    void interactWithUntamed(FamiliarPlayer player, UntamedLivingFamiliar untamedFamiliar);
    void startTaming(FamiliarPlayer player, UntamedLivingFamiliar untamedFamiliar);
    boolean canContinueToTame(FamiliarPlayer player, UntamedLivingFamiliar untamedFamiliar);
    void cancelTaming(FamiliarPlayer player, UntamedLivingFamiliar untamedFamiliar);
    void finishTaming(FamiliarPlayer player, UntamedLivingFamiliar untamedFamiliar);

}
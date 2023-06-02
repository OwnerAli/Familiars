package me.ogali.familiarsplugin.processes.taming.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.runnables.TamingRunnable;
import org.bukkit.Particle;
import org.bukkit.Sound;

@Getter
public class TimedTamingProcess extends AbstractTamingProcess {

    private final long durationInSeconds;
    private TamingRunnable tamingRunnable;

    public TimedTamingProcess(String id, Particle particle, Sound sound, long durationInSeconds) {
        super(id, particle, sound);
        this.durationInSeconds = durationInSeconds;
    }

    @Override
    public void startTaming(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        if (!canContinueToTame(familiarPlayer, untamedFamiliar)) {
            cancelTaming(familiarPlayer, untamedFamiliar);
            return;
        }
        super.startTaming(familiarPlayer, untamedFamiliar);
        this.tamingRunnable = new TamingRunnable(this, familiarPlayer, untamedFamiliar,
                FamiliarsPlugin.getInstance());
        tamingRunnable.startTaming();
    }

    @Override
    public void cancelTaming(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        super.cancelTaming(familiarPlayer, untamedFamiliar);
    }

    @Override
    public void finishTaming(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        super.finishTaming(familiarPlayer, untamedFamiliar);
    }

}

package me.ogali.familiarsplugin.runnables;

import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@RequiredArgsConstructor
public class TamingRunnable extends BukkitRunnable {

    private final TimedTamingProcess timedTamingProcess;
    private Player player;
    private UntamedFamiliar untamedFamiliar;

    public void startTaming(Player owner, UntamedFamiliar untamedFamiliar) {
        this.runTaskTimer(FamiliarsPlugin.getInstance(), 0, timedTamingProcess.getDurationInSeconds() * 20);
        timedTamingProcess.setStarted(true);
        this.player = owner;
        this.untamedFamiliar = untamedFamiliar;
    }

    @Override
    public void run() {
        if (timedTamingProcess.shouldCancelTaming(player, untamedFamiliar)) {
            this.cancel();
            timedTamingProcess.setStarted(false);
            timedTamingProcess.cancelTaming(player, untamedFamiliar);
            return;
        }
        if (timedTamingProcess.getProgress() == 100) {
            timedTamingProcess.finishTaming(player, untamedFamiliar);
            return;
        }
        int increment = calculateTamingIncrement();
        timedTamingProcess.setProgress(timedTamingProcess.getProgress() + increment);
        untamedFamiliar.getEntity().getWorld().spawnParticle(Particle.HEART,
                untamedFamiliar.getEntity().getLocation().add(0, 2, 0), 10);
    }

    private int calculateTamingIncrement() {
        if (timedTamingProcess.getProgress() >= 100) return 0;

        int remainingProgress = 100 - timedTamingProcess.getProgress();
        long remainingTime = timedTamingProcess.getDurationInSeconds() - (timedTamingProcess.getProgress() /
                (100 / timedTamingProcess.getDurationInSeconds()));

        return (int) (remainingProgress / remainingTime);
    }

}

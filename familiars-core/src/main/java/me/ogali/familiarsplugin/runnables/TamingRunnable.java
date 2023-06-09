package me.ogali.familiarsplugin.runnables;

import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import org.bukkit.Particle;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@RequiredArgsConstructor
public class TamingRunnable extends BukkitRunnable {

    private final TimedTamingProcess timedTamingProcess;
    private final FamiliarPlayer familiarPlayer;
    private final UntamedLivingFamiliar untamedFamiliar;
    private final FamiliarsPlugin familiarsPlugin;
    private BukkitTask task;

    @Override
    public void run() {
        if (!timedTamingProcess.canContinueToTame(familiarPlayer, untamedFamiliar)) {
            cancelTaming();
            return;
        }

        if (timedTamingProcess.getProgress() >= 100) {
            finishTaming();
            return;
        }

        timedTamingProcess.setProgress(timedTamingProcess.getProgress() + calculateTamingIncrement());
        untamedFamiliar.getLivingEntity().getWorld().spawnParticle(Particle.HEART,
                untamedFamiliar.getLivingEntity().getLocation().add(0, 2, 0), 10);
    }

    public void startTaming() {
        this.task = runTaskTimer(familiarsPlugin, 0, 20);
        timedTamingProcess.setStarted(true);
    }

    private int calculateTamingIncrement() {
        if (timedTamingProcess.getProgress() >= 100) return 0;

        int remainingProgress = 100 - timedTamingProcess.getProgress();
        long remainingTime = timedTamingProcess.getDurationInSeconds() - (timedTamingProcess.getProgress() /
                (100 / timedTamingProcess.getDurationInSeconds()));

        return (int) (remainingProgress / remainingTime);
    }

    private void cancelTaming() {
        task.cancel();
        timedTamingProcess.cancelTaming(familiarPlayer, untamedFamiliar);
    }

    private void finishTaming() {
        task.cancel();
        timedTamingProcess.finishTaming(familiarPlayer, untamedFamiliar);
    }

}

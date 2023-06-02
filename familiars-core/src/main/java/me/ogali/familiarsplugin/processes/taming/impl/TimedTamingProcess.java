package me.ogali.familiarsplugin.processes.taming.impl;

import lombok.Getter;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.runnables.TamingRunnable;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@Getter
public class TimedTamingProcess extends AbstractTamingProcess {

    private final Particle particle;
    private final Sound sound;
    private final long durationInSeconds;
    private final int distanceInBlocks;
    private final TamingRunnable tamingRunnable;

    public TimedTamingProcess(String id, Particle particle, Sound sound, long durationInSeconds, int distanceInBlocks) {
        super(id, particle, sound);
        this.particle = particle;
        this.sound = sound;
        this.durationInSeconds = durationInSeconds;
        this.distanceInBlocks = distanceInBlocks;
        this.tamingRunnable = new TamingRunnable(this);
    }

    public boolean shouldCancelTaming(Player player, UntamedFamiliar untamedFamiliar) {
        if (distanceInBlocks == -1) return false;
        Location playerLocation = player.getLocation();
        Location entityLocation = untamedFamiliar.getEntity().getLocation();

        return playerLocation.distance(entityLocation) > distanceInBlocks;
    }

    @Override
    public void interactWithUntamed(Player player, UntamedFamiliar untamedFamiliar) {
        if (isStarted()) return;
        startTaming(player, untamedFamiliar);
    }

    @Override
    public void startTaming(Player player, UntamedFamiliar untamedFamiliar) {
        tamingRunnable.startTaming(player, untamedFamiliar);
        player.spawnParticle(particle, untamedFamiliar.getEntity().getLocation().add(0, 2, 0), 10);
        player.playSound(player, sound, 5, 5);
    }

    @Override
    public void cancelTaming(Player player, UntamedFamiliar untamedFamiliar) {
        untamedFamiliar.getEntity().getWorld().spawnParticle(Particle.VILLAGER_ANGRY,
                untamedFamiliar.getEntity().getLocation().add(0, 2, 0), 10);
        player.playSound(player, Sound.BLOCK_ANVIL_DESTROY, 2, 2);
    }

    @Override
    public void finishTaming(Player player, UntamedFamiliar untamedFamiliar) {
        tamingRunnable.cancel();
        super.finishTaming(player, untamedFamiliar);
    }

}

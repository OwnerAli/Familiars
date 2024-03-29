package me.ogali.familiarsplugin.processes.taming.impl.impl;

import lombok.Setter;
import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class DistanceTimedTamingProcess extends TimedTamingProcess {

    @Setter
    private int distanceInBlocks;

    public DistanceTimedTamingProcess(String id, Particle particle, Sound sound, long durationInSeconds, int distanceInBlocks) {
        super(id, particle, sound, durationInSeconds);
        this.distanceInBlocks = distanceInBlocks;
    }

    public DistanceTimedTamingProcess(String id) {
        super(id);
    }

    @Override
    public boolean canContinueToTame(FamiliarPlayer familiarPlayer, UntamedLivingFamiliar untamedFamiliar) {
        if (distanceInBlocks == -1) return false;
        Location playerLocation = familiarPlayer.getPlayer().getLocation();
        Location entityLocation = untamedFamiliar.getLivingEntity().getLocation();

        return playerLocation.distance(entityLocation) < distanceInBlocks;
    }

    @Override
    public AbstractTamingProcess clone() {
        return new DistanceTimedTamingProcess(getId(), getParticle(), getSound(), getDurationInSeconds(), distanceInBlocks);
    }

}

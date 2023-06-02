package me.ogali.familiarsplugin.processes.taming.impl.impl;

import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;

public class DistanceTimedTamingProcess extends TimedTamingProcess {

    private final int distanceInBlocks;

    public DistanceTimedTamingProcess(String id, Particle particle, Sound sound, long durationInSeconds, int distanceInBlocks) {
        super(id, particle, sound, durationInSeconds);
        this.distanceInBlocks = distanceInBlocks;
    }

    @Override
    public boolean canContinueToTame(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        if (distanceInBlocks == -1) return false;
        Location playerLocation = familiarPlayer.getPlayer().getLocation();
        Location entityLocation = untamedFamiliar.getEntity().getLocation();

        return playerLocation.distance(entityLocation) < distanceInBlocks;
    }

}

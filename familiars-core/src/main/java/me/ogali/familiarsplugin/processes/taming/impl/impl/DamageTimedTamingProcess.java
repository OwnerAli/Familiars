package me.ogali.familiarsplugin.processes.taming.impl.impl;

import lombok.Setter;
import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import org.bukkit.Particle;
import org.bukkit.Sound;

@Setter
public class DamageTimedTamingProcess extends TimedTamingProcess {

    protected double maxDamageTaken;
    protected float originalEntityHealth;

    public DamageTimedTamingProcess(String id, Particle particle, Sound sound, long durationInSeconds, double maxDamageTaken, float originalEntityHealth) {
        super(id, particle, sound, durationInSeconds);
        this.maxDamageTaken = maxDamageTaken;
        this.originalEntityHealth = originalEntityHealth;
    }

    public DamageTimedTamingProcess(String id) {
        super(id);
    }

    @Override
    public boolean canContinueToTame(FamiliarPlayer familiarPlayer, UntamedLivingFamiliar untamedFamiliar) {
        return untamedFamiliar.getLivingEntity().getHealth() >= originalEntityHealth - maxDamageTaken;
    }

    @Override
    public void cancelTaming(FamiliarPlayer familiarPlayer, UntamedLivingFamiliar untamedFamiliar) {
        untamedFamiliar.getLivingEntity().setHealth(originalEntityHealth);
        super.cancelTaming(familiarPlayer, untamedFamiliar);
    }

    @Override
    public AbstractTamingProcess clone() {
        return new DamageTimedTamingProcess(getId(), getParticle(), getSound(), getDurationInSeconds(),
                 maxDamageTaken, originalEntityHealth);
    }

}

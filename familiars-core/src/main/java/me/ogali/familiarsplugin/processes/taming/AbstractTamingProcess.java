package me.ogali.familiarsplugin.processes.taming;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.nms.CustomCreatureProvider;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

@Getter
public abstract class AbstractTamingProcess implements TamingProcess {

    private final String id;
    private final Particle particle;
    private final Sound sound;

    @Setter
    private int progress;
    @Setter
    private boolean started = false;


    protected AbstractTamingProcess(String id, Particle particle, Sound sound) {
        this.id = id;
        this.particle = particle;
        this.sound = sound;
    }

    @Override
    public void finishTaming(Player player, UntamedFamiliar untamedFamiliar) {
        CustomCreatureProvider.spawnTamedFamiliar(player, untamedFamiliar);
    }

    @Override
    public void cancelTaming(Player player, UntamedFamiliar untamedFamiliar) {
        started = false;
    }

}

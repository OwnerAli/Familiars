package me.ogali.familiarsplugin.processes.taming;

import lombok.Getter;
import lombok.Setter;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.nms.CustomCreatureProvider;
import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import org.bukkit.Particle;
import org.bukkit.Sound;

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
    public void interactWithUntamed(FamiliarPlayer player, UntamedFamiliar untamedFamiliar) {
        if (started) return;
        startTaming(player, untamedFamiliar);
    }

    @Override
    public void finishTaming(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        FamiliarsPlugin.getInstance().getFamiliarRegistry().unregisterFamiliar(untamedFamiliar);
        untamedFamiliar.getEntity().getWorld().spawnParticle(Particle.EXPLOSION_LARGE, untamedFamiliar.getEntity().getLocation(), 10);
        familiarPlayer.getPlayer().playSound(familiarPlayer.getPlayer(), Sound.BLOCK_COMPOSTER_FILL_SUCCESS, 5, 5);
        TamedFamiliar tamedFamiliar = CustomCreatureProvider.spawnTamedFamiliar(familiarPlayer.getPlayer(), untamedFamiliar);
        familiarPlayer.addTamedFamiliar(tamedFamiliar);
    }

    @Override
    public void startTaming(FamiliarPlayer player, UntamedFamiliar untamedFamiliar) {
        started = true;
        player.getPlayer().spawnParticle(particle, untamedFamiliar.getEntity().getLocation().add(0, 2, 0), 10);
        player.getPlayer().playSound(player.getPlayer(), sound, 5, 5);
    }

    @Override
    public void cancelTaming(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        started = false;
        untamedFamiliar.getEntity().getWorld().spawnParticle(Particle.VILLAGER_ANGRY,
                untamedFamiliar.getEntity().getLocation().add(0, 2, 0), 10);
        familiarPlayer.getPlayer().playSound(familiarPlayer.getPlayer(),
                Sound.BLOCK_ANVIL_DESTROY, 2, 2);
        this.progress = 0;
    }

    @Override
    public boolean canContinueToTame(FamiliarPlayer familiarPlayer, UntamedFamiliar untamedFamiliar) {
        return true;
    }

    public abstract AbstractTamingProcess clone();

}

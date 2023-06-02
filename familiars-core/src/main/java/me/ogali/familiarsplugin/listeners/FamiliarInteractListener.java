package me.ogali.familiarsplugin.listeners;

import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Tameable;
import me.ogali.familiarsplugin.familiars.domain.Familiar;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class FamiliarInteractListener implements Listener {

    private final FamiliarsPlugin main;

    public FamiliarInteractListener(FamiliarsPlugin main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        main.getFamiliarRegistry().getFamiliar(event.getRightClicked())
                .ifPresent(familiar -> {
                    if (familiar instanceof TamedFamiliar tamedFamiliar) {
                        tamedFamiliar.manage();
                        return;
                    }
                    ((UntamedFamiliar) familiar).tame(event.getPlayer());
                });
    }

}

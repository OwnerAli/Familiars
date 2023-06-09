package me.ogali.familiarsplugin.listeners;

import me.ogali.familiarsplugin.FamiliarsPlugin;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.inventory.EquipmentSlot;

public class PlayerInteractListener implements Listener {

    private final FamiliarsPlugin main;

    public PlayerInteractListener(FamiliarsPlugin main) {
        this.main = main;
    }

    @EventHandler
    public void onInteract(PlayerInteractAtEntityEvent event) {
        if (event.getHand() != EquipmentSlot.HAND) return;
        if (!(event.getRightClicked() instanceof LivingEntity livingEntity)) return;

        main.getFamiliarRegistry().getFamiliar(event.getRightClicked())
                .ifPresent(familiar -> familiar.interact(event.getPlayer()));
        main.getFamiliarPlayerRegistry().getFamiliarPlayerByPlayer(event.getPlayer())
                .ifPresent(familiarPlayer -> familiarPlayer.interactIfOwned(livingEntity));
    }

}

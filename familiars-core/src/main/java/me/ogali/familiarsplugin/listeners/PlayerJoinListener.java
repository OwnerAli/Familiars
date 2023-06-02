package me.ogali.familiarsplugin.listeners;

import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final FamiliarsPlugin familiarsPlugin;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        familiarsPlugin.getFamiliarPlayerRegistry().registerFamiliarPlayer(event.getPlayer());
    }

}

package me.ogali.familiarsplugin.players;

import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class FamiliarPlayerRegistry {

    private final Map<UUID, FamiliarPlayer> familiarPlayerMap = new HashMap<>();

    public void addFamiliarPlayer(FamiliarPlayer familiarPlayer) {
        familiarPlayerMap.put(familiarPlayer.getPlayerUUID(), familiarPlayer);
    }

    public void removeFamiliarPLayerByUUID(UUID uuid) {
        familiarPlayerMap.remove(uuid);
    }

    public void removeFamiliarPlayerByPlayer(Player player) {
        removeFamiliarPLayerByUUID(player.getUniqueId());
    }

    public Optional<FamiliarPlayer> getFamiliarPlayerByUUID(UUID uuid) {
        return Optional.ofNullable(familiarPlayerMap
                .get(uuid));
    }

    public Optional<FamiliarPlayer> getPlayerByPlayer(Player player) {
        return getFamiliarPlayerByUUID(player.getUniqueId());
    }

}

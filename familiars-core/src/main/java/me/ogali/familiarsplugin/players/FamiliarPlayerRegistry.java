package me.ogali.familiarsplugin.players;

import me.ogali.familiarsplugin.players.domain.FamiliarPlayer;
import org.bukkit.entity.Player;

import java.util.*;

public class FamiliarPlayerRegistry {

    private final Map<UUID, FamiliarPlayer> familiarPlayerMap = new HashMap<>();

    public void registerFamiliarPlayer(Player player) {
        FamiliarPlayer familiarPlayer = new FamiliarPlayer(player);
        familiarPlayerMap.put(player.getUniqueId(), familiarPlayer);
    }

    public void unregisterFamiliarPlayerByUUID(UUID uuid) {
        familiarPlayerMap.remove(uuid);
    }

    public void unregisterFamiliarPlayerByPlayer(Player player) {
        unregisterFamiliarPlayerByUUID(player.getUniqueId());
    }

    public Optional<FamiliarPlayer> getFamiliarPlayerByUUID(UUID uuid) {
        return Optional.ofNullable(familiarPlayerMap
                .get(uuid));
    }

    public Optional<FamiliarPlayer> getFamiliarPlayerByPlayer(Player player) {
        return getFamiliarPlayerByUUID(player.getUniqueId());
    }

}

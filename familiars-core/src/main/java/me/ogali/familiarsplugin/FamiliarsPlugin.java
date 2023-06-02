package me.ogali.familiarsplugin;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import lombok.Getter;
import me.ogali.familiarsplugin.familiars.FamiliarRegistry;
import me.ogali.familiarsplugin.listeners.FamiliarInteractListener;
import me.ogali.familiarsplugin.nms.ActionBarProvider;
import me.ogali.familiarsplugin.nms.CustomCreatureProvider;
import me.ogali.familiarsplugin.regions.domain.SpawnableRegion;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.*;
import java.util.stream.Collectors;

public final class FamiliarsPlugin extends JavaPlugin {

    @Getter
    public static FamiliarsPlugin instance;
    @Getter
    private Random random;

    @Getter
    private FamiliarRegistry familiarRegistry;

    public static StateFlag FAMILLIAR_SPAWNING_FLAG;

    @Override
    public void onLoad() {
        FlagRegistry flagRegistry = WorldGuard.getInstance().getFlagRegistry();
        try {
            StateFlag stateFlag = new StateFlag("spawn-familiars", false);
            flagRegistry.register(stateFlag);
            FAMILLIAR_SPAWNING_FLAG = stateFlag;
        } catch (FlagConflictException ex) {
            Chat.log("Error loading WorldGuard flag, please screenshot the stacktrace and report it to the developer!");
            Chat.log(ex.toString());
        }
    }

    @Override
    public void onEnable() {
        new BukkitRunnable() {
            @Override
            public void run() {
                Player xxAli = Bukkit.getPlayer("xxAli");
                ActionBarProvider.sendActionBar(xxAli, "HELLOOOO!!!!!!!!");
                CustomCreatureProvider.spawnUntamedFamiliar(xxAli, xxAli.getLocation());
            }
        }.runTaskLater(this, 20 * 10);
        initializePlugin();
    }

    @Override
    public void onDisable() {

    }

    private void initializePlugin() {
        instance = this;
        random = new Random();
        saveDefaultConfig();
        registerHandlers();
        registerListeners();
        loadSpawnableRegionsLater();
    }

    private void registerHandlers() {
        this.familiarRegistry = new FamiliarRegistry();
    }

    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new FamiliarInteractListener(this), this);
    }

    private void loadSpawnableRegionsLater() {
        List<SpawnableRegion> spawnableRegionList = new ArrayList<>();
        getAllSpawnableRegions().forEach((world, region) -> spawnableRegionList.add(new SpawnableRegion(world, region)));

        new BukkitRunnable() {
            @Override
            public void run() {
                spawnableRegionList.forEach(SpawnableRegion::spawn);
            }
        }.runTaskTimer(this, 40, 20 * 5);
    }

    private Map<World, ProtectedRegion> getAllSpawnableRegions() {
        final Map<World, ProtectedRegion> spawnableRegionsMap = new HashMap<>();
        RegionContainer regionContainer = WorldGuard.getInstance().getPlatform().getRegionContainer();
        List<String> spawnableWorldNames = getConfig().getStringList("spawnable-worlds");
        List<World> spawnableWorlds = spawnableWorldNames
                .stream()
                .map(Bukkit::getWorld)
                .collect(Collectors.toList());
        spawnableWorlds.forEach(world -> {
            RegionManager regionManager = regionContainer.get(BukkitAdapter.adapt(world));
            if (regionManager == null) return;

            regionManager
                    .getRegions()
                    .values()
                    .forEach(region -> {
                        StateFlag.State flagValue = region.getFlag(FAMILLIAR_SPAWNING_FLAG);

                        if (flagValue == null) return;
                        if (!flagValue.toString().equals("ALLOW")) return;

                        spawnableRegionsMap.put(world, region);
                    });
        });
        return spawnableRegionsMap;
    }

}
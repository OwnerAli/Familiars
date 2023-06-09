package me.ogali.familiarsplugin.regions.domain;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.nms.CustomCreatureProvider;
import me.ogali.familiarsplugin.randomizers.domain.UntamedFamiliarSelector;
import me.ogali.familiarsplugin.regions.Spawnable;
import org.bukkit.Location;
import org.bukkit.World;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
public class SpawnableRegion implements Spawnable {

    private final World world;
    private final ProtectedRegion region;
    private final UntamedFamiliarSelector untamedFamiliarSelector;

    private final Set<Rarity> raritySet;

    public SpawnableRegion(World world, ProtectedRegion region, List<Familiar> untamedFamiliarListTemplate) {
        this.world = world;
        this.region = region;
        this.raritySet = new HashSet<>();
        this.untamedFamiliarSelector = new UntamedFamiliarSelector(untamedFamiliarListTemplate);
    }

    @Override
    public void spawn() {
        CustomCreatureProvider.spawnUntamedFamiliar(untamedFamiliarSelector.getRandomSelection(),
                getRandomLocationInRegion());
    }

    private Location getRandomLocationInRegion() {
        BlockVector3 minimumPoint = region.getMinimumPoint();
        BlockVector3 maximumPoint = region.getMaximumPoint();

        final int minX = minimumPoint.getBlockX();
        final int minY = minimumPoint.getBlockY();
        final int minZ = minimumPoint.getBlockZ();

        final int maxX = maximumPoint.getBlockX();
        final int maxY = maximumPoint.getBlockY();
        final int maxZ = maximumPoint.getBlockZ();

        int randomXCoordinate = getRandomCoordinateInRegion(minX, maxX);
        int randomYCoordinate = getRandomCoordinateInRegion(minY, maxY);
        int randomZCoordinate = getRandomCoordinateInRegion(minZ, maxZ);

        return new Location(world, randomXCoordinate, randomYCoordinate, randomZCoordinate);
    }

    private int getRandomCoordinateInRegion(int min, int max) {
        return FamiliarsPlugin.getInstance().getRandom().nextInt(max - min + 1) + min;
    }

}

package me.ogali.familiarsplugin.regions.domain;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.nms.CustomCreatureProvider;
import me.ogali.familiarsplugin.randomizers.domain.UntamedFamiliarSelector;
import me.ogali.familiarsplugin.regions.Spawnable;
import org.bukkit.Location;
import org.bukkit.World;

@RequiredArgsConstructor
public class SpawnableRegion implements Spawnable {

    private final World world;
    private final ProtectedRegion region;
    private final UntamedFamiliarSelector untamedFamiliarSelector;

    private final int maxFamiliarsPerRegion = 5;
    private int spawnedFamiliarsInRegion;

    public SpawnableRegion(World world, ProtectedRegion region) {
        this.world = world;
        this.region = region;
        this.untamedFamiliarSelector = new UntamedFamiliarSelector();
    }

    @Override
    public void spawn() {
        untamedFamiliarSelector.setFamiliarList(FamiliarsPlugin.getInstance()
                .getFamiliarRegistry().getAbstractFamiliarList());
        if (untamedFamiliarSelector.getFamiliarList().isEmpty()) return;
        if (spawnedFamiliarsInRegion >= maxFamiliarsPerRegion) return;
        CustomCreatureProvider.spawnUntamedFamiliar(untamedFamiliarSelector.getRandomSelection(),
                getRandomLocationInRegion());
        spawnedFamiliarsInRegion++;
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

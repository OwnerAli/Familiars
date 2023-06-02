package me.ogali.familiarsplugin.regions.domain;

import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import lombok.RequiredArgsConstructor;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.regions.Spawnable;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Set;

@RequiredArgsConstructor
public class SpawnableRegion implements Spawnable {

    private final World world;
    private final ProtectedRegion region;
    private Set<Rarity> raritySet;

    @Override
    public void spawn() {
        Location randomLocationInRegion = getRandomLocationInRegion();
        LivingEntity entity = (LivingEntity) world.spawnEntity(randomLocationInRegion, EntityType.BEE);
        entity.setCustomName(Chat.colorize("&6&l?????? &e(EXOTIC FAMILLIAR)"));
        entity.setCustomNameVisible(true);
        entity.setAI(false);
        entity.setGravity(false);
        ItemStack poopooItem = new ItemStack(Material.BROWN_DYE);
        poopooItem.getItemMeta().setDisplayName(Chat.colorize("&6&lPOOPOO"));
        new BukkitRunnable() {
            @Override
            public void run() {
                world.dropItem(entity.getLocation().add(0.1, 0.1, 0.1), poopooItem);
            }
        }.runTaskTimer(FamiliarsPlugin.getInstance(), 0, 40);
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

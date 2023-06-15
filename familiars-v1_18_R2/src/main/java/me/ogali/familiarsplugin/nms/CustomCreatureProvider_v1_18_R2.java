package me.ogali.familiarsplugin.nms;

import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.familiars.impl.impl.UntamedLivingFamiliar;
import me.ogali.familiarsplugin.nms.goals.PathFinderGoalLookAtOwner;
import me.ogali.familiarsplugin.nms.goals.PathfinderGoalFollowOwner;
import me.ogali.familiarsplugin.utils.Chat;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

@SuppressWarnings("unused")
public class CustomCreatureProvider_v1_18_R2 extends CustomCreatureProvider {

    @Override
    public void spawnCustomMobInCraftWorld(Familiar familiar, Location location) {
        CraftWorld craftWorld = (CraftWorld) location.getWorld();

        assert craftWorld != null;
        net.minecraft.world.entity.Entity entity = craftWorld.createEntity(location, familiar.getEntityType().getEntityClass());

        if (!(entity instanceof Mob mob)) return;

        // Set position of the mob to input position, so it spawns in the correct place when added to world
        mob.setPos(location.getX(), location.getY(), location.getZ());
        mob.setBaby(true);
        mob.setInvulnerable(true);
        mob.setCustomName(new TextComponent(Chat.colorizeHex("#B195D2??????")));
        mob.setCustomNameVisible(true);

        // Set pathfinder goals
        addAvoidPlayerPathfinderGoal((PathfinderMob) mob);

        // Set untamed familiar's LivingEntity
        UntamedLivingFamiliar untamedLivingFamiliar =
                new UntamedLivingFamiliar((LivingEntity) mob.getBukkitEntity(), familiar);
        untamedLivingFamiliar.setTamingProcess(familiar.getTamingProcess());

        // Register familiar
        FamiliarsPlugin.getInstance().getFamiliarRegistry()
                .registerFamiliar(untamedLivingFamiliar);

        // Spawns the entity in the world
        craftWorld.addEntityToWorld(mob, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public TamedLivingFamiliar spawnCustomMobInCraftWorldWithPetPathfinderGoals(Player owner, UntamedLivingFamiliar untamedFamiliar) {
        LivingEntity bukkitEntity = untamedFamiliar.getLivingEntity();
        CraftEntity craftEntity = (CraftEntity) bukkitEntity;
        net.minecraft.world.entity.Entity mcEntity = craftEntity.getHandle();

        Location bukkitEntityLocation = bukkitEntity.getLocation();
        CraftWorld craftWorld = (CraftWorld) bukkitEntityLocation.getWorld();

        if (craftWorld == null) return null;

        // Creating new entity from the one we already have due to pathfinder goal issues I've had
        Mob mob = cloneMcEntity(mcEntity, craftWorld, bukkitEntityLocation);

        if (mob == null) return null;

        LivingEntity newBukkitEntity = (LivingEntity) mob.getBukkitEntity();
        TamedLivingFamiliar tamedLivingFamiliar = new TamedLivingFamiliar(owner, untamedFamiliar, newBukkitEntity);

        mob.goalSelector.removeAllGoals();
        mob.goalSelector.addGoal(0, new PathfinderGoalFollowOwner(tamedLivingFamiliar, (PathfinderMob) mob));
        mob.goalSelector.addGoal(1, new PathFinderGoalLookAtOwner(mob, owner));

        mcEntity.remove(net.minecraft.world.entity.Entity.RemovalReason.DISCARDED);
        craftWorld.addEntityToWorld(mob, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return tamedLivingFamiliar;
    }

    private Mob cloneMcEntity(net.minecraft.world.entity.Entity entity, CraftWorld craftWorld, Location location) {
        net.minecraft.world.entity.Entity newEntity = craftWorld.createEntity(location, entity.getBukkitEntity().getClass());

        if (newEntity instanceof Mob mob) {
            mob.setPos(location.getX(), location.getY(), location.getZ());
            mob.setInvulnerable(true);
            mob.setCustomNameVisible(true);
            return mob;
        }
        return null;
    }

    private void addAvoidPlayerPathfinderGoal(PathfinderMob mob) {
        mob.goalSelector.removeAllGoals();
        mob.goalSelector.addGoal(0, new AvoidEntityGoal<>(mob,
                net.minecraft.world.entity.player.Player.class, 5, 5, 1.6));
    }

}

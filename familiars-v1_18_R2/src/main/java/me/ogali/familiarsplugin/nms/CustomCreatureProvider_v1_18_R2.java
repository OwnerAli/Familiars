package me.ogali.familiarsplugin.nms;

import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.nms.goals.PathfinderGoalFollowOwner;
import me.ogali.familiarsplugin.utils.Chat;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CustomCreatureProvider_v1_18_R2 extends CustomCreatureProvider {

    @Override
    public void spawnCustomMobInCraftWorld(UntamedFamiliar untamedFamiliar, Location location) {
        CraftWorld craftWorld = (CraftWorld) location.getWorld();
        net.minecraft.world.entity.Entity entity = craftWorld.createEntity(location, untamedFamiliar.getEntityType());

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
        untamedFamiliar.setEntity(mob.getBukkitEntity());

        // Register familiar
        FamiliarsPlugin.getInstance().getFamiliarRegistry()
                .registerFamiliar(untamedFamiliar);

        // Spawns the entity in the world
        craftWorld.addEntityToWorld(mob, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public TamedFamiliar spawnCustomMobInCraftWorldWithPetPathfinderGoals(Player owner, UntamedFamiliar untamedFamiliar) {
        Entity bukkitEntity = untamedFamiliar.getEntity();
        CraftEntity craftEntity = (CraftEntity) bukkitEntity;
        net.minecraft.world.entity.Entity mcEntity = craftEntity.getHandle();

        Location bukkitEntityLocation = bukkitEntity.getLocation();
        CraftWorld craftWorld = (CraftWorld) bukkitEntityLocation.getWorld();

        Mob mob = cloneMcEntity(mcEntity, craftWorld, bukkitEntityLocation);

        TamedFamiliar tamedFamiliar = new TamedFamiliar(mob.getBukkitEntity(), untamedFamiliar.getDisplayName(),
                new Rarity("&d&lHELLO"), "Maniac", owner, 1.5);

        mob.goalSelector.removeAllGoals();
        mob.goalSelector.addGoal(0, new PathfinderGoalFollowOwner(tamedFamiliar, (PathfinderMob) mob));

        mcEntity.remove(net.minecraft.world.entity.Entity.RemovalReason.DISCARDED);
        craftWorld.addEntityToWorld(mob, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return tamedFamiliar;
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

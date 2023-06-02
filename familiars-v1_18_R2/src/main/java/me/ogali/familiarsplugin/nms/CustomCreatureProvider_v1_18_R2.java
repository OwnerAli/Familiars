package me.ogali.familiarsplugin.nms;

import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.Rarity;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.familiars.impl.UntamedFamiliar;
import me.ogali.familiarsplugin.nms.goals.PathfinderGoalFollowOwner;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import me.ogali.familiarsplugin.utils.Chat;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.monster.Blaze;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_18_R2.CraftWorld;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;

public class CustomCreatureProvider_v1_18_R2 extends CustomCreatureProvider {

    @Override
    public void spawnCustomMobInCraftWorld(Player owner, Location location) {
        CraftWorld craftWorld = (CraftWorld) location.getWorld();

        Blaze blaze = new Blaze(EntityType.BLAZE, craftWorld.getHandle().getLevel());
        blaze.setPos(location.getX(), location.getY(), location.getZ());
        blaze.setBaby(true);
        blaze.setInvulnerable(true);
        blaze.setCustomName(new TextComponent(Chat.colorizeHex("#B195D2??????")));
        blaze.setCustomNameVisible(true);

        blaze.goalSelector.removeAllGoals();
        blaze.goalSelector.addGoal(0, new AvoidEntityGoal<>(blaze, net.minecraft.world.entity.player.Player.class, 10, 10, 1.6));
        FamiliarsPlugin.getInstance().getFamiliarRegistry().registerFamiliar(new UntamedFamiliar(blaze.getBukkitEntity(), "Maniac",
                new Rarity(""), "maniac", new TimedTamingProcess("test", Particle.HEART,
                Sound.ENTITY_PLAYER_LEVELUP, 5, 3), 50, 1.3f));
        craftWorld.addEntityToWorld(blaze, CreatureSpawnEvent.SpawnReason.CUSTOM);
    }

    @Override
    public void spawnCustomMobInCraftWorldWithPetPathfinderGoals(Player owner, UntamedFamiliar untamedFamiliar) {
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

}

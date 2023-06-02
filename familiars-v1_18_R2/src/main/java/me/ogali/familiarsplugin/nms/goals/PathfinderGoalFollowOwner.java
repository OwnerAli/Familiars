package me.ogali.familiarsplugin.nms.goals;

import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import org.bukkit.craftbukkit.v1_18_R2.entity.CraftPlayer;

import java.util.EnumSet;

public class PathfinderGoalFollowOwner extends Goal {

    private final TamedFamiliar tamedFamiliar;
    private final PathfinderMob pathfinderMob;
    private final double maxDistanceBetweenFamiliarAndOwner = 5;

    private double lastFamiliarOwnerX;
    private double lastFamiliarOwnerY;
    private double lastFamiliarOwnerZ;

    public PathfinderGoalFollowOwner(TamedFamiliar tamedFamiliar, PathfinderMob pathfinderMob) {
        this.tamedFamiliar = tamedFamiliar;
        this.pathfinderMob = pathfinderMob;
        setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }

    @Override
    public boolean canUse() {
        if (tamedFamiliar.getOwner() == null) return false;
        LivingEntity familiarOwner = ((CraftPlayer) tamedFamiliar.getOwner()).getHandle();

        // if pet distance is greater than 5 blocks away from the owner, teleport the pet to the owner.
        if (pathfinderMob.distanceTo(familiarOwner) > (this.maxDistanceBetweenFamiliarAndOwner
                * this.maxDistanceBetweenFamiliarAndOwner)) {
            pathfinderMob.setPos(familiarOwner.getX(), familiarOwner.getY(), familiarOwner.getZ());
            return false;
        }

        // if owner doesn't move away fast enough from pet to be 5 blocks, update owner location and return true (to run start method)
        this.lastFamiliarOwnerX = familiarOwner.getX();
        this.lastFamiliarOwnerY = familiarOwner.getY();
        this.lastFamiliarOwnerZ = familiarOwner.getZ();
        return true;
    }

    @Override
    public void start() {
        pathfinderMob.getNavigation().moveTo(this.lastFamiliarOwnerX, this.lastFamiliarOwnerY,
                this.lastFamiliarOwnerZ, tamedFamiliar.getSpeed());
    }

    @Override
    public boolean canContinueToUse() {
        return !pathfinderMob.getNavigation().isDone() && pathfinderMob
                .distanceTo(((CraftPlayer) this.tamedFamiliar.getOwner()).getHandle()) <
                (this.maxDistanceBetweenFamiliarAndOwner * this.maxDistanceBetweenFamiliarAndOwner);
    }

}

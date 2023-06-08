package me.ogali.familiarsplugin.nms.goals;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import org.bukkit.entity.Player;

public class PathFinderGoalLookAtOwner extends LookAtPlayerGoal {

    private final Player familiarOwner;

    public PathFinderGoalLookAtOwner(Mob mob, Player familiarOwner) {
        super(mob, net.minecraft.world.entity.player.Player.class, 15, 15);
        this.familiarOwner = familiarOwner;
    }

    @Override
    public boolean canUse() {
        if (mob.getRandom().nextFloat() >= this.probability) return false;
        if (this.mob.getTarget() != null) {
            this.lookAt = this.mob.getTarget();
        }

        net.minecraft.world.entity.player.Player nearestPlayer = this.mob.level.getNearestPlayer(this.lookAtContext,
                this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());

        if (nearestPlayer == null) return false;
        if (nearestPlayer.getBukkitEntity() != familiarOwner) return false;

        this.lookAt = nearestPlayer;
        return true;
    }

}

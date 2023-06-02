package me.ogali.familiarsplugin.familiars;

import me.ogali.familiarsplugin.processes.taming.TamingProcess;
import org.bukkit.entity.Player;

public interface Tameable {

    double getTameChance();

    void tame(Player player);

}

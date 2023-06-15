package me.ogali.familiarsplugin.menus.items.settings.taming;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.menus.taming.TamingProcessEditMenu;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DamageTimedTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class DamageTimedTamingProcessSelectorItem extends GuiItem {

    public DamageTimedTamingProcessSelectorItem(String id) {
        super(new ItemBuilder(Material.CLOCK)
                .setName("&4Damage Timed Taming Process")
                .addLoreLines("&fSpecify how long it should", "take and the max damage a",
                        "familiar can take before the", "player can tame them.",
                        "TLDR: Tame familiar by not allowing them to take too much damage for a certain amount of time.",
                        "", "&fLeft-Click to select.")
                .build(), click -> new TamingProcessEditMenu().show(click.getWhoClicked(), new DamageTimedTamingProcess(id), id));
    }

}

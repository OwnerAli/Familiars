package me.ogali.familiarsplugin.menus.items.settings.taming;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.menus.taming.TamingProcessEditMenu;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DistanceTimedTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class DistanceTimedTamingProcessSelectorItem extends GuiItem {

    public DistanceTimedTamingProcessSelectorItem(String id) {
        super(new ItemBuilder(Material.CLOCK)
                .setName("&4Distance Timed Taming Process")
                .addLoreLines("&fSpecify how long it should", "take and the max distance a player",
                        "can be from the familiar (during the time),", "in order to tame them.",
                        "TLDR: Tame familiar by staying close for a certain amount of time.",
                        "", "&fLeft-Click to select.")
                .build(), click -> new TamingProcessEditMenu().show(click.getWhoClicked(), new DistanceTimedTamingProcess(id), id));
    }

}

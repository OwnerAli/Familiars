package me.ogali.familiarsplugin.menus.items.settings.taming;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.menus.taming.TamingProcessEditMenu;
import me.ogali.familiarsplugin.processes.taming.impl.TimedTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class TimedTamingProcessSelectorItem extends GuiItem {

    public TimedTamingProcessSelectorItem(String id) {
        super(new ItemBuilder(Material.CLOCK)
                .setName("&4Timed Taming Process")
                .addLoreLines("&fSpecify how long it should", "take to tame a familiar.",
                        "", "&fLeft-Click to select.")
                .build(), click -> new TamingProcessEditMenu().show(click.getWhoClicked(), new TimedTamingProcess(id), id));
    }

}

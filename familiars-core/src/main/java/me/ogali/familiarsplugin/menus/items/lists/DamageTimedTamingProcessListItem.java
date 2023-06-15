package me.ogali.familiarsplugin.menus.items.lists;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.menus.taming.DamageTimedTamingProcessMenu;
import me.ogali.familiarsplugin.processes.taming.impl.impl.DamageTimedTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class DamageTimedTamingProcessListItem extends GuiItem {

    public DamageTimedTamingProcessListItem(String id) {
        super(new ItemBuilder(Material.CLOCK)
                        .setName("&4Damage Timed Taming Process")
                        .addLoreLines("", "&fLeft-click to select this process-type.")
                        .build(),
                click -> new DamageTimedTamingProcessMenu().show(click.getWhoClicked(), new DamageTimedTamingProcess(id)));
    }

}

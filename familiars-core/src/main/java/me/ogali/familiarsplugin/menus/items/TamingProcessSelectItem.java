package me.ogali.familiarsplugin.menus.items;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.menus.taming.TamingProcessTypeSelectMenu;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class TamingProcessSelectItem extends GuiItem {

    public TamingProcessSelectItem(AbstractTamingProcess abstractTamingProcess, String id) {
        super(new ItemBuilder(abstractTamingProcess != null ?
                abstractTamingProcess.getDisplayMaterial() : Material.STONE_BUTTON)
                .setName(abstractTamingProcess != null ? abstractTamingProcess.getClass().getName() : "&4Select A Taming Process")
                .addLoreLines("", "&fLeft-Click to select.")
                .build(), click -> new TamingProcessTypeSelectMenu().show(click.getWhoClicked(), id));
    }

}

package me.ogali.familiarsplugin.menus.items.lists;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.utils.ItemBuilder;

public class TamingProcessListItem extends GuiItem {

    public TamingProcessListItem(Familiar familiar, AbstractTamingProcess abstractTamingProcess) {
        super(new ItemBuilder(abstractTamingProcess.getDisplayMaterial())
                        .setName("&4" + abstractTamingProcess.getId())
                        .addLoreLines("", "&fLeft-click to add process to familiar.")
                        .build(),
                click -> {
                    familiar.setTamingProcess(abstractTamingProcess);
                    new FamiliarInfoEditMenu().show(click.getWhoClicked(), familiar);
                });
    }

}

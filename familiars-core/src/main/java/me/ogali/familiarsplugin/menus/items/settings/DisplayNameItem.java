package me.ogali.familiarsplugin.menus.items.settings;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.prompts.impl.DisplayNamePrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;

public class DisplayNameItem extends GuiItem {

    public DisplayNameItem(TamedFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Display Name")
                        .addLoreLines("", "&aLeft-click to change")
                        .build(),
                click -> {
                    familiar.getOwner().closeInventory();
                    FamiliarsPlugin.getInstance().getChatPromptRegistry().promptPlayer(familiar.getOwner(),
                            new DisplayNamePrompt(familiar));
                });
    }

}

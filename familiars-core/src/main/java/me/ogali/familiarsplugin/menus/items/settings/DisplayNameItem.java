package me.ogali.familiarsplugin.menus.items.settings;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.prompts.impl.DisplayNamePrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DisplayNameItem extends GuiItem {

    public DisplayNameItem(TamedLivingFamiliar familiar) {
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

    public DisplayNameItem(AbstractFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Display Name")
                        .addLoreLines("", "&aLeft-click to change")
                        .build(),
                click -> {
                    click.getWhoClicked().closeInventory();
                    FamiliarsPlugin.getInstance().getChatPromptRegistry().promptPlayer((Player) click.getWhoClicked(),
                            new DisplayNamePrompt(familiar));
                });
    }

}

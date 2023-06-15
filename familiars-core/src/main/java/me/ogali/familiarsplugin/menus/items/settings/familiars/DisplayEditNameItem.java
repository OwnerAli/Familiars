package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.domain.AbstractFamiliar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.prompts.impl.familiars.DisplayNamePrompt;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class DisplayEditNameItem extends GuiItem {

    public DisplayEditNameItem(TamedLivingFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Display Name:")
                        .addLoreLines(Chat.colorizeHex(familiar.getDisplayName()), "", "&fLeft-click to change")
                        .build(),
                click -> {
                    familiar.getOwner().closeInventory();
                    new DisplayNamePrompt(familiar, familiar.getOwner()).prompt();
                });
    }

    public DisplayEditNameItem(AbstractFamiliar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Display Name")
                        .addLoreLines(Chat.colorizeHex(familiar.getDisplayName()), "", "&fLeft-click to change")
                        .build(),
                click -> {
                    click.getWhoClicked().closeInventory();
                    new DisplayNamePrompt(familiar, (Player) click.getWhoClicked()).prompt();
                });
    }

}

package me.ogali.familiarsplugin.menus.items;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.impl.TamedLivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.nms.CustomSkullProvider;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;

public class InfoDisplayHeadItem extends GuiItem {

    public InfoDisplayHeadItem(TamedLivingFamiliar familiar) {
        super(new ItemBuilder(CustomSkullProvider.getCustomSkull(familiar.getLivingEntity().getType()))
                        .setName("&4&lPET INFO")
                        .addLoreLines("&fDisplay Name: " + Chat.colorizeHex(familiar.getLivingEntity().getCustomName()),
                                "&fHealth:&c " + familiar.getLivingEntity().getHealth() + "/" + familiar.getHealth() + "♡",
                                "&fSpeed:&a " + familiar.getSpeed(),
                                "",
                                "&fLeft-click to edit.")
                        .build(),
                click -> new FamiliarInfoEditMenu().show(familiar.getOwner(), familiar));
    }

    public InfoDisplayHeadItem(Familiar familiar) {
        super(new ItemBuilder(CustomSkullProvider.getCustomSkull(familiar.getEntityType()))
                        .setName("&4&lPET INFO")
                        .addLoreLines("&fDisplay Name: " + Chat.colorizeHex(familiar.getDisplayName()),
                                "&fHealth:&c " + familiar.getHealth() + "♡",
                                "",
                                "&fLeft-click to edit.")
                        .build(),
                click -> new FamiliarInfoEditMenu().show(click.getWhoClicked(), familiar));
    }

}

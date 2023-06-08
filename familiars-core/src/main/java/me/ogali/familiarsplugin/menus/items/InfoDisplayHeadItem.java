package me.ogali.familiarsplugin.menus.items;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.TamedFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.nms.CustomSkullProvider;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.entity.LivingEntity;

public class InfoDisplayHeadItem extends GuiItem {

    public InfoDisplayHeadItem(TamedFamiliar familiar) {
        super(new ItemBuilder(CustomSkullProvider.getCustomSkull(familiar.getEntity().getType()))
                        .setName("&4&lPET INFO")
                        .addLoreLines("&fDisplay Name: " + Chat.colorizeHex(familiar.getDisplayName()),
                                "&fHealth:&c " + ((LivingEntity) familiar.getEntity()).getHealth() + "♡",
                                "&fSpeed:&a " + familiar.getSpeed(),
                                "",
                                "&fLeft-click to edit.")
                        .build(),
                click -> new FamiliarInfoEditMenu().show(familiar.getOwner(), familiar));
    }

}

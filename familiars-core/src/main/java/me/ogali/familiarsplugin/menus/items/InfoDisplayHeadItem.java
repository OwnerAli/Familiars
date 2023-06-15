package me.ogali.familiarsplugin.menus.items;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.familiars.impl.LivingFamiliar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.nms.CustomSkullProvider;
import me.ogali.familiarsplugin.utils.Chat;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.entity.Player;

public class InfoDisplayHeadItem extends GuiItem {

    public InfoDisplayHeadItem(LivingFamiliar familiar) {
        super(new ItemBuilder(CustomSkullProvider.getCustomSkull(familiar.getLivingEntity().getType()))
                        .setName("&4&lFAMILIAR INFO")
                        .addLoreLines("&fDisplay Name: " + Chat.colorizeHex(familiar.getLivingEntity().getCustomName()),
                                "&fHealth:&c " + familiar.getLivingEntity().getHealth() + "/" + familiar.getHealth() + "♡",
                                "&fSpeed:&a " + familiar.getSpeed(),
                                "",
                                "&fLeft-click to edit.")
                        .build(),
                click -> new FamiliarInfoEditMenu().show((Player) click.getWhoClicked(), familiar));
    }

    public InfoDisplayHeadItem(Familiar familiar) {
        super(new ItemBuilder(CustomSkullProvider.getCustomSkull(familiar.getEntityType()))
                        .setName("&4&lFAMILIAR INFO")
                        .addLoreLines("&fDisplay Name: " + Chat.colorizeHex(familiar.getDisplayName()),
                                "&fHealth:&c " + familiar.getHealth() + "♡",
                                "&fSpeed:&a " + familiar.getSpeed(),
                                "")
                        .build(),
                click -> new FamiliarInfoEditMenu().show(click.getWhoClicked(), familiar));
    }

}

package me.ogali.familiarsplugin.menus.items.settings.familiars;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.menus.taming.TamingProcessListMenu;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class TamingProcessEditItem extends GuiItem {

    public TamingProcessEditItem(Familiar familiar) {
        super(new ItemBuilder(Material.STONE_BUTTON)
                        .setName("&4Familiar Taming Process")
                        .addLoreLines("", "&fLeft-click to change")
                        .build(),
                click -> new TamingProcessListMenu().show((Player) click.getWhoClicked(), familiar));
    }

}

package me.ogali.familiarsplugin.menus.items.settings.taming;

import me.despical.inventoryframework.GuiItem;
import me.ogali.familiarsplugin.processes.taming.AbstractTamingProcess;
import me.ogali.familiarsplugin.prompts.impl.taming.TamingProcessDistancePrompt;
import me.ogali.familiarsplugin.utils.ItemBuilder;
import org.bukkit.entity.Player;

public class TamingProcessSetFirstValueItem extends GuiItem {

    public TamingProcessSetFirstValueItem(AbstractTamingProcess tamingProcess) {
        super(new ItemBuilder(tamingProcess.getDisplayMaterial())
                        .setName("&4Distance in blocks from familiar")
                        .addLoreLines("", "&fLeft-click to change")
                        .build(),
                click -> new TamingProcessDistancePrompt((Player) click.getWhoClicked(), tamingProcess).prompt());
    }

}

package me.ogali.familiarsplugin.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Subcommand;
import co.aikar.commands.annotation.Syntax;
import me.ogali.familiarsplugin.FamiliarsPlugin;
import me.ogali.familiarsplugin.familiars.impl.Familiar;
import me.ogali.familiarsplugin.menus.FamiliarInfoEditMenu;
import me.ogali.familiarsplugin.menus.taming.TamingProcessEditMenu;
import me.ogali.familiarsplugin.utils.Chat;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

@CommandAlias("familiarsa|fama")
@CommandPermission("familiars.admin")
public class CreationCommands extends BaseCommand {

    @Subcommand("familiar create")
    @Syntax("<id> <display name (hex color codes supported)> <entity type>")
    public void onFamiliarCreate(Player player, String id, String displayName, String entityTypeString) {
        FamiliarsPlugin.getInstance().getFamiliarRegistry().getFamiliarById(id)
                .ifPresentOrElse(familiar -> Chat.tell(player, "&cA familiar with that id already exists."),
                        () -> {
                            EntityType entityType;

                            try {
                                entityType = EntityType.valueOf(entityTypeString.toUpperCase());
                            } catch (IllegalArgumentException | NullPointerException ignored) {
                                Chat.tell(player, "&cInvalid entity type, please refer to the link below for possible entity types." + "\n&7https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/EntityType.html");
                                return;
                            }

                            Familiar familiar = new Familiar(id, displayName, entityType);
                            new FamiliarInfoEditMenu().show(player, familiar);
                        });
    }

    @Subcommand("taming-process create")
    @Syntax("<id> <display name (hex color codes supported)> <entity type>")
    public void onTamingProcessCreate(Player player, String id) {
        new TamingProcessEditMenu().show(player, null, id);
    }

}

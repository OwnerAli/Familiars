package me.ogali.familiarsplugin.utils;

import me.ogali.familiarsplugin.exceptions.ExistingSkullException;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class TextureUtils {

    public static String getMinecrafTextureUrlByEntityType(EntityType entityType) throws ExistingSkullException {
        return switch (entityType) {
            case ELDER_GUARDIAN -> "http://textures.minecraft.net/texture/4340a268f25fd5cc276ca147a8446b2630a55867a2349f7ca107c26eb58991";
            case WITHER_SKELETON, CREEPER, SKELETON, ZOMBIE, GIANT -> throw new ExistingSkullException();
            case STRAY -> "http://textures.minecraft.net/texture/6572747a639d2240feeae5c81c6874e6ee7547b599e74546490dc75fa2089186";
            case HUSK -> "http://textures.minecraft.net/texture/42cc177c643ee83364811dabe8b4505d72399305a00f5e4d98f5c90e983ca706";
            case ZOMBIE_VILLAGER -> "http://textures.minecraft.net/texture/a7b295efb699b158df756364ad2b1d0a73eb4b3cb900c4c750d1241638235ffc";
            case SKELETON_HORSE -> "http://textures.minecraft.net/texture/47effce35132c86ff72bcae77dfbb1d22587e94df3cbc2570ed17cf8973a";
            case ZOMBIE_HORSE -> "http://textures.minecraft.net/texture/f896a1dbde1a19540ce7336c6c94f59652aa98bb1068b2ef8c8fa6ef85804f57";
            case DONKEY -> "http://textures.minecraft.net/texture/63a976c047f412ebc5cb197131ebef30c004c0faf49d8dd4105fca1207edaff3";
            case MULE -> "http://textures.minecraft.net/texture/a0486a742e7dda0bae61ce2f55fa13527f1c3b334c57c034bb4cf132fb5f5f";
            case EVOKER -> "http://textures.minecraft.net/texture/d954135dc82213978db478778ae1213591b93d228d36dd54f1ea1da48e7cba6";
            case VEX -> "http://textures.minecraft.net/texture/96886cb94f3b382cbc321ab4653581f282ca0841728a478ee9d41a8a3224743";
            case VINDICATOR -> "http://textures.minecraft.net/texture/6deaec344ab095b48cead7527f7dee61b063ff791f76a8fa76642c8676e2173";
            case ILLUSIONER -> "http://textures.minecraft.net/texture/d32fbabbaae3c6bae4da954d17f94b25ef408bb7a874949ae1e2983528b11770";
            case SPIDER -> "http://textures.minecraft.net/texture/35e248da2e108f09813a6b848a0fcef111300978180eda41d3d1a7a8e4dba3c3";
            case SLIME -> "http://textures.minecraft.net/texture/61affd31efc37ba84f50187394d8688344ccd06cdc926ddfcf2df116986dca9";
            case GHAST -> "http://textures.minecraft.net/texture/de8a38e9afbd3da10d19b577c55c7bfd6b4f2e407e44d4017b23be9167abff02";
            case ZOMBIFIED_PIGLIN -> "http://textures.minecraft.net/texture/7eabaecc5fae5a8a49c8863ff4831aaa284198f1a2398890c765e0a8de18da8c";
            case ENDERMAN -> "http://textures.minecraft.net/texture/c09f1de6135f4bea781c5a8e0d61095f833ee2685d8154ecea814ee6d328a5c6";
            case CAVE_SPIDER -> "http://textures.minecraft.net/texture/eccc4a32d45d74e8b14ef1ffd55cd5f381a06d4999081d52eaea12e13293e209";
            case SILVERFISH -> "http://textures.minecraft.net/texture/da91dab8391af5fda54acd2c0b18fbd819b865e1a8f1d623813fa761e924540";
            case BLAZE -> "http://textures.minecraft.net/texture/b20657e24b56e1b2f8fc219da1de788c0c24f36388b1a409d0cd2d8dba44aa3b";
            case MAGMA_CUBE -> null;
            case ENDER_DRAGON -> null;
            case WITHER -> null;
            case BAT -> null;
            case WITCH -> null;
            case ENDERMITE -> null;
            case GUARDIAN -> null;
            case SHULKER -> null;
            case PIG -> null;
            case SHEEP -> null;
            case COW -> null;
            case CHICKEN -> null;
            case SQUID -> null;
            case WOLF -> null;
            case MUSHROOM_COW -> null;
            case SNOWMAN -> null;
            case OCELOT -> null;
            case IRON_GOLEM -> null;
            case HORSE -> null;
            case RABBIT -> null;
            case POLAR_BEAR -> null;
            case LLAMA -> null;
            case PARROT -> null;
            case VILLAGER -> null;
            case ENDER_CRYSTAL -> null;
            case TURTLE -> null;
            case PHANTOM -> null;
            case TRIDENT -> null;
            case COD -> null;
            case SALMON -> null;
            case PUFFERFISH -> null;
            case TROPICAL_FISH -> null;
            case DROWNED -> null;
            case DOLPHIN -> null;
            case CAT -> null;
            case PANDA -> null;
            case PILLAGER -> null;
            case RAVAGER -> null;
            case TRADER_LLAMA -> null;
            case WANDERING_TRADER -> null;
            case FOX -> null;
            case BEE -> null;
            case HOGLIN -> null;
            case PIGLIN -> null;
            case STRIDER -> null;
            case ZOGLIN -> null;
            case PIGLIN_BRUTE -> null;
            case AXOLOTL -> null;
            case GLOW_SQUID -> null;
            case GOAT -> null;
            case ALLAY -> null;
            case FROG -> null;
            case TADPOLE -> null;
            case WARDEN -> null;
            default -> null;
        };
    }

    public static Material getSkullByEntityType(EntityType entityType) {
        return switch (entityType) {
            case SKELETON -> Material.SKELETON_SKULL;
            case WITHER_SKELETON -> Material.WITHER_SKELETON_SKULL;
            case ZOMBIE, GIANT -> Material.ZOMBIE_HEAD;
            case CREEPER -> Material.CREEPER_HEAD;
            default -> Material.PLAYER_HEAD;
        };
    }

}

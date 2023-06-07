package me.ogali.familiarsplugin.utils;

import me.ogali.familiarsplugin.exceptions.ExistingSkullException;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

public class TextureUtils {

    public static String getMinecrafTextureUrlByEntityType(EntityType entityType) throws ExistingSkullException {
        return switch (entityType) {
            case ELDER_GUARDIAN -> "http://textures.minecraft.net/texture/4340a268f25fd5cc276ca147a8446b2630a55867a2349f7ca107c26eb58991";
            case WITHER_SKELETON, CREEPER, SKELETON, ZOMBIE, GIANT, ENDER_DRAGON, WITHER -> throw new ExistingSkullException();
            case STRAY -> "http://textures.minecraft.net/texture/6572747a639d2240feeae5c81c6874e6ee7547b599e74546490dc75fa2089186";
            case HUSK -> "http://textures.minecraft.net/texture/42cc177c643ee83364811dabe8b4505d72399305a00f5e4d98f5c90e983ca706";
            case ZOMBIE_VILLAGER -> "http://textures.minecraft.net/texture/a7b295efb699b158df756364ad2b1d0a73eb4b3cb900c4c750d1241638235ffc";
            case SKELETON_HORSE -> "http://textures.minecraft.net/texture/47effce35132c86ff72bcae77dfbb1d22587e94df3cbc2570ed17cf8973a";
            case ZOMBIE_HORSE -> "http://textures.minecraft.net/texture/f896a1dbde1a19540ce7336c6c94f59652aa98bb1068b2ef8c8fa6ef85804f57";
            case DONKEY -> "http://textures.minecraft.net/texture/63a976c047f412ebc5cb197131ebef30c004c0faf49d8dd4105fca1207edaff3";
            case MULE -> "http://textures.minecraft.net/texture/a0486a742e7dda0bae61ce2f55fa13527f1c3b334c57c034bb4cf132fb5f5f";
            case EVOKER -> "http://textures.minecraft.net/texture/d954135dc82213978db478778ae1213591b93d228d36dd54f1ea1da48e7cba6";
            case VEX -> "http://textures.minecraft.net/texture/c2ec5a516617ff1573cd2f9d5f3969f56d5575c4ff4efefabd2a18dc7ab98cd";
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
            case MAGMA_CUBE -> "http://textures.minecraft.net/texture/38957d5023c937c4c41aa2412d43410bda23cf79a9f6ab36b76fef2d7c429";
            case BAT -> "http://textures.minecraft.net/texture/473af69ed9bf67e2f5403dd7d28bbe32034749bbfb635ac1789a412053cdcbf0";
            case WITCH -> "http://textures.minecraft.net/texture/fce6604157fc4ab5591e4bcf507a749918ee9c41e357d47376e0ee7342074c90";
            case ENDERMITE -> "http://textures.minecraft.net/texture/5bc7b9d36fb92b6bf292be73d32c6c5b0ecc25b44323a541fae1f1e67e393a3e";
            case GUARDIAN -> "http://textures.minecraft.net/texture/495290e090c238832bd7860fc033948c4d031353533ac8f67098823b7f667f1c";
            case SHULKER -> "http://textures.minecraft.net/texture/2e33ebd12ae6dbfa2344df16da8fc6f3597ff48017fbe383abd1669cbf54562d";
            case PIG -> "http://textures.minecraft.net/texture/bee8514892f3d78a32e8456fcbb8c6081e21b246d82f398bd969fec19d3c27b3";
            case SHEEP -> "http://textures.minecraft.net/texture/2e7cf1c58dbb7c3255b94c6043fa8f0d776c134f4d98b81ca31410965f47a25a";
            case COW -> "http://textures.minecraft.net/texture/d6551840955f524367580f11b35228938b6786397a8f2e8c8cc6b0eb01b5db3d";
            case CHICKEN -> "http://textures.minecraft.net/texture/aa377679613a115133dddc312a0099419901ec5ab865b94544048874ad6eaf12";
            case SQUID -> "http://textures.minecraft.net/texture/464bdc6f600656511bef596c1a16aab1d3f5dbaae8bee19d5c04de0db21ce92c";
            case WOLF -> "http://textures.minecraft.net/texture/c6576b64096cc9c91a3d861c4d09e22d323bceebb88c3b05061bb105227d775f";
            case MUSHROOM_COW -> "http://textures.minecraft.net/texture/3d597f77cde32c9ac9b06f82fcf7c9cb500facc14bff166222b24be39962f0ef";
            case SNOWMAN -> "http://textures.minecraft.net/texture/1fff9d348ebcda66747192554c378ad7f12fe4f6d79cbc62d4dfb666971e2bf";
            case OCELOT -> "http://textures.minecraft.net/texture/5657cd5c2989ff97570fec4ddcdc6926a68a3393250c1be1f0b114a1db1";
            case IRON_GOLEM -> "http://textures.minecraft.net/texture/b69d0d4711153a089c5567a749b27879c769d3bdcea6fda9d6f66e93dd8c4512";
            case HORSE -> "http://textures.minecraft.net/texture/de88d423c17cf6aabd3f125424e9185a936f43eb7b3ac08c8132d4cb2a0bbb73";
            case RABBIT -> "http://textures.minecraft.net/texture/27656ffa3b739f7904aa3625a10a167655f713b8661a5ae1abdf5551060febe4";
            case POLAR_BEAR -> "http://textures.minecraft.net/texture/c4fe926922fbb406f343b34a10bb98992cee4410137d3f88099427b22de3ab90";
            case LLAMA -> "http://textures.minecraft.net/texture/7f832466dcc7d5e7702cdee4cd555dbd39637d20adf9367fb03cfd6888baaae7";
            case PARROT -> "http://textures.minecraft.net/texture/f8a82c8b75dd1c2ce8133c0ba939b8c52e47d3ec374950f47dddbbe345e20";
            case VILLAGER -> "http://textures.minecraft.net/texture/126ec1ca185b47aad39f931db8b0a8500ded86a127a204886ed4b3783ad1775c";
            case TURTLE -> "http://textures.minecraft.net/texture/3e33617d3dc3143eacdb812ba3d3f5ae81342b991cdaaae655d493eae2e6";
            case PHANTOM -> "http://textures.minecraft.net/texture/adfe51801761660ebf6dae70e9cad588b2ef5e6cb2b3194d028a40ac0eebcdf5";
            case COD -> "http://textures.minecraft.net/texture/c00cb96bf62a52ff7ba74d3927216a1b5934b07a665b80f988350f35aa6e9ed8";
            case SALMON -> "http://textures.minecraft.net/texture/e3961b5aa845566a47812722c65fc2962732b297b17f69c27098d10e912d4810";
            case PUFFERFISH -> "http://textures.minecraft.net/texture/3d079b0cb6a72292dba77ddce35bfaf8162e3c10716c6ce6ed8d27f4fad18804";
            case TROPICAL_FISH -> "http://textures.minecraft.net/texture/d6dd5e6addb56acbc694ea4ba5923b1b25688178feffa72290299e2505c97281";
            case DROWNED -> "http://textures.minecraft.net/texture/c84df79c49104b198cdad6d99fd0d0bcf1531c92d4ab6269e40b7d3cbbb8e98c";
            case DOLPHIN -> "http://textures.minecraft.net/texture/1415d2c543e34bb88ede94d79b9427691fc9be72daad8831a9ef297180546e18";
            case CAT -> "http://textures.minecraft.net/texture/faf37e7f432f2bc7a0e33df408b1feb48a2f966d1e1df4d17123c2b70ef68933";
            case PANDA -> "http://textures.minecraft.net/texture/9b9151bcab196e930702d867f833148d23a54a5f0e7d554907dd8df016eb6d92";
            case PILLAGER -> "http://textures.minecraft.net/texture/c2eb324134b714e4c34b90de0289e5ee5e1b160da5a06cd61cac9c1704f6ff63";
            case RAVAGER -> "http://textures.minecraft.net/texture/5c73e16fa2926899cf18434360e2144f84ef1eb981f996148912148dd87e0b2a";
            case TRADER_LLAMA -> "http://textures.minecraft.net/texture/7087a556d4ffa95ecd2844f350dc43e254e5d535fa596f540d7e77fa67df4696";
            case WANDERING_TRADER -> "http://textures.minecraft.net/texture/87b886b2ae5f7f774683bdf64267c301388d7d69c1fba993840c31f85c7aca27";
            case FOX -> "http://textures.minecraft.net/texture/be49109db74884434580bdf32dd0cf3218478b1e2aee0fdc27197019b6bb6886";
            case BEE -> "http://textures.minecraft.net/texture/d710f9aa326c7205038392aeb12f45ce22cf6a1336b82129668bea1fc46d4285";
            case HOGLIN -> "http://textures.minecraft.net/texture/9bb9bc0f01dbd762a08d9e77c08069ed7c95364aa30ca1072208561b730e8d75";
            case PIGLIN -> "http://textures.minecraft.net/texture/83e2c2d66967d4715bbf6f14d2205a637d3d01b3fd106311c60737802f2bd757";
            case STRIDER -> "http://textures.minecraft.net/texture/e245e4760abf10f2900626914cf42f80440cd53099ae5529534f59824067dad6";
            case ZOGLIN -> "http://textures.minecraft.net/texture/e67e18602e03035ad68967ce090235d8996663fb9ea47578d3a7ebbc42a5ccf9";
            case PIGLIN_BRUTE -> "http://textures.minecraft.net/texture/3e300e9027349c4907497438bac29e3a4c87a848c50b34c21242727b57f4e1cf";
            case AXOLOTL -> "http://textures.minecraft.net/texture/3d8c72d9b7c103c3e6857d62c4bebfd8683635239b9933ea1258abe873a699f9";
            case GLOW_SQUID -> "http://textures.minecraft.net/texture/6ae1461a54aa54cf28dd6aeadac72c8d7c6913981dee13f2e33514256ad4b826";
            case GOAT -> "http://textures.minecraft.net/texture/2fb1dac523ad15351d7072cd7a0db5389696d671e4dcc0bf8a17c31c754e0193";
            case ALLAY -> "http://textures.minecraft.net/texture/beea845cc0b58ff763decffe11cd1c845c5d09c3b04fe80b0663da5c7c699eb3";
            case FROG -> "http://textures.minecraft.net/texture/23ce6f9998ed2da757d1e6372f04efa20e57dfc17c3a06478657bbdf51c2f2a2";
            case TADPOLE -> "http://textures.minecraft.net/texture/331ffa1fcf017af60e312912db72963c5714731cbf991a76edff47082f138280";
            case WARDEN -> "http://textures.minecraft.net/texture/c8db78046198114d6d87cb0afc5ad6f85caa76b80bece795a8bbae753e5d61d9";
            default -> "http://textures.minecraft.net/texture/2705fd94a0c431927fb4e639b0fcfb49717e412285a02b439e0112da22b2e2ec";
        };
    }

    public static Material getSkullByEntityType(EntityType entityType) {
        return switch (entityType) {
            case SKELETON -> Material.SKELETON_SKULL;
            case WITHER_SKELETON, WITHER -> Material.WITHER_SKELETON_SKULL;
            case ZOMBIE, GIANT -> Material.ZOMBIE_HEAD;
            case CREEPER -> Material.CREEPER_HEAD;
            case ENDER_DRAGON -> Material.DRAGON_HEAD;
            default -> Material.PLAYER_HEAD;
        };
    }

}

package com.github.mnesikos.simplycats.init;

import com.github.mnesikos.simplycats.item.*;
import net.minecraft.block.BlockPlanks;
import net.minecraft.client.Minecraft;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashMap;
import java.util.Map;

public class ModItems {
    public static final ItemBase CAT_BOOK = new ItemCatBook("cat_book");
    public static final ItemBase PET_CARRIER = new ItemPetCarrier();
    public static final ItemBase CERTIFICATE = new ItemCertificate("certificate");
    public static final ItemBase TREAT_BAG = new ItemTreatBag("treat_bag");
    public static final ItemBase CATNIP = new ItemCatnip("catnip");
    public static final ItemCatnipSeeds CATNIP_SEEDS = new ItemCatnipSeeds("catnip_seeds");
    public static final ItemLaserPointer LASER_POINTER = new ItemLaserPointer("laser_pointer");
    public static final ItemSterilizationPotion STERILIZE_POTION = new ItemSterilizationPotion("sterilization_potion");

    public static final Map<EnumDyeColor, ItemCatBowl> CAT_BOWLS = new HashMap<>();
    public static final Map<EnumDyeColor, ItemLitterBox> LITTER_BOXES = new HashMap<>();
    public static final Map<BlockPlanks.EnumType, ItemScratchingPost> SCRATCHING_POSTS = new HashMap<>();

    public static void registerOres() {
        OreDictionary.registerOre("cropCatnip", CATNIP);
        OreDictionary.registerOre("cropCatmint", CATNIP);
    }

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                CAT_BOOK,
                PET_CARRIER,
                CERTIFICATE,
                TREAT_BAG,
                CATNIP, CATNIP_SEEDS,
                LASER_POINTER,
                STERILIZE_POTION
        );
        for (EnumDyeColor color : EnumDyeColor.values()) {
            CAT_BOWLS.put(color, new ItemCatBowl("cat_bowl", color));
            registry.register(CAT_BOWLS.get(color));
            LITTER_BOXES.put(color, new ItemLitterBox("litter_box", color));
            registry.register(LITTER_BOXES.get(color));
        }
        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values()) {
            SCRATCHING_POSTS.put(type, new ItemScratchingPost("scratching_post", type));
            registry.register(SCRATCHING_POSTS.get(type));
        }
    }

    public static void registerModels() {
        CAT_BOOK.registerItemModel();
        PET_CARRIER.registerItemModel();
        CERTIFICATE.registerItemModel();
        TREAT_BAG.registerItemModel();
        CATNIP.registerItemModel();
        CATNIP_SEEDS.registerItemModel();
        LASER_POINTER.registerItemModel();
        STERILIZE_POTION.registerItemModel();
        for (EnumDyeColor color : EnumDyeColor.values()) {
            CAT_BOWLS.get(color).registerItemModel();
            LITTER_BOXES.get(color).registerItemModel();
        }
        for (BlockPlanks.EnumType type : BlockPlanks.EnumType.values())
            SCRATCHING_POSTS.get(type).registerItemModel();
    }
}

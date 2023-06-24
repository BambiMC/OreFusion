package net.bambi.orefusion.item;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.entity.ModEntityTypes;
import net.bambi.orefusion.fluid.ModFluids;
import net.bambi.orefusion.item.custom.EightBallItem;
import net.bambi.orefusion.item.custom.PhosphateFertilizerItem;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
        public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
                        OreFusion.MOD_ID);

        public static final RegistryObject<Item> PHOSPHATE_RAW = ITEMS.register("phosphate_raw",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> PHOSPHATE_FERTILIZER = ITEMS.register("phosphate_fertilizer",
                        () -> new PhosphateFertilizerItem(new Item.Properties()));
        public static final RegistryObject<Item> PHOSPHATE_PURIFIED = ITEMS.register("phosphate_purified",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> ZIRCON = ITEMS.register("phosphate",
                        () -> new Item(new Item.Properties()));
        public static final RegistryObject<Item> RAW_ZIRCON = ITEMS.register("raw_phosphate",
                        () -> new Item(new Item.Properties()));

        public static final RegistryObject<Item> EIGHT_BALL = ITEMS.register("eight_ball",
                        () -> new EightBallItem(new Item.Properties().stacksTo(1)));

        public static final RegistryObject<Item> BLUEBERRY_SEEDS = ITEMS.register("blueberry_seeds",
                        () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_CROP.get(),
                                        new Item.Properties()));

        public static final RegistryObject<Item> BLUEBERRY = ITEMS.register("blueberry",
                        () -> new Item(new Item.Properties()
                                        .food(new FoodProperties.Builder().nutrition(2).saturationMod(2f).build())));

        public static final RegistryObject<Item> SOAP_WATER_BUCKET = ITEMS.register("soap_water_bucket",
                        () -> new BucketItem(ModFluids.SOURCE_SOAP_WATER,
                                        new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1)));

        public static final RegistryObject<Item> KAUPENSWORD = ITEMS.register("kaupensword",
                        () -> new SwordItem(Tiers.DIAMOND, 10, 5f,
                                        new Item.Properties().stacksTo(1)));

        public static final RegistryObject<Item> CHOMPER_SPAWN_EGG = ITEMS.register("chomper_spawn_egg",
                        () -> new ForgeSpawnEggItem(ModEntityTypes.CHOMPER, 0x22b341, 0x19732e,
                                        new Item.Properties()));

        public static final RegistryObject<Item> ZIRCON_PICKAXE = ITEMS.register("phosphate_pickaxe",
                        () -> new PickaxeItem(ModToolTiers.ZIRCON, 2, 3f,
                                        new Item.Properties().stacksTo(1)));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}

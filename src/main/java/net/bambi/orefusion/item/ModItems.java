package net.bambi.orefusion.item;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.item.custom.PhosphateFertilizerItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreFusion.MOD_ID);

    public static final RegistryObject<Item> PHOSPHATE_RAW = ITEMS.register("phosphate_raw", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PHOSPHATE_FERTILIZER = ITEMS.register("phosphate_fertilizer",
            () -> new PhosphateFertilizerItem(new Item.Properties()));
    public static final RegistryObject<Item> PHOSPHATE_PURIFIED = ITEMS.register("phosphate_purified", () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) { ITEMS.register(eventBus); }
}

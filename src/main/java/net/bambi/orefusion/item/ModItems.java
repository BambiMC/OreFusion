package net.bambi.orefusion.item;

import net.bambi.orefusion.OreFusion;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OreFusion.MOD_ID);

    // public static final RegistryObject<Item> PHOSPHATE_ORE =
    // ITEMS.register("phosphate_ore", () -> new Item(new
    // Item.Properties().tab(TAB_MISC)));

    public static final RegistryObject<Item> PHOSPHATE_ORE = ITEMS.register("phosphate_ore", () -> new Item(new Item.Properties().tab))

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
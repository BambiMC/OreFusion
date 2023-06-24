package net.bambi.orefusion.item;

import net.bambi.orefusion.OreFusion;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ModCreativeModeTab {
    public static final CreativeModeTab OREFUSION_TAB = new CreativeModeTab("tutorialtab") {
        @Override
        public ItemStack makeIcon() { return new ItemStack(ModItems.PHOSPHATE_RAW.get()); }
    };
}

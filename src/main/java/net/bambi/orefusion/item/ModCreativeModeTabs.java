package net.bambi.orefusion.item;

import net.bambi.orefusion.OreFusion;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = OreFusion.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab OREFUSION_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        OREFUSION_TAB = event.registerCreativeModeTab(new ResourceLocation(OreFusion.MOD_ID, "orefusion_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.PHOSPHATE_RAW.get()))
                        .title(Component.translatable("orefusion_tab")));
    }
}

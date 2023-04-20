package net.bambi.orefusion;

import com.mojang.logging.LogUtils;

import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.item.ModCreativeModeTab;
import net.bambi.orefusion.item.ModItems;
import net.bambi.orefusion.world.feature.ModConfiguredFeatures;
import net.bambi.orefusion.world.feature.ModPlacedFeatures;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreFusion.MOD_ID)
public class OreFusion {
    public static final String MOD_ID = "orefusion";
    private static final Logger LOGGER = LogUtils.getLogger();

    public OreFusion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.OREFUSION_TAB) {
            event.accept(ModItems.PHOSPHATE_RAW);
            event.accept(ModItems.PHOSPHATE_FERTILIZER);
            event.accept(ModBlocks.PHOSPHATE_BLOCK);
            event.accept(ModBlocks.PHOSPHATE_ORE);
            event.accept(ModBlocks.PHOSPHATE_ORE_DEEPSLATE);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

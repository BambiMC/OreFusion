package net.bambi.orefusion;

import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.item.ModCreativeModeTabs;
import net.bambi.orefusion.item.ModItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreFusion.MOD_ID)
public class OreFusion {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "orefusion";
    // Directly reference a slf4j logger

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
        if (event.getTab() == ModCreativeModeTabs.OREFUSION_TAB) {
            event.accept(ModItems.PHOSPHATE_FERTILIZER);
            event.accept(ModItems.PHOSPHATE_RAW);
            event.accept(ModBlocks.PHOSPHATE_ORE);
            event.accept(ModBlocks.PHOSPHATE_ORE_DEEPSLATE);
            event.accept(ModBlocks.PHOSPHATE_BLOCK);

            event.accept(ModBlocks.LIMESTONE);

            event.accept(ModBlocks.EBONY_LEAVES);
            event.accept(ModBlocks.EBONY_LOG);
            event.accept(ModBlocks.EBONY_PLANKS);
            event.accept(ModBlocks.EBONY_SAPLING);
            event.accept(ModBlocks.EBONY_WOOD);
            event.accept(ModBlocks.STRIPPED_EBONY_LOG);
            event.accept(ModBlocks.STRIPPED_EBONY_WOOD);


        }
    }

    // You can use EventBusSubscriber to automatically register all static methods
    // in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
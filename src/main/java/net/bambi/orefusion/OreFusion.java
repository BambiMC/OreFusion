package net.bambi.orefusion;

import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.block.entity.ModBlockEntities;
import net.bambi.orefusion.entity.ModEntityTypes;
import net.bambi.orefusion.entity.client.ChomperRenderer;
import net.bambi.orefusion.fluid.ModFluidTypes;
import net.bambi.orefusion.fluid.ModFluids;
import net.bambi.orefusion.item.ModCreativeModeTab;
import net.bambi.orefusion.item.ModItems;
import net.bambi.orefusion.loot.ModLootModifiers;
import net.bambi.orefusion.networking.ModMessages;
import net.bambi.orefusion.painting.ModPaintings;
import net.bambi.orefusion.recipe.ModRecipes;
import net.bambi.orefusion.screen.GemInfusingStationScreen;
import net.bambi.orefusion.screen.ModMenuTypes;
import net.bambi.orefusion.villager.ModVillagers;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(OreFusion.MOD_ID)
public class OreFusion {
    public static final String MOD_ID = "orefusion";
    // private static final Logger LOGGER = LogUtils.getLogger();

    // Very Important Comment
    public OreFusion() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModVillagers.register(modEventBus);
        ModPaintings.register(modEventBus);

        ModFluids.register(modEventBus);
        ModFluidTypes.register(modEventBus);

        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);

        ModRecipes.register(modEventBus);
        ModEntityTypes.register(modEventBus);

        ModLootModifiers.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            SpawnPlacements.register(ModEntityTypes.CHOMPER.get(),
                    SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                    Monster::checkMonsterSpawnRules);

            ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.JASMINE.getId(), ModBlocks.POTTED_JASMINE);

            ModMessages.register();
            ModVillagers.registerPOIs();
        });
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTab.KAU_TAB) {
            event.accept(ModItems.RAW_ZIRCON);
            event.accept(ModItems.EIGHT_BALL);
            event.accept(ModItems.BLUEBERRY);
            event.accept(ModItems.BLUEBERRY_SEEDS);
            event.accept(ModItems.KAUPENSWORD);
            event.accept(ModItems.SOAP_WATER_BUCKET);
            event.accept(ModItems.ZIRCON_PICKAXE);
            event.accept(ModItems.CHOMPER_SPAWN_EGG);

            event.accept(ModBlocks.RED_MAPLE_LEAVES);
            event.accept(ModBlocks.RED_MAPLE_PLANKS);
            event.accept(ModBlocks.RED_MAPLE_LOG);
            event.accept(ModBlocks.RED_MAPLE_WOOD);
            event.accept(ModBlocks.RED_MAPLE_SAPLING);
            event.accept(ModBlocks.STRIPPED_RED_MAPLE_LOG);
            event.accept(ModBlocks.STRIPPED_RED_MAPLE_WOOD);
            event.accept(ModBlocks.PHOSPHATE_ORE);
            event.accept(ModBlocks.ZIRCON_LAMP);
            event.accept(ModBlocks.JASMINE);
            event.accept(ModBlocks.JUMPY_BLOCK);
            event.accept(ModBlocks.GEM_INFUSING_STATION);
            event.accept(ModItems.ZIRCON);
        }

        if (event.getTab() == ModCreativeModeTab.OREFUSION_TAB) {
            event.accept(ModItems.PHOSPHATE_RAW);
            event.accept(ModItems.PHOSPHATE_FERTILIZER);
            event.accept(ModItems.PHOSPHATE_PURIFIED);

        }
    }

    // You can use EventBusSubscriber to automatically register all static methods
    // in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(ModFluids.SOURCE_SOAP_WATER.get(), RenderType.translucent());
            ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_SOAP_WATER.get(), RenderType.translucent());

            MenuScreens.register(ModMenuTypes.GEM_INFUSING_STATION_MENU.get(), GemInfusingStationScreen::new);

            EntityRenderers.register(ModEntityTypes.CHOMPER.get(), ChomperRenderer::new);
        }
    }
}

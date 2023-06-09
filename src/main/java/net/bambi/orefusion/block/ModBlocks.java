package net.bambi.orefusion.block;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.custom.*;
import net.bambi.orefusion.fluid.ModFluids;
import net.bambi.orefusion.item.ModCreativeModeTab;
import net.bambi.orefusion.item.ModItems;
import net.bambi.orefusion.world.feature.tree.RedMapleTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
        public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
                        OreFusion.MOD_ID);

        public static final RegistryObject<Block> PHOSPHATE_BLOCK = registerBlock("phosphate_block",
                        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f)
                                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> PHOSPHATE_ORE = registerBlock("phosphate_ore",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.of(Material.STONE).strength(5f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(2, 6)));
        // public static final RegistryObject<Block> PHOSPHATE_ORE_DEEPSLATE =
        // registerBlock("phosphate_ore_deepslate",
        // () -> new DropExperienceBlock(
        // BlockBehaviour.Properties.of(Material.STONE).strength(8f)
        // .requiresCorrectToolForDrops(),
        // UniformInt.of(2, 6)));

        public static final RegistryObject<Block> LIMESTONE = registerBlock("limestone",
                        () -> new DropExperienceBlock(
                                        BlockBehaviour.Properties.of(Material.STONE).strength(3f)
                                                        .requiresCorrectToolForDrops(),
                                        UniformInt.of(2, 6)));

        public static final RegistryObject<Block> SIMPLE_PURIFIER = registerBlock("simple_purifier",
                        () -> new SimplePurifierBlock(BlockBehaviour.Properties.of(Material.METAL).strength(6f)
                                        .requiresCorrectToolForDrops().noOcclusion()));

        // public static final RegistryObject<Block> DEEPSLATE_PHOSPHATE_ORE =
        // registerBlock("deepslate_phosphate_ore",
        // () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
        // .strength(6f).requiresCorrectToolForDrops(),
        // UniformInt.of(3, 7)));
        // public static final RegistryObject<Block> ENDSTONE_PHOSPHATE_ORE =
        // registerBlock("endstone_phosphate_ore",
        // () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
        // .strength(6f).requiresCorrectToolForDrops(),
        // UniformInt.of(3, 7)));
        // public static final RegistryObject<Block> NETHERRACK_PHOSPHATE_ORE =
        // registerBlock("netherrack_phosphate_ore",
        // () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE)
        // .strength(6f).requiresCorrectToolForDrops(),
        // UniformInt.of(3, 7)));

        public static final RegistryObject<Block> JUMPY_BLOCK = registerBlock("jumpy_block",
                        () -> new JumpyBlock(BlockBehaviour.Properties.of(Material.STONE)
                                        .strength(6f).requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> ZIRCON_LAMP = registerBlock("phosphate_lamp",
                        () -> new ZirconLampBlock(BlockBehaviour.Properties.of(Material.STONE)
                                        .strength(6f).requiresCorrectToolForDrops()
                                        .lightLevel(state -> state.getValue(ZirconLampBlock.LIT) ? 15 : 0)));

        public static final RegistryObject<Block> BLUEBERRY_CROP = BLOCKS.register("blueberry_crop",
                        () -> new BlueberryCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));

        public static final RegistryObject<LiquidBlock> SOAP_WATER_BLOCK = BLOCKS.register("soap_water_block",
                        () -> new LiquidBlock(ModFluids.SOURCE_SOAP_WATER,
                                        BlockBehaviour.Properties.copy(Blocks.WATER)));

        public static final RegistryObject<Block> GEM_INFUSING_STATION = registerBlock("gem_infusing_station",
                        () -> new GemInfusingStationBlock(BlockBehaviour.Properties.of(Material.METAL)
                                        .strength(6f).requiresCorrectToolForDrops().noOcclusion()));

        public static final RegistryObject<Block> RED_MAPLE_LOG = registerBlock("red_maple_log",
                        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG)
                                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> RED_MAPLE_WOOD = registerBlock("red_maple_wood",
                        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD)
                                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> STRIPPED_RED_MAPLE_LOG = registerBlock("stripped_red_maple_log",
                        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_LOG)
                                        .requiresCorrectToolForDrops()));
        public static final RegistryObject<Block> STRIPPED_RED_MAPLE_WOOD = registerBlock("stripped_red_maple_wood",
                        () -> new ModFlammableRotatedPillarBlock(
                                        BlockBehaviour.Properties.copy(Blocks.STRIPPED_OAK_WOOD)
                                                        .requiresCorrectToolForDrops()));

        public static final RegistryObject<Block> RED_MAPLE_PLANKS = registerBlock("red_maple_planks",
                        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)
                                        .requiresCorrectToolForDrops()) {
                                @Override
                                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return true;
                                }

                                @Override
                                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return 5;
                                }

                                @Override
                                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return 20;
                                }
                        });
        public static final RegistryObject<Block> RED_MAPLE_LEAVES = registerBlock("red_maple_leaves",
                        () -> new LeavesBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LEAVES)
                                        .requiresCorrectToolForDrops()) {
                                @Override
                                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return true;
                                }

                                @Override
                                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return 30;
                                }

                                @Override
                                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos,
                                                Direction direction) {
                                        return 60;
                                }
                        });

        public static final RegistryObject<Block> RED_MAPLE_SAPLING = registerBlock("red_maple_sapling",
                        () -> new SaplingBlock(new RedMapleTreeGrower(),
                                        BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)));

        public static final RegistryObject<Block> JASMINE = registerBlock("jasmine",
                        () -> new FlowerBlock(MobEffects.GLOWING, 5,
                                        BlockBehaviour.Properties.copy(Blocks.DANDELION)));

        public static final RegistryObject<Block> POTTED_JASMINE = BLOCKS.register("potted_jasmine",
                        () -> new FlowerPotBlock(() -> ((FlowerPotBlock) Blocks.FLOWER_POT), ModBlocks.JASMINE,
                                        BlockBehaviour.Properties.copy(Blocks.DANDELION)));

        private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
                RegistryObject<T> toReturn = BLOCKS.register(name, block);
                registerBlockItem(name, toReturn);
                return toReturn;
        }

        private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
                return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        }

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}

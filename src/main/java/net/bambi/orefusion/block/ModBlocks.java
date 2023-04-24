package net.bambi.orefusion.block;

import java.util.function.Supplier;
import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.custom.ModFlammableRotatedPillarBlock;
import net.bambi.orefusion.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OreFusion.MOD_ID);

    public static final RegistryObject<Block> PHOSPHATE_BLOCK = registerBlock(
        "phosphate_block",
        () -> new Block(BlockBehaviour.Properties.of(Material.METAL).strength(6f).requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> PHOSPHATE_ORE = registerBlock(
        "phosphate_ore",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(5f).requiresCorrectToolForDrops(), UniformInt.of(2, 6))
    );

    public static final RegistryObject<Block> PHOSPHATE_ORE_DEEPSLATE = registerBlock(
        "phosphate_ore_deepslate",
        () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(8f).requiresCorrectToolForDrops(), UniformInt.of(2, 6))
    );

    public static final RegistryObject<Block> EBONY_LOG = registerBlock(
        "ebony_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );
    public static final RegistryObject<Block> EBONY_WOOD = registerBlock(
        "ebony_wood",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );
    public static final RegistryObject<Block> STRIPPED_EBONY_LOG = registerBlock(
        "stripped_ebony_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );
    public static final RegistryObject<Block> STRIPPED_EBONY_WOOD = registerBlock(
        "stripped_ebony_wood",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );
    public static final RegistryObject<Block> EBONY_LOG = registerBlock(
        "ebony_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );
    public static final RegistryObject<Block> EBONY_LOG = registerBlock(
        "ebony_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );

    public static final RegistryObject<Block> EBONY_LOG = registerBlock(
        "ebony_log",
        () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.OAK_LOG).strength(5f).requiresCorrectToolForDrops())
    );

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

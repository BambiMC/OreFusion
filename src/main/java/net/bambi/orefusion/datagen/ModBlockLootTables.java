package net.bambi.orefusion.datagen;

import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PHOSPHATE_BLOCK.get());

        add(ModBlocks.PHOSPHATE_ORE.get(), (block) -> createOreDrop(ModBlocks.PHOSPHATE_ORE.get(),
                ModItems.PHOSPHATE_RAW.get()));
        // add(ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get(), (block) ->
        // createOreDrop(ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get(),
        // ModItems.PHOSPHATE_RAW.get()));
        add(ModBlocks.LIMESTONE.get(), (block) -> createOreDrop(ModBlocks.LIMESTONE.get(),
                ModItems.PHOSPHATE_FERTILIZER.get()));

        // this.dropSelf(ModBlocks.EBONY_LOG.get());
        // this.dropSelf(ModBlocks.EBONY_WOOD.get());
        // this.dropSelf(ModBlocks.EBONY_PLANKS.get());
        // this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        // this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        // this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        // this.add(ModBlocks.EBONY_LEAVES.get(), (block) -> createLeavesDrops(block,
        // ModBlocks.EBONY_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.dropSelf(ModBlocks.SIMPLE_PURIFIER.get());
        this.dropSelf(ModBlocks.JUMPY_BLOCK.get());
        this.dropSelf(ModBlocks.ZIRCON_LAMP.get());
        this.dropSelf(ModBlocks.BLUEBERRY_CROP.get());

        this.dropSelf(ModBlocks.SOAP_WATER_BLOCK.get());

        this.dropSelf(ModBlocks.GEM_INFUSING_STATION.get());

        this.dropSelf(ModBlocks.RED_MAPLE_LOG.get());

        this.dropSelf(ModBlocks.RED_MAPLE_WOOD.get());

        this.dropSelf(ModBlocks.STRIPPED_RED_MAPLE_LOG.get());

        this.dropSelf(ModBlocks.STRIPPED_RED_MAPLE_WOOD.get());

        this.dropSelf(ModBlocks.RED_MAPLE_PLANKS.get());

        this.dropSelf(ModBlocks.RED_MAPLE_LEAVES.get());
        this.dropSelf(ModBlocks.RED_MAPLE_SAPLING.get());

        this.dropSelf(ModBlocks.JASMINE.get());
        this.dropSelf(ModBlocks.POTTED_JASMINE.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

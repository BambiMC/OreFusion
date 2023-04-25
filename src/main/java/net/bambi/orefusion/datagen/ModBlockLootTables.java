package net.bambi.orefusion.datagen;

import net.bambi.orefusion.block.ModBlocks;
import net.bambi.orefusion.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() { super(Set.of(), FeatureFlags.REGISTRY.allFlags()); }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.PHOSPHATE_BLOCK.get());

        add(ModBlocks.PHOSPHATE_ORE.get(), (block) -> createOreDrop(ModBlocks.PHOSPHATE_ORE.get(), ModItems.PHOSPHATE_RAW.get()));
        add(ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get(), (block) -> createOreDrop(ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get(), ModItems.PHOSPHATE_RAW.get()));
        this.dropSelf(ModBlocks.EBONY_LOG.get());
        this.dropSelf(ModBlocks.EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_PLANKS.get());

        this.dropSelf(ModBlocks.STRIPPED_EBONY_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_EBONY_WOOD.get());
        this.dropSelf(ModBlocks.EBONY_SAPLING.get());

        this.add(ModBlocks.EBONY_LEAVES.get(), (block) -> createLeavesDrops(block, ModBlocks.EBONY_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() { return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator; }
}

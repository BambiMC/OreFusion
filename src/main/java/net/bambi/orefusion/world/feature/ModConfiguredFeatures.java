package net.bambi.orefusion.world.feature;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.ModBlocks;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PHOSPHATE_ORE_KEY = registerKey(
            "overworld_phosphate_ore");

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_PHOSPHATE_ORES = Suppliers
            .memoize(() -> List.of(
                    OreConfiguration.target(new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES),
                            ModBlocks.PHOSPHATE_ORE.get().defaultBlockState()),
                    OreConfiguration.target(new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                            ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get().defaultBlockState())));

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        // HolderGetter<PlacedFeature> placedFeatures =
        // context.lookup(Registries.PLACED_FEATURE);

        register(context, OVERWORLD_PHOSPHATE_ORE_KEY, Feature.ORE,
                new OreConfiguration(OVERWORLD_PHOSPHATE_ORES.get(), 12));

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(OreFusion.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}

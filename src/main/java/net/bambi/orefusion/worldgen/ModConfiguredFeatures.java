package net.bambi.orefusion.worldgen;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.AcaciaFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.StraightTrunkPlacer;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PHOSPHATE_ORE_KEY = registerKey("phosphate_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_LIMESTONE_ORE_KEY = registerKey("limestone");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> overworldPhosphateOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.PHOSPHATE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldLimestoneOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.LIMESTONE.get().defaultBlockState()));

        register(context, EBONY_KEY, Feature.TREE,
                new TreeConfiguration.TreeConfigurationBuilder(BlockStateProvider.simple(ModBlocks.EBONY_LOG.get()), new ForkingTrunkPlacer(6, 1, 3),
                        BlockStateProvider.simple(ModBlocks.EBONY_LEAVES.get()), new AcaciaFoliagePlacer(UniformInt.of(1, 3),
                                UniformInt.of(0, 0)),
                        new TwoLayersFeatureSize(5, 8, 2)).build());

        //veins size max 9 / 64, MAX IS 64!
        register(context, OVERWORLD_PHOSPHATE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldPhosphateOres, 9));
        register(context, OVERWORLD_LIMESTONE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldLimestoneOres, 64));
       
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(OreFusion.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
package net.bambi.orefusion.worldgen;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
        public static final ResourceKey<ConfiguredFeature<?, ?>> EBONY_KEY = registerKey("ebony");

        public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_PHOSPHATE_ORE_KEY = registerKey(
                        "phosphate_ore");

        public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
                RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
                RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
                // RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
                // RuleTest endstoneReplaceables = new BlockMatchTest(Blocks.END_STONE);

                List<OreConfiguration.TargetBlockState> overworldPhosphateOres = List.of(
                                OreConfiguration.target(stoneReplaceables,
                                                ModBlocks.PHOSPHATE_ORE.get().defaultBlockState()),
                                OreConfiguration.target(deepslateReplaceables,
                                                ModBlocks.PHOSPHATE_ORE_DEEPSLATE.get().defaultBlockState()));

                register(context, OVERWORLD_PHOSPHATE_ORE_KEY, Feature.ORE,
                                new OreConfiguration(overworldPhosphateOres, 9));

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

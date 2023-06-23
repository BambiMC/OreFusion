package net.bambi.orefusion.block.entity;

import net.bambi.orefusion.OreFusion;
import net.bambi.orefusion.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES,
            OreFusion.MOD_ID);

    public static final RegistryObject<BlockEntityType<SimplePurifierBlockEntity>> SIMPLE_PURIFIER = BLOCK_ENTITIES.register("simple_purifier",
            () -> BlockEntityType.Builder.of(SimplePurifierBlockEntity::new, ModBlocks.SIMPLE_PURIFIER.get()).build(null));

    public static void register(IEventBus eventBus) { BLOCK_ENTITIES.register(eventBus); }
}

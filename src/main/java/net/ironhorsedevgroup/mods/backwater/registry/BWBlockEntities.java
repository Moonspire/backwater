package net.ironhorsedevgroup.mods.backwater.registry;

import net.ironhorsedevgroup.mods.backwater.Backwater;
import net.ironhorsedevgroup.mods.backwater.block.blockentities.RainBarrelBlockEntity;
import net.ironhorsedevgroup.mods.backwater.block.blockentities.WellTopperBlockEntity;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BWBlockEntities {
        public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Backwater.MODID);

        public static final RegistryObject<BlockEntityType<?>> OAK_RAIN_BARREL = register("oak_rain_barrel", BWBlocks.OAK_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> SPRUCE_RAIN_BARREL = register("spruce_rain_barrel", BWBlocks.SPRUCE_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> DARK_OAK_RAIN_BARREL = register("dark_oak_rain_barrel", BWBlocks.DARK_OAK_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> BIRCH_RAIN_BARREL = register("birch_rain_barrel", BWBlocks.BIRCH_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> JUNGLE_RAIN_BARREL = register("jungle_rain_barrel", BWBlocks.JUNGLE_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> ACACIA_RAIN_BARREL = register("acacia_rain_barrel", BWBlocks.ACACIA_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> MANGROVE_RAIN_BARREL = register("mangrove_rain_barrel", BWBlocks.MANGROVE_RAIN_BARREL, RainBarrelBlockEntity::new);
        public static final RegistryObject<BlockEntityType<?>> WELL_TOPPER = register("well_topper", BWBlocks.WELL_TOPPER, WellTopperBlockEntity::new);

        private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
                                                                   BlockEntityType.BlockEntitySupplier<?> supplier) {
            return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
        }

        public static void Register(IEventBus modEventBus) {
            REGISTRY.register(modEventBus);
        }
}

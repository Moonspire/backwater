package net.ironhorsedevgroup.mods.backwater.registry;

import net.ironhorsedevgroup.mods.backwater.Backwater;
import net.ironhorsedevgroup.mods.backwater.block.RainBarrelBlock;
import net.ironhorsedevgroup.mods.backwater.block.WellShaftBlock;
import net.ironhorsedevgroup.mods.backwater.block.WellShaftLadderBlock;
import net.ironhorsedevgroup.mods.backwater.block.WellTopperBlock;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BWBlocks {
    public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, Backwater.MODID);

    public static final RegistryObject<Block> DARK_OAK_RAIN_BARREL = REGISTRY.register("dark_oak_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> OAK_RAIN_BARREL = REGISTRY.register("oak_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> BIRCH_RAIN_BARREL = REGISTRY.register("birch_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> SPRUCE_RAIN_BARREL = REGISTRY.register("spruce_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> JUNGLE_RAIN_BARREL = REGISTRY.register("jungle_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> MANGROVE_RAIN_BARREL = REGISTRY.register("mangrove_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> ACACIA_RAIN_BARREL = REGISTRY.register("acacia_rain_barrel", RainBarrelBlock::new);
    public static final RegistryObject<Block> WELL_SHAFT = REGISTRY.register("well_shaft", WellShaftBlock::new);
    public static final RegistryObject<Block> WELL_SHAFT_LADDER = REGISTRY.register("well_shaft_ladder", WellShaftLadderBlock::new);
    public static final RegistryObject<Block> WELL_TOPPER = REGISTRY.register("well_topper", WellTopperBlock::new);

    public static void Register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void clientSetup(FMLClientSetupEvent event) {
            ItemBlockRenderTypes.setRenderLayer(OAK_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(SPRUCE_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(BIRCH_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(JUNGLE_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(DARK_OAK_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(MANGROVE_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());
            ItemBlockRenderTypes.setRenderLayer(ACACIA_RAIN_BARREL.get(), renderType -> renderType == RenderType.cutout());

            // Foliage
            //ItemBlockRenderTypes.setRenderLayer(BERRY_BUSH.get(), renderType -> renderType == RenderType.cutout());
        }
    }
}

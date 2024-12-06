package net.ironhorsedevgroup.mods.backwater.registry;

import net.ironhorsedevgroup.mods.backwater.Backwater;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class BWItems {
    // Always loaded registry
    public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, Backwater.MODID);

    // Quark + Cozy Home compat registry
    public static final DeferredRegister<Item> QK_CH = DeferredRegister.create(ForgeRegistries.ITEMS, Backwater.MODID);

    // Undergarden + Cozy Home compat registry
    public static final DeferredRegister<Item> UG_CH = DeferredRegister.create(ForgeRegistries.ITEMS, Backwater.MODID);

    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
        return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }
    private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab, String id) {
        return REGISTRY.register(id, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    // Survival Tab
    public static final RegistryObject<Item> DARK_OAK_RAIN_BARREL = block(BWBlocks.DARK_OAK_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> OAK_RAIN_BARREL = block(BWBlocks.OAK_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> BIRCH_RAIN_BARREL = block(BWBlocks.BIRCH_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> SPRUCE_RAIN_BARREL = block(BWBlocks.SPRUCE_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> JUNGLE_RAIN_BARREL = block(BWBlocks.JUNGLE_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> ACACIA_RAIN_BARREL = block(BWBlocks.ACACIA_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> MANGROVE_RAIN_BARREL = block(BWBlocks.MANGROVE_RAIN_BARREL, BWTabs.BACKWATER);
    public static final RegistryObject<Item> WELL_SHAFT = block(BWBlocks.WELL_SHAFT, BWTabs.BACKWATER);
    public static final RegistryObject<Item> WELL_TOPPER = block(BWBlocks.WELL_TOPPER, BWTabs.BACKWATER);
    //public static final RegistryObject<Item> PEMMICAN = REGISTRY.register("pemmican", PemmicanItem::new);
    public static final RegistryObject<Item> SALT_BOTTLE = REGISTRY.register("salt_bottle", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER).craftRemainder(net.minecraft.world.item.Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> SALT = REGISTRY.register("salt", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    //public static final RegistryObject<Item> SILT_BOWL = REGISTRY.register("silt_bowl", BowlOfSiltItem::new);
    public static final RegistryObject<Item> ANCIENT_PLANK = QK_CH.register("ancient_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    public static final RegistryObject<Item> AZALEA_PLANK = QK_CH.register("azalea_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    public static final RegistryObject<Item> BLOSSOM_PLANK = QK_CH.register("blossom_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    public static final RegistryObject<Item> GRONGLE_PLANK = UG_CH.register("grongle_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    public static final RegistryObject<Item> SMOGSTEM_PLANK = UG_CH.register("smogstem_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));
    public static final RegistryObject<Item> WIGGLEWOOD_PLANK = UG_CH.register("wigglewood_plank", () -> new Item(new Item.Properties().tab(BWTabs.BACKWATER)));

    /*
    private static RegistryObject<Item> berries(String regName) {
        return REGISTRY.register(regName, () -> new BerriesItem(TWEBlocks.BERRY_BUSH.get(), new Item.Properties().tab(Tabs.BACKWATER).food(Foods.SWEET_BERRIES)));
    }
    */

    public static void Register(IEventBus modEventBus) {
        REGISTRY.register(modEventBus);
        if (ModList.get().isLoaded("cozy_home")) {
            if (ModList.get().isLoaded("quark")) {
                QK_CH.register(modEventBus);
            }
            if (ModList.get().isLoaded("undergarden")) {
                UG_CH.register(modEventBus);
            }
        }
    }
}

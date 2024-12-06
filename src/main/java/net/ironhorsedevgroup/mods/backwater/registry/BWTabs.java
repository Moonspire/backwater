package net.ironhorsedevgroup.mods.backwater.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BWTabs {
	public static CreativeModeTab BACKWATER;

	public static void load() {

		BACKWATER = new CreativeModeTab("tab_backwater") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(BWBlocks.WELL_TOPPER.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
}

package net.ironhorsedevgroup.mods.backwater.block;

import net.ironhorsedevgroup.mods.toolshed.abstracts.AbstractFluidCollector;
import net.ironhorsedevgroup.mods.toolshed.tools.Fluid;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public abstract class AbstractRainBarrelBlock extends AbstractFluidCollector {
    public AbstractRainBarrelBlock(Integer collection_rate, Properties blockproperties) {
        super(collection_rate, blockproperties);
    }


    @Override
    public void addFluidToBlock(Level world, BlockPos pos) {
        if (world.isRaining() && world.canSeeSky(pos)) {
            Float downfall = Math.abs(world.getBiome(pos).value().getDownfall());
            if (ModList.get().isLoaded("thirst")) {
                CompoundTag tag = new CompoundTag();
                tag.putInt("Purity", 2);
                FluidStack fluid = new FluidStack(ForgeRegistries.FLUIDS.getValue(getFluid()), (int) (rate * downfall), tag);
                Fluid.addFluid(world, pos, 1, fluid);
            } else {
                Fluid.addFluid(world, pos, 1, (int) (rate * downfall));
            }
        }
    }
}

package net.ironhorsedevgroup.mods.backwater.block;

import net.ironhorsedevgroup.mods.toolshed.tools.Fluid;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;

public abstract class AbstractRainBarrelBlock extends AbstractFluidCollector {
    public AbstractRainBarrelBlock(Integer collection_rate, Properties blockproperties) {
        super(collection_rate, blockproperties);
    }


    @Override
    public void addFluidToBlock(Level world, BlockPos pos) {
        if (world.isRaining() && world.canSeeSky(pos)) {
            Float downfall = Math.abs(world.getBiome(pos).value().getDownfall());
            Fluid.addFluid(world, pos, 1, (int) (rate * downfall));
        }
    }
}

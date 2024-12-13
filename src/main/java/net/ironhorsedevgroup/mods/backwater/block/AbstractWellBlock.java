package net.ironhorsedevgroup.mods.backwater.block;

import net.ironhorsedevgroup.mods.toolshed.abstracts.AbstractFluidCollector;
import net.ironhorsedevgroup.mods.toolshed.tools.Fluid;
import net.ironhorsedevgroup.mods.toolshed.tools.MathUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public abstract class AbstractWellBlock extends AbstractFluidCollector implements SimpleWaterloggedBlock {
    public static int water_depth;
    public static double table_strength;
    public static List<Block> well_shafts;
    public static int water_amount;
    public AbstractWellBlock(Integer target_depth, Double water_table_strength, List<Block> shaft_blocks, Integer collection_rate, Properties blockproperties) {
        super(collection_rate, blockproperties);
        water_depth = target_depth;
        table_strength = water_table_strength;
        well_shafts = shaft_blocks;
    }

    public AbstractWellBlock(Integer target_depth, Double water_table_strength, Block shaft_block, Integer collection_rate, Properties blockproperties) {
        super(collection_rate, blockproperties);
        water_depth = target_depth;
        table_strength = water_table_strength;
        well_shafts = List.of(shaft_block);
    }

    @Override
    public void addFluidToBlock(Level world, BlockPos pos) {
        if (ModList.get().isLoaded("thirst")) {
            CompoundTag tag = new CompoundTag();
            tag.putInt("Purity", 2);
            FluidStack fluid = new FluidStack(ForgeRegistries.FLUIDS.getValue(getFluid()), calculateWaterAmount(world, pos), tag);
            Fluid.addFluid(world, pos, 1, fluid);
        } else {
            Fluid.addFluid(world, pos, 1, calculateWaterAmount(world, pos));
        }
    }
    
    public int calculateWaterAmount(Level world, BlockPos pos) {
        int depth = getWellDepth(world, pos);
        BlockPos bottomPos = new BlockPos(pos.getX(), pos.getY() - depth, pos.getZ());
        double curve = MathUtils.getBellCurveAtX(rate, table_strength, water_depth, depth);
        double downfall = Math.abs(world.getBiome(pos).value().getDownfall());
        double bottomDownfall = Math.abs(world.getBiome(bottomPos).value().getDownfall());
        if (bottomDownfall > downfall) {
            downfall = bottomDownfall;
        }
        if (Fluid.isBlockWaterlogged(world, bottomPos)) {
            downfall = downfall + 0.1;
        }
        water_amount = (int) (curve * downfall);
        return water_amount;
    }

    public int getWellDepth(LevelAccessor world, BlockPos pos) {
        int depth = 1;
        boolean isShaft = true;
        while (isShaft) {
            if (well_shafts.contains(world.getBlockState(pos.below(depth)))) {
                depth = depth + 1;
            } else {
                depth = depth - 1;
                isShaft = false;
            }
        }
        return depth;
    }
}

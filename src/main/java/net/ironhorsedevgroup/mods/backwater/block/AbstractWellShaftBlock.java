package net.ironhorsedevgroup.mods.backwater.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;

public abstract class AbstractWellShaftBlock extends Block implements SimpleWaterloggedBlock {
    public AbstractWellShaftBlock(Properties blockproperties) {
        super(blockproperties);
    }
}

package net.pl3x.rubies.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockRuby extends BlockBase {
    public BlockRuby() {
        super(Material.ROCK, "ruby_block", "rubyBlock");

        setHardness(10F);
        setResistance(50F);

        setHarvestLevel("pickaxe", 2);

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.RED;
    }
}

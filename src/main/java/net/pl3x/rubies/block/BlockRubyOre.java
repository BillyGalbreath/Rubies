package net.pl3x.rubies.block;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockRubyOre extends BlockBase {
    public BlockRubyOre() {
        super(Material.ROCK, "ruby_ore", "rubyOre");

        setHardness(20F);
        setResistance(30F);

        setHarvestLevel("pickaxe", 4);

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.STONE;
    }
}

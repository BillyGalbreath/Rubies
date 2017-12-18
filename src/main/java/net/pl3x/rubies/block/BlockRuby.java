package net.pl3x.rubies.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import javax.annotation.Nonnull;

public class BlockRuby extends BlockBase {
    public BlockRuby() {
        super(Material.IRON, "ruby_block", "rubyBlock");

        setHardness(10);
        setResistance(50);

        setHarvestLevel("pickaxe", 2);

        setSoundType(SoundType.METAL);
    }

    @Override
    @Nonnull
    public MapColor getMapColor(IBlockState state, IBlockAccess world, BlockPos pos) {
        return MapColor.RED;
    }

    @Override
    public BlockRuby setCreativeTab(CreativeTabs creativeTabs) {
        super.setCreativeTab(creativeTabs);
        return this;
    }
}

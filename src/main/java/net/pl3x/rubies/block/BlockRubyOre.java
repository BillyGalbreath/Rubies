package net.pl3x.rubies.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pl3x.rubies.configuration.HarvestTool;

import javax.annotation.Nonnull;

public class BlockRubyOre extends BlockBase {
    public BlockRubyOre(Material material, String name, String oreName, float hardness, float resistance, HarvestTool harvestTool, int harvestLevel, MapColor mapColor, SoundType soundType) {
        super(material, name, oreName, hardness, resistance, harvestTool, harvestLevel, mapColor, soundType);
    }

    @Override
    @Nonnull
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT_MIPPED;
    }

    @Override
    public boolean shouldSideBeRendered(IBlockState state, @Nonnull IBlockAccess world, @Nonnull BlockPos pos, EnumFacing side) {
        BlockPos sidePos = pos.offset(side);
        IBlockState sideState = world.getBlockState(sidePos);
        return !sideState.doesSideBlockRendering(world, sidePos, side.getOpposite()) ||
                !sideState.isSideSolid(world, sidePos, side.getOpposite());
    }
}

package net.pl3x.rubies.block.dependencies;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.pl3x.rubies.block.ModBlocks;
import net.pl3x.stairs.block.stairs.StairsBasic;
import net.pl3x.stairs.tab.StairsTab;

public class BlockRubyStairs extends StairsBasic {
    public BlockRubyStairs() {
        super(Material.IRON, "stairs_ruby", MapColor.RED);
        setHardness(10F);
        setResistance(50F);
        setSoundType(SoundType.METAL);

        ModBlocks.__BLOCKS__.add(this);
        net.pl3x.stairs.block.ModBlocks.__BLOCKS__.remove(this);

        StairsTab.LIST.add(StairsTab.LIST.indexOf(net.pl3x.stairs.block.ModBlocks.STAIRS_EMERALD) + 1, this);
    }
}

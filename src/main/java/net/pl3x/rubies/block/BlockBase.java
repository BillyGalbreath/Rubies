package net.pl3x.rubies.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {
    public BlockBase(Material material, String name) {
        super(material);
        setUnlocalizedName(name);
        setRegistryName(name);

        ModBlocks.__BLOCKS__.add(this);
    }
}

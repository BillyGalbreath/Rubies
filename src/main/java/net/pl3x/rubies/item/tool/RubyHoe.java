package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.pl3x.rubies.item.ModItems;
import net.pl3x.rubies.material.RubyMaterial;

public class RubyHoe extends ItemHoe {
    public static final String name = "ruby_hoe";

    public RubyHoe() {
        super(RubyMaterial.TOOL);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.__ITEMS__.add(this);
    }
}

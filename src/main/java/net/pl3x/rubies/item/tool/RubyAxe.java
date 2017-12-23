package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.pl3x.rubies.item.ModItems;
import net.pl3x.rubies.material.RubyMaterial;

public class RubyAxe extends ItemAxe {
    public static final String name = "ruby_axe";

    public RubyAxe() {
        super(RubyMaterial.TOOL, 8f, -3.1f);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.__ITEMS__.add(this);
    }
}

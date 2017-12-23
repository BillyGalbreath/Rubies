package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.pl3x.rubies.item.ModItems;
import net.pl3x.rubies.material.RubyMaterial;

public class RubySword extends ItemSword {
    public static final String name = "ruby_sword";

    public RubySword() {
        super(RubyMaterial.TOOL);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.__ITEMS__.add(this);
    }
}

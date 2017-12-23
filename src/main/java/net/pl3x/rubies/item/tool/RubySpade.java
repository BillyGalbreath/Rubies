package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.pl3x.rubies.item.ModItems;
import net.pl3x.rubies.material.RubyMaterial;

public class RubySpade extends ItemSpade {
    public static final String name = "ruby_shovel";

    public RubySpade() {
        super(RubyMaterial.TOOL);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.__ITEMS__.add(this);
    }
}

package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;
import net.pl3x.rubies.item.ModItems;
import net.pl3x.rubies.material.RubyMaterial;

public class RubyPickaxe extends ItemPickaxe {
    public static final String name = "ruby_pickaxe";

    public RubyPickaxe() {
        super(RubyMaterial.TOOL);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.__ITEMS__.add(this);
    }
}

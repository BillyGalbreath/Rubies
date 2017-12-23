package net.pl3x.rubies.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class RubyItem extends Item {
    public final String name = "ruby";

    public RubyItem() {
        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CreativeTabs.MISC);

        ModItems.__ITEMS__.add(this);
    }
}

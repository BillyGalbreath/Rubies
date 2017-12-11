package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.pl3x.rubies.item.ModItems;

public class ItemAxe extends net.minecraft.item.ItemAxe {
    public ItemAxe(ToolMaterial material, String name) {
        super(material, 8f, -3.1f);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.items.add(this);
    }
}

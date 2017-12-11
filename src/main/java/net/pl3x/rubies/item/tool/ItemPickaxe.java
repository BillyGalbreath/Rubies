package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.pl3x.rubies.item.ModItems;

public class ItemPickaxe extends net.minecraft.item.ItemPickaxe {
    public ItemPickaxe(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.items.add(this);
    }
}

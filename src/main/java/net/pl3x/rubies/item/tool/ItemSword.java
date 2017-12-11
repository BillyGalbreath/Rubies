package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.pl3x.rubies.item.ModItems;

public class ItemSword extends net.minecraft.item.ItemSword {
    public ItemSword(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.items.add(this);
    }
}

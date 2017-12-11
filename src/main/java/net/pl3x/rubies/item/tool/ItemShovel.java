package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;
import net.pl3x.rubies.item.ModItems;

public class ItemShovel extends ItemSpade {
    public ItemShovel(ToolMaterial material, String name) {
        super(material);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.TOOLS);

        ModItems.items.add(this);
    }
}

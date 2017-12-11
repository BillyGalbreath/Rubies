package net.pl3x.rubies.item.tool;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.pl3x.rubies.item.ModItems;

public class ItemArmor extends net.minecraft.item.ItemArmor {
    public ItemArmor(ArmorMaterial material, EntityEquipmentSlot slot, String name) {
        super(material, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.items.add(this);
    }
}

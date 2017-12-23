package net.pl3x.rubies.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.pl3x.rubies.material.RubyMaterial;

public class RubyArmor extends net.minecraft.item.ItemArmor {
    public RubyArmor(EntityEquipmentSlot slot, String name) {
        super(RubyMaterial.ARMOR, 0, slot);
        setRegistryName(name);
        setUnlocalizedName(name);

        setCreativeTab(CreativeTabs.COMBAT);

        ModItems.__ITEMS__.add(this);
    }
}

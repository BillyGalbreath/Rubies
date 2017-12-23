package net.pl3x.rubies.material;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;
import net.pl3x.rubies.Rubies;

public class RubyMaterial {
    public static final ItemArmor.ArmorMaterial ARMOR = EnumHelper.addArmorMaterial("RUBY", Rubies.modId + ":ruby", 40, new int[]{6, 12, 16, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4);
    public static final Item.ToolMaterial TOOL = EnumHelper.addToolMaterial("RUBY", 5, 2038, 12, 6, 30);
}

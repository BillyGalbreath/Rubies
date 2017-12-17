package net.pl3x.rubies.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.configuration.ModConfig;
import net.pl3x.rubies.item.tool.ItemArmor;
import net.pl3x.rubies.item.tool.ItemAxe;
import net.pl3x.rubies.item.tool.ItemHoe;
import net.pl3x.rubies.item.tool.ItemPickaxe;
import net.pl3x.rubies.item.tool.ItemShovel;
import net.pl3x.rubies.item.tool.ItemSword;

import java.util.HashSet;
import java.util.Set;

import static net.minecraft.item.Item.ToolMaterial;
import static net.minecraft.item.ItemArmor.ArmorMaterial;

public class ModItems {
    public static final Set<Item> items = new HashSet<>();

    public static final ArmorMaterial rubyArmorMaterial = EnumHelper.addArmorMaterial(
            "RUBY", Rubies.modId + ":ruby",
            ModConfig.armor.factor_durability,
            new int[]{
                    ModConfig.armor.reduction_boots,
                    ModConfig.armor.reduction_leggings,
                    ModConfig.armor.reduction_chestplate,
                    ModConfig.armor.reduction_helmet},
            ModConfig.armor.factor_enchantability,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            ModConfig.armor.factor_toughness);
    public static final ToolMaterial rubyToolMaterial = EnumHelper.addToolMaterial(
            "RUBY",
            ModConfig.tool.harvestLevel,
            ModConfig.tool.durability,
            ModConfig.tool.efficiency,
            ModConfig.tool.damage,
            ModConfig.tool.enchantability);

    public static final ItemBase RUBY = new ItemBase("ruby", "ruby").setCreativeTab(CreativeTabs.MISC);

    public static final ItemAxe RUBY_AXE = new ItemAxe(rubyToolMaterial, "ruby_axe");
    public static final ItemHoe RUBY_HOE = new ItemHoe(rubyToolMaterial, "ruby_hoe");
    public static final ItemPickaxe RUBY_PICKAXE = new ItemPickaxe(rubyToolMaterial, "ruby_pickaxe");
    public static final ItemShovel RUBY_SHOVEL = new ItemShovel(rubyToolMaterial, "ruby_shovel");
    public static final ItemSword RUBY_SWORD = new ItemSword(rubyToolMaterial, "ruby_sword");

    public static final ItemArmor RUBY_BOOTS = new ItemArmor(rubyArmorMaterial, EntityEquipmentSlot.FEET, "ruby_boots");
    public static final ItemArmor RUBY_CHESTPLATE = new ItemArmor(rubyArmorMaterial, EntityEquipmentSlot.CHEST, "ruby_chestplate");
    public static final ItemArmor RUBY_HELMET = new ItemArmor(rubyArmorMaterial, EntityEquipmentSlot.HEAD, "ruby_helmet");
    public static final ItemArmor RUBY_LEGGINGS = new ItemArmor(rubyArmorMaterial, EntityEquipmentSlot.LEGS, "ruby_leggings");

    public static void register(IForgeRegistry<Item> registry) {
        items.forEach(registry::register);
    }

    public static void registerModels() {
        items.forEach(item -> Rubies.proxy.registerItemRenderer(item, 0, item.getUnlocalizedName().substring(5)));
    }
}

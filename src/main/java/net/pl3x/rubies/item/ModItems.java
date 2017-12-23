package net.pl3x.rubies.item;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.item.tool.RubyAxe;
import net.pl3x.rubies.item.tool.RubyHoe;
import net.pl3x.rubies.item.tool.RubyPickaxe;
import net.pl3x.rubies.item.tool.RubySpade;
import net.pl3x.rubies.item.tool.RubySword;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Set;

public class ModItems {
    public static final Set<Item> __ITEMS__ = new HashSet<>();

    public static final RubyItem RUBY = new RubyItem();

    public static final RubyAxe RUBY_AXE = new RubyAxe();
    public static final RubyHoe RUBY_HOE = new RubyHoe();
    public static final RubyPickaxe RUBY_PICKAXE = new RubyPickaxe();
    public static final RubySpade RUBY_SHOVEL = new RubySpade();
    public static final RubySword RUBY_SWORD = new RubySword();

    public static final RubyArmor RUBY_BOOTS = new RubyArmor(EntityEquipmentSlot.FEET, "ruby_boots");
    public static final RubyArmor RUBY_CHESTPLATE = new RubyArmor(EntityEquipmentSlot.CHEST, "ruby_chestplate");
    public static final RubyArmor RUBY_HELMET = new RubyArmor(EntityEquipmentSlot.HEAD, "ruby_helmet");
    public static final RubyArmor RUBY_LEGGINGS = new RubyArmor(EntityEquipmentSlot.LEGS, "ruby_leggings");

    public static void register(IForgeRegistry<Item> registry) {
        increaseMaxArmor();

        __ITEMS__.forEach(registry::register);
    }

    public static void registerModels() {
        __ITEMS__.forEach(item -> Rubies.proxy.registerItemRenderer(item, 0, item.getUnlocalizedName().substring(5)));
    }

    private static void increaseMaxArmor() {
        try {
            Field field = ReflectionHelper.findField(SharedMonsterAttributes.class, "ARMOR");
            field.setAccessible(true);

            Field modifiersField = Field.class.getDeclaredField("modifiers");
            modifiersField.setAccessible(true);
            modifiersField.setInt(field, field.getModifiers() & ~Modifier.FINAL);

            field.set(null, new RangedAttribute(null, "generic.armor", 0.0D, 0.0D, 40.0D).setShouldWatch(true));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

package net.pl3x.rubies.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nonnull;

public class ItemBase extends Item {
    private final String oreName;

    public ItemBase(String name, String oreName) {
        setUnlocalizedName(name);
        setRegistryName(name);

        this.oreName = oreName;

        ModItems.items.add(this);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }

    @Override
    @Nonnull
    public ItemBase setCreativeTab(@Nonnull CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}

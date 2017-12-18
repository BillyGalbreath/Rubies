package net.pl3x.rubies.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.oredict.OreDictionary;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.item.ModItems;

import javax.annotation.Nonnull;
import java.util.Random;

public class BlockBase extends Block {
    private final String name;
    private final String oreName;

    public BlockBase(Material material, String name, String oreName) {
        super(material);

        this.name = name;
        this.oreName = oreName;

        setUnlocalizedName(name);
        setRegistryName(name);

        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        ModBlocks.__BLOCKS__.add(this);
    }

    void registerItemModel(Item item) {
        Rubies.proxy.registerItemRenderer(item, 0, name);
    }

    public void initOreDict() {
        OreDictionary.registerOre(oreName, this);
    }

    Item createItemBlock() {
        return new ItemBlock(this).setRegistryName(getRegistryName());
    }

    @Override
    @Nonnull
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (this == ModBlocks.RUBY_ORE) {
            return ModItems.RUBY;
        } else {
            return Item.getItemFromBlock(this);
        }
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, @Nonnull Random random) {
        if (fortune < 1) {
            return quantityDropped(random);
        }
        if (Item.getItemFromBlock(this) != getItemDropped(getBlockState().getValidStates().iterator().next(), random, fortune)) {
            int i = random.nextInt(fortune + 2) - 1;
            if (i < 0) {
                i = 0;
            }
            return quantityDropped(random) * (i + 1);
        } else {
            return quantityDropped(random);
        }
    }
}

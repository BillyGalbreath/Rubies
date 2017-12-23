package net.pl3x.rubies.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.block.dependencies.DepBlocks;

import java.util.HashSet;
import java.util.Set;

public class ModBlocks {
    public static final Set<Block> __BLOCKS__ = new HashSet<>();

    public static final BlockRuby RUBY_BLOCK = new BlockRuby().setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
    public static final BlockRubyOre RUBY_ORE = new BlockRubyOre().setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

    public static Block RUBY_BLOCK_STAIRS;
    public static Block RUBY_ORE_STAIRS;

    static {
        if (Loader.isModLoaded("stairs")) {
            DepBlocks.init();
        } else {
            RUBY_BLOCK_STAIRS = new BlockBase(Material.ROCK, "stairs_ruby");
            RUBY_ORE_STAIRS = new BlockBase(Material.ROCK, "stairs_ruby_ore");
        }
    }

    public static void register(IForgeRegistry<Block> registry) {
        __BLOCKS__.forEach(registry::register);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        __BLOCKS__.forEach(block -> registry.register(new ItemBlock(block).setRegistryName(block.getRegistryName())));
    }

    public static void registerModels() {
        __BLOCKS__.forEach(block -> Rubies.proxy.registerItemRenderer(Item.getItemFromBlock(block), 0, block.getUnlocalizedName().substring(5)));
    }
}

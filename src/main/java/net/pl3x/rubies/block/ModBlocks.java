package net.pl3x.rubies.block;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.HashSet;
import java.util.Set;

public class ModBlocks {
    public static final Set<BlockBase> __BLOCKS__ = new HashSet<>();

    public static final BlockRubyOre RUBY_ORE = new BlockRubyOre();
    public static final BlockBase RUBY_BLOCK = new BlockRuby();

    public static void register(IForgeRegistry<Block> registry) {
        __BLOCKS__.forEach(registry::register);
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        __BLOCKS__.forEach(block -> registry.register(block.createItemBlock()));
    }

    public static void registerModels() {
        __BLOCKS__.forEach(block -> block.registerItemModel(Item.getItemFromBlock(block)));
    }
}

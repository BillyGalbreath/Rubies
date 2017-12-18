package net.pl3x.rubies.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;
import net.pl3x.rubies.configuration.ModConfig;

import java.util.HashSet;
import java.util.Set;

public class ModBlocks {
    public static final Set<BlockBase> __BLOCKS__ = new HashSet<>();

    public static final BlockRubyOre RUBY_ORE = new BlockRubyOre(
            Material.ROCK, "ruby_ore", "rubyOre",
            ModConfig.blockRubyOre.hardness,
            ModConfig.blockRubyOre.resistance,
            ModConfig.blockRubyOre.harvestTool,
            ModConfig.blockRubyOre.harvestLevel,
            MapColor.STONE,
            SoundType.STONE);
    public static final BlockBase RUBY_BLOCK = new BlockBase(
            Material.IRON, "ruby_block", "rubyBlock",
            ModConfig.blockRubyBlock.hardness,
            ModConfig.blockRubyBlock.resistance,
            ModConfig.blockRubyBlock.harvestTool,
            ModConfig.blockRubyBlock.harvestLevel,
            MapColor.RED,
            SoundType.METAL);

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

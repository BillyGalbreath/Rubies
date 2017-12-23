package net.pl3x.rubies.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.pl3x.rubies.block.ModBlocks;
import net.pl3x.rubies.item.ModItems;

public class ModRecipes {
    public static void init() {
        // Ore Dict
        OreDictionary.registerOre("rubyBlock", ModBlocks.RUBY_BLOCK);
        OreDictionary.registerOre("rubyOre", ModBlocks.RUBY_ORE);
        OreDictionary.registerOre("ruby", ModItems.RUBY);

        if (Loader.isModLoaded("stairs")) {
            OreDictionary.registerOre("rubyStairs", ModBlocks.RUBY_BLOCK_STAIRS);
            OreDictionary.registerOre("rubyOreStairs", ModBlocks.RUBY_ORE_STAIRS);
        }

        // Smelting
        GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY), 1.5F);
    }
}

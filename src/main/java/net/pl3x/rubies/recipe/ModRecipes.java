package net.pl3x.rubies.recipe;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pl3x.rubies.block.ModBlocks;
import net.pl3x.rubies.configuration.ModConfig;
import net.pl3x.rubies.item.ModItems;

public class ModRecipes {
    public static void init() {
        // Ore Dict
        ModBlocks.RUBY_BLOCK.initOreDict();
        ModBlocks.RUBY_ORE.initOreDict();
        ModItems.RUBY.initOreDict();

        // Smelting
        GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY), ModConfig.smelting.xp);
    }
}

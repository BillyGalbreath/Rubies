package net.pl3x.rubies.proxy;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pl3x.rubies.recipe.ModRecipes;
import net.pl3x.rubies.world.ModWorldGen;

public class ServerProxy {
    public void preInit(FMLPreInitializationEvent event) {
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        ModRecipes.init();
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }
}


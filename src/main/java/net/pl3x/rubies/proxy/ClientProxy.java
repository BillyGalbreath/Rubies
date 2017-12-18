package net.pl3x.rubies.proxy;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.block.model.BakedModel;
import net.pl3x.rubies.block.model.ModelLoader;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
        ModelLoaderRegistry.registerLoader(new ModelLoader());
    }

    @Override
    public void init(FMLInitializationEvent event) {
        super.init(event);
    }

    @Override
    public void registerItemRenderer(Item item, int meta, String id) {
        net.minecraftforge.client.model.ModelLoader.setCustomModelResourceLocation(
                item, meta, new ModelResourceLocation(Rubies.modId + ":" + id, "inventory"));
    }

    @SubscribeEvent
    public void on(TextureStitchEvent.Pre event) {
        event.getMap().registerSprite(BakedModel.RUBY_ORE);
        event.getMap().registerSprite(BakedModel.RUBY_ORE_GLOW);
    }
}

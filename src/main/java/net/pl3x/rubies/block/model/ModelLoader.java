package net.pl3x.rubies.block.model;

import net.minecraft.client.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.IModel;
import net.pl3x.rubies.Rubies;
import net.pl3x.rubies.block.ModBlocks;

import javax.annotation.Nonnull;

public class ModelLoader implements ICustomModelLoader {
    @Override
    public void onResourceManagerReload(@Nonnull IResourceManager resourceManager) {
    }

    @Override
    public boolean accepts(@Nonnull ResourceLocation modelLocation) {
        return modelLocation.getResourceDomain().equals(Rubies.modId) &&
                modelLocation.getResourcePath().equals(ModBlocks.RUBY_ORE.getRegistryName().getResourcePath());
    }

    @Override
    @Nonnull
    public IModel loadModel(@Nonnull ResourceLocation modelLocation) throws Exception {
        return Model.INSTANCE;
    }
}

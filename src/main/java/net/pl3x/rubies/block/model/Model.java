package net.pl3x.rubies.block.model;

import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import javax.annotation.Nonnull;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Function;

public class Model implements IModel {
    public static final Model INSTANCE = new Model();

    @Override
    @Nonnull
    public Collection<ResourceLocation> getDependencies() {
        return Collections.emptyList();
    }

    @Override
    @Nonnull
    public Collection<ResourceLocation> getTextures() {
        return Collections.emptyList();
    }

    @Override
    @Nonnull
    public IBakedModel bake(@Nonnull IModelState state, @Nonnull VertexFormat format, @Nonnull Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        VertexFormat vertex = new VertexFormat();
        format.getElements().forEach(vertex::addElement);
        vertex.addElement(DefaultVertexFormats.TEX_2S);
        return new BakedModel(vertex, bakedTextureGetter);
    }

    @Override
    @Nonnull
    public IModelState getDefaultState() {
        return TRSRTransformation.identity();
    }
}

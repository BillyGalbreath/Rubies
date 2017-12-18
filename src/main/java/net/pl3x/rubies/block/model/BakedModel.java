package net.pl3x.rubies.block.model;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.model.pipeline.UnpackedBakedQuad;
import net.pl3x.rubies.Rubies;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class BakedModel implements IBakedModel {
    public static final ResourceLocation RUBY_ORE = new ResourceLocation(Rubies.modId, "blocks/ruby_ore");
    public static final ResourceLocation RUBY_ORE_GLOW = new ResourceLocation(Rubies.modId, "blocks/ruby_ore_glow");

    private final VertexFormat format;
    private final TextureAtlasSprite baseSprite, overlaySprite;

    private final Map<EnumFacing, BakedQuad> baseQuads = new HashMap<>();
    private final Map<EnumFacing, BakedQuad> overlayQuads = new HashMap<>();

    public BakedModel(VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        this.format = format;
        this.baseSprite = bakedTextureGetter.apply(RUBY_ORE);
        this.overlaySprite = bakedTextureGetter.apply(RUBY_ORE_GLOW);

        for (EnumFacing facing : EnumFacing.values()) {
            baseQuads.put(facing, createQuad(facing, BlockVec.FULL_CUBE.get(facing), baseSprite, 0));
            overlayQuads.put(facing, createQuad(facing, BlockVec.FULL_CUBE.get(facing), overlaySprite, 220));
        }
    }

    private void putVertex(UnpackedBakedQuad.Builder builder, Vec3d vec, TextureAtlasSprite sprite, float u, float v, int brightness) {
        for (int e = 0; e < format.getElementCount(); e++) {
            switch (format.getElement(e).getUsage()) {
                case POSITION:
                    builder.put(e, (float) vec.x, (float) vec.y, (float) vec.z);
                    break;
                case COLOR:
                    builder.put(e, 1, 1, 1, 1);
                    break;
                case UV:
                    if (format.getElement(e).getIndex() == 1) {
                        if (brightness > 0) {
                            builder.put(e, ((float) ((brightness >> 4) & 15) * 32) / 65535, 0F);
                        } else {
                            builder.put(e);
                        }
                    } else {
                        builder.put(e, sprite.getInterpolatedU(u), sprite.getInterpolatedV(v));
                    }
                    break;
                case NORMAL:
                    builder.put(e);
                    break;
                default:
                    builder.put(e);
                    break;
            }
        }
    }

    private BakedQuad createQuad(EnumFacing facing, BlockVec vec, TextureAtlasSprite sprite, int brightness) {
        UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(format);
        builder.setTexture(sprite);
        builder.setQuadOrientation(facing);
        putVertex(builder, vec.v1, sprite, 16, 16, brightness);
        putVertex(builder, vec.v2, sprite, 16, 0, brightness);
        putVertex(builder, vec.v3, sprite, 0, 0, brightness);
        putVertex(builder, vec.v4, sprite, 0, 16, brightness);
        return builder.build();
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
        if (side == null) {
            return Collections.emptyList();
        }

        List<BakedQuad> quads = new ArrayList<>();
        quads.add(baseQuads.get(side));
        quads.add(overlayQuads.get(side));
        return quads;
    }

    @Override
    public boolean isAmbientOcclusion() {
        return true;
    }

    @Override
    public boolean isGui3d() {
        return true;
    }

    @Override
    public boolean isBuiltInRenderer() {
        return false;
    }

    @Override
    @Nonnull
    public TextureAtlasSprite getParticleTexture() {
        return baseSprite;
    }

    @Override
    @Nonnull
    public ItemCameraTransforms getItemCameraTransforms() {
        return ItemCameraTransforms.DEFAULT;
    }

    @Override
    @Nonnull
    public ItemOverrideList getOverrides() {
        return ItemOverrideList.NONE;
    }
}

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
import java.util.List;
import java.util.function.Function;

public class BakedModel implements IBakedModel {
    public static final ResourceLocation RUBY_ORE = new ResourceLocation(Rubies.modId, "blocks/ruby_ore");
    public static final ResourceLocation RUBY_ORE_GLOW = new ResourceLocation(Rubies.modId, "blocks/ruby_ore_glow");

    private final VertexFormat format;
    private final TextureAtlasSprite base, overlay;

    public BakedModel(VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
        this.format = format;
        this.base = bakedTextureGetter.apply(RUBY_ORE);
        this.overlay = bakedTextureGetter.apply(RUBY_ORE_GLOW);
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

    private BakedQuad createQuad(Vec3d v1, Vec3d v2, Vec3d v3, Vec3d v4, TextureAtlasSprite sprite, EnumFacing facing, int brightness) {
        UnpackedBakedQuad.Builder builder = new UnpackedBakedQuad.Builder(format);
        builder.setTexture(sprite);
        builder.setQuadOrientation(facing);
        builder.setQuadTint(1);
        putVertex(builder, v1, sprite, 16, 16, brightness);
        putVertex(builder, v2, sprite, 16, 0, brightness);
        putVertex(builder, v3, sprite, 0, 0, brightness);
        putVertex(builder, v4, sprite, 0, 16, brightness);
        return builder.build();
    }

    @Override
    @Nonnull
    public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
        List<BakedQuad> quads = new ArrayList<>();

        if (side == EnumFacing.DOWN)
            quads.add(createQuad(new Vec3d(1, 0, 0), new Vec3d(1, 0, 1), new Vec3d(0, 0, 1), new Vec3d(0, 0, 0), base, EnumFacing.DOWN, 0));
        if (side == EnumFacing.UP)
            quads.add(createQuad(new Vec3d(0, 1, 0), new Vec3d(0, 1, 1), new Vec3d(1, 1, 1), new Vec3d(1, 1, 0), base, EnumFacing.UP, 0));
        if (side == EnumFacing.SOUTH)
            quads.add(createQuad(new Vec3d(1, 0, 1), new Vec3d(1, 1, 1), new Vec3d(0, 1, 1), new Vec3d(0, 0, 1), base, EnumFacing.NORTH, 0));
        if (side == EnumFacing.NORTH)
            quads.add(createQuad(new Vec3d(0, 0, 0), new Vec3d(0, 1, 0), new Vec3d(1, 1, 0), new Vec3d(1, 0, 0), base, EnumFacing.SOUTH, 0));
        if (side == EnumFacing.WEST)
            quads.add(createQuad(new Vec3d(0, 0, 1), new Vec3d(0, 1, 1), new Vec3d(0, 1, 0), new Vec3d(0, 0, 0), base, EnumFacing.EAST, 0));
        if (side == EnumFacing.EAST)
            quads.add(createQuad(new Vec3d(1, 0, 0), new Vec3d(1, 1, 0), new Vec3d(1, 1, 1), new Vec3d(1, 0, 1), base, EnumFacing.WEST, 0));

        if (side == EnumFacing.DOWN)
            quads.add(createQuad(new Vec3d(1, 0, 0), new Vec3d(1, 0, 1), new Vec3d(0, 0, 1), new Vec3d(0, 0, 0), overlay, EnumFacing.DOWN, 240));
        if (side == EnumFacing.UP)
            quads.add(createQuad(new Vec3d(0, 1, 0), new Vec3d(0, 1, 1), new Vec3d(1, 1, 1), new Vec3d(1, 1, 0), overlay, EnumFacing.UP, 240));
        if (side == EnumFacing.SOUTH)
            quads.add(createQuad(new Vec3d(1, 0, 1), new Vec3d(1, 1, 1), new Vec3d(0, 1, 1), new Vec3d(0, 0, 1), overlay, EnumFacing.NORTH, 240));
        if (side == EnumFacing.NORTH)
            quads.add(createQuad(new Vec3d(0, 0, 0), new Vec3d(0, 1, 0), new Vec3d(1, 1, 0), new Vec3d(1, 0, 0), overlay, EnumFacing.SOUTH, 240));
        if (side == EnumFacing.WEST)
            quads.add(createQuad(new Vec3d(0, 0, 1), new Vec3d(0, 1, 1), new Vec3d(0, 1, 0), new Vec3d(0, 0, 0), overlay, EnumFacing.EAST, 240));
        if (side == EnumFacing.EAST)
            quads.add(createQuad(new Vec3d(1, 0, 0), new Vec3d(1, 1, 0), new Vec3d(1, 1, 1), new Vec3d(1, 0, 1), overlay, EnumFacing.WEST, 240));

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
        return base;
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

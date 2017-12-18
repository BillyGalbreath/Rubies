package net.pl3x.rubies.block.model;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.Vec3d;

import java.util.HashMap;
import java.util.Map;

public class BlockVec {
    public static final Map<EnumFacing, BlockVec> FULL_CUBE = new HashMap<>();

    static {
        FULL_CUBE.put(EnumFacing.DOWN, new BlockVec(new Vec3d(1, 0, 0), new Vec3d(1, 0, 1), new Vec3d(0, 0, 1), new Vec3d(0, 0, 0)));
        FULL_CUBE.put(EnumFacing.UP, new BlockVec(new Vec3d(0, 1, 0), new Vec3d(0, 1, 1), new Vec3d(1, 1, 1), new Vec3d(1, 1, 0)));
        FULL_CUBE.put(EnumFacing.SOUTH, new BlockVec(new Vec3d(1, 0, 1), new Vec3d(1, 1, 1), new Vec3d(0, 1, 1), new Vec3d(0, 0, 1)));
        FULL_CUBE.put(EnumFacing.NORTH, new BlockVec(new Vec3d(0, 0, 0), new Vec3d(0, 1, 0), new Vec3d(1, 1, 0), new Vec3d(1, 0, 0)));
        FULL_CUBE.put(EnumFacing.WEST, new BlockVec(new Vec3d(0, 0, 1), new Vec3d(0, 1, 1), new Vec3d(0, 1, 0), new Vec3d(0, 0, 0)));
        FULL_CUBE.put(EnumFacing.EAST, new BlockVec(new Vec3d(1, 0, 0), new Vec3d(1, 1, 0), new Vec3d(1, 1, 1), new Vec3d(1, 0, 1)));
    }

    public final Vec3d v1, v2, v3, v4;

    public BlockVec(Vec3d v1, Vec3d v2, Vec3d v3, Vec3d v4) {
        this.v1 = v1;
        this.v2 = v2;
        this.v3 = v3;
        this.v4 = v4;
    }
}

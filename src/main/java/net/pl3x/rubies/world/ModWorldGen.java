package net.pl3x.rubies.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.pl3x.rubies.block.ModBlocks;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (world.provider.getDimension() == 0) {
            new WorldGenMinable(ModBlocks.RUBY_ORE.getDefaultState(), rand.nextInt(6))
                    .generate(world, rand, new BlockPos((chunkX << 4) + rand.nextInt(16),
                            rand.nextInt(16), (chunkZ << 4) + rand.nextInt(16)));
        }
    }
}

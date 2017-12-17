package net.pl3x.rubies.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.pl3x.rubies.block.ModBlocks;
import net.pl3x.rubies.configuration.ModConfig;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (!ModConfig.worldGen.enabled) {
            return; // disabled worldgen
        }
        if (world.provider.getDimension() == 0) {
            for (int i = 0; i < ModConfig.worldGen.maxChances; i++) {
                new WorldGenMinable(ModBlocks.RUBY_ORE.getDefaultState(),
                        rand.nextInt(ModConfig.worldGen.maxVeinSize))
                        .generate(world, rand, new BlockPos(
                                (chunkX << 4) + rand.nextInt(16),
                                ModConfig.worldGen.yLower + rand.nextInt(ModConfig.worldGen.yUpper - ModConfig.worldGen.yLower + 1),
                                (chunkZ << 4) + rand.nextInt(16)));
            }
        }
    }
}

package net.pl3x.rubies.world;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.pl3x.rubies.block.ModBlocks;
import net.pl3x.rubies.configuration.RubyConfig;

import java.util.Random;

public class ModWorldGen implements IWorldGenerator {
    @Override
    public void generate(Random rand, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) {
        if (RubyConfig.oreChance > 0 && RubyConfig.oreVeinSize > 0 && world.provider.getDimensionType() == DimensionType.OVERWORLD) {
            WorldGenMinable generator = new WorldGenMinable(ModBlocks.RUBY_ORE.getDefaultState(), rand.nextInt(RubyConfig.oreVeinSize));
            int yDiff = RubyConfig.oreMaxY - RubyConfig.oreMinY + 1;
            for (int i = 0; i < RubyConfig.oreChance; i++) {
                generator.generate(world, rand, new BlockPos((chunkX << 4) + rand.nextInt(16),
                        RubyConfig.oreMinY + rand.nextInt(yDiff), (chunkZ << 4) + rand.nextInt(16)));
            }
        }
    }
}

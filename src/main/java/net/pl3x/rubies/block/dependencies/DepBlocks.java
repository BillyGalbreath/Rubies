package net.pl3x.rubies.block.dependencies;

import net.pl3x.rubies.block.ModBlocks;

public class DepBlocks {
    public static void init() {
        ModBlocks.RUBY_BLOCK_STAIRS = new BlockRubyStairs();
        ModBlocks.RUBY_ORE_STAIRS = new BlockRubyOreStairs();
    }
}

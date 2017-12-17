package net.pl3x.rubies.configuration;

import net.minecraftforge.common.config.Config;
import net.pl3x.rubies.Rubies;

@Config(modid = Rubies.modId)
@Config.LangKey("config.title")
public class ModConfig {
    @Config.LangKey("config.armor")
    public static Armor armor = new Armor();

    @Config.LangKey("config.block.ruby")
    public static Block blockRubyBlock = new Block(10F, 50F, HarvestTool.PICKAXE, 2);

    @Config.LangKey("config.block.rubyOre")
    public static Block blockRubyOre = new Block(20F, 30F, HarvestTool.PICKAXE, 3);

    @Config.LangKey("config.smelting")
    public static Smelting smelting = new Smelting();

    @Config.LangKey("config.tool")
    public static Tool tool = new Tool();

    @Config.LangKey("config.worldgen")
    public static WorldGen worldGen = new WorldGen();

    public static class Armor {
        @Config.LangKey("config.armor.durability")
        public int factor_durability = 40;

        @Config.LangKey("config.armor.enchantability")
        public int factor_enchantability = 30;

        @Config.LangKey("config.armor.toughness")
        public float factor_toughness = 4.0F;

        @Config.LangKey("config.armor.boots")
        public int reduction_boots = 4;

        @Config.LangKey("config.armor.leggings")
        public int reduction_leggings = 7;

        @Config.LangKey("config.armor.chestplate")
        public int reduction_chestplate = 10;

        @Config.LangKey("config.armor.helmet")
        public int reduction_helmet = 4;
    }

    public static class Block {
        public Block(float hardness, float resistance, HarvestTool harvestTool, int harvestLevel) {
            this.hardness = hardness;
            this.resistance = resistance;
            this.harvestTool = harvestTool;
            this.harvestLevel = harvestLevel;
        }

        @Config.LangKey("config.blocks.hardness")
        public float hardness;

        @Config.LangKey("config.blocks.resistance")
        public float resistance;

        @Config.LangKey("config.blocks.harvestTool")
        public HarvestTool harvestTool;

        @Config.LangKey("config.blocks.harvestLevel")
        public int harvestLevel;
    }

    public static class Smelting {
        @Config.LangKey("config.smelting.xp")
        public float xp = 0.7F;
    }

    public static class Tool {
        @Config.LangKey("config.tool.damage")
        public float damage = 5.0F;

        @Config.LangKey("config.tool.durability")
        public int durability = 2038;

        @Config.LangKey("config.tool.efficiency")
        public float efficiency = 12.0F;

        @Config.LangKey("config.tool.enchantability")
        public int enchantability = 30;

        @Config.LangKey("config.tool.harvestLevel")
        public int harvestLevel = 5;
    }

    public static class WorldGen {
        @Config.LangKey("config.worldgen.enabled")
        public boolean enabled = true;

        @Config.LangKey("config.worldgen.chances")
        public int maxChances = 2;

        @Config.LangKey("config.worldgen.veins")
        public int maxVeinSize = 8;

        @Config.LangKey("config.worldgen.minY")
        public int yLower = 0;

        @Config.LangKey("config.worldgen.maxY")
        public int yUpper = 15;
    }
}

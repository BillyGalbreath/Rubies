package net.pl3x.rubies.configuration;

public enum HarvestTool {
    AXE,
    PICKAXE,
    SHOVEL;

    public String toolClass() {
        return name().toLowerCase();
    }
}

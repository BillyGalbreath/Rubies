package net.pl3x.rubies.configuration;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.pl3x.rubies.Rubies;

@Config(modid = Rubies.modId)
public class RubyConfig {
    @Config.LangKey("config.worldgen.veins")
    public static int oreVeinSize = 6;

    @Config.LangKey("config.worldgen.chances")
    public static int oreChance = 1;

    @Config.LangKey("config.worldgen.minY")
    public static int oreMinY = 0;

    @Config.LangKey("config.worldgen.maxY")
    public static int oreMaxY = 16;

    @Mod.EventBusSubscriber(modid = Rubies.modId)
    private static class EventHandler {
        @SubscribeEvent
        public static void on(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(Rubies.modId)) {
                ConfigManager.sync(Rubies.modId, Config.Type.INSTANCE);
            }
        }
    }
}

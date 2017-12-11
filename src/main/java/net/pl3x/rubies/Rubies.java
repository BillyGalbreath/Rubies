package net.pl3x.rubies;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.pl3x.rubies.proxy.ServerProxy;

@Mod(modid = Rubies.modId, name = Rubies.name, version = Rubies.version)
public class Rubies {
    public static final String modId = "rubies";
    public static final String name = "Rubies";
    public static final String version = "@DEV_BUILD@";

    @SidedProxy(serverSide = "net.pl3x.rubies.proxy.ServerProxy", clientSide = "net.pl3x.rubies.proxy.ClientProxy")
    public static ServerProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }
}

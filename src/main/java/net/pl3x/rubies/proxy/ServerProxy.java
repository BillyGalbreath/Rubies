package net.pl3x.rubies.proxy;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.pl3x.rubies.advancement.ModAdvancements;
import net.pl3x.rubies.item.RubyArmor;
import net.pl3x.rubies.recipe.ModRecipes;
import net.pl3x.rubies.world.ModWorldGen;

public class ServerProxy {
    public void preInit(FMLPreInitializationEvent event) {
        ModAdvancements.registerTriggers();
        MinecraftForge.EVENT_BUS.register(this);
    }

    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new ModWorldGen(), 0);
        ModRecipes.init();
    }

    public void registerItemRenderer(Item item, int meta, String id) {
    }

    private int tick = 0;

    @SubscribeEvent
    public void on(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (tick % 20 == 0) {
                for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance().getPlayerList().getPlayers()) {
                    ModAdvancements.MOD_LOADED_TRIGGER.trigger(player, "stairs");
                }
            }
            tick++;
            if (tick > 19) {
                tick = 0;
            }
        }
    }

    @SubscribeEvent
    public void on(LivingHurtEvent event) {
        float reduction = event.getAmount() / 8 * 1.5F;
        for (ItemStack armor : event.getEntity().getArmorInventoryList()) {
            if (armor.getItem() instanceof RubyArmor) {
                event.setAmount(event.getAmount() - reduction);
            }
        }
    }
}

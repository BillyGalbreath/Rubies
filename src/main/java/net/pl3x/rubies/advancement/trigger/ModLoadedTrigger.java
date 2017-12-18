package net.pl3x.rubies.advancement.trigger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.advancements.critereon.AbstractCriterionInstance;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Loader;
import net.pl3x.rubies.Rubies;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ModLoadedTrigger implements ICriterionTrigger<ModLoadedTrigger.Instance> {
    private static final ResourceLocation ID = new ResourceLocation(Rubies.modId, "mod_loaded");
    private final Map<PlayerAdvancements, Listeners> listeners = Maps.newHashMap();

    @Override
    public ResourceLocation getId() {
        return ID;
    }

    @Override
    public void addListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        //listeners.computeIfAbsent(playerAdvancementsIn, ModLoadedTrigger.Listeners::new).add(listener);

        ModLoadedTrigger.Listeners listeners = this.listeners.get(playerAdvancementsIn);

        if (listeners == null) {
            listeners = new ModLoadedTrigger.Listeners(playerAdvancementsIn);
            this.listeners.put(playerAdvancementsIn, listeners);
        }

        listeners.add(listener);
    }

    @Override
    public void removeListener(PlayerAdvancements playerAdvancementsIn, Listener<Instance> listener) {
        Listeners listeners = this.listeners.get(playerAdvancementsIn);
        if (listeners != null) {
            listeners.remove(listener);
            if (listeners.isEmpty()) {
                this.listeners.remove(playerAdvancementsIn);
            }
        }
    }

    @Override
    public void removeAllListeners(PlayerAdvancements playerAdvancementsIn) {
        this.listeners.remove(playerAdvancementsIn);
    }

    @Override
    public Instance deserializeInstance(JsonObject json, JsonDeserializationContext context) {
        String modId = JsonUtils.getString(json, "modid");
        return new Instance(modId);
    }

    public void trigger(EntityPlayerMP player, String modId) {
        Listeners listeners = this.listeners.get(player.getAdvancements());
        if (listeners != null) {
            listeners.trigger(modId);
        }
    }

    public static class Instance extends AbstractCriterionInstance {
        String modId;

        public Instance(String modId) {
            super(ID);
            this.modId = modId;
        }

        public boolean test(String modId) {
            return Loader.isModLoaded(modId);
        }
    }

    static class Listeners {
        private final PlayerAdvancements playerAdvancements;
        private final Set<Listener<Instance>> listeners = Sets.newHashSet();

        public Listeners(PlayerAdvancements playerAdvancementsIn) {
            this.playerAdvancements = playerAdvancementsIn;
        }

        public boolean isEmpty() {
            return this.listeners.isEmpty();
        }

        public void add(Listener<Instance> listener) {
            this.listeners.add(listener);
        }

        public void remove(Listener<Instance> listener) {
            this.listeners.remove(listener);
        }

        public void trigger(String modId) {
            List<Listener<Instance>> list = null;

            for (Listener<Instance> listener : this.listeners) {
                if (listener.getCriterionInstance().test(modId)) {
                    if (list == null) {
                        list = Lists.newArrayList();
                    }
                    list.add(listener);
                }
            }

            if (list != null) {
                for (Listener<Instance> listener1 : list) {
                    listener1.grantCriterion(this.playerAdvancements);
                }
            }
        }
    }
}

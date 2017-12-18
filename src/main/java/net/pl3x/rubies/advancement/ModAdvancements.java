package net.pl3x.rubies.advancement;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.advancements.ICriterionTrigger;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.pl3x.rubies.advancement.trigger.ModLoadedTrigger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ModAdvancements {
    public static final ModLoadedTrigger MOD_LOADED_TRIGGER = new ModLoadedTrigger();

    public static void registerTriggers() {
        try {
            Method method = ReflectionHelper.findMethod(CriteriaTriggers.class, "register", "func_192118_a", ICriterionTrigger.class);
            method.setAccessible(true);
            method.invoke(null, MOD_LOADED_TRIGGER);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

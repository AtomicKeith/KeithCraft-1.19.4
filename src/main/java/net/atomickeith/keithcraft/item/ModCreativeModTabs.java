package net.atomickeith.keithcraft.item;

import net.atomickeith.keithcraft.KeithCraft;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KeithCraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModTabs {
    public static CreativeModeTab KEITHCRAFT_TAB;

    @SubscribeEvent
    public static void registerCreativeModTabs(CreativeModeTabEvent.Register event) {
        KEITHCRAFT_TAB = event.registerCreativeModeTab(new ResourceLocation(KeithCraft.MOD_ID, "keithcraft_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RAW_TIN.get())).title(Component
                        .translatable("creativemodtab.keithcraft_tab")));
    }
}

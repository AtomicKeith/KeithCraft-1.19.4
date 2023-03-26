package net.atomickeith.keithcraft;

import com.mojang.logging.LogUtils;
import net.atomickeith.keithcraft.block.ModBlocks;
import net.atomickeith.keithcraft.item.ModCreativeModTabs;
import net.atomickeith.keithcraft.item.ModItems;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(KeithCraft.MOD_ID)
public class KeithCraft {
    public static final String MOD_ID = "keithcraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public KeithCraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.RAW_TIN);
            event.accept(ModItems.TIN_INGOT);
        }

        if(event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.TIN_BLOCK);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
            event.accept(ModBlocks.RAW_TIN_BLOCK);
        }

        if(event.getTab() == ModCreativeModTabs.KEITHCRAFT_TAB) {
            event.accept(ModBlocks.TIN_ORE);
            event.accept(ModBlocks.DEEPSLATE_TIN_ORE);
            event.accept(ModItems.RAW_TIN);
            event.accept(ModBlocks.RAW_TIN_BLOCK);
            event.accept(ModItems.TIN_INGOT);
            event.accept(ModBlocks.TIN_BLOCK);
        }
    }

    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

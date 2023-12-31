package net.swimmingtuna.lotm;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.swimmingtuna.lotm.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LOTM.MOD_ID)
public class LOTM
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "lotm";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public LOTM()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
                event.accept(ModItems.MindReading);
                event.accept(ModItems.Awe);
                event.accept(ModItems.Frenzy);
                event.accept(ModItems.Placate);
                event.accept(ModItems.BattleHypnotism);
                event.accept(ModItems.PsychologicalInvisibility);
                event.accept(ModItems.Guidance);
                event.accept(ModItems.Manipulation);
                event.accept(ModItems.MentalPlague);
                event.accept(ModItems.MindStorm);
                event.accept(ModItems.ConsciousnessStroll);
                event.accept(ModItems.DragonBreath);
                event.accept(ModItems.PlagueStorm);
                event.accept(ModItems.DreamWeaving);
                event.accept(ModItems.Discern);
                event.accept(ModItems.DreamIntoReality);
                event.accept(ModItems.Prophesize);
                event.accept(ModItems.EnvisionLife);
                event.accept(ModItems.EnvisionNature);
                event.accept(ModItems.EnvisionWeather);
                event.accept(ModItems.EnvisionBarrier);
                event.accept(ModItems.EnvisionDeath);
                event.accept(ModItems.EnvisionKingdom);
                event.accept(ModItems.EnvisionLocation);
                event.accept(ModItems.EnvisionHealth);



        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {
        }
    }
}

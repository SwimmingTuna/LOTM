package net.swimmingtuna.lotm.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.swimmingtuna.lotm.Client.SpiritualityHUDOverlay;
import net.swimmingtuna.lotm.LOTM;

import static net.swimmingtuna.lotm.LOTM.MOD_ID;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = LOTM.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
        public static class ClientModBusEvents {
            @SubscribeEvent
            public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
                event.registerAboveAll("spirituality", SpiritualityHUDOverlay.HUD_SPIRITUALITY);


        }


    }
}

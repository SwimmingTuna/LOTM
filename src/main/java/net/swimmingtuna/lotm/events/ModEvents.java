package net.swimmingtuna.lotm.events;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.LogicalSide;
import net.swimmingtuna.lotm.BeyonderStats.BeyonderSpirituality.BeyonderSpiritualityProvider;
import net.swimmingtuna.lotm.LOTM;

public class ModEvents {

   @SubscribeEvent
   public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
       if (event.getObject() instanceof Player) {
           if (!event.getObject().getCapability(BeyonderSpiritualityProvider.BEYONDER_SPIRITUALITY).isPresent()) {
               event.addCapability(new ResourceLocation(LOTM.MOD_ID,"properties"), new BeyonderSpiritualityProvider());
           }
       }
   }

   @SubscribeEvent
    public static void onPlayerCloned (PlayerEvent.Clone event) {
       if (event.isWasDeath()) {
           event.getOriginal().getCapability(BeyonderSpiritualityProvider.BEYONDER_SPIRITUALITY).ifPresent(oldStore -> {
               event.getOriginal().getCapability(BeyonderSpiritualityProvider.BEYONDER_SPIRITUALITY).ifPresent(newStore -> {
                   newStore.copyFrom(oldStore);
               });
           });
       }
   }

   @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
       event.register(BeyonderSpiritualityProvider.class);}

    @SubscribeEvent
    public static void onPlayerTrick(TickEvent.PlayerTickEvent event) {
       if (event.side == LogicalSide.SERVER) {
           event.player.getCapability(BeyonderSpiritualityProvider.BEYONDER_SPIRITUALITY).ifPresent(spirutality-> {
               if (spirutality.getSpiruality() < 100 && event.player.getRandom().nextFloat() < 0.0005f) {
                   spirutality.addSpirituality(1);
               }
           });
       }
    }
}

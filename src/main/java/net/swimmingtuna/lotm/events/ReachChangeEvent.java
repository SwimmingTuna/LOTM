package net.swimmingtuna.lotm.events;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import javax.swing.text.html.parser.Entity;

import java.util.UUID;

import static net.swimmingtuna.lotm.events.ReachChangeUUIDs.BeyonderEntityReach;
import static net.swimmingtuna.lotm.item.custom.MindReading.pUsedHand;

public class ReachChangeEvent {

    public static void checkEntityTooFar(PlayerInteractEvent event, Entity pEntity, Player pPlayer, InteractionHand pUsedHand) {
        if(pUsedHand(pPlayer)) {
            UUID uuidforOppositeHand = BeyonderEntityReach;
            AttributeInstance attackRange = pPlayer.getAttribute(ForgeMod.ENTITY_REACH.get());
            if (attackRange != null) {
                AttributeModifier beyonderModifier = attackRange.getModifier(BeyonderEntityReach);
                if (beyonderModifier != null) {
                    attackRange.removeModifier(beyonderModifier.getId());
                    double range = pPlayer.getAttributeValue(ForgeMod.ENTITY_REACH.get());
                    double trueReach = range == 0 ? 0 : range + (pPlayer.isCreative() ? 3 : 0);
                    attackRange.addTransientModifier(beyonderModifier);

                }
            }
        }
    }
}

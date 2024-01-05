package net.swimmingtuna.lotm.item.custom;

import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.swimmingtuna.lotm.events.ReachChange;

import java.util.UUID;

import static net.swimmingtuna.lotm.events.ReachChange.BeyonderBlockReach;
import static net.swimmingtuna.lotm.events.ReachChange.BeyonderEntityReach;


public class MindReading extends Item {

@Deprecated
    public MindReading(Properties pProperties) {
        super(pProperties);}

    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers (EquipmentSlot pSlot) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> attributeBuilder = ImmutableMultimap.builder();
        attributeBuilder.putAll(super.getDefaultAttributeModifiers(pSlot));
        attributeBuilder.put(ForgeMod.ENTITY_REACH.get(), new AttributeModifier(BeyonderEntityReach, "Reach modifier", 12, AttributeModifier.Operation.ADDITION));
        attributeBuilder.put(ForgeMod.BLOCK_REACH.get(), new AttributeModifier(BeyonderBlockReach, "Reach modifier", 12, AttributeModifier.Operation.ADDITION));
        return pSlot == EquipmentSlot.MAINHAND ? attributeBuilder.build() : super.getDefaultAttributeModifiers(pSlot);
    }


    @Deprecated
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pUsedHand(pPlayer)) {
            UUID uuidforOppositeHand = BeyonderEntityReach;
            AttributeInstance attackRange = pPlayer.getAttribute(ForgeMod.ENTITY_REACH.get());
            if (attackRange != null) {
                AttributeModifier beyonderModifier = attackRange.getModifier(uuidforOppositeHand);
                double range = pPlayer.getAttributeValue(ForgeMod.ENTITY_REACH.get());
                double trueReach = range == 15 ? 0 : range + (pPlayer.isCreative() ? 0: 0);
                attackRange.addTransientModifier(beyonderModifier);




            }
        }
        if (pInteractionTarget.level().isClientSide) return InteractionResult.SUCCESS;
        pPlayer.sendSystemMessage(Component.literal("Can not use Mind Reading on a non player entity"));
        return InteractionResult.PASS;}

    private static boolean pUsedHand(Player pPlayer) {
        ItemStack mainHandStack = pPlayer.getMainHandItem();
                return(mainHandStack.getItem() instanceof MindReading);
    }



        }
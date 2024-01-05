package net.swimmingtuna.lotm.item.custom;


import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


public class MindReadingTest extends Item {
    public MindReadingTest(Properties pProperties) {
        super(pProperties);}



    @Deprecated
    public InteractionResult interactLivingEntity(ItemStack pStack, Player pPlayer, LivingEntity pInteractionTarget, InteractionHand pUsedHand) {
        if (pInteractionTarget.level().isClientSide) return InteractionResult.SUCCESS;
        pPlayer.sendSystemMessage(Component.literal("Can not use Mind Reading on a non player entity"));
        return InteractionResult.PASS;}
    @Mixin(MultiPlayerGameMode.class)
    public class MultiPlayerGameModeMixin {
        @Inject(method="getPickRange", at=@At("HEAD"), cancellable = true)
        public void getPickRange(CallbackInfoReturnable<Float> cir) {
            Player player = Minecraft.getInstance().player;
            if (player != null && player.getMainHandItem().getItem() instanceof MindReadingTest) {
                cir.setReturnValue(15.0f);
                @Mixin(GameRenderer.class)
                class GameRendererMixin {
                    @ModifyConstant(method = "pick", constant = @Constant(doubleValue = 3.0))
                    public double injected(double constant) {
                        return 15.0;

                    }
                }
            }


        }}}
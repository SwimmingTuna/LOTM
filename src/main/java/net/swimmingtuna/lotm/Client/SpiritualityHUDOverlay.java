package net.swimmingtuna.lotm.Client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;
import net.swimmingtuna.lotm.Beyonder.BeyonderStats.BeyonderSpirituality.BeyonderSpirituality;
import net.swimmingtuna.lotm.LOTM;
import net.minecraft.resources.ResourceLocation;



public class SpiritualityHUDOverlay  {
    private static final ResourceLocation FULL_SPIRITUALITY = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/full_spirituality.png");
    private static final ResourceLocation EMPTY_SPIRITUALITY = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/empty_spirituality.png");
    private static final ResourceLocation SPIRITUALITY_1 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_1");
    private static final ResourceLocation SPIRITUALITY_2 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_2");
    private static final ResourceLocation SPIRITUALITY_3 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_3");
    private static final ResourceLocation SPIRITUALITY_4 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_4");
    private static final ResourceLocation SPIRITUALITY_5 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_5");
    private static final ResourceLocation SPIRITUALITY_6 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_6");
    private static final ResourceLocation SPIRITUALITY_7 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_7");
    private static final ResourceLocation SPIRITUALITY_8 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_8");
    private static final ResourceLocation SPIRITUALITY_9 = new ResourceLocation(LOTM.MOD_ID,"textures/spirituality/spirituality_9");

    public static final IGuiOverlay HUD_SPIRITUALITY = (((gui, guiGraphics, partialTick, screenWidth, screenHeight) -> {
        int x = screenWidth / 2;
        int y = screenHeight;

        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F,1.0F,1.0F,1.0F);
        RenderSystem.setShaderTexture(0, EMPTY_SPIRITUALITY);
        for (int i = 0; i < 10; i++) {
            guiGraphics.blit(EMPTY_SPIRITUALITY, x+10, y-48,0,0,81,8,81,8);
        }
        RenderSystem.setShaderTexture(0,FULL_SPIRITUALITY);
        for (int i = 0; i < 10; i++) {
            if (ClientSpiritualityData.getPlayerSpirituality() > i) {
                guiGraphics.blit(FULL_SPIRITUALITY,x-94,y-54,0,0,12,12,12,12);
            }
            else {
                break;
            }
        }
    }));






}








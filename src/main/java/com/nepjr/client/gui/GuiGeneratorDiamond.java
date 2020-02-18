package com.nepjr.client.gui;

import com.nepjr.container.ContainerGeneratorDiamond;
import com.nepjr.te.TileEntityGeneratorDiamond;

import codechicken.lib.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly (Side.CLIENT)
public class GuiGeneratorDiamond extends GuiMachineBase<TileEntityGeneratorDiamond, ContainerGeneratorDiamond> {

    private static final ResourceLocation GUI_TEX = new ResourceLocation("nepstuff", "textures/gui/gen.png");

    public GuiGeneratorDiamond(InventoryPlayer player, TileEntityGeneratorDiamond machine) {
        super(new ContainerGeneratorDiamond(player, machine));
        setBackgroundTexture(GUI_TEX);
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {

        String s = I18n.format("container.neutron_collector");
        float scaled_progress = scaleF(machineTile.getProgress(), TileEntityGeneratorDiamond.PRODUCTION_TICKS, 100);
        String progress = "Progress: " + MathHelper.round(scaled_progress, 10) + "%";

        fontRenderer.drawString(s, xSize / 2 - fontRenderer.getStringWidth(s) / 2, 6, 0x404040);
        fontRenderer.drawString(progress, xSize / 2 - fontRenderer.getStringWidth(progress) / 2, 60, 0x404040);
        fontRenderer.drawString(I18n.format("container.inventory"), 8, ySize - 96 + 2, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        drawBackground();
        super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    }
}
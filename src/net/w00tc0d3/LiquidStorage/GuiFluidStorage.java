package net.w00tc0d3.LiquidStorage;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

/**
 * Created with IntelliJ IDEA.
 * User: w00tc0d3
 * Date: 9/22/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuiFluidStorage extends GuiContainer {

    private static final ResourceLocation gui = new ResourceLocation("minecraft", "textures/gui/container/furnace.png");
    private TileFluidStorage fluidStorage;

    public GuiFluidStorage(TileFluidStorage fluidStorage)
    {
        super(new ContainerFluidStorage(fluidStorage));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(gui);
        int l = (width - xSize) / 2;
        int i1 = (height - ySize) / 2;
        drawTexturedModalRect(l, i1, 0, 0, xSize, ySize);
    }
}

package net.w00tc0d3.LiquidStorage;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiFluidStorage extends GuiContainer {
    public static final ResourceLocation resource = new ResourceLocation(LiquidStorage.modid.toLowerCase(), "textures/gui/fluidstorage.png");
    TileFluidStorage tileFluidStorage;

    public GuiFluidStorage(TileFluidStorage tileEntity) {
        super(new ContainerFluidStorage(tileEntity));
        this.tileFluidStorage = (TileFluidStorage) tileEntity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        this.fontRenderer.drawString("Fluid Storage", 5, 5, 0x000000);
        this.fontRenderer.drawString(tileFluidStorage.returnFluidInfo().get("fluid").toString(), 5, 20, 0x000000);
        this.fontRenderer.drawString(tileFluidStorage.returnFluidInfo().get("amount").toString(), 5, 32, 0x000000);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(resource);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
}

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

    public GuiFluidStorage(TileFluidStorage tileEntity) {
        super(new ContainerFluidStorage(tileEntity));
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
        drawDefaultBackground();
    }
}

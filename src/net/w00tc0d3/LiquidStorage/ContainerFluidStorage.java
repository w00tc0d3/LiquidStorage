package net.w00tc0d3.LiquidStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.tileentity.TileEntityFurnace;

/**
 * Created with IntelliJ IDEA.
 * User: w00tc0d3
 * Date: 9/22/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class ContainerFluidStorage extends Container {
    private TileFluidStorage tileFluidStorage;

    public ContainerFluidStorage(TileFluidStorage tileFluidStorage) {
        this.tileFluidStorage = tileFluidStorage;
    }

    @Override
    public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
        return this.tileFluidStorage.isUseableByPlayer(par1EntityPlayer);
    }
}

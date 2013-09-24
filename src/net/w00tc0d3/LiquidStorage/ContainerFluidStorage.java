package net.w00tc0d3.LiquidStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.HashMap;

public class ContainerFluidStorage extends Container {
    private TileFluidStorage tileFluid;
    public ContainerFluidStorage(TileFluidStorage tileEntity) {
        this.tileFluid = (TileFluidStorage) tileEntity;
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return true;
    }
}

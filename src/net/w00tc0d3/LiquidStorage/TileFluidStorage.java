package net.w00tc0d3.LiquidStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.*;

public class TileFluidStorage extends TileEntity implements IFluidHandler {

    public final FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * 2000000);

    public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
        return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord + 0.5D, (double)this.yCoord + 0.5D, (double)this.zCoord + 0.5D) <= 64.0D;
    }

    @Override
    public int fill(ForgeDirection from, FluidStack resource, boolean doFill) {
        if (resource == null) {
            return 0;
        }

        int totalUsed = 0;

        FluidStack liquid = tank.getFluid();

        if (liquid != null && liquid.amount > 0 && !liquid.isFluidEqual(resource)) {
            return 0;
        }

        while (tank != null && resource.amount > 0) {
            int used = tank.fill(resource, doFill);
            resource.amount -= used;

            totalUsed += used;
        }
        return totalUsed;
    }

    public FluidStack drain(ForgeDirection from, int maxEmpty, boolean doDrain) {
        return tank.drain(maxEmpty, doDrain);
    }

    public FluidStack drain(ForgeDirection from, FluidStack resource, boolean doDrain) {
        if(resource == null)
            return null;

        if(!resource.isFluidEqual(tank.getFluid()))
            return null;

        return drain(from, resource.amount, doDrain);
    }

    public boolean canFill(ForgeDirection from, Fluid fluid) {
        return true;
    }

    public boolean canDrain(ForgeDirection from, Fluid fluid) {
        return false;
    }

    public FluidTankInfo[] getTankInfo(ForgeDirection from) {
        return new FluidTankInfo[]{tank.getInfo()};
    }
}

package net.w00tc0d3.LiquidStorage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.fluids.*;

import java.util.HashMap;

public class TileFluidStorage extends TileEntity implements IFluidHandler {

    public final FluidTank tank = new FluidTank(FluidContainerRegistry.BUCKET_VOLUME * 2000000);
    private int ticks;

    @Override
    public void updateEntity() {
        if(worldObj.isRemote)
            return;

        ticks++;
        if(ticks == 100) {
            System.out.println("updateEntity()");
            this.worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
            ticks = 0;
        }
    }

    public HashMap returnFluidInfo() {
        HashMap<String, String> m = new HashMap<String, String>();
        String fluidName;
        if(this.tank != null && (this.tank.getFluid()) != null) {
            fluidName = new String(FluidRegistry.getFluidName(this.tank.getFluid()));
            m.put("fluid", fluidName.substring(0, 1).toUpperCase() + fluidName.substring(1));
            m.put("amount", Integer.toString(this.tank.getFluidAmount()));
        } else {
            m.put("fluid", "none");
            m.put("amount", Integer.toString(0));
        }
        return m;
    }

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

    @Override
    public void writeToNBT(NBTTagCompound nbt) {
        super.writeToNBT(nbt);
        tank.writeToNBT(nbt);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt) {
        super.readFromNBT(nbt);
        tank.readFromNBT(nbt);
    }

    @Override
    public Packet getDescriptionPacket() {
        NBTTagCompound tag = new NBTTagCompound();
        writeToNBT(tag);
        return new Packet132TileEntityData(xCoord, yCoord, zCoord, 1, tag);
    }

    @Override
    public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
        readFromNBT(packet.data);
        System.out.println("onDataPacket()");
    }
}

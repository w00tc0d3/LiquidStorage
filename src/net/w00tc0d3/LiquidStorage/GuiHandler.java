package net.w00tc0d3.LiquidStorage;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

/**
 * Created with IntelliJ IDEA.
 * User: w00tc0d3
 * Date: 9/22/13
 * Time: 5:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class GuiHandler implements IGuiHandler {
    /**
     * Returns a Server side Container to be displayed to the user.
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (!world.blockExists(x, y, z))
            return null;

        TileEntity tile = world.getBlockTileEntity(x, y, z);

        switch(ID) {
            case 0:
                if(!(tile instanceof TileFluidStorage))
                    return null;
                return new ContainerFluidStorage(player.inventory, (TileFluidStorage) tile);

            default:
                return null;
        }
    }

    /**
     * Returns a Container to be displayed to the user. On the client side, this
     * needs to return a instance of GuiScreen On the server side, this needs to
     * return a instance of Container
     *
     * @param ID     The Gui ID Number
     * @param player The player viewing the Gui
     * @param world  The current world
     * @param x      X Position
     * @param y      Y Position
     * @param z      Z Position
     * @return A GuiScreen/Container to be displayed to the user, null if none.
     */
    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        if (!world.blockExists(x, y, z))
            return null;

        TileEntity tile = world.getBlockTileEntity(x, y, z);

        switch(ID) {
            case 0:
                if(!(tile instanceof TileFluidStorage))
                    return null;
                return new GuiFluidStorage(player.inventory, (TileFluidStorage) tile);
            default:
                return null;
        }
    }
}

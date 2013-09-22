package net.w00tc0d3.LiquidStorage;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.world.World;

public class FluidStorageBlock extends BlockContainer {
    public FluidStorageBlock(int id) {
        super(id, Material.iron);
        setHardness(0.5F);
        setResistance(5F);
        setUnlocalizedName("fluidStorageBlock");
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    @Override
    public TileEntity createNewTileEntity(World world) {
        return null;
    }

    @Override
    public boolean hasTileEntity(int meta) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int meta) {
        return new TileFluidStorage();
    }

    @Override
    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World par1World, int xPar, int yPar, int zPar, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
        TileFluidStorage tileFluidStorage = (TileFluidStorage) par1World.getBlockTileEntity(xPar, yPar, zPar);

        if(tileFluidStorage != null) {
            par5EntityPlayer.openGui(LiquidStorage.liquidStorage, 0, par1World, xPar, yPar, zPar);
        }
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister register) {
        this.blockIcon = register.registerIcon(LiquidStorage.modid + ":fluidstorageblock");
    }
}

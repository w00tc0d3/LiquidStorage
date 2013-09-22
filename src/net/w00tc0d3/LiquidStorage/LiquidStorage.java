package net.w00tc0d3.LiquidStorage;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.w00tc0d3.LiquidStorage.PacketHandler;
import net.w00tc0d3.LiquidStorage.GuiHandler;

@Mod(name = "Liquid Storage", modid = LiquidStorage.modid, version = "0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { LiquidStorage.modid }, packetHandler = PacketHandler.class)
public class LiquidStorage {
    public final static String modid = "liquidstorage";
    public static GuiHandler guiHandler;

    @Mod.Instance(modid)
    public static LiquidStorage liquidStorage;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        final Block blockFluidStorage = new FluidStorageBlock(500);

        GameRegistry.registerBlock(blockFluidStorage, blockFluidStorage.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileFluidStorage.class, "tileFluidStorage");
        NetworkRegistry.instance().registerGuiHandler(this, guiHandler);
        LanguageRegistry.addName(blockFluidStorage, "Fluid Storage");
    }
}

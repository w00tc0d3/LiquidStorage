package net.w00tc0d3.LiquidStorage;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.block.Block;
import net.w00tc0d3.LiquidStorage.PacketHandler;

@Mod(name = "Liquid Storage", modid = LiquidStorage.modid, version = "0.3")
@NetworkMod(clientSideRequired = true, serverSideRequired = true, channels = { "liquidum" }, packetHandler = PacketHandler.class)
public class LiquidStorage {
    public final static String modid = "liquidstorage";

    @Mod.Instance(modid)
    public static LiquidStorage liquidStorage;

    public final static Block blockFluidStorage = new FluidStorageBlock(500);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerBlock(blockFluidStorage, blockFluidStorage.getUnlocalizedName());
        GameRegistry.registerTileEntity(TileFluidStorage.class, "tileFluidStorage");
        LanguageRegistry.addName(blockFluidStorage, "Fluid Storage");
    }
}
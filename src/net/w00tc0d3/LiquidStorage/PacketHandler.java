package net.w00tc0d3.LiquidStorage;

import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.Player;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;

/**
 * Created with IntelliJ IDEA.
 * User: w00tc0d3
 * Date: 9/22/13
 * Time: 5:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class PacketHandler implements IPacketHandler {
    /**
     * Recieve a packet from one of the registered channels for this packet handler
     *
     * @param manager The network manager this packet arrived from
     * @param packet  The packet itself
     * @param player  A dummy interface representing the player - it can be cast into a real player instance if needed
     */
    @Override
    public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player) {
    }
}

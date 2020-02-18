package com.nepjr.net;

import com.nepjr.te.TileEntityGeneratorBase;

import codechicken.lib.packet.PacketCustom;
import net.minecraft.entity.player.EntityPlayer;

public class ExNetDis {

    public static final String NET_CHANNEL = "nepstuff";

    public static void dispatchMachineUpdate(TileEntityGeneratorBase machineTile) {
        PacketCustom packet = new PacketCustom(NET_CHANNEL, 1);
        packet.writePos(machineTile.getPos());
        machineTile.writeUpdateData(packet);
        packet.sendToChunk(machineTile);
    }

    public static void dispatchGuiChanges(EntityPlayer player, TileEntityGeneratorBase machineTile, boolean isFullSync) {
        PacketCustom packet = new PacketCustom(NET_CHANNEL, 2);
        packet.writePos(machineTile.getPos());
        packet.writeBoolean(isFullSync);
        machineTile.writeGuiData(packet, isFullSync);
        packet.sendToPlayer(player);
    }

}
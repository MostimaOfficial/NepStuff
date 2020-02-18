package com.nepjr.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;

import java.awt.*;

import com.nepjr.net.ExNetDis;
import com.nepjr.te.TileEntityGeneratorBase;

public abstract class ContainerMachineBase<T extends TileEntityGeneratorBase> extends Container {

    protected final T machineTile;
    private boolean isFirstPacket;

    public ContainerMachineBase(T machineTile) {
        this.machineTile = machineTile;
    }

    protected abstract Point getPlayerInvOffset();

    protected void bindPlayerInventory(InventoryPlayer playerInventory) {

        Point offset = getPlayerInvOffset();
        int xOffset = offset.x;
        int yOffset = offset.y;

        for (int row = 0; row < 3; ++row) {
            for (int slot = 0; slot < 9; ++slot) {
                addSlotToContainer(new Slot(playerInventory, slot + row * 9 + 9, xOffset + slot * 18, yOffset + row * 18));
            }
        }

        for (int slot = 0; slot < 9; ++slot) {
            addSlotToContainer(new Slot(playerInventory, slot, xOffset + slot * 18, yOffset + 58));
        }
    }

    public T getTile() {
        return machineTile;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return !(machineTile instanceof IInventory) || ((IInventory) machineTile).isUsableByPlayer(playerIn);
    }

    @Override
    public void detectAndSendChanges() {
        super.detectAndSendChanges();

        for (IContainerListener listener : listeners) {
            if (listener instanceof EntityPlayer) {
                ExNetDis.dispatchGuiChanges(((EntityPlayer) listener), machineTile, isFirstPacket | machineTile.fullContainerSync);
            }
        }
        machineTile.fullContainerSync = false;
        isFirstPacket = false;
    }
}
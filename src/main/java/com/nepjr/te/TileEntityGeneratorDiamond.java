package com.nepjr.te;


import javax.annotation.Nullable;

import codechicken.lib.packet.PacketCustom;
import codechicken.lib.util.BlockUtils;
import codechicken.lib.util.ItemUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class TileEntityGeneratorDiamond extends TileEntityGeneratorBase implements IInventory {

    public static final int PRODUCTION_TICKS = 100;

    private ItemStack diamonds = ItemStack.EMPTY;
    private ItemStack ISDiamond = new ItemStack(Items.DIAMOND);
    private int progress;

    @Override
    public void doWork() {
        if (++progress >= PRODUCTION_TICKS) {
            if (diamonds.isEmpty()) {
                diamonds = ItemUtils.copyStack(ISDiamond, 1);
            } else if (ItemUtils.areStacksSameType(diamonds, ISDiamond)) {
                if (diamonds.getCount() < 64) {
                    diamonds.grow(1);
                }
            }
            progress = 0;
            markDirty();
        }
    }

    @Override
    protected void onWorkStopped() {
        progress = 0;
    }

    @Override
    protected boolean canWork() {
        return diamonds.isEmpty() || diamonds.getCount() < 64;
    }

    public int getProgress() {
        return progress;
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        super.readFromNBT(tag);
        if (tag.hasKey("diamonds")) {
            diamonds = new ItemStack(tag.getCompoundTag("diamonds"));
        }
        progress = tag.getInteger("Progress");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound tag) {
        tag.setInteger("Progress", progress);
        if (diamonds != null) {
            NBTTagCompound produce = new NBTTagCompound();
            diamonds.writeToNBT(produce);
            tag.setTag("Diamonds", produce);
        } else {
            tag.removeTag("Diamonds");
        }
        return super.writeToNBT(tag);
    }

    @Override
    public void writeGuiData(PacketCustom packet, boolean isFullSync) {
        packet.writeVarInt(progress);
    }

    @Override
    public void readGuiData(PacketCustom packet, boolean isFullSync) {
        progress = packet.readVarInt();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY || super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing side) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(new InvWrapper(this));
        }
        return super.getCapability(capability, side);
    }

    @Override
    public int getSizeInventory() {
        return 1;
    }

    @Override
    public boolean isEmpty() {
        return diamonds.isEmpty();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return diamonds;
    }

    @Override
    public ItemStack decrStackSize(int slot, int decrement) {
        if (diamonds.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            if (decrement < diamonds.getCount()) {
                ItemStack take = diamonds.splitStack(decrement);
                if (diamonds.getCount() <= 0) {
                    diamonds = ItemStack.EMPTY;
                }
                return take;
            } else {
                ItemStack take = diamonds;
                diamonds = ItemStack.EMPTY;
                return take;
            }
        }
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer player) {
        return world.getTileEntity(getPos()) == this && BlockUtils.isEntityInRange(getPos(), player, 64);
    }

    @Override
    public boolean isItemValidForSlot(int slot, ItemStack stack) {
        return false;
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public void setInventorySlotContents(int slot, ItemStack stack) {
        diamonds = stack;
    }

    @Override
    public String getName() {
        return "container.neutron";
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ItemStack removeStackFromSlot(int slot) {
        return ItemStack.EMPTY;
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {
    }

    @Override
    public int getFieldCount() {
        return 2;
    }

    @Override
    public void clear() {
    }

}
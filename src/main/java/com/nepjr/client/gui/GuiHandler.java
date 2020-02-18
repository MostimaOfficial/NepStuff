package com.nepjr.client.gui;

import com.nepjr.container.ContainerGeneratorDiamond;
import com.nepjr.te.TileEntityGeneratorDiamond;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int GEN_DIAMOND = 0;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		BlockPos pos = new BlockPos(x, y, z);
		TileEntity tile = world.getTileEntity(pos);
		switch (ID) {
		case 0: 
			return new ContainerGeneratorDiamond(player.inventory, ((TileEntityGeneratorDiamond) tile));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

}

package com.nepjr.blocks;

import com.nepjr.ModMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInvalid extends Block {
	public BlockInvalid() {
		super(Material.ROCK);
		setUnlocalizedName(ModMain.MODID + ".blockinvalid");
		setRegistryName("modblockinvalid");
	}

}

package com.nepjr.blocks;

import com.nepjr.ModMain;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInvalid extends Block {
	public BlockInvalid(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModMain.creativeTab);
	}

}

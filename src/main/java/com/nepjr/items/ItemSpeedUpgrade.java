package com.nepjr.items;

import com.nepjr.ModMain;

import net.minecraft.item.Item;

public class ItemSpeedUpgrade extends Item {
	
	public ItemSpeedUpgrade(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModMain.creativeTab);
		
	}

}

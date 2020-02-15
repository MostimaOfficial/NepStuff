package com.nepjr.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemInfinityCoal extends Item {
	
	public ItemInfinityCoal(String name) {
		super();
		setUnlocalizedName(name);
		setRegistryName(name);
	}
	
	public int getItemBurnTime(ItemStack itemstack) {
		return 2147483647;
	}

}

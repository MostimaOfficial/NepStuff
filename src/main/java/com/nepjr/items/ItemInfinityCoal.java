package com.nepjr.items;

import com.nepjr.ModMain;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;

public class ItemInfinityCoal extends Item implements IFuelHandler {
	
	public ItemInfinityCoal(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModMain.creativeTab);
	}
	
	@Override
	public int getBurnTime(ItemStack fuel) {
		return 63072000;
	}
	
	@Override
	public ItemInfinityCoal setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(ModMain.creativeTab);
			return this;
	}

}

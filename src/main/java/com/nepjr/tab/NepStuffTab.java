package com.nepjr.tab;

import com.nepjr.ModMain;
import com.nepjr.lib.ItemLib;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class NepStuffTab extends CreativeTabs {

	public NepStuffTab() {
		super(ModMain.MODID);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(ItemLib.iCoal);
	}

	@Override
	public boolean hasSearchBar() {
		return true;
	}

}

package com.nepjr.lib;

import com.nepjr.ModMain;
import com.nepjr.items.ItemInfinityCoal;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid=ModMain.MODID)
public class ItemLib {
	
	static Item infinityCoal;
	
	public static void itemInit() {
		infinityCoal = new ItemInfinityCoal("item_icoal");
	}
	
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().register((infinityCoal).setRegistryName(infinityCoal.getRegistryName()));
	}
}

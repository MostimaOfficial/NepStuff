package com.nepjr.lib;

import com.nepjr.ModMain;
import com.nepjr.items.ItemInfinityCoal;
import com.nepjr.items.ItemSpeedUpgrade;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod.EventBusSubscriber(modid=ModMain.MODID)
public class ItemLib {
	
	public static Item iCoal;
	public static Item upgradeSpeed;
	
	public static void init() {
		iCoal = new ItemInfinityCoal("infinity_coal");
		upgradeSpeed = new ItemSpeedUpgrade("speed_upgrade");
	}
	
	@SubscribeEvent
	public static void registerItem(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(iCoal);
		event.getRegistry().registerAll(upgradeSpeed);
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event) {
		registerRender(iCoal);
		registerRender(upgradeSpeed);
	}
	
	private static void registerRender(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation( item.getRegistryName(), "inventory"));
	}
	
	@EventHandler
	public static void initFuel() {
		GameRegistry.registerFuelHandler((IFuelHandler) iCoal);
	}
}

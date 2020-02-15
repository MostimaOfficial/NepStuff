package com.nepjr.lib;

import com.nepjr.ModMain;
import com.nepjr.blocks.BlockInvalid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid=ModMain.MODID)
public class BlockLib {
	
	static Block blockInvalid;
	
	public static void init() {
		blockInvalid = new BlockInvalid("invalid_block", Material.ROCK);
	}
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().registerAll(blockInvalid);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    	event.getRegistry().register(new ItemBlock(blockInvalid).setRegistryName(blockInvalid.getRegistryName()));
    }
    
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
    	registerItemRenders(Item.getItemFromBlock(blockInvalid));
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemRenders(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}
	
}
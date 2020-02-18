package com.nepjr.lib;

import com.nepjr.ModMain;
import com.nepjr.blocks.BlockDiamondGen;
import com.nepjr.blocks.BlockInvalid;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid=ModMain.MODID)
public class BlockLib {
	
	static Block blockInvalid;
	
	static BlockContainer blockDiamondGen;
	
	public static void init() {
		blockInvalid = new BlockInvalid("invalid_block", Material.ROCK);
		blockDiamondGen = new BlockDiamondGen("diamond_generator", Material.IRON);
	}
    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
    	event.getRegistry().registerAll(blockInvalid);
    	event.getRegistry().registerAll(blockDiamondGen);
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event) {
    	event.getRegistry().register(new ItemBlock(blockInvalid).setRegistryName(blockInvalid.getRegistryName()));
    	event.getRegistry().register(new ItemBlock(blockDiamondGen).setRegistryName(blockDiamondGen.getRegistryName()));
    	}
    
    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
    	registerItemRenders(Item.getItemFromBlock(blockInvalid));
    	registerItemRenders(Item.getItemFromBlock(blockDiamondGen));
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerItemRenders(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "normal"));
	}
	
}
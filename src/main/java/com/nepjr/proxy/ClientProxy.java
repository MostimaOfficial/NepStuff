package com.nepjr.proxy;

import com.nepjr.ModMain;
import com.nepjr.client.gui.GuiHandler;

import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent e) {
        super.preInit(e);
    }
    
    @Override
    public void init() {
    	NetworkRegistry.INSTANCE.registerGuiHandler(ModMain.instance, new GuiHandler());
    }
    
    @SubscribeEvent
    public static void registerModels(ModelRegistryEvent event) {
    }
}
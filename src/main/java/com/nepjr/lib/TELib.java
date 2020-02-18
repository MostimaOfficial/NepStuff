package com.nepjr.lib;

import com.nepjr.te.TileEntityGeneratorDiamond;

import net.minecraftforge.fml.common.registry.GameRegistry;

public class TELib {

	public static void regTE() {
		GameRegistry.registerTileEntity(TileEntityGeneratorDiamond.class, "nepsutff:gendia");
	}
	
}

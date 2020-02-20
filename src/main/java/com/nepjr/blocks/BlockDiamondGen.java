package com.nepjr.blocks;

import com.nepjr.ModMain;
import com.nepjr.te.TileEntityGeneratorDiamond;

import codechicken.lib.util.ItemUtils;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockDiamondGen extends BlockContainer {

	public BlockDiamondGen(String name, Material material) {
		super(material);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModMain.creativeTab);
	}	

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        if (world.isRemote) {
            return true;
        } else {
            player.openGui(ModMain.instance, 0, world, pos.getX(), pos.getY(), pos.getZ());
            return true;
        }
    }
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityGeneratorDiamond();
	}
	

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        TileEntityGeneratorDiamond collector = (TileEntityGeneratorDiamond) world.getTileEntity(pos);

        if (collector != null) {
            ItemUtils.dropInventory(world, pos, collector);
        }

        super.breakBlock(world, pos, state);
    }

}

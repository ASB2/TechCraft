package TechCraft.blocks;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.lib.SpecialPlayers;

public class BlockBurningFlower extends BlockFlower {


    public BlockBurningFlower(int par1, Material par3Material) {
        super(par1, par3Material);
        this.setCreativeTab(TechCraft.tabTechno);
    }

    @Override
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon("TechCraft:BlockBurningFlower");
    }	

    public void onEntityCollidedWithBlock(World par1World, int par2, int par3, int par4, Entity entity) {

        if(entity instanceof EntityPlayer) {

            if(!(SpecialPlayers.isSpecialPlayer(((EntityPlayer)entity).username))) {

                entity.attackEntityFrom(DamageSource.onFire, 1); 
            }
        }
        else {
            entity.attackEntityFrom(DamageSource.onFire, 1); 
        }
    }
}
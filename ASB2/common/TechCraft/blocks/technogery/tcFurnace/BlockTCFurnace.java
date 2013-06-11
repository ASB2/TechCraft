package TechCraft.blocks.technogery.tcFurnace;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import TechCraft.TechCraft;
import TechCraft.blocks.TechCraftContainers;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockTCFurnace extends TechCraftContainers {
    
    private TileTCFurnace tile;

    private Icon frontLit;
    private Icon frontUnlit;
    private Icon side;

    public BlockTCFurnace(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
        if(player.isSneaking())
            return false;

        super.onBlockActivated(world, x, y, z, player, par6, par7, par8, par9);
        player.openGui(TechCraft.instance, 2, world, x, y, z);
        return true;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {

        frontLit = par1IconRegister.registerIcon("TechCraft:BlockFurnaceTop"); 
        frontUnlit = par1IconRegister.registerIcon("TechCraft:BlockFurnaceTopoff");   
        side = par1IconRegister.registerIcon("TechCraft:ColoredBlack");
    }

    @Override
    public Icon getIcon(int side, int metadata) {

        switch(side) {

            case 1: {

                if(tile != null) {
                    
                    if(tile.isBurning) {
                        
                        return frontLit;
                    }
                    
                    else {
                        return frontUnlit;
                    }
                }
                
                else {
                    
                    return frontUnlit;
                }
            }

            default: return this.side;
        }

    }

    @Override
    public void randomDisplayTick(World world, int x, int y, int z, Random prng)
    {
        if(tile != null && tile.isBurning) {

            double yMod = (prng.nextDouble());            
            
            yMod += 1;
            
            world.spawnParticle("smoke", x + .5, y + yMod, z + .5, 0, 0, 0);
            world.spawnParticle("flame", x + .5, y + yMod, z + .5, 0, 0, 0);
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world) {
        tile = new TileTCFurnace();
        return tile;
    }

}

package TechCraft.blocks.technogery.power_Conduit;

import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import TechCraft.blocks.TechCraftContainers;
import TechCraft.blocks.TechCraftTile;
import TechCraft.power.IPowerMisc;

public class BlockPowerConduitMoving extends TechCraftContainers {

    TilePowerConduitMoving tile;

    public BlockPowerConduitMoving(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        
        if(tile != null) {

            if((TechCraftTile.getTilesNextTo(tile, world)) > 0) {

                if(tile.getNetwork() != null) {
                    
                tile.getNetwork().addConductorsAround(tile);
                tile.getNetwork().addSourceAround(tile);
                tile.getNetwork().addSinkAround(tile);
                }
            }
        }
        
        super.onBlockPlacedBy(world, x, y, z, entityLiving, itemStack);
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int sideHit, float hitX, float hitY, float hitZ, int metaData) {

        if(tile != null) {

            if((TechCraftTile.getTilesNextTo(tile, world)) > 0) {

                tile.getNetwork().addConductorsAround(tile);
                tile.getNetwork().addSourceAround(tile);
                tile.getNetwork().addSinkAround(tile);
            }
        }
        
        super.onBlockPlaced(world, x, y, z, sideHit, hitX, hitY, hitZ, metaData);
        return sideHit;
    }
    
    public void onNeighborBlockChange(World world, int x, int y, int z, int metadata) {

        if(tile != null) {

            if((TechCraftTile.getTilesNextTo(tile, world)) > 0) {

                tile.getNetwork().addConductorsAround(tile);
                tile.getNetwork().addSourceAround(tile);
                tile.getNetwork().addSinkAround(tile);
            }
        }
    }

    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int metaData) {

        if(tile != null) {
            
            TileEntity tileUP = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.DOWN);
            TileEntity tileDOWN = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.UP); 
            TileEntity tileNORTH = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.NORTH); 
            TileEntity tileSOUTH = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.SOUTH); 
            TileEntity tileWEST = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.WEST); 
            TileEntity tileEAST = TechCraftTile.translateDirectionToTile(tile, world, ForgeDirection.EAST); 

            if(tileUP != null) {

                if(this.tile != null && tileUP instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileUP);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileUP);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileUP);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }

            if(tileDOWN != null) {

                if(this.tile != null && tileDOWN instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileDOWN);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileDOWN);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileDOWN);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }

            if(tileNORTH != null) {

                if(this.tile != null && tileNORTH instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileNORTH);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileNORTH);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileNORTH);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }

            if(tileSOUTH != null) {

                if(this.tile != null && tileSOUTH instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileSOUTH);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileSOUTH);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileSOUTH);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }

            if(tileWEST != null) {

                if(this.tile != null && tileWEST instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileWEST);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileWEST);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileWEST);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }

            if(tileEAST != null) {

                if(this.tile != null && tileEAST instanceof IPowerMisc) {

                    IPowerMisc tileI = ((IPowerMisc)tileEAST);

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileEAST);
                    }

                    if(tileI.recievePower()) {

                        this.tile.getNetwork().addSink(tileEAST);
                    }

                    if(tileI instanceof TilePowerConduitMoving) {

                        this.tile.getNetwork().addConductor(((TilePowerConduitMoving)tileI));
                    }
                }
            }
        }
        super.onBlockDestroyedByPlayer(world, x, y, z, metaData);
    }

    @Override
    public TileEntity createNewTileEntity(World world) {

        tile = new TilePowerConduitMoving();        
        return tile;
    }

    /**
     * The type of render function that is called for this block
     */
    public int getRenderType()
    {
        return -1;
    }

    /**
     * Is this block (a) opaque and (B) a full 1m cube? This determines whether or not to render the shared face of two
     * adjacent blocks and also whether the player can attach torches, redstone wire, etc to this block.
     */
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return false;
    }

}
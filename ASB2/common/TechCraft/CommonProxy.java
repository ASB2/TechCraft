package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.technogery.farms.BasicFarm.ContainerBasicFarm;
import TechCraft.blocks.technogery.farms.BasicFarm.TileBasicFarm;
import TechCraft.blocks.technogery.tcChargeBench.ContainerTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcFurnace.ContainerTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.ContainerGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler{

    public void registerServerTickHandler(){
        //TickRegistry.registerTickHandler(new MyToolsTickHandlerServer(), Side.SERVER);
    }

    // Client stuff
    public void register() {

        // Nothing here as this is the server side proxy
    }

    public static int addArmor(String string) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        switch(ID){
            case 0: return new ContainerBasicFarm(player.inventory, (TileBasicFarm) tileEntity);
            case 1: return new ContainerGenorator(player.inventory, (TileGenorator) tileEntity);
            case 2: return new ContainerTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
            case 3: return new ContainerTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);            
            
        }

        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // TODO Auto-generated method stub
        return null;
    }
}

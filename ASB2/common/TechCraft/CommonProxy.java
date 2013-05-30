package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.tcRunes.ContainerRune;
import TechCraft.blocks.tcRunes.TileBasicRune;
import TechCraft.blocks.technogery.farms.BasicFarm.ContainerBasicFarm;
import TechCraft.blocks.technogery.farms.BasicFarm.TileBasicFarm;
import TechCraft.blocks.technogery.tcChargeBench.ContainerTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcFurnace.ContainerTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.ContainerGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcGrinder.ContainerTCGrinder;
import TechCraft.blocks.technogery.tcGrinder.TileTCGrinder;
import TechCraft.blocks.technogery.tcInfuser.ContainerTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcTeleporter.ContainerTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import cpw.mods.fml.common.network.IGuiHandler;
import TechCraft.blocks.tanks.*;

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

        if(tileEntity != null) {

            switch(ID){
                case 0: return new ContainerBasicFarm(player.inventory, (TileBasicFarm) tileEntity);
                case 1: return new ContainerGenorator(player.inventory, (TileGenorator) tileEntity);
                case 2: return new ContainerTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                case 3: return new ContainerTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);            
                case 4:return new ContainerRune(player.inventory, (TileBasicRune)tileEntity); 
                case 5:return new ContainerTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                case 6:return new ContainerTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                case 7:return new ContainerTCGrinder(player.inventory, (TileTCGrinder)tileEntity);
                case 8:return new ContainerTCTank(player.inventory, (TileTCTank)tileEntity);
            }
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        // TODO Auto-generated method stub
        return null;
    }
}

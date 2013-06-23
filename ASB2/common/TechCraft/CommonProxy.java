package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.tcRunes.ContainerRune;
import TechCraft.blocks.tcRunes.TileBasicRune;
import TechCraft.blocks.tcToolManager.ContainerToolManager;
import TechCraft.blocks.tcToolManager.TileToolManager;
import TechCraft.blocks.technogery.tcChargeBench.ContainerTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.ContainerTCEnergyConstructor;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
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
import TechCraft.items.gui.ContainerEnchancedDestructionCatalyst;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import TechCraft.blocks.tcItemExtractor.*;

public class CommonProxy implements IGuiHandler {

    public void registerServerTickHandler(){
        TickRegistry.registerTickHandler(new TechCraftTickHandlerServer(), Side.SERVER);
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

        if(ID >= 0) {

            if(tileEntity != null) {

                switch(ID){
                    case 1: return new ContainerGenorator(player.inventory, (TileGenorator) tileEntity);
                    case 2: return new ContainerTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                    case 3: return new ContainerTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);            
                    case 4:return new ContainerRune(player.inventory, (TileBasicRune)tileEntity); 
                    case 5:return new ContainerTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                    case 6:return new ContainerTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                    case 7:return new ContainerTCGrinder(player.inventory, (TileTCGrinder)tileEntity);
                    case 9:return new ContainerToolManager(player.inventory, (TileToolManager)tileEntity);
                    case 10:return new ContainerTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);
                    case 11:return new ContainerItemExtractor(player.inventory, (TileItemExtractor)tileEntity);
                }
            }
        }

        else {

            switch(ID) {

                case -1: return new ContainerEnchancedDestructionCatalyst(player);
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

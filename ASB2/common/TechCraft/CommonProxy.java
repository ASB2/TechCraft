package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import TechCraft.blocks.tcItemExtractor.ContainerItemExtractor;
import TechCraft.blocks.tcItemExtractor.TileItemExtractor;
import TechCraft.blocks.technogery.tcChargeBench.ContainerTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.ContainerTCEnergyConstructor;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFurnace.ContainerTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.ContainerGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcInfuser.ContainerTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcTeleporter.ContainerTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.blocks.technogery.tcWirelessEnergyManger.ContainerWirelessEnergyManager;
import TechCraft.blocks.technogery.tcWirelessEnergyManger.TileWirelessEnergyManager;
import TechCraft.items.gui.ContainerEnchancedDestructionCatalyst;
import TechCraft.power.IPowerMisc;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class CommonProxy implements IGuiHandler {

    public void registerServerTickHandler() {

        TickRegistry.registerTickHandler(new TechCraftTickHandlerServer(), Side.SERVER);
    }

    public void register() {
    }

    public static int addArmor(String string) {

        return 0;
    }

    public void renderBeam(TileEntity source, IPowerMisc tile) {
        
    }
    
    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if(ID >= 0) {

            if(tileEntity != null) {

                switch(ID) {

                    case 1: return new ContainerGenorator(player.inventory, (TileGenorator) tileEntity);
                    case 2: return new ContainerTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                    case 3: return new ContainerTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);            
                    case 5:return new ContainerTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                    case 6:return new ContainerTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                    case 10:return new ContainerTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);
                    case 11:return new ContainerItemExtractor(player.inventory, (TileItemExtractor)tileEntity);
                    case 12:return new ContainerWirelessEnergyManager(player.inventory, (TileWirelessEnergyManager)tileEntity);
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

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
import TechCraft.items.gui.ContainerEnchancedDestructionCatalyst;
import TechCraft.power.IPowerMisc;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;
import TechCraft.blocks.technogery.tcPlanter.*;

public class CommonProxy implements IGuiHandler {

    public void registerServerTickHandler() {

        TickRegistry.registerTickHandler(new TechCraftTickHandlerServer(), Side.SERVER);
    }

    public void register() {
    }

    public static int addArmor(String string) {

        return 0;
    }

    public void renderBeam(TileEntity source, IPowerMisc tile, int renderTime) {

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,int x, int y, int z) {

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if(ID >= 0) {

            if(tileEntity != null) {

                if(tileEntity instanceof TileGenorator) {

                    return new ContainerGenorator(player.inventory, (TileGenorator) tileEntity);
                }

                if(tileEntity instanceof TileTCFurnace) {

                    return new ContainerTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                }

                if(tileEntity instanceof TileTCChargeBench) {

                    return new ContainerTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity); 
                }

                if(tileEntity instanceof TileTCInfuser) {

                    return new ContainerTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                }

                if(tileEntity instanceof TileTCTeleporter) {

                    return new ContainerTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                }

                if(tileEntity instanceof TileTCEnergyConstructor) {

                    return new ContainerTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);
                }

                if(tileEntity instanceof TileItemExtractor) {

                    return new ContainerItemExtractor(player.inventory, (TileItemExtractor)tileEntity);
                }
                
                if(tileEntity instanceof TilePlanter) {

                    return new ContainerPlanter(player.inventory, (TilePlanter)tileEntity);
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

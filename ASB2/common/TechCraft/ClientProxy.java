package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import TechCraft.blocks.conduitInterface.items.GuiItemConduitInterface;
import TechCraft.blocks.conduitInterface.items.ItemRendererItemConduitInterface;
import TechCraft.blocks.conduitInterface.items.TileItemConduitInterface;
import TechCraft.blocks.conduitInterface.items.TileRendererItemConduitInterface;
import TechCraft.blocks.tanks.GuiTCTank;
import TechCraft.blocks.tanks.TileEntityRendererTileTank;
import TechCraft.blocks.tanks.TileTCTank;
import TechCraft.blocks.tcConduits.tcItemConduits.ItemRendererTCItemConduit;
import TechCraft.blocks.tcConduits.tcItemConduits.TileRendererTCItemConduit;
import TechCraft.blocks.tcConduits.tcItemConduits.TileTCItemConduit;
import TechCraft.blocks.tcDeepStorageCell.GuiDeepStorageCell;
import TechCraft.blocks.tcDeepStorageCell.TileDeepStorageCell;
import TechCraft.blocks.tcRunes.GuiRune;
import TechCraft.blocks.tcRunes.ItemRendererTileBasicRune;
import TechCraft.blocks.tcRunes.TileBasicRune;
import TechCraft.blocks.tcRunes.TileEntityRendererTileBasicRune;
import TechCraft.blocks.tcToolManager.GuiToolManager;
import TechCraft.blocks.tcToolManager.TileToolManager;
import TechCraft.blocks.technogery.TileEntityRendererTileTest;
import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.blocks.technogery.tcChargeBench.GuiTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.GuiTCEnergyConstructor;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFocus.ItemRendererTileTechnogryFocus;
import TechCraft.blocks.technogery.tcFocus.TileEntityRendererTileTechnogryFocus;
import TechCraft.blocks.technogery.tcFocus.TileTechnogryFocus;
import TechCraft.blocks.technogery.tcFurnace.GuiTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.GuiGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcGrinder.GuiTCGrinder;
import TechCraft.blocks.technogery.tcGrinder.TileTCGrinder;
import TechCraft.blocks.technogery.tcInfuser.GuiTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcSphere.ItemRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileEntityRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.GuiTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.items.gui.GuiEnchancedDestructionCatalyst;
import TechCraft.keybindings.TCKeyBindingM;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

    @Override
    public void register() {

        KeyBindingRegistry.registerKeyBinding(new TCKeyBindingM());
        TickRegistry.registerTickHandler(new TechCraftTickHandlerClient(), Side.CLIENT);
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileTCItemConduit.class, new TileRendererTCItemConduit());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCItemConduit.blockID, (IItemRenderer)new ItemRendererTCItemConduit());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTCEnergySphere.class, new TileEntityRendererMagicEnergySphere());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCEnergySphere.blockID, (IItemRenderer)new ItemRendererMagicEnergySphere());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTestBlock.class, new TileEntityRendererTileTest());
        //MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTestBlock.blockID, (IItemRenderer)new ItemRendererTestItem());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTechnogryFocus.class, new TileEntityRendererTileTechnogryFocus());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTechnogryFocus.blockID, (IItemRenderer)new ItemRendererTileTechnogryFocus());

        ClientRegistry.bindTileEntitySpecialRenderer(TileBasicRune.class, new TileEntityRendererTileBasicRune());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockBasicRune.blockID, (IItemRenderer)new ItemRendererTileBasicRune()); 
        ClientRegistry.bindTileEntitySpecialRenderer(TileTCTank.class, new TileEntityRendererTileTank());

        ClientRegistry.bindTileEntitySpecialRenderer(TileItemConduitInterface.class, new TileRendererItemConduitInterface());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockItemConduitInterface.blockID, (IItemRenderer)new ItemRendererItemConduitInterface()); 
    }



    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if(ID >= 0) {

            if(tileEntity != null) {

                switch(ID) {
                    case 1: return new GuiGenorator(player.inventory, (TileGenorator) tileEntity);
                    case 2: return new GuiTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                    case 3: return new GuiTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);
                    case 4: return new GuiRune(player.inventory, (TileBasicRune)tileEntity);
                    case 5: return new GuiTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                    case 6: return new GuiTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                    case 7: return new GuiTCGrinder(player.inventory, (TileTCGrinder)tileEntity);
                    case 8: return new GuiTCTank(player.inventory, (TileTCTank)tileEntity);
                    case 9: return new GuiToolManager(player.inventory, (TileToolManager)tileEntity);
                    case 10: return new GuiTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);             
                    case 11: return new GuiItemConduitInterface(player.inventory, (TileItemConduitInterface)tileEntity);  
                    case 12: return new GuiDeepStorageCell(player.inventory, (TileDeepStorageCell)tileEntity);  
                    //case 1: return new GuiCrafting(player.inventory, world, x, y, z);            

                    //case 4: return new GuiMagicGauntlet(player);
                }
            }
        }

        else {
            switch(ID) {

                case -1: return new GuiEnchancedDestructionCatalyst(player);
            }
        }
        return null;
    }





}

package TechCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import TechCraft.blocks.tcConduits.tcItemConduits.ItemRendererTCItemConduit;
import TechCraft.blocks.tcConduits.tcItemConduits.TileRendererTCItemConduit;
import TechCraft.blocks.tcConduits.tcItemConduits.TileTCItemConduit;
import TechCraft.blocks.tcItemExtractor.GuiItemExtractor;
import TechCraft.blocks.tcItemExtractor.ItemRendererItemExtractor;
import TechCraft.blocks.tcItemExtractor.TileItemExtractor;
import TechCraft.blocks.tcItemExtractor.TileRendererItemExtractor;
import TechCraft.blocks.technogery.TileEntityRendererTileTest;
import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.blocks.technogery.tcChargeBench.GuiTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcEnergyConstructor.GuiTCEnergyConstructor;
import TechCraft.blocks.technogery.tcEnergyConstructor.TileTCEnergyConstructor;
import TechCraft.blocks.technogery.tcFurnace.GuiTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.GuiGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcInfuser.GuiTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.ItemRendererInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileRendererInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcSphere.ItemRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileEntityRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.GuiTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.blocks.technogery.tcWirelessEnergyManger.GuiWirelessEnergyManager;
import TechCraft.blocks.technogery.tcWirelessEnergyManger.TileWirelessEnergyManager;
import TechCraft.fx.FXBeam;
import TechCraft.items.gui.GuiEnchancedDestructionCatalyst;
import TechCraft.keybindings.TCKeyBindingM;
import TechCraft.power.IPowerMisc;
import TechCraft.vector.Vector3;
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

        ClientRegistry.bindTileEntitySpecialRenderer(TileItemExtractor.class, new TileRendererItemExtractor());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockItemExtractor.blockID, (IItemRenderer)new ItemRendererItemExtractor()); 

        ClientRegistry.bindTileEntitySpecialRenderer(TileTCInfuser.class, new TileRendererInfuser());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCInfuser.blockID, (IItemRenderer)new ItemRendererInfuser()); 
    }

    public void renderBeam(TileEntity source, IPowerMisc tile) {
        FXBeam beam;

        int coords[] = tile.getPosition();
        int renderTime = 10;

        beam = new FXBeam(source.worldObj, new Vector3(source.xCoord + .5, source.yCoord + .5, source.zCoord + .5), new Vector3(coords[0] + .5, coords[1] + .5, coords[2] + .5), 1, 1, 1, renderTime, 20F);
        Minecraft.getMinecraft().effectRenderer.addEffect(beam);        
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
                    case 5: return new GuiTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                    case 6: return new GuiTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                    case 10: return new GuiTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);             
                    case 11: return new GuiItemExtractor(player.inventory, (TileItemExtractor)tileEntity);  
                    case 12: return new GuiWirelessEnergyManager(player.inventory, (TileWirelessEnergyManager)tileEntity);  
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

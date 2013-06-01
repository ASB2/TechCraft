package TechCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import TechCraft.blocks.item_transfer_wireless.TileItemReciever;
import TechCraft.blocks.tanks.GuiTCTank;
import TechCraft.blocks.tanks.TileTCTank;
import TechCraft.blocks.tcRunes.GuiRune;
import TechCraft.blocks.tcRunes.TileBasicRune;
import TechCraft.blocks.technogery.TileTechnogryFocus;
import TechCraft.blocks.technogery.TileTestBlock;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitExporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;
import TechCraft.blocks.technogery.farms.BasicFarm.GuiBasicFarm;
import TechCraft.blocks.technogery.farms.BasicFarm.TileBasicFarm;
import TechCraft.blocks.technogery.tcChargeBench.GuiTCChargeBench;
import TechCraft.blocks.technogery.tcChargeBench.TileTCChargeBench;
import TechCraft.blocks.technogery.tcFurnace.GuiTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.GuiGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcGrinder.GuiTCGrinder;
import TechCraft.blocks.technogery.tcGrinder.TileTCGrinder;
import TechCraft.blocks.technogery.tcInfuser.GuiTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.GuiTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.renders.ItemRendererMagicConduitExporting;
import TechCraft.renders.ItemRendererMagicConduitImporting;
import TechCraft.renders.ItemRendererMagicConduitMoving;
import TechCraft.renders.ItemRendererMagicEnergySphere;
import TechCraft.renders.ItemRendererTileBasicRune;
import TechCraft.renders.ItemRendererTileItemReciever;
import TechCraft.renders.ItemRendererTileTechnogryFocus;
import TechCraft.renders.TileEntityRendererMagicConduitExporting;
import TechCraft.renders.TileEntityRendererMagicConduitImporting;
import TechCraft.renders.TileEntityRendererMagicConduitMoving;
import TechCraft.renders.TileEntityRendererMagicEnergySphere;
import TechCraft.renders.TileEntityRendererTileBasicRune;
import TechCraft.renders.TileEntityRendererTileItemReciever;
import TechCraft.renders.TileEntityRendererTileTechnogryFocus;
import TechCraft.renders.TileEntityRendererTileTest;
import cpw.mods.fml.client.registry.ClientRegistry;

public class ClientProxy extends CommonProxy {

    @Override
    public void register() {

        //KeyBindingRegistry.registerKeyBinding(new MyToolsKeyBindings());

        //MinecraftForgeClient.registerItemRenderer(ItemRegistry.ItemMagicGauntlet.itemID,  (IItemRenderer)new ItemRendererMagicGauntlet());

        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicConduitImporting.class, new TileEntityRendererMagicConduitImporting());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockMagicConduitImporting.blockID, (IItemRenderer)new ItemRendererMagicConduitImporting());

        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicConduitExporting.class, new TileEntityRendererMagicConduitExporting());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockMagicConduitExporting.blockID, (IItemRenderer)new ItemRendererMagicConduitExporting());

        ClientRegistry.bindTileEntitySpecialRenderer(TileMagicConduitMoving.class, new TileEntityRendererMagicConduitMoving());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockMagicConduitMoving.blockID, (IItemRenderer)new ItemRendererMagicConduitMoving());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTCEnergySphere.class, new TileEntityRendererMagicEnergySphere());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCEnergySphere.blockID, (IItemRenderer)new ItemRendererMagicEnergySphere());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTestBlock.class, new TileEntityRendererTileTest());
        //MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTestBlock.blockID, (IItemRenderer)new ItemRendererTestItem());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTechnogryFocus.class, new TileEntityRendererTileTechnogryFocus());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTechnogryFocus.blockID, (IItemRenderer)new ItemRendererTileTechnogryFocus());

        ClientRegistry.bindTileEntitySpecialRenderer(TileBasicRune.class, new TileEntityRendererTileBasicRune());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockBasicRune.blockID, (IItemRenderer)new ItemRendererTileBasicRune()); 
        
        ClientRegistry.bindTileEntitySpecialRenderer(TileItemReciever.class, new TileEntityRendererTileItemReciever());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockBasicRune.blockID, (IItemRenderer)new ItemRendererTileItemReciever()); 
    }



    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        
        if(tileEntity != null) {
            switch(ID){
                case 0: return new GuiBasicFarm(player.inventory, (TileBasicFarm) tileEntity);
                case 1: return new GuiGenorator(player.inventory, (TileGenorator) tileEntity);
                case 2: return new GuiTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                case 3: return new GuiTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);
                case 4: return new GuiRune(player.inventory, (TileBasicRune)tileEntity);
                case 5: return new GuiTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                case 6: return new GuiTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                case 7: return new GuiTCGrinder(player.inventory, (TileTCGrinder)tileEntity);
                case 8: return new GuiTCTank(player.inventory, (TileTCTank)tileEntity);
                //case 1: return new GuiCrafting(player.inventory, world, x, y, z);            

                //case 4: return new GuiMagicGauntlet(player);
            }
        }
        return null;
    }





}

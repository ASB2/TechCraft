package TechCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
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
import TechCraft.blocks.technogery.tcEnergySender.ItemRendererEnergySender;
import TechCraft.blocks.technogery.tcEnergySender.TileEnergySender;
import TechCraft.blocks.technogery.tcEnergySender.TileRendererEnergySender;
import TechCraft.blocks.technogery.tcFurnace.GuiTCFurnace;
import TechCraft.blocks.technogery.tcFurnace.TileTCFurnace;
import TechCraft.blocks.technogery.tcGenorator.GuiGenorator;
import TechCraft.blocks.technogery.tcGenorator.TileGenorator;
import TechCraft.blocks.technogery.tcInfuser.GuiTCInfuser;
import TechCraft.blocks.technogery.tcInfuser.ItemRendererInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileRendererInfuser;
import TechCraft.blocks.technogery.tcInfuser.TileTCInfuser;
import TechCraft.blocks.technogery.tcPlanter.GuiPlanter;
import TechCraft.blocks.technogery.tcPlanter.TilePlanter;
import TechCraft.blocks.technogery.tcSphere.ItemRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileEntityRendererMagicEnergySphere;
import TechCraft.blocks.technogery.tcSphere.TileTCEnergySphere;
import TechCraft.blocks.technogery.tcTeleporter.GuiTCTeleporter;
import TechCraft.blocks.technogery.tcTeleporter.TileTCTeleporter;
import TechCraft.fx.FXBeam;
import TechCraft.items.gui.GuiEnchancedDestructionCatalyst;
import TechCraft.keybindings.TCKeyBindingM;
import TechCraft.power.IPowerMisc;
import TechCraft.vector.Vector3;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

    @Override
    public void register() {

        KeyBindingRegistry.registerKeyBinding(new TCKeyBindingM());
        TickRegistry.registerTickHandler(new TechCraftTickHandlerClient(), Side.CLIENT);

        ClientRegistry.bindTileEntitySpecialRenderer(TileTCEnergySphere.class, new TileEntityRendererMagicEnergySphere());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCEnergySphere.blockID, (IItemRenderer)new ItemRendererMagicEnergySphere());

        ClientRegistry.bindTileEntitySpecialRenderer(TileTestBlock.class, new TileEntityRendererTileTest());
        //MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTestBlock.blockID, (IItemRenderer)new ItemRendererTestItem());

        ClientRegistry.bindTileEntitySpecialRenderer(TileItemExtractor.class, new TileRendererItemExtractor());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockItemExtractor.blockID, (IItemRenderer)new ItemRendererItemExtractor()); 

        ClientRegistry.bindTileEntitySpecialRenderer(TileTCInfuser.class, new TileRendererInfuser());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockTCInfuser.blockID, (IItemRenderer)new ItemRendererInfuser()); 

        ClientRegistry.bindTileEntitySpecialRenderer(TileEnergySender.class, new TileRendererEnergySender());
        MinecraftForgeClient.registerItemRenderer(BlockRegistry.BlockEnergySender.blockID, (IItemRenderer)new ItemRendererEnergySender()); 

    }

    public void renderBeam(TileEntity source, IPowerMisc tile, int renderTime) {
        FXBeam beam;

        int coords[] = tile.getPosition();

        beam = new FXBeam(source.worldObj, new Vector3(source.xCoord + .5, source.yCoord + .5, source.zCoord + .5), new Vector3(coords[0] + .5, coords[1] + .5, coords[2] + .5), 1, 1, 1, renderTime, 20F);
        Minecraft.getMinecraft().effectRenderer.addEffect(beam);        
    }

    public void sendChatMessage(String message) {
        
        FMLClientHandler.instance().getClient();
        this.sendChatToPlayer(Minecraft.getMinecraft().thePlayer, message);
    }
    
    public void sendChatToPlayer(EntityPlayer player, String message) {

        if(!player.worldObj.isRemote)
            player.addChatMessage(message);
    }

    public void renderTexture(ResourceLocation texture) {

        FMLClientHandler.instance().getClient().renderEngine.func_110577_a(texture);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z){

        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);

        if(ID >= 0) {

            if(tileEntity != null) {

                if(tileEntity instanceof TileGenorator) {

                    return new GuiGenorator(player.inventory, (TileGenorator) tileEntity);
                }

                if(tileEntity instanceof TileTCFurnace) {

                    return new GuiTCFurnace(player.inventory, (TileTCFurnace)tileEntity);
                }

                if(tileEntity instanceof TileTCChargeBench) {

                    return new GuiTCChargeBench(player.inventory, (TileTCChargeBench)tileEntity);
                }

                if(tileEntity instanceof TileTCInfuser) {

                    return new GuiTCInfuser(player.inventory, (TileTCInfuser)tileEntity);
                }

                if(tileEntity instanceof TileTCTeleporter) {

                    return new GuiTCTeleporter(player.inventory, (TileTCTeleporter)tileEntity);
                }

                if(tileEntity instanceof TileTCEnergyConstructor) {

                    return new GuiTCEnergyConstructor(player.inventory, (TileTCEnergyConstructor)tileEntity);        
                }

                if(tileEntity instanceof TileItemExtractor) {

                    return new GuiItemExtractor(player.inventory, (TileItemExtractor)tileEntity);  
                }

                if(tileEntity instanceof TilePlanter) {

                    return new GuiPlanter(player.inventory, (TilePlanter)tileEntity);  
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

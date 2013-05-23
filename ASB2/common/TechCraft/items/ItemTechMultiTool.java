package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import TechCraft.modes.ModeBase;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTechMultiTool extends TechCraftItems{

    public ItemTechMultiTool(int par1) {
        super(par1);
        
    }

    
    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTechMultiTool");
        
    }
    
    int mode = 3;

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {   
        if(!par2World.isRemote){
            if(!par3EntityPlayer.isSneaking()){

                ModeBase.getMode(mode).onRightClick(par1ItemStack, par2World, par3EntityPlayer);
            }

            else{

                ModeBase.getMode(mode).onShiftRightClick(par1ItemStack, par2World, par3EntityPlayer);
            }  
        }

        return par1ItemStack;
    }

    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int par7, float par8, float par9, float par10)
    {
        if(!world.isRemote){

            if(!player.isSneaking()){

                ModeBase.getMode(mode).onRightClickOnBlock(par1ItemStack, player, world, par7, par7, par7, par7, par10, par10, par10);
            }

            else{

                ModeBase.getMode(mode).onShiftClickOnBlock(par1ItemStack, player, world, par7, par7, par7, par7, par10, par10, par10);
            }       
        }
        return true;
    }

    public boolean hitEntity(ItemStack par1ItemStack, EntityLiving par2EntityLiving, EntityLiving par3EntityLiving)
    {
        ModeBase.getMode(mode).onHitEntity(par1ItemStack, par2EntityLiving, par3EntityLiving);
        return true;
    }

    public boolean onBlockDestroyed(ItemStack par1ItemStack, World par2World, int par3, int par4, int par5, int par6, EntityLiving par7EntityLiving)
    {
        if(!par2World.isRemote){
            ModeBase.getMode(mode).onBlockDestroyed(par1ItemStack, par2World, par6, par6, par6, par6, par7EntityLiving);
        }
        return true;
    }

    public ItemStack onEaten(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
    {
        return ModeBase.getMode(mode).onEaten(par1ItemStack, par2World, par3EntityPlayer);
    }
    public void onUpdate(ItemStack par1ItemStack, World par2World, Entity par3Entity, int par4, boolean par5) {

        ModeBase.getMode(mode).onUpdate(par1ItemStack, par2World, par3Entity, par4, par5);        
    }

    public EnumAction getItemUseAction(ItemStack par1ItemStack)
    {

        return ModeBase.getMode(mode).getItemUseAction(par1ItemStack);
    }

    public void onPlayerStoppedUsing(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer, int par4) {
        
        ModeBase.getMode(mode).onPlayerStoppedUsing(par1ItemStack, par2World, par3EntityPlayer, par4);
    }

    public boolean onItemUseFirst(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {        
        
        return ModeBase.getMode(mode).onItemUseFirst(stack, player, world, side, side, side, side, hitZ, hitZ, hitZ);
    }

    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
    {

        return ModeBase.getMode(mode).onBlockStartBreak(itemstack, Z, Z, Z, player);
    }

    public void onUsingItemTick(ItemStack stack, EntityPlayer player, int count)
    {
        ModeBase.getMode(mode).onUsingItemTick(stack, player, count);
    }

    public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {

        return ModeBase.getMode(mode).onLeftClickEntity(stack, player, entity);
    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return ModeBase.getMode(mode).hasEffect(par1ItemStack);
    }

}

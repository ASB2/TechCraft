package TechCraft.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemTeleporter extends TechCraftItems{

    protected int magicMax = 100;
    protected int magicStored;
    protected double x = 0;
    protected double y = 0;
    protected double z = 0;
    protected boolean coodsSet = false;

    public ItemTeleporter(int par1) {
        super(par1);
        setMaxStackSize(1);

    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemTeleporter");
    }

    public void onCreated(ItemStack par1ItemStack, World par2World, EntityPlayer player) {
        this.setXCoord(par1ItemStack,player.posX);
        this.setYCoord(par1ItemStack,player.posY);
        this.setZCoord(par1ItemStack,player.posZ);
        setCoodsSet(par1ItemStack, true);
    }

    public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
    {
        if(!isCoodsSet(par1ItemStack)){
            this.setXCoord(par1ItemStack,player.posX);
            this.setYCoord(par1ItemStack,player.posY);
            this.setZCoord(par1ItemStack,player.posZ);
            setCoodsSet(par1ItemStack, true);
        }
        if(isCoodsSet(par1ItemStack)){
            player.setPositionAndUpdate(this.getXCoord(par1ItemStack),this.getYCoord(par1ItemStack) , this.getZCoord(par1ItemStack));

        }
        return par1ItemStack;
    }


    @SuppressWarnings("unchecked")
    @Override
    public void addInformation(ItemStack par1ItemStack, EntityPlayer player,@SuppressWarnings("rawtypes") List info, boolean b){
        if(isCoodsSet(par1ItemStack)){
            //info.add("You will be teleported to x: "+this.getXCoord(par1ItemStack)+" y: "+this.getYCoord(par1ItemStack) +" z:"+this.getZCoord(par1ItemStack));
        }
        if(!isCoodsSet(par1ItemStack)){
            info.add("Link not set.");
        }
    }



    public boolean isCoodsSet(ItemStack item) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if (nbtTagCompound != null){
            return nbtTagCompound.getBoolean("coodsSet");
        }
        return coodsSet;
    }

    public void setCoodsSet(ItemStack item,boolean coodsSet) {
        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setBoolean("coodsSet", coodsSet);        
    }

    public double getXCoord(ItemStack item) {
        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if (nbtTagCompound != null){
            return nbtTagCompound.getDouble("X");
        }
        return 0;
    }

    public void setXCoord(ItemStack item, double x) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setDouble("X", x);
    }

    public double getYCoord(ItemStack item) {
        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if (nbtTagCompound != null){
            return nbtTagCompound.getDouble("Y");
        }
        return 0;
    }

    public void setYCoord(ItemStack item, double y) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setDouble("Y", y);
    }

    public double getZCoord(ItemStack item) {
        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if (nbtTagCompound != null){
            return nbtTagCompound.getDouble("Z");
        }
        return 0;
    }

    public void setZCoord(ItemStack item, double z) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setDouble("Z", z);
    }

    public int getMagicStored(ItemStack item) {
        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if (nbtTagCompound != null){
            return nbtTagCompound.getInteger("magicStored");
        }
        return 0;
    }

    public void setMagicStored(ItemStack item, int magicStored) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setInteger("magicStored", magicStored);
    }

    public int getMagicMax(ItemStack item) {
        return magicMax;
    }

    public void setMagicMax(ItemStack item, int magicMax) {
        this.magicMax = magicMax;
    }

}

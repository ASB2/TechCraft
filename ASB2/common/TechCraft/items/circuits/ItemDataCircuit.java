package TechCraft.items.circuits;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import TechCraft.items.*;
import TechCraft.circuits.*;

public class ItemDataCircuit extends TechCraftItems implements ISimpleDataCircuit {

    static int maxTypes = 1;
    static int maxData = 10000;

    public ItemDataCircuit(int id) {
        super(id);
        this.setMaxStackSize(1);
    }

    @Override
    public void registerIcons(IconRegister iconRegister){

        itemIcon = iconRegister.registerIcon("TechCraft:ItemCircuitData");
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, java.util.List info, boolean var1) 
    {
        super.addInformation(itemStack, player, info, var1);
        info.add("Type ID: " + getType(itemStack));
        info.add("Stored Data: " + getStoredData(itemStack) + " / " + getMaximumData(itemStack));
    }

    @Override
    public boolean setType(ItemStack itemStack, int blockOrItemID) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(itemStack);

        if(!nbtTagCompound.hasKey("type")) {

            nbtTagCompound.setInteger("type", blockOrItemID);
            return true;
        }
        return false;
    }

    @Override
    public int getType(ItemStack itemStack) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(itemStack);

        if(nbtTagCompound.hasKey("type")) {

            return nbtTagCompound.getInteger("type");
        }
        return 0;
    }

    @Override
    public int getMaxTypes(ItemStack itemStack) {

        return maxTypes;
    }

    @Override
    public boolean setStoredData(ItemStack itemStack, int amount, boolean adding) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(itemStack);

        if(adding) {

            if(this.getMaximumData(itemStack) - this.getStoredData(itemStack) >= amount) {

                nbtTagCompound.setInteger("typeAmount", amount);
                return true;
            }
        }
        else {

            if(this.getStoredData(itemStack) >= amount) {

                nbtTagCompound.setInteger("typeAmount", amount);
                return true;
            }
        }
        return false;
    }

    @Override
    public int getStoredData(ItemStack itemStack) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(itemStack);

        return nbtTagCompound.getInteger("typeAmount");
    }

    @Override
    public int getMaximumData(ItemStack itemStack) {

        return maxData;
    }
}

package TechCraft.items.technogery;

import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import TechCraft.items.NBTCompoundHelper;
import TechCraft.items.TechCraftItems;
import TechCraft.power.IPowerItems;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnergyBlob extends TechCraftItems implements IPowerItems {

    int powerStored;
    int powerMax = 100;

    int powerToMove = 5;

    public ItemEnergyBlob(int par1) {
        super(par1);
        setMaxStackSize(1);        
    }

    @Override
    public void registerIcons(IconRegister iconRegister) {

        itemIcon = iconRegister.registerIcon("TechCraft:ItemEnergyBlob");
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(!world.isRemote) {
            player.sendChatToPlayer("Power stored: " + this.getPowerStored(itemStack) +" / " + this.getPowerMax(itemStack));
        }
        return itemStack;
    }

    @Override
    public boolean onItemUseFirst(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {

        return false;
    }

    @Override
    public int getPowerStored(ItemStack item) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        if(nbtTagCompound != null)

            return nbtTagCompound.getInteger("powerStored");

        return powerStored;
    }

    @Override
    public int getPowerMax(ItemStack item) {

        //NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        //if(nbtTagCompound != null)
        //return nbtTagCompound.getInteger("powerMax");

        return powerMax;
    }

    @Override
    public void usePower(int PowerUsed, ItemStack item) {
        if(this.getPowerStored(item) > PowerUsed) {

            this.setPowerStored(item, this.getPowerStored(item) - PowerUsed);
        }
    }

    @Override
    public void gainPower(int PowerGained, ItemStack item) {

        if(this.getPowerMax(item) - this.getPowerStored(item) >= PowerGained){            

            this.setPowerStored(item, this.getPowerStored(item) + PowerGained);
        }
    }

    private void setPowerStored(ItemStack item,int power) {

        NBTTagCompound nbtTagCompound = NBTCompoundHelper.getTAGfromItemstack(item);
        nbtTagCompound.setInteger("powerStored", power);

        this.powerStored = power;
    }

    @Override
    public String getName() {

        return "Energy Blob";
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List info, boolean var1) {
        super.addInformation(itemStack, player, info, var1);
        info.add("Power stored: " + this.getPowerStored(itemStack) +" / " + this.getPowerMax(itemStack));
        info.add("A basic device for storing power.");
    }

}

package TechCraft.items;

import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumMovingObjectType;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import TechCraft.power.IPowerMisc;
import TechCraft.utils.UtilDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTestItem extends TechCraftItems {

    public ItemTestItem(int par1) {
        super(par1);

    }

    int mode = 1;

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack par1ItemStack)
    {
        return true;
    }

    int length = 5;

    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
    {
        if(player.isSneaking()){

            if(world.isRemote)
                length = length - 1;

            if(!world.isRemote)
                player.sendChatToPlayer("Length = " + length);

            return itemStack;
        }        

        if(!world.isRemote) {
            
            switch(this.mode) {

                case 0: {

                    Vec3 look = player.getLookVec();
                    EntityLargeFireball fireball2 = new EntityLargeFireball(world, player, 1, 2, 1);
                    fireball2.setPosition(
                            player.posX + look.xCoord * 1,
                            player.posY + look.yCoord * 2,
                            player.posZ + look.zCoord * 1);
                    fireball2.accelerationX = look.xCoord * .1;
                    fireball2.accelerationY = look.yCoord * .1;
                    fireball2.accelerationZ = look.zCoord * .1;
                    world.spawnEntityInWorld(fireball2);

                    return itemStack;
                }

                case 1: {

                    float f = 1.0F;
                    float f1 = player.prevRotationPitch + (player.rotationPitch - player.prevRotationPitch) * f;
                    float f2 = player.prevRotationYaw + (player.rotationYaw - player.prevRotationYaw) * f;
                    double d = player.prevPosX + (player.posX - player.prevPosX) * (double)f;
                    double d1 = (player.prevPosY + (player.posY - player.prevPosY) * (double)f + 1.6200000000000001D) - (double)player.yOffset;
                    double d2 = player.prevPosZ + (player.posZ - player.prevPosZ) * (double)f;
                    Vec3 vec3d = Vec3.createVectorHelper(d, d1, d2);
                    float f3 = MathHelper.cos(-f2 * 0.01745329F - (float)Math.PI);
                    float f4 = MathHelper.sin(-f2 * 0.01745329F - (float)Math.PI);
                    float f5 = -MathHelper.cos(-f1 * 0.01745329F);
                    float f6 = MathHelper.sin(-f1 * 0.01745329F);
                    float f7 = f4 * f5;
                    float f8 = f6;
                    float f9 = f3 * f5;
                    double d3 = 5000D;
                    Vec3 vec3d1 = vec3d.addVector((double)f7 * d3, (double)f8 * d3, (double)f9 * d3);
                    MovingObjectPosition movingobjectposition = world.rayTraceBlocks_do_do(vec3d, vec3d1, false, true);
                    if (movingobjectposition == null)
                    {
                    }
                    if (movingobjectposition.typeOfHit == EnumMovingObjectType.TILE)
                    {
                        int i = movingobjectposition.blockX;
                        int j = movingobjectposition.blockY;
                        int k = movingobjectposition.blockZ;
                        world.spawnEntityInWorld(new EntityLightningBolt(world, i, j, k));
                    }
                    return itemStack;
                }
            }
    }
    return itemStack;
}

public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer player, World world, int x, int y, int z, int side, float hitx, float hity, float hitz){

    int power = 10;

    if(world.getBlockTileEntity(x,y,z) instanceof IPowerMisc){

        IPowerMisc mTile = (IPowerMisc) world.getBlockTileEntity(x, y, z);

        if(!player.isSneaking()){

            mTile.getPowerProvider().gainPower(power, UtilDirection.translateNumberToDirection(side));
            player.sendChatToPlayer("Applied "+power+" Power");

        }
        else{   
            mTile.getPowerProvider().usePower(power, UtilDirection.translateNumberToDirection(side));
            player.sendChatToPlayer("Drew "+power+" Power");
        }
    }
    return true;        
}
}

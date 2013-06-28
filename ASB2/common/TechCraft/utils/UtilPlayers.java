package TechCraft.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import TechCraft.TechCraft;

public class UtilPlayers {

    private static String[] specialPlayers = new String[] {"ASB2", "Proswhere", "iOverpowered"};

    public static boolean hasItemStack(EntityPlayer player, ItemStack itemStack) {

        if(itemStack != null) {

            for(int i = 0; i < player.inventory.getSizeInventory(); i++ ) {

                if(player.inventory.getStackInSlot(i) != null) {

                    if(player.inventory.getStackInSlot(i).equals(itemStack)) {

                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int slotWithItem(EntityPlayer player, ItemStack itemStack) {

        if(itemStack != null) {

            for(int i = 0; i < player.inventory.getSizeInventory(); i++ ) {

                if(player.inventory.getStackInSlot(i) != null) {

                    if(player.inventory.getStackInSlot(i).equals(itemStack)) {

                        return i;
                    }
                }
            }
        }
        return 0;
    }

    @SuppressWarnings("unused")
    public static boolean isSpecialPlayer(String player) {

        if(TechCraft.modCreatorAndHelperPerks) {

            for(int p = 0; p < UtilPlayers.specialPlayers.length; p++) {

                if(UtilPlayers.specialPlayers[p].equals(player)) {    

                    return true;
                }   

                else {

                    return false;
                }
            }        
        }
        return false;
    }

}

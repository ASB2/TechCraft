package TechCraft.utils;

import TechCraft.*;

public class UtilPlayers {

    private static String[] specialPlayers = new String[] {"ASB2", "Proswhere", "iOverpowered"};

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

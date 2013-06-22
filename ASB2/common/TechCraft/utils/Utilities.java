package TechCraft.utils;

import TechCraft.*;

public class Utilities {

    /**
     * The amount of ticks under a condution to gain power a power gen block will gain power    
     */
    public static int TICKSTOPOWER = 10;

    private static String[] specialPlayers = new String[] {"ASB2", "Proswhere", "iOverpowered"};

    @SuppressWarnings("unused")
    public static boolean isSpecialPlayer(String player) {

        if(TechCraft.modCreatorAndHelperPerks) {
            
            for(int p = 0; p < Utilities.specialPlayers.length; p++) {

                if(Utilities.specialPlayers[p].equals(player)) {    

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

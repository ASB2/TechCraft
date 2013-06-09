package TechCraft.lib;

public class MiscUtilities {

    public static String[] specialPlayers = new String[] {"ASB2", "Proswhere", "iOverpowered"};
    
    //Currently 10 ticks to power
    
    public static int TICKSTOPOWER = 10;
    
    @SuppressWarnings("unused")
    public static boolean isSpecialPlayer(String player) {
        
        for(int p = 0; p < MiscUtilities.specialPlayers.length; p++) {
            
            if(MiscUtilities.specialPlayers[p].equals(player)) {    
                
                return true;
            }   
            
            else {
                
                return false;
            }
        }        
        return false;
    }

}

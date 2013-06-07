package TechCraft.lib;

public class SpecialPlayers {

    public static String[] specialPlayers = new String[] {"ASB2", "Proswhere", "iOverpowered"};
    
    @SuppressWarnings("unused")
    public static boolean isSpecialPlayer(String player) {
        
        for(int p = 0; p < SpecialPlayers.specialPlayers.length; p++) {
            
            if(SpecialPlayers.specialPlayers[p].equals(player)) {    
                
                return true;
            }   
            
            else {
                
                return false;
            }
        }        
        return false;
    }

    public static String[] getSpecialPlayers() {
        
        return specialPlayers;
    }
}

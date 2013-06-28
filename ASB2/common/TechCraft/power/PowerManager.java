package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

public class PowerManager {

    public static PowerManager instance = new PowerManager();

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<PowerProvider> powerProviders = new ArrayList();

    public void addPowerProvider(PowerProvider provider) {

        powerProviders.add(provider);
    }

    public static PowerManager getInstance() {

        return instance;
    }
    
    public List<PowerProvider> getPowerProviderList() {

        return powerProviders;
    }
    
    public void updatePowerProviders() {
        
        for(int i = 0; i < this.powerProviders.size(); i++) {
            
            if(powerProviders.get(i) != null) {
             
                powerProviders.get(i).updateProvider();
            }
            else {
                
                powerProviders.remove(i);
            }
        }
    }
}

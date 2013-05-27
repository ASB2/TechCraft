package TechCraft;

import net.minecraftforge.liquids.ITankContainer;

public interface ITCTankContainer extends ITankContainer{

    String getLiquidStackName();
    
    int getCapasity();
}

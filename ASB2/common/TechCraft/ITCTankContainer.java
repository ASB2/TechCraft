package TechCraft;

import net.minecraftforge.liquids.ITankContainer;
import net.minecraftforge.liquids.LiquidTank;

public interface ITCTankContainer extends ITankContainer{

    LiquidTank[] getTank();
}

package TechCraft;

import java.util.EnumSet;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TechCraftTickHandlerClient implements ITickHandler {

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {
        //TODO
    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {
        
        // TODO Auto-generated method stub
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.CLIENT);
    }

    @Override
    public String getLabel() {

        return "TechCraft Client Ticks";
    }

}

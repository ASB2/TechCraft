package TechCraft;

import java.util.EnumSet;

import TechCraft.power.PowerManager;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class TechCraftTickHandlerServer implements ITickHandler {

    @Override
    public void tickStart(EnumSet<TickType> type, Object... tickData) {

    }

    @Override
    public void tickEnd(EnumSet<TickType> type, Object... tickData) {

        PowerManager.getInstance().updatePowerProviders();
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.SERVER);
    }

    @Override
    public String getLabel() {

        return "TechCraft Server Tick Handler";
    }
}

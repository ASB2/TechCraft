package TechCraft.power;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.world.World;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitExporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitImporting;
import TechCraft.blocks.technogery.PowerConduit_Wire.MagicConduit.TileMagicConduitMoving;

public class PowerNetwork {

    private List <TileMagicConduitMoving> conductors = new ArrayList<TileMagicConduitMoving>();

    private List <TileMagicConduitExporting> exporting = new ArrayList<TileMagicConduitExporting>();

    private List <TileMagicConduitImporting> importing = new ArrayList<TileMagicConduitImporting>();

    @SuppressWarnings("unused")
    private World worldObj;

    public TileMagicConduitMoving tileCore;

    private int age = 0;
    int powerToMove = 5;
    int buffer = 0;

    public PowerNetwork(World world, TileMagicConduitMoving tile) {    

        worldObj = world;
        this.tileCore = tile;

        this.addConductor(tile);
    }

    public void updateNetwork() {

        age = tileCore.age;

        for(int i = 0; i < conductors.size(); i++){

            conductors.get(i).addConductorsAround();
            conductors.get(i).addImportingAround();
            conductors.get(i).addExportingAround();
        }

        if(importing.size() > 0 && exporting.size() > 0) {

            for(int i = 0; i < importing.size(); i++) {

                if(importing.get(i).getPowerStored() >= powerToMove) {

                    if(importing.get(i).usePower(powerToMove)) {

                        buffer = buffer + powerToMove;
                    }
                }
            }
        }

        if(exporting.size() > 0 && this.buffer > 0) {

            for(int i = 0; i < exporting.size(); i++) {

                if(exporting.get(i).getPowerMax() - exporting.get(i).getPowerStored() >= powerToMove) {

                    if(buffer >= powerToMove && exporting.get(i).gainPower(powerToMove)) {

                        buffer = buffer - powerToMove;
                    }
                }
            }
        }
    }

    public void revaluateNetwork(IPowerConductor tile) {

        if(tile != tileCore) {

            tile.overrideNetwork(null);

            if(tile instanceof TileMagicConduitMoving) {
                conductors.remove(tile);
            }
            if(tile instanceof TileMagicConduitImporting) {
                importing.remove(tile);
            }
            if(tile instanceof TileMagicConduitExporting) {
                exporting.remove(tile);
            }
        }
    }

    public void addConductor(TileMagicConduitMoving tile) {

        conductors.add(tile);
    }

    public void removeConductor(TileMagicConduitMoving tile) {

        conductors.remove(tile);
    }

    public void addImporting(TileMagicConduitImporting tile) {

        importing.add(tile);
    }

    public void removeImporting(TileMagicConduitImporting tile) {

        importing.remove(tile);
    }

    public void addExporting(TileMagicConduitExporting tile) {

        exporting.add(tile);
    }

    public void removeExporting(TileMagicConduitExporting tile) {

        exporting.remove(tile);
    }

    public List<TileMagicConduitMoving> getConductors() {
        return conductors;
    }

    public List<TileMagicConduitExporting> getExporting() {
        return exporting;
    }

    public List<TileMagicConduitImporting> getImporting() {
        return importing;
    }

    public int getAge() {
        return age;
    }

    public int getBuffer() {
        
        return this.buffer;
    }
}

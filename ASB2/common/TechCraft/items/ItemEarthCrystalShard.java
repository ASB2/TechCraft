package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemEarthCrystalShard extends TechCraftItems {

    public ItemEarthCrystalShard(int par1) {
        super(par1);
    }

    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemEarthCrystalShard");
    }

}
package TechCraft.items;

import net.minecraft.client.renderer.texture.IconRegister;

public class ItemGarnet extends TechCraftItems {

    public ItemGarnet(int par1) {
        super(par1);
        
    }
    
    @Override
    public void registerIcons(IconRegister iconRegister){
        itemIcon = iconRegister.registerIcon("TechCraft:ItemGarnet");
    }
}
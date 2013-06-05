package TechCraft;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class TechCraftKeyBindings extends KeyHandler {

    static KeyBinding binding = new KeyBinding("MP", Keyboard.KEY_M);

    public TechCraftKeyBindings() {

        super(new KeyBinding[]{binding}, new boolean[]{false});
    }

    @Override
    public String getLabel() {

        return "TechCraft keybindings";
    }

    @Override
    public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
    {}

    @Override
    public void keyUp(EnumSet<TickType> types, KeyBinding key, boolean tickEnd) {
        
        Messenger.displayInChat("Test Key");
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.CLIENT);
    }
}
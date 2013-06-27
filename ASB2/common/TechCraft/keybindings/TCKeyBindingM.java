package TechCraft.keybindings;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import TechCraft.Message;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class TCKeyBindingM extends KeyHandler {

    static KeyBinding binding = new KeyBinding("TechCraft", Keyboard.KEY_M);

    public TCKeyBindingM() {

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
        
        //Message.sendToClient("Test Key");
    }

    @Override
    public EnumSet<TickType> ticks() {

        return EnumSet.of(TickType.CLIENT);
    }
}
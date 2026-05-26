package de.psjahn.tcl;

import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keymapping.v1.KeyMappingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.resources.Identifier;
import org.lwjgl.glfw.GLFW;

public class ToggleCursorLock implements ClientModInitializer {
	public static final String MOD_ID = "toggle-cursor-lock";
	public static boolean CURSOR_UNLOCKED;

	public static final KeyMapping.Category CATEGORY = new KeyMapping.Category(Identifier.fromNamespaceAndPath(MOD_ID, MOD_ID));
	public static final KeyMapping TOGGLE_KEY = KeyMappingHelper.registerKeyMapping(new KeyMapping("key.toggle_cursor_lock.toggle", GLFW.GLFW_KEY_COMMA, CATEGORY));

	@Override
	public void onInitializeClient() {
		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while(TOGGLE_KEY.consumeClick()) {
				CURSOR_UNLOCKED = !CURSOR_UNLOCKED;
				Window window = client.getWindow();
				if(CURSOR_UNLOCKED) {
					InputConstants.setupMouseCallbacks(window, null, null, null, null);
					client.mouseHandler.releaseMouse();
				} else {
					client.mouseHandler.setup(window);
					client.mouseHandler.grabMouse();
				}
			}
		});
	}
}
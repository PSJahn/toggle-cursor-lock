package de.psjahn.tcl.mixin;

import de.psjahn.tcl.ToggleCursorLock;
import net.minecraft.client.MouseHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MouseHandler.class)
public class MouseHandlerMixin {
    @Inject(method = "grabMouse", at = @At("HEAD"))
    private void injectGrabMouse(CallbackInfo ci) {
        ToggleCursorLock.CURSOR_UNLOCKED = false;
    }
}

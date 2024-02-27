package top.liy233.mcm.quickonlinemode.mixin;


import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.world.GameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import top.liy233.mcm.quickonlinemode.Main;

@Mixin(IntegratedServer.class)
public class OpenServerMixin {
    @Inject(method = "openToLan", at = @At("HEAD"))
    private void saveServerPort(GameMode gameMode, boolean cheatsAllowed, int port, CallbackInfoReturnable<Boolean> cir){
        Main.LOGGER.info("listen open lan in port {}", port);
        if (port >= 0){
            Main.SERVER_PORT = port;
        }
    }
}

package top.liy233.mcm.quickonlinemode;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;

import java.io.IOException;

public class PlayerEvent {

    public static ActionResult join(Entity entity, ServerWorld world){
        if (entity.isPlayer()){
            PlayerEntity player = (PlayerEntity) entity;
            player.sendMessage(Text.of("[QOM] 此模组基于OpenFRP的OPEN API"), false);
        }
        return ActionResult.PASS;
    }

    public static ActionResult quit(Entity entity, ServerWorld world) {
        if (entity.isPlayer()){
            try {
                PlayerEntity player = (PlayerEntity) entity;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ActionResult.PASS;
    }

}

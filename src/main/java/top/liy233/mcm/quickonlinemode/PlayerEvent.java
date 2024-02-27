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
            player.sendMessage(Text.of("[QOM] 使用/quickonlinemod start进行联机"), false);
        }
        return ActionResult.PASS;
    }


}

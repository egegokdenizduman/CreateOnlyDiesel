package com.jesz.createdieselgenerators;

import com.simibubi.create.foundation.block.connected.AllCTTypes;
import com.simibubi.create.foundation.block.connected.CTSpriteShiftEntry;
import com.simibubi.create.foundation.block.connected.CTSpriteShifter;
import net.minecraft.resources.ResourceLocation;

public class CDGSpriteShifts {
    public static final CTSpriteShiftEntry MODULAR_DIESEL_ENGINE = horizontal("diesel_engine_big");
    public static final CTSpriteShiftEntry DISTILLATION_TANK = rectangle("distillation_tower/distillation_tank"),
            DISTILLATION_TANK_TOP = rectangle("distillation_tower/distillation_tank_top"),
            DISTILLATION_TANK_NORTH = rectangle("distillation_tower/distillation_tank", "distillation_tower/distillation_tank_pipes_connected");

    public static final CTSpriteShiftEntry BULK_FERMENTER = rectangle("bulk_fermenter/side"),
            BULK_FERMENTER_TOP = rectangle("bulk_fermenter/top");

    public static void init(){}
    private static CTSpriteShiftEntry horizontal(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.CROSS,  CreateDieselGenerators.rl("block/"+name),
                CreateDieselGenerators.rl("block/"+name+"_connected"));
    }
    private static CTSpriteShiftEntry rectangle(String name) {
        return CTSpriteShifter.getCT(AllCTTypes.RECTANGLE,  CreateDieselGenerators.rl("block/"+name),
                CreateDieselGenerators.rl("block/"+name+"_connected"));
    }

    private static CTSpriteShiftEntry rectangle(String name, String connectedName) {
        return CTSpriteShifter.getCT(AllCTTypes.RECTANGLE,  CreateDieselGenerators.rl("block/"+name),
                CreateDieselGenerators.rl("block/"+connectedName));
    }

}

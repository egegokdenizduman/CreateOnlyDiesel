package com.jesz.createdieselgenerators;

import com.tterrag.registrate.util.entry.FluidEntry;
import net.minecraft.core.BlockPos;
import net.minecraft.core.dispenser.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.REGISTRATE;

public class CDGFluids {

    public static final FluidEntry<BaseFlowingFluid.Flowing> PLANT_OIL = REGISTRATE.fluid("plant_oil",
                    CreateDieselGenerators.rl("block/fluid/plant_oil_still"),
                    CreateDieselGenerators.rl("block/fluid/plant_oil_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> CRUDE_OIL = REGISTRATE.fluid("crude_oil",
                            CreateDieselGenerators.rl("block/crude_oil_still"),
                            CreateDieselGenerators.rl("block/crude_oil_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(100))
            .fluidProperties(p -> p.levelDecreasePerBlock(3)
                    .tickRate(25)
                    .slopeFindDistance(2)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> BIODIESEL = REGISTRATE.fluid("biodiesel",
                    CreateDieselGenerators.rl("block/biodiesel_still"),
                    CreateDieselGenerators.rl("block/biodiesel_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> DIESEL = REGISTRATE.fluid("diesel",
                    CreateDieselGenerators.rl("block/diesel_still"),
                    CreateDieselGenerators.rl("block/diesel_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> GASOLINE = REGISTRATE.fluid("gasoline",
                    CreateDieselGenerators.rl("block/gasoline_still"),
                    CreateDieselGenerators.rl("block/gasoline_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(3)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();

    public static final FluidEntry<BaseFlowingFluid.Flowing> ETHANOL = REGISTRATE.fluid("ethanol",
                            CreateDieselGenerators.rl("block/fluid/ethanol_still"),
                            CreateDieselGenerators.rl("block/fluid/ethanol_flow"))
            .properties(b -> b.viscosity(1500)
                    .density(500))
            .fluidProperties(p -> p.levelDecreasePerBlock(2)
                    .tickRate(25)
                    .slopeFindDistance(5)
                    .explosionResistance(100f))
            .source(BaseFlowingFluid.Source::new)
            .block()
            .build()
            .bucket()
            .onRegister(CDGFluids::registerFluidDispenseBehavior)
            .build()
            .register();


    public static void register() {}

    // from Create

    private static final DispenseItemBehavior DEFAULT = new DefaultDispenseItemBehavior();
    private static final DispenseItemBehavior DISPENSE_FLUID = new DefaultDispenseItemBehavior(){
        @Override
        protected ItemStack execute(BlockSource pSource, ItemStack pStack) {
            DispensibleContainerItem dispensibleContainerItem = (DispensibleContainerItem) pStack.getItem();
            BlockPos pos = pSource.pos().relative(pSource.state().getValue(DispenserBlock.FACING));
            Level level = pSource.level();
            if (dispensibleContainerItem.emptyContents(null, level, pos, null, pStack)) {
                return new ItemStack(Items.BUCKET);
            }
            return DEFAULT.dispense(pSource, pStack);
        }
    };

    private static void registerFluidDispenseBehavior(BucketItem bucket) {
        DispenserBlock.registerBehavior(bucket, DISPENSE_FLUID);
    }
}

package com.jesz.createdieselgenerators;

import com.jesz.createdieselgenerators.compat.strut_your_stuff.StrutYourStuffRegistryEntries;
import com.jesz.createdieselgenerators.content.track_layers_bag.TrackLayersBagItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CDGCreativeTab {

    private static final DeferredRegister<CreativeModeTab> TAB_REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "createdieselgenerators");
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = TAB_REGISTER.register("cdg_creative_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.cdg_creative_tab"))
                    .icon(CDGBlocks.DIESEL_ENGINE::asStack)
                    .displayItems((pParameters, output) -> {
                        output.accept(CDGItems.ENGINE_PISTON.get());
                        output.accept(CDGItems.WIRE_CUTTERS.get());
                        output.accept(CDGItems.HAMMER.get());
                        output.accept(CDGItems.ENGINE_SILENCER.get());
                        output.accept(CDGItems.ENGINE_TURBO.get());
                        output.accept(CDGBlocks.DIESEL_ENGINE.get());
                        output.accept(CDGBlocks.MODULAR_DIESEL_ENGINE.get());
                        output.accept(CDGBlocks.HUGE_DIESEL_ENGINE.get());
                        output.accept(CDGItems.DISTILLATION_CONTROLLER.get());
                        output.accept(CDGItems.OIL_SCANNER.get());
                        output.accept(CDGBlocks.PUMPJACK_HOLE.get());
                        output.accept(CDGBlocks.PUMPJACK_BEARING.get());
                        output.accept(CDGBlocks.PUMPJACK_CRANK.get());
                        output.accept(CDGBlocks.PUMPJACK_HEAD.get());
                        output.accept(CDGBlocks.CANISTER.get());
                        output.accept(CDGBlocks.BASIN_LID.get());
                        output.accept(CDGBlocks.BULK_FERMENTER.get());
                        output.accept(CDGBlocks.ANDESITE_GIRDER.get());
                        if (ModList.get().isLoaded("struts"))
                            StrutYourStuffRegistryEntries.fillCreativeTab(output);
                        output.accept(CDGFluids.CRUDE_OIL.getBucket().get());
                        output.accept(CDGFluids.BIODIESEL.getBucket().get());
                        output.accept(CDGFluids.DIESEL.getBucket().get());
                        output.accept(CDGFluids.GASOLINE.getBucket().get());
                        output.accept(CDGFluids.PLANT_OIL.getBucket().get());
                        output.accept(CDGFluids.ETHANOL.getBucket().get());
                        output.accept(CDGItems.TRACK_LAYERS_BAG.get());
                        output.accept(TrackLayersBagItem.full());
                        for (var fluid : CDGFluids.CONCRETE)
                            output.accept(fluid.getBucket().orElseThrow());
                    })
                    .build());

    public static void register(IEventBus modEventBus) {
        TAB_REGISTER.register(modEventBus);
    }

}


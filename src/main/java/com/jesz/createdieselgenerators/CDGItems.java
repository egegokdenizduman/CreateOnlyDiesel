package com.jesz.createdieselgenerators;

import com.jesz.createdieselgenerators.content.distillation.DistillationControllerItem;
import com.jesz.createdieselgenerators.content.tools.OilScannerItem;
import com.jesz.createdieselgenerators.content.tools.hammer.HammerItem;
import com.jesz.createdieselgenerators.content.tools.wire_cutters.WireCuttersItem;
import com.jesz.createdieselgenerators.content.track_layers_bag.TrackLayersBagItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.REGISTRATE;

public class CDGItems {

    public static final ItemEntry<Item> ENGINE_PISTON = REGISTRATE.item("engine_piston", Item::new).register();

    public static final ItemEntry<Item> ENGINE_SILENCER = REGISTRATE.item("engine_silencer", Item::new).register();

    public static final ItemEntry<Item> ENGINE_TURBO = REGISTRATE.item("engine_turbocharger", Item::new).register();

    public static final ItemEntry<DistillationControllerItem> DISTILLATION_CONTROLLER = REGISTRATE.item("distillation_controller", DistillationControllerItem::new).register();

    public static final ItemEntry<OilScannerItem> OIL_SCANNER = REGISTRATE.item("oil_scanner", OilScannerItem::new)
            .onRegister(OilScannerItem::registerModelOverrides).model(OilScannerItem::addOverrideModels)
            .register();

    public static final ItemEntry<TrackLayersBagItem> TRACK_LAYERS_BAG = REGISTRATE.item("track_layers_bag", TrackLayersBagItem::new)
            .lang("Track Layer's Bag")
            .onRegister(TrackLayersBagItem::registerModelOverrides)
            .model(TrackLayersBagItem::addOverrideModels)
            .register();

    public static final ItemEntry<HammerItem> HAMMER = REGISTRATE.item("hammer", HammerItem::new)
            .properties(p -> p.durability(128))
            .properties(p -> p.attributes(AxeItem.createAttributes(Tiers.IRON, 6.0F, -3.1F)))
            .model((c, p) -> p.handheldItem(c.getEntry()))
            .register();

    public static final ItemEntry<WireCuttersItem> WIRE_CUTTERS = REGISTRATE.item("wire_cutters", WireCuttersItem::new)
            .properties(p -> p.durability(128))
            .register();


    public static void register() {}
}

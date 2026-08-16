package com.jesz.createdieselgenerators;

import com.simibubi.create.api.contraption.storage.fluid.MountedFluidStorageType;
import com.simibubi.create.content.fluids.tank.storage.FluidTankMountedStorageType;
import com.tterrag.registrate.util.entry.RegistryEntry;

import java.util.function.Supplier;

import static com.jesz.createdieselgenerators.CreateDieselGenerators.REGISTRATE;

public class CDGMountedStorageTypes {

    private static <T extends MountedFluidStorageType<?>> RegistryEntry<MountedFluidStorageType<?>, T> simpleFluid(String name, Supplier<T> supplier) {
        return REGISTRATE.mountedFluidStorage(name, supplier).register();
    }


    public static void register() {};
}

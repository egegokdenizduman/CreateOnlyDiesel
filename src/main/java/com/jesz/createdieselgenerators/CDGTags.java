package com.jesz.createdieselgenerators;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

public class CDGTags {

    public static final TagKey<Biome> OIL_BIOMES = TagKey.create(Registries.BIOME, CreateDieselGenerators.rl("oil_biomes"));
    public static final TagKey<Biome> DENY_OIL_BIOMES = TagKey.create(Registries.BIOME, CreateDieselGenerators.rl("deny_oil_biomes"));
    public static final TagKey<Block> PUMPJACK_PIPE = TagKey.create(BuiltInRegistries.BLOCK.key(), CreateDieselGenerators.rl("pumpjack_pipe"));
    public static final TagKey<Block> OIL_DEPOSIT = TagKey.create(BuiltInRegistries.BLOCK.key(), CreateDieselGenerators.rl("oil_deposit"));
    public static final TagKey<Fluid> PUMPJACK_OUTPUT = TagKey.create(BuiltInRegistries.FLUID.key(), CreateDieselGenerators.rl("pumpjack_output"));
}

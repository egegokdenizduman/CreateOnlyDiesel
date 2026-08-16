package com.jesz.createdieselgenerators.compat.kubejs;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.jesz.createdieselgenerators.CreateDieselGenerators;
import dev.latvian.mods.kubejs.client.LangKubeEvent;
import dev.latvian.mods.kubejs.event.EventGroup;
import dev.latvian.mods.kubejs.event.EventGroupRegistry;
import dev.latvian.mods.kubejs.event.EventHandler;
import dev.latvian.mods.kubejs.generator.KubeAssetGenerator;
import dev.latvian.mods.kubejs.plugin.ClassFilter;
import dev.latvian.mods.kubejs.plugin.KubeJSPlugin;
import dev.latvian.mods.kubejs.script.ScriptType;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;

import java.util.List;

public class CDGKubeJSPlugin implements KubeJSPlugin {
    public static EventGroup GROUP = EventGroup.of("CDGEvents");
    public static EventHandler OIL_CHUNKS = GROUP.server("oilAmount", () -> GetChunkOilAmountEventJS.class);
    static {
        OIL_CHUNKS.hasResult();
    }

    @Override
    public void registerEvents(EventGroupRegistry registry) {
        registry.register(GROUP);
    }

    @Override
    public void registerClasses(ClassFilter filter) {
        filter.allow("com.jesz.createdieselgenerators");
        filter.deny("com.jesz.createdieselgenerators.mixins");
        filter.deny(CDGKubeJSPlugin.class);
    }

    public static int calculateOilChunks(List<Holder<Biome>> biomes, ChunkPos chunkPos, long seed) {
        if (!OIL_CHUNKS.hasListeners())
            return -1;

        GetChunkOilAmountEventJS event = new GetChunkOilAmountEventJS();
        event.chunkPos = chunkPos;
        event.seed = seed;
        String[] stringBiomes = new String[biomes.size()];
        for (int i = 0; i < stringBiomes.length; i++) {
            stringBiomes[i] = biomes.stream().map(b -> ((Holder.Reference)b).key().location().toString()).toList().get(i);
        }
        event.biomes = stringBiomes;

        return ((Double)OIL_CHUNKS.post(event).value()).intValue();
    }

    JsonElement generateTextureModel(ResourceLocation rl) {
        JsonObject object = new JsonObject();
        object.add("parent", new JsonPrimitive("minecraft:item/generated"));
        JsonObject texturesObject = new JsonObject();
        texturesObject.add("layer0", new JsonPrimitive(rl.toString()));
        object.add("textures", texturesObject);
        return object;
    }
}

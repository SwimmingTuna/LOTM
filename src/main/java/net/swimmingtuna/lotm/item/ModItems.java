package net.swimmingtuna.lotm.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.swimmingtuna.lotm.LOTM;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LOTM.MOD_ID);

public static final RegistryObject<Item> MindReading = ITEMS.register("mindreading",
        ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Awe = ITEMS.register("awe",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Frenzy = ITEMS.register("frenzy",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Placate = ITEMS.register("placate",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BattleHypnotism = ITEMS.register("battlehypnotism",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PsychologicalInvisibility = ITEMS.register("psychologicalinvisibility",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Guidance = ITEMS.register("guidance",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Manipulation = ITEMS.register("manipulation",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MentalPlague = ITEMS.register("mentalplague",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MindStorm = ITEMS.register("mindstorm",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ConsciousnessStroll = ITEMS.register("consciousnessstroll",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DragonBreath = ITEMS.register("dragonbreath",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PlagueStorm = ITEMS.register("plaguestorm",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DreamWeaving = ITEMS.register("dreamweaving",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Discern = ITEMS.register("discern",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> DreamIntoReality = ITEMS.register("dreamintoreality",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Prophesize = ITEMS.register("prophesize",
            ()-> new Item(new Item.Properties()));
    public static final RegistryObject<Item> Envision = ITEMS.register("envision",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

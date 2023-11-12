package net.ZuperZ.bog.item;

import net.ZuperZ.bog.Bog;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Bog.MOD_ID);

    //Silver : this dimension is equivalent to Iron
    public static final RegistryObject<Item> SILVER = ITEMS.register("silver",
            () -> new Item(new Item.Properties()));

    //Cranberries : when you have 6 of them you can make cranberry sauce using cranberry sauce and leaves makes salad
    public static final RegistryObject<Item> CRANBERRIES = ITEMS.register("cranberries",
            () -> new Item(new Item.Properties()));

    //salad : cranberry sauce and leaves makes salad
    public static final RegistryObject<Item> SALAD = ITEMS.register("salad",
            () -> new Item(new Item.Properties()));

    //leaf : a leaf from the Weeping Willow leaves
    public static final RegistryObject<Item> LEAF = ITEMS.register("leaf",
            () -> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
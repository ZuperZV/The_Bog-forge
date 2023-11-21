package net.ZuperZ.bog.block;

import net.ZuperZ.bog.Bog;
import net.ZuperZ.bog.Bog;
import net.ZuperZ.bog.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Bog.MOD_ID);
    public static final RegistryObject<Block> BOG_GRASS = registerBlock("bog_grass",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRASS)));
    //public static final RegistryObject<Block> RAW_SILVER_BLOCK = registerBlock("raw_silver_block",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    //public static final RegistryObject<Block> SILVER_BLOCK = registerBlock("silver_block",
    //        () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    //public static final RegistryObject<Block> WEEPING_WILLOW_PLANKS = registerBlock("weeping_willow_planks",
    //        () -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
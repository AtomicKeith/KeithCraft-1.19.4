package net.atomickeith.keithcraft.datagen;

import net.atomickeith.keithcraft.block.ModBlocks;
import net.atomickeith.keithcraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.TIN_BLOCK.get());
        dropSelf(ModBlocks.RAW_TIN_BLOCK.get());

        add(ModBlocks.TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.TIN_ORE.get(), ModItems.RAW_TIN.get()));
        add(ModBlocks.DEEPSLATE_TIN_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_TIN_ORE.get(), ModItems.RAW_TIN.get()));

        this.dropSelf(ModBlocks.WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_WISTERIA_WOOD.get());
        this.dropSelf(ModBlocks.WISTERIA_PLANKS.get());
        this.dropSelf(ModBlocks.WISTERIA_SAPLING.get());

        this.add(ModBlocks.WISTERIA_LEAVES.get(), (block) ->
                createLeavesDrops(block, ModBlocks.WISTERIA_LEAVES.get(), NORMAL_LEAVES_SAPLING_CHANCES));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}

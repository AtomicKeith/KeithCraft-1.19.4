package net.atomickeith.keithcraft.datagen;

import net.atomickeith.keithcraft.KeithCraft;
import net.atomickeith.keithcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, KeithCraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

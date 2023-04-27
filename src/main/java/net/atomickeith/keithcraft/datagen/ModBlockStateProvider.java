package net.atomickeith.keithcraft.datagen;

import net.atomickeith.keithcraft.KeithCraft;
import net.atomickeith.keithcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
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

        logBlock(((RotatedPillarBlock) ModBlocks.WISTERIA_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.WISTERIA_WOOD.get(), blockTexture(ModBlocks.WISTERIA_LOG.get()), blockTexture(ModBlocks.WISTERIA_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WISTERIA_LOG.get(), new ResourceLocation(KeithCraft.MOD_ID, "block/stripped_wisteria_log"),
                new ResourceLocation(KeithCraft.MOD_ID, "block/stripped_wisteria_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_WISTERIA_WOOD.get(), new ResourceLocation(KeithCraft.MOD_ID, "block/stripped_wisteria_log"),
                new ResourceLocation(KeithCraft.MOD_ID, "block/stripped_wisteria_log"));

        simpleBlockItem(ModBlocks.WISTERIA_LOG.get(), models().withExistingParent("keithcraft:wisteria_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.WISTERIA_WOOD.get(), models().withExistingParent("keithcraft:wisteria_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WISTERIA_LOG.get(), models().withExistingParent("keithcraft:stripped_wisteria_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_WISTERIA_WOOD.get(), models().withExistingParent("keithcraft:stripped_wisteria_wood", "minecraft:block/cube_column"));

        blockWithItem(ModBlocks.WISTERIA_PLANKS);
        blockWithItem(ModBlocks.WISTERIA_LEAVES);
        saplingBlock(ModBlocks.WISTERIA_SAPLING);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}

package org.nootnoot.fabricchaos;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import static org.nootnoot.fabricchaos.ModFluids.STILLSUSPICIOUSFLUID;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem){
        Identifier itemID = Identifier.of(Fabricchaos.MOD_ID, name);
        if (shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM,itemID,blockItem);
        }
        return Registry.register(Registries.BLOCK,itemID,block);
    }

    public static void initialize(){

    }

    public static final Block SUSPICIOUS_BLOCK = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.MOSS_BLOCK)),"suspicious_block",true);
    public static final Block SUSPICIOUS_FLUID_BLOCK = register(new FluidBlock((FlowableFluid) STILLSUSPICIOUSFLUID, FabricBlockSettings.copy(Blocks.WATER).liquid())
            ,"suspicious_fluid_block"
            ,false
    );


}

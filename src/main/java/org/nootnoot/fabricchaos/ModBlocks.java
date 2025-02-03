package org.nootnoot.fabricchaos;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.*;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.nootnoot.fabricchaos.suspiciousItems.SuspiciousSword;

import java.util.Arrays;

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

    public static final Block SUSPICIOUS_BLOCK = register(new Block(AbstractBlock.Settings.create().sounds(BlockSoundGroup.MOSS_BLOCK)) {
        //well it should work now
        @Override
        public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            if (player.getStackInHand(hand).getItem() instanceof SwordItem){
                var inputattmods =((SwordItem)player.getStackInHand(hand).getItem()).getAttributeModifiers(player.getStackInHand(hand), EquipmentSlot.MAINHAND);
                ItemStack result = new ItemStack(new SuspiciousSword(
                        ((SwordItem)player.getStackInHand(hand).getItem()).getMaterial(),
                        (int) inputattmods.get(EntityAttributes.GENERIC_ATTACK_DAMAGE).stream().iterator().next().getValue(),
                        (float) inputattmods.get(EntityAttributes.GENERIC_ATTACK_SPEED).stream().iterator().next().getValue()));
                NbtCompound nbtCompound =  player.getStackInHand(hand).getNbt();
                if (nbtCompound != null) {
                    result.setNbt(nbtCompound.copy());
                }
                //world.spawnEntity(new ItemEntity(world,player.getX(),player.getY(),player.getZ(), result));
                player.getInventory().insertStack(player.getInventory().indexOf(player.getStackInHand(hand)),result);
                return ActionResult.CONSUME;
            }
            return ActionResult.PASS;
        }
    },"suspicious_block",true);
    public static final Block SUSPICIOUS_FLUID_BLOCK = register(new FluidBlock((FlowableFluid) STILLSUSPICIOUSFLUID, FabricBlockSettings.copy(Blocks.WATER).liquid())
            ,"suspicious_fluid_block"
            ,false
    );


}

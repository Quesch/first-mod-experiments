package org.nootnoot.fabricchaos;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;

public abstract class suspiciousFluid extends FlowableFluid {

    public static boolean isInfinite=true;
    public static int flowspeed = 4;
    public static int leveldecreaseperblock = 1;
    public static boolean replacable = false;
    public static int tickrate = 5;
    public static float blastresistenz = 100f;

    @Override
    public boolean matchesType(Fluid fluid) {
        return fluid == getStill() || fluid == getFlowing();
    }

    @Override
    public Fluid getFlowing() {
        return ModFluids.FLOWINGSUSPICIOUSFLUID;
    }

    @Override
    public Fluid getStill() {
        return ModFluids.STILLSUSPICIOUSFLUID;
    }

    @Override
    protected boolean isInfinite(World world) {
        return isInfinite;
    }

    @Override
    protected void beforeBreakingBlock(WorldAccess world, BlockPos pos, BlockState state) {
        final BlockEntity blockEntity = state.hasBlockEntity() ? world.getBlockEntity(pos) : null;
        Block.dropStacks(state, world, pos, blockEntity);
    }

    @Override
    protected int getFlowSpeed(WorldView world) {
        return flowspeed;
    }

    @Override
    protected int getLevelDecreasePerBlock(WorldView world) {
        return leveldecreaseperblock;
    }

    @Override
    public Item getBucketItem() {
        return Moditems.SUSPICIOUS_BUCKET;
    }

    @Override
    protected boolean canBeReplacedWith(FluidState state, BlockView world, BlockPos pos, Fluid fluid, Direction direction) {
        return replacable;
    }

    @Override
    public int getTickRate(WorldView world) {
        return tickrate;
    }

    @Override
    protected float getBlastResistance() {
        return blastresistenz;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return ModBlocks.SUSPICIOUS_FLUID_BLOCK.getDefaultState().with(Properties.LEVEL_15,getBlockStateLevel(state));
    }

    public static class Flowing extends suspiciousFluid{
        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public int getLevel(FluidState fluidState) {
            return fluidState.get(LEVEL);
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return false;
        }
    }
    public static class Still extends suspiciousFluid{
        @Override
        public int getLevel(FluidState fluidState) {
            return 8;
        }

        @Override
        public boolean isStill(FluidState fluidState) {
            return true;
        }
    }
}

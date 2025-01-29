package org.nootnoot.fabricchaos;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.util.Identifier;
import org.w3c.dom.events.Event;

public class ModFluids {
    public static void initialize(){}
    public static Fluid registerStillFluid(String name, FlowableFluid fluid){

        Identifier stillfluidID = Identifier.of(Fabricchaos.MOD_ID, "still_"+name);
        return Registry.register(Registries.FLUID, stillfluidID, fluid);
    }
    public static Fluid registerFlowingFluid(String name, FlowableFluid fluid){
        Identifier flowingfluidID = Identifier.of(Fabricchaos.MOD_ID, "flowing_"+name);
        return Registry.register(Registries.FLUID, flowingfluidID, fluid);
    }
    public static BucketItem registerFluidBucket(String name, Fluid fluid){
        return (BucketItem) Moditems.register(new BucketItem(fluid,new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1)),name);
    }
    public static final Fluid STILLSUSPICIOUSFLUID = registerStillFluid("suspicious_fluid",new suspiciousFluid.Still());
    public static final Fluid FLOWINGSUSPICIOUSFLUID = registerFlowingFluid("suspicious_fluid",new suspiciousFluid.Flowing());



}

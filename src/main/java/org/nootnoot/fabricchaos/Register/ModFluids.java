package org.nootnoot.fabricchaos.Register;

import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.nootnoot.fabricchaos.Fabricchaos;
import org.nootnoot.fabricchaos.modfluids.suspiciousFluid;

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

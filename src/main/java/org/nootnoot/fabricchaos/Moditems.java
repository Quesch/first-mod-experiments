package org.nootnoot.fabricchaos;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.fabricmc.fabric.api.transfer.v1.fluid.CauldronFluidContent;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;


public class Moditems {
    public static void initialize() {

        ModBlocks.initialize();
        Moditemgroup.initialize();
        ModFluids.initialize();
        CompostingChanceRegistry.INSTANCE.add(Moditems.SUSPICIOUS_SUBSTANCE, 15f);
        FuelRegistry.INSTANCE.add(Moditems.SUSPICIOUS_SUBSTANCE, 60 * 20);

    }
    ;
    public static final FoodComponent Poison101_FoodComponent = new FoodComponent.Builder()
            .alwaysEdible()
            .snack()
            .hunger(12)
            .saturationModifier(12)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 1), 0.99f) //look into Potions for exapmples
            .build();

    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(Fabricchaos.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static final Item SUSPICIOUS_SUBSTANCE = register(
            new Item(new Item.Settings().food(Poison101_FoodComponent)),
            "suspicious_substance" //Name the texture file the same as the item's identifier, but with a .png extension.
    );
    public static final Item SUSPICIOUS_SWORD = register(
            new SwordItem(SuspiciousMaterial.NETHERITE_INSTANCE,6,0.06f, new Item.Settings()) {}
            ,"suspicious_sword"
    );
    public static final BucketItem SUSPICIOUS_BUCKET = ModFluids.registerFluidBucket("suspicious_bucket",ModFluids.STILLSUSPICIOUSFLUID);

}
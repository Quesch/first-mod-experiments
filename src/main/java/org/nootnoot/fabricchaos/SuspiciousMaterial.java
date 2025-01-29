package org.nootnoot.fabricchaos;


import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

/*
If you're creating multiple tool materials, consider using an Enum to store them. Vanilla does this in the
ToolMaterials class, which stores all the tool materials that are used in the game.
This class can also be used to determine your tool material's properties in relation to vanilla tool materials.
*/
public class SuspiciousMaterial implements ToolMaterial {
    private final int miningLevel;
    private final int itemDurability;
    private final float miningSpeed;
    private final float attackDamage;
    private final int enchantability;
    private final Ingredient repairIngredient;
    private final ToolMaterial basetool;


    public SuspiciousMaterial(ToolMaterial basetool) {
        this.basetool = basetool;
        miningLevel= basetool.getMiningLevel();
        itemDurability= (int) (basetool.getDurability()*1.5);
        miningSpeed=basetool.getMiningSpeedMultiplier()*2;
        attackDamage= (float) (basetool.getAttackDamage()*1.6);
        enchantability=basetool.getEnchantability()*2;
        repairIngredient = Ingredient.ofItems(Moditems.SUSPICIOUS_SUBSTANCE);
    }
    public static final SuspiciousMaterial NETHERITE_INSTANCE = new SuspiciousMaterial(ToolMaterials.NETHERITE);

    @Override
    public int getMiningLevel() {
        return miningLevel;
    }
    @Override
    public int getDurability() {
        return itemDurability;
    }
    @Override
    public float getMiningSpeedMultiplier() {
        return miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return attackDamage;
    }

    @Override
    public int getEnchantability() {
        return enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient;
    }

    public ToolMaterial getBasetool() {
        return basetool;
    }
}
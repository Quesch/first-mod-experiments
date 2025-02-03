package org.nootnoot.fabricchaos.suspiciousItems;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import org.nootnoot.fabricchaos.Moditems;

public class SuspiciousSword extends SwordItem {
    public SuspiciousSword(ToolMaterial toolMaterial, int baseDamage, float baseAttackSpeed) {
        this(toolMaterial, baseDamage, baseAttackSpeed, Moditems.defaultsettings().maxCount(1));
    }

    public SuspiciousSword(ToolMaterial toolMaterial, int baseDamage, float baseAttackSpeed, Item.Settings settings) {
        super(toolMaterial, (int)(baseDamage*(toolMaterial.getAttackDamage()-1)), baseAttackSpeed, settings);
    }
    /*
    used to make it do something
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) { }
    */
}

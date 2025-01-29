package org.nootnoot.fabricchaos;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class Moditemgroup{

    public static void initialize(){
        Registry.register(Registries.ITEM_GROUP,FabricchaosItemsKey,FabricchaosItems);
        ItemGroupEvents.modifyEntriesEvent(FabricchaosItemsKey).register(ItemGroup -> {
            ItemGroup.add(Moditems.SUSPICIOUS_SUBSTANCE);
            ItemGroup.add(Moditems.SUSPICIOUS_SWORD);
            ItemGroup.add(ModBlocks.SUSPICIOUS_BLOCK.asItem());
            ItemGroup.add(Moditems.SUSPICIOUS_BUCKET);
        });

    };
    public static final ItemGroup FabricchaosItems = FabricItemGroup.builder()
            .icon(()->new ItemStack( Moditems.SUSPICIOUS_SUBSTANCE)) //it is the icon, but it still doesn't have a texture
            .displayName(Text.translatable("itemGroup.fabricchaosItems"))
            .build();
    public static final RegistryKey<ItemGroup> FabricchaosItemsKey = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Fabricchaos.MOD_ID,"item_group"));
}

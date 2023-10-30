package fr.flaton.walkietalkie.item;

import dev.architectury.registry.registries.DeferredRegister;
import dev.architectury.registry.registries.RegistrySupplier;
import fr.flaton.walkietalkie.WalkieTalkie;
import fr.flaton.walkietalkie.block.ModBlocks;
import fr.flaton.walkietalkie.config.ModConfig;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(WalkieTalkie.MOD_ID, RegistryKeys.ITEM);
    
    public static final RegistrySupplier<Item> WALKIETALKIE = ITEMS.register("walkietalkie", () -> new WalkieTalkieItem(
            new Item.Settings().maxCount(1).fireproof().arch$tab(ModItemGroup.WALKIETALKIE), ModConfig.netheriteWalkieTalkieRange));

    public static final RegistrySupplier<Item> SPEAKER = ITEMS.register("speaker", () -> new BlockItem(ModBlocks.SPEAKER.get(),
            new Item.Settings().arch$tab(ModItemGroup.WALKIETALKIE)));

    public static void register() {
        ITEMS.register();
    }

}

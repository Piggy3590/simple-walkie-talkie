package fr.flaton.walkietalkie.fabric;

import fr.flaton.walkietalkie.WalkieTalkie;
import fr.flaton.walkietalkie.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;

import fr.flaton.walkietalkie.block.ModBlocks;
import fr.flaton.walkietalkie.block.entity.ModBlockEntities;
import fr.flaton.walkietalkie.item.ModItemGroup;
import fr.flaton.walkietalkie.item.ModItems;
import fr.flaton.walkietalkie.item.WalkieTalkieItem;
import fr.flaton.walkietalkie.network.ModMessages;
import fr.flaton.walkietalkie.screen.ModScreenHandlers;
import fr.flaton.walkietalkie.sound.ModSounds;

public class WalkieTalkieFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ModConfig config = new ModConfig(FabricLoader.getInstance().getConfigDir());
        config.loadModConfig();

        ModBlocks.register();
		ModItems.register();
		ModItemGroup.register();
		ModSounds.registerSounds();
		
		ModBlockEntities.register();
		ModScreenHandlers.register();

		ModMessages.registerC2SPackets();
    }
}

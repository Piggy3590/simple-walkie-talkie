package fr.flaton.walkietalkie;

import fr.flaton.walkietalkie.block.ModBlocks;
import fr.flaton.walkietalkie.block.entity.ModBlockEntities;
import fr.flaton.walkietalkie.item.ModItemGroup;
import fr.flaton.walkietalkie.item.ModItems;
import fr.flaton.walkietalkie.item.WalkieTalkieItem;
import fr.flaton.walkietalkie.network.ModMessages;
import fr.flaton.walkietalkie.screen.ModScreenHandlers;
import fr.flaton.walkietalkie.sound.ModSounds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.Registries;
import net.fabricmc.api.ModInitializer;

public class WalkieTalkie implements ModInitializer {
	public static final String MOD_ID = "walkietalkie";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	
	@Override
	public void onInitialize() {
		ModBlocks.register();
		ModItems.register();
		ModItemGroup.register();
		ModSounds.registerSounds();
		
		ModBlockEntities.register();
		ModScreenHandlers.register();

		ModMessages.registerC2SPackets();
	}
}
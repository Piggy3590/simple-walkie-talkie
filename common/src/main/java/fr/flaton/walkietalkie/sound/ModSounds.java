package fr.flaton.walkietalkie.sound;

import fr.flaton.walkietalkie.WalkieTalkie;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
	public static final SoundEvent RADIO_OPEN_EVENT = registerSoundEvent("radio_open");
	public static final SoundEvent RADIO_CLOSE_EVENT = registerSoundEvent("radio_close");

	private static SoundEvent registerSoundEvent(String name) {
		Identifier id = new Identifier(WalkieTalkie.MOD_ID, name);
		return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
	}

	public static void registerSounds()
	{
		WalkieTalkie.LOGGER.info("Registering Sounds for " + WalkieTalkie.MOD_ID);
	}
}
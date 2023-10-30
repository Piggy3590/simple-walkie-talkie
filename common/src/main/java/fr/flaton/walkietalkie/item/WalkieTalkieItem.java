package fr.flaton.walkietalkie.item;
import fr.flaton.walkietalkie.WalkieTalkie;

import fr.flaton.walkietalkie.sound.ModSounds;
import fr.flaton.walkietalkie.client.gui.screen.WalkieTalkieScreen;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.sound.SoundCategory;

public class WalkieTalkieItem extends Item {

    public int getRange() {
        return RANGE;
    }

    private final int RANGE;

    public static final String NBT_KEY_CANAL = "walkietalkie.canal";
    public static final String NBT_KEY_MUTE = "walkietalkie.mute";
    public static final String NBT_KEY_ACTIVATE = "walkietalkie.activate";

    private boolean activateState;

    public WalkieTalkieItem(Settings settings, int range) {
        super(settings);
        RANGE = range;
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {

        ItemStack stack = player.getStackInHand(hand);
        if (world.isClient()) {
            if (player.getStackInHand(hand).hasNbt()) {
                if (player.isSneaking()) {
                    new WalkieTalkieScreen(stack);
                }
            }
        }
        if (!player.isSneaking()) {
            NbtCompound nbt = stack.getNbt();
            activateState = nbt.getBoolean(WalkieTalkieItem.NBT_KEY_ACTIVATE);
            nbt.putBoolean(WalkieTalkieItem.NBT_KEY_ACTIVATE, !activateState);
            if (!activateState) {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSounds.RADIO_OPEN_EVENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                stack.getOrCreateNbt().putInt("CustomModelData", 0);
                player.getItemCooldownManager().set(this, 5);
            } else {
                world.playSound(player, player.getX(), player.getY(), player.getZ(), ModSounds.RADIO_CLOSE_EVENT, SoundCategory.BLOCKS, 1.0F, 1.0F);
                stack.getOrCreateNbt().putInt("CustomModelData", 1);
                player.getItemCooldownManager().set(this, 5);
            }
        }
        return super.use(world, player, hand);
    }
    
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (world.isClient()) {
            return;
        }

        if (!stack.hasNbt()) {
            NbtCompound nbtCompound = new NbtCompound();
            nbtCompound.putBoolean(WalkieTalkieItem.NBT_KEY_ACTIVATE, false);
            nbtCompound.putBoolean(WalkieTalkieItem.NBT_KEY_MUTE, false);
            nbtCompound.putInt(WalkieTalkieItem.NBT_KEY_CANAL, 1);
            stack.setNbt(nbtCompound);
        }
    }
}


package me.noteswiper.gyisti.entity;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.PlayMessages;
import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MoveBackToVillageGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FollowMobGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.chat.Component;
import net.minecraft.nbt.CompoundTag;

import me.noteswiper.gyisti.init.GyistiModEntities;

public class GyistiPlayerEntity extends PathfinderMob {
	public static final EntityDataAccessor<String> DATA_gyistiplayer_name = SynchedEntityData.defineId(GyistiPlayerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<String> DATA_gyistiplayer_chatmsg = SynchedEntityData.defineId(GyistiPlayerEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_gyistiplayer_status = SynchedEntityData.defineId(GyistiPlayerEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_gyistiplayer_exp = SynchedEntityData.defineId(GyistiPlayerEntity.class, EntityDataSerializers.INT);

	public GyistiPlayerEntity(PlayMessages.SpawnEntity packet, Level world) {
		this(GyistiModEntities.GYISTI_PLAYER.get(), world);
	}

	public GyistiPlayerEntity(EntityType<GyistiPlayerEntity> type, Level world) {
		super(type, world);
		setMaxUpStep(0.6f);
		xpReward = 2;
		setNoAi(false);
		setCustomName(Component.literal("Player"));
		setCustomNameVisible(true);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.STONE_SWORD));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Items.IRON_HELMET));
	}

	@Override
	public Packet<ClientGamePacketListener> getAddEntityPacket() {
		return NetworkHooks.getEntitySpawningPacket(this);
	}

	@Override
	protected void defineSynchedData() {
		super.defineSynchedData();
		this.entityData.define(DATA_gyistiplayer_name, "Unknown");
		this.entityData.define(DATA_gyistiplayer_chatmsg, "");
		this.entityData.define(DATA_gyistiplayer_status, 0);
		this.entityData.define(DATA_gyistiplayer_exp, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(2, new FloatGoal(this));
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.2));
		this.targetSelector.addGoal(4, new HurtByTargetGoal(this));
		this.goalSelector.addGoal(5, new FollowMobGoal(this, 1, (float) 10, (float) 5));
		this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 0.8));
		this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Villager.class, (float) 6));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, false));
		this.goalSelector.addGoal(9, new OpenDoorGoal(this, true));
		this.goalSelector.addGoal(10, new MoveBackToVillageGoal(this, 0.6, false));
		this.goalSelector.addGoal(11, new RandomSwimmingGoal(this, 1, 40));
	}

	@Override
	public MobType getMobType() {
		return MobType.UNDEFINED;
	}

	@Override
	public SoundEvent getAmbientSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gyisti:corruptedplayer.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gyisti:corruptedplayer.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("gyisti:corruptedplayer.hurt"));
	}

	@Override
	public boolean hurt(DamageSource damagesource, float amount) {
		if (damagesource.is(DamageTypes.IN_FIRE))
			return false;
		return super.hurt(damagesource, amount);
	}

	@Override
	public boolean fireImmune() {
		return true;
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putString("Datagyistiplayer_name", this.entityData.get(DATA_gyistiplayer_name));
		compound.putString("Datagyistiplayer_chatmsg", this.entityData.get(DATA_gyistiplayer_chatmsg));
		compound.putInt("Datagyistiplayer_status", this.entityData.get(DATA_gyistiplayer_status));
		compound.putInt("Datagyistiplayer_exp", this.entityData.get(DATA_gyistiplayer_exp));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datagyistiplayer_name"))
			this.entityData.set(DATA_gyistiplayer_name, compound.getString("Datagyistiplayer_name"));
		if (compound.contains("Datagyistiplayer_chatmsg"))
			this.entityData.set(DATA_gyistiplayer_chatmsg, compound.getString("Datagyistiplayer_chatmsg"));
		if (compound.contains("Datagyistiplayer_status"))
			this.entityData.set(DATA_gyistiplayer_status, compound.getInt("Datagyistiplayer_status"));
		if (compound.contains("Datagyistiplayer_exp"))
			this.entityData.set(DATA_gyistiplayer_exp, compound.getInt("Datagyistiplayer_exp"));
	}

	public static void init() {
		SpawnPlacements.register(GyistiModEntities.GYISTI_PLAYER.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3251);
		builder = builder.add(Attributes.MAX_HEALTH, 20);
		builder = builder.add(Attributes.ARMOR, 5);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.21);
		builder = builder.add(Attributes.ATTACK_KNOCKBACK, 0.22);
		return builder;
	}
}

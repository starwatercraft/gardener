package org.zira.gardener.client;

import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import net.minecraft.client.render.entity.equipment.EquipmentModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.state.BipedEntityRenderState;
import net.minecraft.entity.Entity;
import org.jetbrains.annotations.Nullable;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import software.bernie.geckolib.animatable.GeoItem;
import software.bernie.geckolib.animatable.SingletonGeoAnimatable;
import software.bernie.geckolib.animatable.client.GeoRenderProvider;
import software.bernie.geckolib.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.animation.*;
import software.bernie.geckolib.animation.AnimatableManager.ControllerRegistrar;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.event.GeoRenderEvent;
import software.bernie.geckolib.renderer.GeoArmorRenderer;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Set;
import java.util.function.Consumer;

public class WolfLeatherArmorItem extends ArmorItem implements GeoItem {

    private AnimatableInstanceCache cache =  GeckoLibUtil.createInstanceCache(this);

    public WolfLeatherArmorItem(ArmorMaterial material, EquipmentType type, Settings settings) {
        super(material, type, settings);

        SingletonGeoAnimatable.registerSyncedAnimatable(this);
        System.out.println("Registered WolfLeatherArmorItem");
    }

    private PlayState predicate(AnimationState animationState) {
        animationState.getController().setAnimation(RawAnimation.begin().then("idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
     public void createGeoRenderer(Consumer<GeoRenderProvider> consumer) {
         consumer.accept(new GeoRenderProvider() {
             private GeoArmorRenderer<?> renderer;
// <E extends LivingEntity, S extends BipedEntityRenderState> @Nullable BipedEntityModel<?> getGeoArmorRenderer(@Nullable E livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, EquipmentModel.LayerType type, BipedEntityModel<S> original)
             @Override
             public <E extends LivingEntity, S extends BipedEntityRenderState> @Nullable BipedEntityModel<?> getGeoArmorRenderer(@Nullable E livingEntity, ItemStack itemStack, EquipmentSlot equipmentSlot, EquipmentModel.LayerType type, BipedEntityModel<S> original) {
                 if (this.renderer == null) // Important that we do this. If we just instantiate it directly in the field
                                            // it can cause incompatibilities with some mods.
                     this.renderer = new WolfLeatherArmorRenderer();

                 return this.renderer;
             }
         });
     }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, 20, state -> PlayState.CONTINUE));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

}

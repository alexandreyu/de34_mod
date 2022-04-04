package io.github.alexandreyu.de34m.common.item;

import net.minecraft.stats.Stats;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ThrowablePotionItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class RefelxItem extends ThrowablePotionItem {

	public RefelxItem(Properties properties) {
		super(properties);
		// TODO Auto-generated constructor stub
	}
	
	public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
	      ItemStack itemstack = player.getItemInHand(hand);
	      if (!level.isClientSide) {
	         ThrownPotion bleach = new ThrownPotion(level, player);
	         bleach.setItem(itemstack);
	         bleach.shootFromRotation(player, player.getXRot(), player.getYRot(), 20.0F, 0.5F, 1.0F);
	         level.addFreshEntity(bleach);
	      }

	      player.awardStat(Stats.ITEM_USED.get(this));
	      if (!player.getAbilities().instabuild) {
	         itemstack.shrink(1);
	      }

	      return InteractionResultHolder.sidedSuccess(itemstack, level.isClientSide());
	   }
	
	@Override
	public void shootFromRotation(Entity entity, float xrot, float yrot, float p_37255_, float p_37256_, float p_37257_) {
	      float f = -Mth.sin(yrot * ((float)Math.PI / 180F)) * Mth.cos(xrot * ((float)Math.PI / 180F));
	      float f1 = -Mth.sin((xrot + p_37255_) * ((float)Math.PI / 180F));
	      float f2 = Mth.cos(yrot * ((float)Math.PI / 180F)) * Mth.cos(xrot * ((float)Math.PI / 180F));
	      this.shoot((double)f, (double)f1, (double)f2, p_37256_, p_37257_);
	      Vec3 vec3 = entity.getDeltaMovement();
	      this.setDeltaMovement(this.getDeltaMovement().add(vec3.x, entity.isOnGround() ? 0.0D : vec3.y, vec3.z));
	   }
	
}

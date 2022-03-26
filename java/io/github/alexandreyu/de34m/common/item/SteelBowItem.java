package io.github.alexandreyu.de34m.common.item;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;

public class SteelBowItem extends BowItem{

	public SteelBowItem(Properties p_40660_) {
		super(p_40660_);
		// TODO Auto-generated constructor stub
	}
	
	public void releaseUsing(ItemStack item, Level level, LivingEntity livingEntity, int durabiliyu) {
	      if (livingEntity instanceof Player) {
	         Player player = (Player)livingEntity;
	         boolean flag = player.getAbilities().instabuild || EnchantmentHelper.getItemEnchantmentLevel(Enchantments.INFINITY_ARROWS, item) > 0;
	         ItemStack itemstack = player.getProjectile(item);

	         int i = this.getUseDuration(item) - durabiliyu;
	         i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(item, level, player, i, !itemstack.isEmpty() || flag);
	         if (i < 0) return;

	         if (!itemstack.isEmpty() || flag) {
	            if (itemstack.isEmpty()) {
	               itemstack = new ItemStack(Items.ARROW);
	            }

	            float f = getPowerForTime(i);
	            if (!((double)f < 0.1D)) {
	               boolean flag1 = player.getAbilities().instabuild || (itemstack.getItem() instanceof ArrowItem && ((ArrowItem)itemstack.getItem()).isInfinite(itemstack, item, player));
	               if (!level.isClientSide) {
	                  ArrowItem arrowitem = (ArrowItem)(itemstack.getItem() instanceof ArrowItem ? itemstack.getItem() : Items.ARROW);
	                  AbstractArrow abstractarrow = arrowitem.createArrow(level, itemstack, player);
	                  abstractarrow = customArrow(abstractarrow);
	                  abstractarrow.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, f * 3.0F, 1.0F);
	                  abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + 1.5D + 1.5D);
	                  if (f == 1.0F) {
	                     abstractarrow.setCritArrow(true);
	                  }

	                  int j = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.POWER_ARROWS, item);
	                  if (j > 0) {
	                     abstractarrow.setBaseDamage(abstractarrow.getBaseDamage() + (double)j * 0.5D + 0.5D);
	                  }

	                  int k = EnchantmentHelper.getItemEnchantmentLevel(Enchantments.PUNCH_ARROWS, item);
	                  if (k > 0) {
	                     abstractarrow.setKnockback(k);
	                  }

	                  if (EnchantmentHelper.getItemEnchantmentLevel(Enchantments.FLAMING_ARROWS, item) > 0) {
	                     abstractarrow.setSecondsOnFire(100);
	                  }

	                  item.hurtAndBreak(1, player, (p_40665_) -> {
	                     p_40665_.broadcastBreakEvent(player.getUsedItemHand());
	                  });
	                  if (flag1 || player.getAbilities().instabuild && (itemstack.is(Items.SPECTRAL_ARROW) || itemstack.is(Items.TIPPED_ARROW))) {
	                     abstractarrow.pickup = AbstractArrow.Pickup.CREATIVE_ONLY;
	                  }

	                  level.addFreshEntity(abstractarrow);
	               }

	               level.playSound((Player)null, player.getX(), player.getY(), player.getZ(), SoundEvents.ARROW_SHOOT, SoundSource.PLAYERS, 1.0F, 1.0F / (level.getRandom().nextFloat() * 0.4F + 1.2F) + f * 0.5F);
	               if (!flag1 && !player.getAbilities().instabuild) {
	                  itemstack.shrink(1);
	                  if (itemstack.isEmpty()) {
	                     player.getInventory().removeItem(itemstack);
	                  }
	               }

	               player.awardStat(Stats.ITEM_USED.get(this));
	            }
	         }
	      }
	   }

}

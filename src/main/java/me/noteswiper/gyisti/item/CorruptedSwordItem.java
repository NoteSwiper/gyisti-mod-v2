
package me.noteswiper.gyisti.item;

import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.resources.ResourceLocation;

public class CorruptedSwordItem extends SwordItem {
	public CorruptedSwordItem() {
		super(new Tier() {
			public int getUses() {
				return 3348;
			}

			public float getSpeed() {
				return 5.5f;
			}

			public float getAttackDamageBonus() {
				return 2.1f;
			}

			public int getLevel() {
				return 2;
			}

			public int getEnchantmentValue() {
				return 5;
			}

			public Ingredient getRepairIngredient() {
				return Ingredient.of(ItemTags.create(new ResourceLocation("minecraft:corrupted/item")));
			}
		}, 3, -2.6f, new Item.Properties());
	}
}

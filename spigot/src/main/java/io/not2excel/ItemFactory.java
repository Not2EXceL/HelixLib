package io.not2excel;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

public class ItemFactory {

	private ItemStack itemStack;

	public ItemFactory(Material mat){
		itemStack = new ItemStack(mat);
	}

	public ItemFactory(ItemStack stack){
		itemStack = stack;
	}

	public ItemMeta getMeta(){
		return itemStack.getItemMeta();
	}

	public ItemFactory setLore(List<String> lore){
		if(lore == null) return this;
		ItemMeta meta = getMeta();
		meta.setLore(StringUtil.colorList(lore));
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemFactory setLore(int index, String lore){
		ItemMeta meta = getMeta();
		List<String> lores = meta.getLore();
		//if(lores.size() < index) //Not needed lel?
		while(index + 1 > lores.size())
			lores.add("");
		lores.add(StringUtil.colorString(lore));
		meta.setLore(lores);
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemFactory setDisplayName(String displayName){
		ItemMeta meta = getMeta();
		meta.setDisplayName(StringUtil.colorString(displayName));
		itemStack.setItemMeta(meta);
		return this;
	}

	public ItemFactory setAmount(int amount){
		itemStack.setAmount(amount);
		return this;
	}

	public ItemFactory setMaterial(Material mat){
		itemStack.setType(mat);
		return this;
	}

	public ItemFactory setMaterial(int materialId){
		itemStack.setType(Material.getMaterial(materialId));
		return this;
	}

	/**
	 * Sets the glow that you get when you enchant an item without enchanting
	 * an item
	 */
	public ItemFactory addGlow(boolean boo){
		if(!boo) return this;
		this.addEnchantment(Enchantment.OXYGEN, 1);
		ItemMeta meta = itemStack.getItemMeta();
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		itemStack.setItemMeta(meta);
		return this;
	}

	/**
	 * Adds a map of enchantments to the item
	 * (Doesn't have to be safe)
	 *
	 * @param enchantments The enchantment mapped to the integer level of the enchantment
	 */
	public ItemFactory setEnchantments(Map<Enchantment, Integer> enchantments){
		itemStack.addUnsafeEnchantments(enchantments);
		return this;
	}

	/**
	 * Adds an unsafe enchantment to the itemstack
	 *
	 * @param enchant The enchantment to apply
	 * @param level The level of the enchantment
	 */
	public ItemFactory addEnchantment(Enchantment enchant, Integer level){
		itemStack.addUnsafeEnchantment(enchant, level);
		return this;
	}

	@Deprecated
	/**
	 * Uses some random spigot method to set unbreakability of the itemstack
	 * Note: Hasn't been tested yet, deprecated until testing occurs
	 */
	public ItemFactory setUnbreakable(){
		ItemMeta meta = getMeta();
		meta.spigot().setUnbreakable(true);
		itemStack.setItemMeta(meta);
		return this;
	}

	/**
	 * Sets the durability, itemmeta, damage value, whatever you want to call it
	 * of the item, limited to 32767... because minecraft
	 *
	 * @param durability the durability, with upper bound of 32767
	 */
	public ItemFactory setDurability(int durability){
		itemStack.setDurability((short) (durability > 32767 ? 32767 : durability));
		return this;
	}

	/**
	 * @return the amount of players that own minecraft, casted to an item stack
	 */
	public ItemStack getItemStack(){
		return itemStack;
	}

}

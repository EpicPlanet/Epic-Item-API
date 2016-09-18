/*
 * This file is part of Epic-Item-API, licensed under the MIT License (MIT).
 *
 * Copyright (c) Epic Planet Minecraft Server <https://epicpla.net>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.epicpla.epicitemapi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Utility;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFactory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import java.util.*;

/**
 * Allows simply manipulating an {@link ItemStack}. <br>
 * Always changes the {@link ItemStack}'s content directly.<br>
 * <code>set</code>xxx methods will return the object itself except {@link #setItemMeta(ItemMeta)}.<br>
 * e.g. <code>new EItemStack(stack).setDisplayName("FooBar").setLore("Foo", "Bar");</code>
 */
public class EItemStack implements Cloneable, ConfigurationSerializable {

    private ItemStack handle;

    /**
     * Does not create a new ItemStack but manipulates existing {@link ItemStack}
     * @param handle {@link ItemStack} to be manipulated
     */
    public EItemStack(final ItemStack handle) {
        this.handle = handle;
    }

    /**
     * Gets the {@link ItemStack} being manipulated
     * @return {@link ItemStack} being manipulated
     */
    public ItemStack getItemStack() {
        return handle;
    }

    /**
     * Defaults stack size to 1, with no extra data
     *
     * @param type item material id
     * @deprecated Magic value
     */
    @Deprecated
    public EItemStack(final int type) {
        handle = new ItemStack(type);
    }

    /**
     * Defaults stack size to 1, with no extra data
     *
     * @param type item material
     */
    public EItemStack(final Material type) {
        handle = new ItemStack(type);
    }

    /**
     * An item stack with no extra data
     *
     * @param type   item material id
     * @param amount stack size
     * @deprecated Magic value
     */
    @Deprecated
    public EItemStack(final int type, final int amount) {
        handle = new ItemStack(type, amount);
    }

    /**
     * An item stack with no extra data
     *
     * @param type   item material
     * @param amount stack size
     */
    public EItemStack(final Material type, final int amount) {
        handle = new ItemStack(type, amount);
    }

    /**
     * An item stack with the specified damage / durability
     *
     * @param type   item material id
     * @param amount stack size
     * @param damage durability / damage
     * @deprecated Magic value
     */
    @Deprecated
    public EItemStack(final int type, final int amount, final short damage) {
        handle = new ItemStack(type, amount, damage);
    }

    /**
     * An item stack with the specified damage / durabiltiy
     *
     * @param type   item material
     * @param amount stack size
     * @param damage durability / damage
     */
    public EItemStack(final Material type, final int amount, final short damage) {
        handle = new ItemStack(type, amount, damage);
    }

    /**
     * @param type   the raw type id
     * @param amount the amount in the stack
     * @param damage the damage value of the item
     * @param data   the data value or null
     * @deprecated this method uses an ambiguous data byte object
     */
    @Deprecated
    public EItemStack(final int type, final int amount, final short damage, final Byte data) {
        handle = new ItemStack(type, amount, damage, data);
    }

    /**
     * @param type   the type
     * @param amount the amount in the stack
     * @param damage the damage value of the item
     * @param data   the data value or null
     * @deprecated this method uses an ambiguous data byte object
     */
    @Deprecated
    public EItemStack(final Material type, final int amount, final short damage, final Byte data) {
        handle = new ItemStack(type, amount, damage, data);
    }

    /**
     * Gets the type of this item
     *
     * @return Type of the items in this stack
     */
    @Utility
    public Material getType() {
        return handle.getType();
    }

    /**
     * Sets the type of this item
     * <p>
     * Note that in doing so you will reset the MaterialData for this stack
     *
     * @param type New type to set the items in this stack to
     */
    @Utility
    public EItemStack setType(Material type) {
        handle.setType(type);
        return this;
    }

    /**
     * Gets the type id of this item
     *
     * @return Type Id of the items in this stack
     * @deprecated Magic value
     */
    @Deprecated
    public int getTypeId() {
        return handle.getTypeId();
    }

    /**
     * Sets the type id of this item
     * <p>
     * Note that in doing so you will reset the MaterialData for this stack
     *
     * @param type New type id to set the items in this stack to
     * @deprecated Magic value
     */
    @Deprecated
    public EItemStack setTypeId(int type) {
        handle.setTypeId(type);
        return this;
    }

    /**
     * Gets the amount of items in this stack
     *
     * @return Amount of items in this stack
     */
    public int getAmount() {
        return handle.getAmount();
    }

    /**
     * Sets the amount of items in this stack
     *
     * @param amount New amount of items in this stack
     */
    public EItemStack setAmount(int amount) {
        handle.setAmount(amount);
        return this;
    }

    /**
     * Gets the MaterialData for this stack of items
     *
     * @return MaterialData for this item
     */
    public MaterialData getData() {
        return handle.getData();
    }

    /**
     * Sets the MaterialData for this stack of items
     *
     * @param data New MaterialData for this item
     */
    public EItemStack setData(MaterialData data) {
        handle.setData(data);
        return this;
    }

    /**
     * Sets the durability of this item
     *
     * @param durability Durability of this item
     */
    public EItemStack setDurability(final short durability) {
        handle.setDurability(durability);
        return this;
    }

    /**
     * Gets the durability of this item
     *
     * @return Durability of this item
     */
    public short getDurability() {
        return handle.getDurability();
    }

    /**
     * Get the maximum stacksize for the material hold in this ItemStack.
     * (Returns -1 if it has no idea)
     *
     * @return The maximum you can stack this material to.
     */
    @Utility
    public int getMaxStackSize() {
        return handle.getMaxStackSize();
    }

    @Override
    @Utility
    public String toString() {
        return handle.toString();
    }

    @Override
    @Utility
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EItemStack)) {
            return false;
        }

        EItemStack stack = (EItemStack) obj;
        return handle.getAmount() == stack.handle.getAmount() && handle.isSimilar(stack.handle);
    }

    /**
     * This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack the item stack to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    @Utility
    public boolean isSimilar(ItemStack stack) {
        return handle.isSimilar(stack);
    }

    /**
     * This method is the same as equals, but does not consider stack size
     * (amount).
     *
     * @param stack the item stack to compare to
     * @return true if the two stacks are equal, ignoring the amount
     */
    @Utility
    public boolean isSimilar(EItemStack stack) {
        return handle.isSimilar(stack.handle);
    }

    @Override
    public EItemStack clone() {
        return new EItemStack(handle.clone());
    }

    @Override
    @Utility
    public int hashCode() {
        return handle.hashCode() * 31 + 1;
    }

    /**
     * Checks if this ItemStack contains the given {@link Enchantment}
     *
     * @param ench Enchantment to test
     * @return True if this has the given enchantment
     */
    public boolean containsEnchantment(Enchantment ench) {
        return handle.containsEnchantment(ench);
    }

    /**
     * Gets the level of the specified enchantment on this item stack
     *
     * @param ench Enchantment to check
     * @return Level of the enchantment, or 0
     */
    public int getEnchantmentLevel(Enchantment ench) {
        return handle.getEnchantmentLevel(ench);
    }

    /**
     * Gets a map containing all enchantments and their levels on this item.
     *
     * @return Map of enchantments.
     */
    public Map<Enchantment, Integer> getEnchantments() {
        return handle.getEnchantments();
    }

    /**
     * Adds the specified enchantments to this item stack.
     * <p>
     * This method is the same as calling {@link
     * #addEnchantment(org.bukkit.enchantments.Enchantment, int)} for each
     * element of the map.
     *
     * @param enchantments Enchantments to add
     * @throws IllegalArgumentException if the specified enchantments is null
     * @throws IllegalArgumentException if any specific enchantment or level
     *                                  is null. <b>Warning</b>: Some enchantments may be added before this
     *                                  exception is thrown.
     */
    @Utility
    public EItemStack addEnchantments(Map<Enchantment, Integer> enchantments) {
        handle.addEnchantments(enchantments);
        return this;
    }

    /**
     * Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     *
     * @param ench  Enchantment to add
     * @param level Level of the enchantment
     * @throws IllegalArgumentException if enchantment null, or enchantment is
     *                                  not applicable
     */
    @Utility
    public EItemStack addEnchantment(Enchantment ench, int level) {
        handle.addEnchantment(ench, level);
        return this;
    }

    /**
     * Adds the specified enchantments to this item stack in an unsafe manner.
     * <p>
     * This method is the same as calling {@link
     * #addUnsafeEnchantment(org.bukkit.enchantments.Enchantment, int)} for
     * each element of the map.
     *
     * @param enchantments Enchantments to add
     */
    @Utility
    public EItemStack addUnsafeEnchantments(Map<Enchantment, Integer> enchantments) {
        handle.addUnsafeEnchantments(enchantments);
        return this;
    }

    /**
     * Adds the specified {@link Enchantment} to this item stack.
     * <p>
     * If this item stack already contained the given enchantment (at any
     * level), it will be replaced.
     * <p>
     * This method is unsafe and will ignore level restrictions or item type.
     * Use at your own discretion.
     *
     * @param ench  Enchantment to add
     * @param level Level of the enchantment
     */
    public EItemStack addUnsafeEnchantment(Enchantment ench, int level) {
        handle.addUnsafeEnchantment(ench, level);
        return this;
    }

    /**
     * Removes the specified {@link Enchantment} if it exists on this
     * ItemStack
     *
     * @param ench Enchantment to remove
     * @return Previous level, or 0
     */
    public int removeEnchantment(Enchantment ench) {
        return handle.removeEnchantment(ench);
    }

    @Utility
    public Map<String, Object> serialize() {
        Map<String, Object> result = new LinkedHashMap<>();

        result.put("type", handle.getType().name());

        if (handle.getDurability() != 0) {
            result.put("damage", handle.getDurability());
        }

        if (handle.getAmount() != 1) {
            result.put("amount", handle.getAmount());
        }

        ItemMeta meta = handle.getItemMeta();
        if (!Bukkit.getItemFactory().equals(meta, null)) {
            result.put("meta", meta);
        }

        return result;
    }

    /**
     * Required method for configuration serialization
     *
     * @param args map to deserialize
     * @return deserialized item stack
     * @see ConfigurationSerializable
     */
    public static EItemStack deserialize(Map<String, Object> args) {
        Material type = Material.getMaterial((String) args.get("type"));
        short damage = 0;
        int amount = 1;

        if (args.containsKey("damage")) {
            damage = ((Number) args.get("damage")).shortValue();
        }

        if (args.containsKey("amount")) {
            amount = ((Number) args.get("amount")).intValue();
        }

        ItemStack result = new ItemStack(type, amount, damage);

        if (args.containsKey("enchantments")) { // Backward compatiblity, @deprecated
            Object raw = args.get("enchantments");

            if (raw instanceof Map) {
                Map<?, ?> map = (Map<?, ?>) raw;

                for (Map.Entry<?, ?> entry : map.entrySet()) {
                    Enchantment enchantment = Enchantment.getByName(entry.getKey().toString());

                    if ((enchantment != null) && (entry.getValue() instanceof Integer)) {
                        result.addUnsafeEnchantment(enchantment, (Integer) entry.getValue());
                    }
                }
            }
        } else if (args.containsKey("meta")) { // We cannot and will not have meta when enchantments (pre-ItemMeta) exist
            Object raw = args.get("meta");
            if (raw instanceof ItemMeta) {
                result.setItemMeta((ItemMeta) raw);
            }
        }

        return new EItemStack(result);
    }

    /**
     * Get a copy of this ItemStack's {@link ItemMeta}.
     *
     * @return a copy of the current ItemStack's ItemData
     */
    public ItemMeta getItemMeta() {
        return handle.getItemMeta();
    }

    /**
     * Checks to see if any meta data has been defined.
     *
     * @return Returns true if some meta data has been set for this item
     */
    public boolean hasItemMeta() {
        return handle.hasItemMeta();
    }

    /**
     * Set the ItemMeta of this ItemStack.
     *
     * @param itemMeta new ItemMeta, or null to indicate meta data be cleared.
     * @return True if successfully applied ItemMeta, see {@link
     * ItemFactory#isApplicable(ItemMeta, ItemStack)}
     * @throws IllegalArgumentException if the item meta was not created by
     *                                  the {@link ItemFactory}
     */
    public boolean setItemMeta(ItemMeta itemMeta) {
        return handle.setItemMeta(itemMeta);
    }

    /**
     * Checks for existence of a display name.
     *
     * @return true if this has a display name
     */
    public boolean hasDisplayName() {
        return getItemMeta().hasDisplayName();
    }

    /**
     * Gets the display name that is set.
     * <p>
     * Plugins should check that hasDisplayName() returns <code>true</code>
     * before calling this method.
     *
     * @return the display name that is set
     */
    public String getDisplayName() {
        return getItemMeta().getDisplayName();
    }

    /**
     * Sets the display name.
     *
     * @param name the name to set
     */
    public EItemStack setDisplayName(String name) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setDisplayName(name);
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Checks for existence of lore.
     *
     * @return true if this has lore
     */
    public boolean hasLore() {
        return getItemMeta().hasLore();
    }

    /**
     * Gets the lore that is set.
     * <p>
     * Plugins should check if hasLore() returns <code>true</code> before
     * calling this method.
     *
     * @return a list of lore that is set
     */
    public List<String> getLore() {
        return getItemMeta().getLore();
    }

    /**
     * Sets the lore for this item.
     * Removes lore when given null.
     *
     * @param lore the lore that will be set
     */
    public EItemStack setLore(List<String> lore) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setLore(lore);
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Sets the lore for this item.
     * Removes lore when given null.
     *
     * @param lore the lore that will be set
     */
    public EItemStack setLore(String... lore) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.setLore(Arrays.asList(lore));
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Checks if the specified enchantment conflicts with any enchantments in
     * this ItemMeta.
     *
     * @param ench enchantment to test
     * @return true if the enchantment conflicts, false otherwise
     */
    public boolean hasConflictingEnchant(Enchantment ench) {
        return getItemMeta().hasConflictingEnchant(ench);
    }

    /**
     * Set itemflags which should be ignored when rendering a ItemStack in the Client. This Method does silently ignore double set itemFlags.
     *
     * @param itemFlags The hideflags which shouldn't be rendered
     */
    public EItemStack addItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(itemFlags);
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Set itemflags which should be ignored when rendering a ItemStack in the Client. This Method does silently ignore double set itemFlags.
     *
     * @param itemFlags The hideflags which shouldn't be rendered
     */
    public EItemStack addItemFlags(List<ItemFlag> itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.addItemFlags(itemFlags.toArray(new ItemFlag[0]));
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Remove specific set of itemFlags. This tells the Client it should render it again. This Method does silently ignore double removed itemFlags.
     *
     * @param itemFlags Hideflags which should be removed
     */
    public EItemStack removeItemFlags(ItemFlag... itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemFlags);
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Remove specific set of itemFlags. This tells the Client it should render it again. This Method does silently ignore double removed itemFlags.
     *
     * @param itemFlags Hideflags which should be removed
     */
    public EItemStack removeItemFlags(List<ItemFlag> itemFlags) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.removeItemFlags(itemFlags.toArray(new ItemFlag[0]));
        setItemMeta(itemMeta);
        return this;
    }

    /**
     * Get current set itemFlags. The collection returned is unmodifiable.
     *
     * @return A set of all itemFlags set
     */
    public Set<ItemFlag> getItemFlags() {
        return getItemMeta().getItemFlags();
    }

    /**
     * Check if the specified flag is present on this item.
     *
     * @param flag the flag to check
     * @return if it is present
     */
    public boolean hasItemFlag(ItemFlag flag) {
        return getItemMeta().hasItemFlag(flag);
    }

    /**
     * Return if the unbreakable tag is true
     *
     * @return true if the unbreakable tag is true
     */
    public boolean isUnbreakable() {
        return getItemMeta().spigot().isUnbreakable();
    }

    /**
     * Sets the unbreakable tag
     *
     * @param unbreakable true if set unbreakable
     */
    public EItemStack setUnbreakable(boolean unbreakable) {
        ItemMeta itemMeta = getItemMeta();
        itemMeta.spigot().setUnbreakable(unbreakable);
        setItemMeta(itemMeta);
        return this;
    }
}

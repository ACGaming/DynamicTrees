package com.ferreusveritas.dynamictrees.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import com.ferreusveritas.dynamictrees.ModTabs;
import com.ferreusveritas.dynamictrees.api.TreeRegistry;
import com.ferreusveritas.dynamictrees.trees.Species;

public class Bark extends Item {
	
	public final static String TREE = "tree";

	public Bark() {
		this("bark");
	}

	public Bark(String name) {
		setRegistryName(name);
		setUnlocalizedName(getRegistryName().toString());
		setCreativeTab(ModTabs.dynamicTreesTab);
	}
	
	public NBTTagCompound getNBT(ItemStack itemStack) {
		return itemStack.hasTagCompound() ? itemStack.getTagCompound() : new NBTTagCompound();
	}

	public Bark setSpecies(ItemStack itemStack, Species species) {
		NBTTagCompound nbt = getNBT(itemStack);
		nbt.setString(TREE, species.toString());
		itemStack.setTagCompound(nbt);
		return this;
	}

	public Species getSpecies(ItemStack itemStack) {
		NBTTagCompound nbt = getNBT(itemStack);

		if (nbt.hasKey(TREE)) {
			return TreeRegistry.findSpecies(new ResourceLocation(nbt.getString(TREE)));
		} else {
			Species species = TreeRegistry.findSpeciesSloppy("oak");
			setSpecies(itemStack, species);
			return species;
		}
	}
}

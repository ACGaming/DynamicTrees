package com.ferreusveritas.dynamictrees;

import com.ferreusveritas.dynamictrees.items.Bark;
import com.ferreusveritas.dynamictrees.items.DendroPotion;
import com.ferreusveritas.dynamictrees.items.DirtBucket;
import com.ferreusveritas.dynamictrees.items.Staff;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.ArrayList;

@Mod.EventBusSubscriber(modid = ModConstants.MODID)
public class ModItems {

	public static DendroPotion dendroPotion;
	public static DirtBucket dirtBucket;
	public static Staff treeStaff;
	public static Bark bark;

	public static void preInit() {
		dendroPotion = new DendroPotion();//Potions
		dirtBucket = new DirtBucket();//Dirt Bucket
		treeStaff = new Staff();//Creative Mode Staff
		bark = new Bark();//Bark
	}

	@SubscribeEvent
	public static void register(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();

		ArrayList<Item> treeItems = new ArrayList<>();
		ModTrees.baseFamilies.forEach(tree -> tree.getRegisterableItems(treeItems));
		ModTrees.dynamicCactus.getRegisterableItems(treeItems);

		registry.registerAll(dendroPotion, dirtBucket, treeStaff, bark);
		registry.registerAll(treeItems.toArray(new Item[0]));
	}

}

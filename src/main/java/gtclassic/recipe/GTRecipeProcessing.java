package gtclassic.recipe;

import java.util.Iterator;
import java.util.Map;

import gtclassic.material.GTMaterial;
import gtclassic.material.GTMaterialGen;
import ic2.api.classic.recipe.ClassicRecipes;
import ic2.api.classic.recipe.machine.IMachineRecipeList;
import ic2.core.block.machine.low.TileEntityCompressor;
import ic2.core.block.machine.low.TileEntityExtractor;
import ic2.core.block.machine.low.TileEntityMacerator;
import ic2.core.platform.registry.Ic2Items;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fluids.FluidRegistry;

public class GTRecipeProcessing {

	static IMachineRecipeList smelting = ClassicRecipes.furnace;

	public static void init() {
		maceratorUtil("oreBauxite", 1, GTMaterialGen.getDust(GTMaterial.Bauxite, 4));
		maceratorUtil("oreIridium", 1, GTMaterialGen.getDust(GTMaterial.Iridium, 2));
		TileEntityMacerator.addRecipe(GTMaterialGen.getIc2(Ic2Items.iridiumOre, 1), GTMaterialGen.getDust(GTMaterial.Iridium, 1));
		TileEntityMacerator.addRecipe("stoneMarble", 1, GTMaterialGen.getDust(GTMaterial.Calcite, 1));
		TileEntityMacerator.addRecipe("stoneLimestone", 1, GTMaterialGen.getDust(GTMaterial.Calcite, 1));
		TileEntityMacerator.addRecipe(GTMaterialGen.get(Items.FLINT, 1), GTMaterialGen.getDust(GTMaterial.Flint, 1));
		TileEntityMacerator.addRecipe("enderpearl", 1, GTMaterialGen.getDust(GTMaterial.EnderPearl, 1));
		TileEntityMacerator.addRecipe(GTMaterialGen.get(Items.ENDER_EYE, 1), GTMaterialGen.getDust(GTMaterial.EnderEye, 2));
		TileEntityMacerator.addRecipe("gemEmerald", 1, GTMaterialGen.getDust(GTMaterial.Emerald, 1));
		TileEntityExtractor.addRecipe("oreRuby", 1, GTMaterialGen.getGem(GTMaterial.Ruby, 3), 0.1F);
		TileEntityExtractor.addRecipe("oreSapphire", 1, GTMaterialGen.getGem(GTMaterial.Sapphire, 3), 0.1F);
		TileEntityCompressor.addRecipe("dustEmerald", 1, GTMaterialGen.get(Items.EMERALD, 1));
		TileEntityCompressor.addRecipe("dustCarbon", 8, GTMaterialGen.getIc2(Ic2Items.carbonFiber, 1));
		TileEntityCompressor.addRecipe("dustUranium", 1, GTMaterialGen.getIc2(Ic2Items.uraniumIngot, 1), 0.3F);
		TileEntityCompressor.addRecipe("dustThorium", 1, GTMaterialGen.getIngot(GTMaterial.Thorium, 1));
		ClassicRecipes.fluidGenerator.addEntry(FluidRegistry.getFluid("sodium"), 3800, 8);
		ClassicRecipes.fluidGenerator.addEntry(FluidRegistry.getFluid("hydrogen"), 950, 16);
		ClassicRecipes.fluidGenerator.addEntry(FluidRegistry.getFluid("methane"), 3000, 16);
	}

	/*
	 * Adds a macerator recipe while removing duplicates generated by ic2c
	 */
	public static void maceratorUtil(String input, int amount, ItemStack output) {
		TileEntityMacerator.oreBlacklist.add(input);
		TileEntityMacerator.addRecipe(input, amount, output);
	}

	/*
	 * removing smelting recipes code by Muramasa
	 */
	public static void removeSmelting(ItemStack resultStack) {
		ItemStack recipeResult;
		Map<ItemStack, ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator<ItemStack> iterator = recipes.keySet().iterator();
		while (iterator.hasNext()) {
			ItemStack tmpRecipe = iterator.next();
			recipeResult = recipes.get(tmpRecipe);
			if (ItemStack.areItemStacksEqual(resultStack, recipeResult)) {
				iterator.remove();
			}
		}
	}
}
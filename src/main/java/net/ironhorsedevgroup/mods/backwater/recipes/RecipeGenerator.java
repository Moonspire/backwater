package net.ironhorsedevgroup.mods.backwater.recipes;

import net.ironhorsedevgroup.mods.backwater.registry.BWItems;
import net.ironhorsedevgroup.mods.toolshed.materials.MaterialIngredient;
import net.ironhorsedevgroup.mods.toolshed.materials.Materials;
import net.ironhorsedevgroup.mods.toolshed.tools.Tags;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.minecraftforge.common.data.ForgeItemTagsProvider;

import java.util.Arrays;
import java.util.function.Consumer;

public class RecipeGenerator extends RecipeProvider implements IConditionBuilder {
    public RecipeGenerator(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        rainBarrelRecipe(BWItems.DARK_OAK_RAIN_BARREL.get(), new MaterialIngredient("minecraft:dark_oak"), consumer);
        rainBarrelRecipe(BWItems.OAK_RAIN_BARREL.get(), new MaterialIngredient("minecraft:oak"), consumer);
        rainBarrelRecipe(BWItems.BIRCH_RAIN_BARREL.get(), new MaterialIngredient("minecraft:birch"), consumer);
        rainBarrelRecipe(BWItems.SPRUCE_RAIN_BARREL.get(), new MaterialIngredient("minecraft:spruce"), consumer);
        rainBarrelRecipe(BWItems.JUNGLE_RAIN_BARREL.get(), new MaterialIngredient("minecraft:jungle"), consumer);
        rainBarrelRecipe(BWItems.MANGROVE_RAIN_BARREL.get(), new MaterialIngredient("minecraft:mangrove"), consumer);
        rainBarrelRecipe(BWItems.ACACIA_RAIN_BARREL.get(), new MaterialIngredient("minecraft:acacia"), consumer);
        wellShaftRecipe(BWItems.WELL_SHAFT.get(), Items.COBBLESTONE, consumer);
        wellTopperRecipe(BWItems.WELL_TOPPER.get(), Items.COBBLESTONE, Tags.getItemTag(new ResourceLocation("forge:rods/wooden")), Tags.getItemTag(new ResourceLocation("minecraft", "wooden_slabs")), consumer);
    }

    public void wellTopperRecipe(ItemLike topper, ItemLike material, TagKey<Item> support, TagKey<Item> roof, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shaped(topper)
                .define('R', roof)
                .define('S', support)
                .define('X', material)
                .pattern("RRR")
                .pattern("S S")
                .pattern("X X")
                .group("well_shaft")
                .unlockedBy("has_stone", has(material))
                .save(consumer, new ResourceLocation("backwater", "crafting/wells/" + getItemName(topper)));

    }

    public void wellShaftRecipe(ItemLike shaft, ItemLike material, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shaped(shaft, 8)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .pattern("X X")
                .group("well_shaft")
                .unlockedBy("has_stone", has(Items.COBBLESTONE))
                .save(consumer, new ResourceLocation("backwater", "crafting/wells/" + getItemName(shaft)));

    }

    public void rainBarrelRecipe(ItemLike barrel, Ingredient material, Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shaped(barrel, 2)
                .define('X', material)
                .pattern("X X")
                .pattern("X X")
                .pattern("XXX")
                .group("rain_barrel")
                .unlockedBy("has_planks", has(Items.OAK_PLANKS))
                .save(consumer, new ResourceLocation("backwater", "crafting/barrels/" + getItemName(barrel)));
    }
}

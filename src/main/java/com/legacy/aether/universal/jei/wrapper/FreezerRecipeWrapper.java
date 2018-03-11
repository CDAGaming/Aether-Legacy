package com.legacy.aether.universal.jei.wrapper;

import com.google.common.collect.Lists;
import com.legacy.aether.api.AetherAPI;
import com.legacy.aether.api.freezables.AetherFreezable;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class FreezerRecipeWrapper implements IRecipeWrapper {

    private final ArrayList<ItemStack> inputs;

    private final ArrayList<ItemStack> outputs;

    public AetherFreezable freezable;

    public FreezerRecipeWrapper(AetherFreezable recipe) {
        this.freezable = recipe;

        this.inputs = Lists.newArrayList();
        this.outputs = Lists.newArrayList();

        for (AetherFreezable freezable : AetherAPI.getInstance().getFreezableValues()) {
            this.inputs.add(freezable.getInput());
            this.outputs.add(freezable.getOutput());
        }
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(ItemStack.class, this.freezable.getInput());
        ingredients.setOutput(ItemStack.class, this.freezable.getOutput());
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {

    }

    @Override
    public List<String> getTooltipStrings(int mouseX, int mouseY) {
        return null;
    }

    @Override
    public boolean handleClick(Minecraft minecraft, int mouseX, int mouseY, int mouseButton) {
        return false;
    }

}
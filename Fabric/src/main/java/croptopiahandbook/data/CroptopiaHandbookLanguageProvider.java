package croptopiahandbook.data;

import java.util.concurrent.CompletableFuture;

import org.jspecify.annotations.NonNull;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import net.minecraft.core.HolderLookup;

import croptopiahandbook.data.book.CroptopiaHandbookBookProvider;

public class CroptopiaHandbookLanguageProvider extends FabricLanguageProvider {

    protected CroptopiaHandbookLanguageProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryFuture) {
        super(dataOutput, registryFuture);
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registryLookup, @NonNull TranslationBuilder translationBuilder) {
        addBookEntry(translationBuilder, "intro", "Introduction to Croptopia Handbook");
        addBookEntry(translationBuilder, "crops.name", "Crops");
        addBookEntry(translationBuilder, "crops.desc", "Information about the crops that you can find in Croptopia.");
        addBookEntry(translationBuilder, "crops.crops.name", "Plants");
        addBookEntry(translationBuilder, "crops.crops.details", "Crops can be found around the world. They have specific biomes that they will spawn in. In 2.0.0 crop spawning is now determined with datapacks rather than the 'category' of biome, it is now determined by the biomes name. If you would like certain crops added to modded biomes, make an issue on the Croptopia github page.");
        addBookEntry(translationBuilder, "crops.trees.name", "Trees");
        addBookEntry(translationBuilder, "crops.trees.details", "In the world you can find various trees with custom crops growing on them. To harvest them you can right click them when they're fully grown.");
        addBookEntry(translationBuilder, "desserts.name", "Desserts");
        addBookEntry(translationBuilder, "desserts.desc", "Sweet Treats");
        addBookEntry(translationBuilder, "drinks.name", "Drinks");
        addBookEntry(translationBuilder, "drinks.desc", "Croptopia comes with a variety of drinks to satiate your hunger and thirst.");
        addBookEntry(translationBuilder, "ingredients.name", "Ingredients");
        addBookEntry(translationBuilder, "ingredients.desc", "These ingredients are crafted together and then used in other recipes.");
        addBookEntry(translationBuilder, "cooking.name", "Cooking");
        addBookEntry(translationBuilder, "cooking.desc", "These items can be cooked.");
        addBookEntry(translationBuilder, "meals.name", "Meals");
        addBookEntry(translationBuilder, "meals.desc", "Hearty meals to fill you up.");
        addBookEntry(translationBuilder, "snacks.name", "Snacks");
        addBookEntry(translationBuilder, "snacks.desc", "Snacks for a quick pick me up.");
        addBookEntry(translationBuilder, "utensils.name", "Utensils");
        addBookEntry(translationBuilder, "utensils.desc", "All you need to know to craft the different utensils in Croptopia");
    }

    protected void addBookEntry(TranslationBuilder translationBuilder, String name, String text) {
        translationBuilder.add(CroptopiaHandbookBookProvider.translationLoc + name, text);
    }

}

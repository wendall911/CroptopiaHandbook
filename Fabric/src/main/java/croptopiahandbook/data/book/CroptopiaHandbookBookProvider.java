package croptopiahandbook.data.book;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

import org.jspecify.annotations.NonNull;

import com.epherical.croptopia.CroptopiaCommon;
import com.epherical.croptopia.common.ItemNamesV2;
import com.epherical.croptopia.common.MiscNames;
import com.epherical.croptopia.register.Content;
import com.epherical.croptopia.register.helpers.FarmlandCrop;
import com.epherical.croptopia.register.helpers.Furnace;
import com.epherical.croptopia.register.helpers.TreeCrop;
import com.epherical.croptopia.register.helpers.Utensil;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;

import handbook.api.data.BookBuilder;
import handbook.api.data.CategoryBuilder;
import handbook.api.data.EntryBuilder;
import handbook.api.data.HandbookBookProvider;

import croptopiahandbook.CroptopiaHandbook;

public class CroptopiaHandbookBookProvider extends HandbookBookProvider {

    public static final String translationLoc = "info.croptopia.guide.";
    private int categorySortNum = -1;
    private int entrySortNum = -1;
    private final Map<Item, String> ingredients = new HashMap<>(){{
        put(Content.PAPRIKA, ItemNamesV2.PAPRIKA);
        put(Content.SALT, ItemNamesV2.SALT);
        put(Content.OLIVE_OIL, ItemNamesV2.OLIVE_OIL);
        put(Content.CHEESE, ItemNamesV2.CHEESE);
        put(Content.FLOUR, ItemNamesV2.FLOUR);
        put(Content.BUTTER, ItemNamesV2.BUTTER);
        put(Content.NOODLE, ItemNamesV2.NOODLE);
        put(Content.TOFU, ItemNamesV2.TOFU);
        put(Content.CHOCOLATE, ItemNamesV2.CHOCOLATE);
        put(Content.TORTILLA, ItemNamesV2.TORTILLA);
        put(Content.SOY_SAUCE, ItemNamesV2.SOY_SAUCE);
        put(Content.DOUGH, ItemNamesV2.DOUGH);
        put(Content.RAVIOLI, ItemNamesV2.RAVIOLI);
        put(Content.SALSA, ItemNamesV2.SALSA);
        put(Content.ARTICHOKE_DIP, ItemNamesV2.ARTICHOKE_DIP);
        put(Content.PEPPERONI, ItemNamesV2.PEPPERONI);
        put(Content.CREMA, ItemNamesV2.CREMA);
        put(Content.CORN_HUSK, ItemNamesV2.CORN_HUSK);
        put(Content.WHIPPING_CREAM, ItemNamesV2.WHIPPING_CREAM);
        put(Content.WATER_BOTTLE, ItemNamesV2.WATER_BOTTLE);
        put(Content.MILK_BOTTLE, ItemNamesV2.MILK_BOTTLE);
        put(Content.RAW_BACON, ItemNamesV2.RAW_BACON);
        put(Content.ROASTED_PUMPKIN_SEEDS, ItemNamesV2.ROASTED_PUMPKIN_SEEDS);
        put(Content.ROASTED_SUNFLOWER_SEEDS, ItemNamesV2.ROASTED_SUNFLOWER_SEEDS);
        put(Content.SEA_LETTUCE, ItemNamesV2.SEA_LETTUCE);
        put(Content.FROG_LEGS, ItemNamesV2.FROG_LEGS);
        put(Content.GROUND_PORK, ItemNamesV2.GROUND_PORK);
        put(Content.COOKING_OIL, ItemNamesV2.COOKING_OIL);
    }};
    private final Map<Item, String> desserts = new HashMap<>(){{
        put(Content.MANGO_ICE_CREAM.asItem(), ItemNamesV2.MANGO_ICE_CREAM);
        put(Content.PECAN_ICE_CREAM.asItem(), ItemNamesV2.PECAN_ICE_CREAM);
        put(Content.STRAWBERRY_ICE_CREAM.asItem(), ItemNamesV2.STRAWBERRY_ICE_CREAM);
        put(Content.VANILLA_ICE_CREAM.asItem(), ItemNamesV2.VANILLA_ICE_CREAM);
        put(Content.APPLE_PIE.asItem(), ItemNamesV2.APPLE_PIE);
        put(Content.CHERRY_PIE.asItem(), ItemNamesV2.CHERRY_PIE);
        put(Content.PECAN_PIE.asItem(), ItemNamesV2.PECAN_PIE);
        put(Content.RHUBARB_PIE.asItem(), ItemNamesV2.RHUBARB_PIE);
        put(Content.YAM_JAM, ItemNamesV2.YAM_JAM);
        put(Content.BANANA_CREAM_PIE, ItemNamesV2.BANANA_CREAM_PIE);
        put(Content.CANDY_CORN, ItemNamesV2.CANDY_CORN);
        put(Content.RUM_RAISIN_ICE_CREAM, ItemNamesV2.RUM_RAISIN_ICE_CREAM);
        put(Content.CHEESE_CAKE, ItemNamesV2.CHEESE_CAKE);
        put(Content.BROWNIES, ItemNamesV2.BROWNIES);
        put(Content.SNICKER_DOODLE, ItemNamesV2.SNICKER_DOODLE);
        put(Content.BANANA_NUT_BREAD, ItemNamesV2.BANANA_NUT_BREAD);
        put(Content.CANDIED_NUTS, ItemNamesV2.CANDIED_NUTS);
        put(Content.ALMOND_BRITTLE, ItemNamesV2.ALMOND_BRITTLE);
        put(Content.OATMEAL_COOKIE, ItemNamesV2.RAISIN_OATMEAL_COOKIE);
        put(Content.NUTTY_COOKIE, ItemNamesV2.NUTTY_COOKIE);
        put(Content.CORNISH_PASTY, ItemNamesV2.CORNISH_PASTY);
        put(Content.ETON_MESS, ItemNamesV2.ETON_MESS);
        put(Content.STICKY_TOFFEE_PUDDING, ItemNamesV2.CORNISH_PASTY);
        put(Content.TRIFLE, ItemNamesV2.TRIFLE);
        put(Content.SCONES, ItemNamesV2.CORNISH_PASTY);
        put(Content.FIGGY_PUDDING, ItemNamesV2.CORNISH_PASTY);
        put(Content.TREACLE_TART, ItemNamesV2.CORNISH_PASTY);
        put(Content.TRES_LECHE_CAKE, ItemNamesV2.FAJITAS);
        put(Content.CANDIED_KUMQUATS, ItemNamesV2.CANDIED_KUMQUATS);
        put(Content.MERINGUE, ItemNamesV2.MERINGUE);
        put(Content.SWEET_CREPES, ItemNamesV2.SWEET_CREPES);
        put(Content.CINNAMON_ROLL, ItemNamesV2.CINNAMON_ROLL);
        put(Content.CARROT_CAKE, ItemNamesV2.CARROT_CAKE);
    }};
    private final Map<Item, String> drinks = new HashMap<>(){{
        put(Content.APPLE_JUICE.asItem(), ItemNamesV2.APPLE_JUICE);
        put(Content.CRANBERRY_JUICE.asItem(), ItemNamesV2.CRANBERRY_JUICE);
        put(Content.GRAPE_JUICE.asItem(), ItemNamesV2.GRAPE_JUICE);
        put(Content.MELON_JUICE.asItem(), ItemNamesV2.MELON_JUICE);
        put(Content.ORANGE_JUICE.asItem(), ItemNamesV2.ORANGE_JUICE);
        put(Content.PINEAPPLE_JUICE.asItem(), ItemNamesV2.PINEAPPLE_JUICE);
        put(Content.SAGUARO_JUICE.asItem(), ItemNamesV2.SAGUARO_JUICE);
        put(Content.TOMATO_JUICE.asItem(), ItemNamesV2.TOMATO_JUICE);
        put(Content.BANANA_SMOOTHIE.asItem(), ItemNamesV2.BANANA_SMOOTHIE);
        put(Content.STRAWBERRY_SMOOTHIE.asItem(), ItemNamesV2.STRAWBERRY_SMOOTHIE);
        put(Content.COFFEE, ItemNamesV2.COFFEE);
        put(Content.LEMONADE, ItemNamesV2.LEMONADE);
        put(Content.LIMEADE, ItemNamesV2.LIMEADE);
        put(Content.SOY_MILK, ItemNamesV2.SOY_MILK);
        put(Content.KALE_SMOOTHIE, ItemNamesV2.KALE_SMOOTHIE);
        put(Content.FRUIT_SMOOTHIE, ItemNamesV2.FRUIT_SMOOTHIE);
        put(Content.CHOCOLATE_MILKSHAKE, ItemNamesV2.CHOCOLATE_MILKSHAKE);
        put(Content.BEER, ItemNamesV2.BEER);
        put(Content.WINE, ItemNamesV2.WINE);
        put(Content.MEAD, ItemNamesV2.MEAD);
        put(Content.RUM, ItemNamesV2.RUM);
        put(Content.PUMPKIN_SPICE_LATTE, ItemNamesV2.PUMPKIN_SPICE_LATTE);
        put(Content.HORCHATA, ItemNamesV2.HORCHATA);
        put(Content.TEA, ItemNamesV2.TEA);
    }};
    private final Map<String, Furnace> cookingRecipes = new HashMap<>(){{
        put(Content.BLACKBEAN.name(), Content.BAKED_BEANS);
        put(Content.SWEETPOTATO.name(), Content.BAKED_SWEET_POTATO);
        put(Content.YAM.name(), Content.BAKED_YAM);
        put("sugar", Content.CARAMEL);
        put(Content.ANCHOVY.name(), Content.COOKED_ANCHOVY);
        put(ItemNamesV2.RAW_BACON, Content.COOKED_BACON);
        put(Content.CALAMARI.name(), Content.COOKED_CALAMARI);
        put(Content.SHRIMP.name(), Content.COOKED_SHRIMP);
        put(Content.TUNA.name(), Content.COOKED_TUNA);
        put("sugar_cane", Content.MOLASSES);
        put(Content.CORN.name(), Content.POPCORN);
        put(Content.GRAPE.name(), Content.RAISINS);
        put("bread", Content.TOAST);
        put(ItemNamesV2.RAW_RAVAGER_MEAT, Content.COOKED_RAVAGER_MEAT);
        put(ItemNamesV2.WATER_BOTTLE, null);
    }};
    private final Map<Item, String> meals = new HashMap<>(){{
        put(Content.SCRAMBLED_EGGS, ItemNamesV2.SCRAMBLED_EGGS);
        put(Content.BUTTERED_TOAST, ItemNamesV2.BUTTERED_TOAST);
        put(Content.TOAST_WITH_JAM, ItemNamesV2.TOAST_WITH_JAM);
        put(Content.HAM_SANDWICH, ItemNamesV2.HAM_SANDWICH);
        put(Content.PEANUT_BUTTER_AND_JAM, ItemNamesV2.PEANUT_BUTTER_AND_JAM);
        put(Content.BLT, ItemNamesV2.PEANUT_BUTTER_AND_JAM);
        put(Content.GRILLED_CHEESE, ItemNamesV2.GRILLED_CHEESE);
        put(Content.TUNA_SANDWICH, ItemNamesV2.TUNA_SANDWICH);
        put(Content.CHEESEBURGER, ItemNamesV2.CHEESEBURGER);
        put(Content.HAMBURGER, ItemNamesV2.HAMBURGER);
        put(Content.TOFUBURGER, ItemNamesV2.TOFUBURGER);
        put(Content.PIZZA, ItemNamesV2.PIZZA);
        put(Content.SUPREME_PIZZA, ItemNamesV2.SUPREME_PIZZA);
        put(Content.CHEESE_PIZZA, ItemNamesV2.CHEESE_PIZZA);
        put(Content.PINEAPPLE_PEPPERONI_PIZZA, ItemNamesV2.PINEAPPLE_PEPPERONI_PIZZA);
        put(Content.LEMON_CHICKEN, ItemNamesV2.LEMON_CHICKEN);
        put(Content.FRIED_CHICKEN, ItemNamesV2.LEMON_CHICKEN);
        put(Content.CHICKEN_AND_NOODLES, ItemNamesV2.LEMON_CHICKEN);
        put(Content.CHICKEN_AND_DUMPLINGS, ItemNamesV2.LEMON_CHICKEN);
        put(Content.TOFU_AND_DUMPLINGS, ItemNamesV2.LEMON_CHICKEN);
        put(Content.SPAGHETTI_SQUASH, ItemNamesV2.SPAGHETTI_SQUASH);
        put(Content.CHICKEN_AND_RICE, ItemNamesV2.CHICKEN_AND_RICE);
        put(Content.TACO, ItemNamesV2.TACO);
        put(Content.SUSHI, ItemNamesV2.SUSHI);
        put(Content.EGG_ROLL, ItemNamesV2.EGG_ROLL);
        put(Content.CASHEW_CHICKEN, ItemNamesV2.CASHEW_CHICKEN);
        put(Content.BURRITO, ItemNamesV2.BURRITO);
        put(Content.TOSTADA, ItemNamesV2.TOSTADA);
        put(Content.CARNITAS, ItemNamesV2.CARNITAS);
        put(Content.FAJITAS, ItemNamesV2.FAJITAS);
        put(Content.ENCHILADA, ItemNamesV2.FAJITAS);
        put(Content.CHURROS, ItemNamesV2.FAJITAS);
        put(Content.TAMALES, ItemNamesV2.FAJITAS);
        put(Content.STUFFED_POBLANOS, ItemNamesV2.FAJITAS);
        put(Content.CHILI_RELLENO, ItemNamesV2.CHILI_RELLENO);
        put(Content.REFRIED_BEANS, ItemNamesV2.REFRIED_BEANS);
        put(Content.CHIMICHANGA, ItemNamesV2.CHIMICHANGA);
        put(Content.QUESADILLA, ItemNamesV2.QUESADILLA);
        put(Content.SHEPHERDS_PIE, ItemNamesV2.SHEPHERDS_PIE);
        put(Content.BEEF_WELLINGTON, ItemNamesV2.BEEF_WELLINGTON);
        put(Content.FISH_AND_CHIPS, ItemNamesV2.FISH_AND_CHIPS);
        put(Content.AJVAR, ItemNamesV2.AJVAR);
        put(Content.AJVAR_TOAST, ItemNamesV2.AJVAR_TOAST);
        put(Content.AVOCADO_TOAST, ItemNamesV2.AVOCADO_TOAST);
        put(Content.BEEF_STEW, ItemNamesV2.BEEF_STEW);
        put(Content.BEEF_STIR_FRY, ItemNamesV2.BEEF_STIR_FRY);
        put(Content.BUTTERED_GREEN_BEANS, ItemNamesV2.BEEF_STIR_FRY);
        put(Content.CHEESY_ASPARAGUS, ItemNamesV2.BEEF_STIR_FRY);
        put(Content.CHOCOLATE_ICE_CREAM, ItemNamesV2.CHOCOLATE_ICE_CREAM);
        put(Content.EGGPLANT_PARMESAN, ItemNamesV2.EGGPLANT_PARMESAN);
        put(Content.FRUIT_CAKE, ItemNamesV2.FRUIT_CAKE);
        put(Content.GRILLED_EGGPLANT, ItemNamesV2.GRILLED_EGGPLANT);
        put(Content.KIWI_SORBET, ItemNamesV2.KIWI_SORBET);
        put(Content.LEMON_COCONUT_BAR, ItemNamesV2.LEMON_COCONUT_BAR);
        put(Content.NETHER_WART_STEW, ItemNamesV2.NETHER_WART_STEW);
        put(Content.PEANUT_BUTTER, ItemNamesV2.PEANUT_BUTTER);
        put(Content.PEANUT_BUTTER_W_CELERY, ItemNamesV2.PEANUT_BUTTER);
        put(Content.POTATO_SOUP, ItemNamesV2.POTATO_SOUP);
        put(Content.RATATOUILLE, ItemNamesV2.RATATOUILLE);
        put(Content.RHUBARB_CRISP, ItemNamesV2.RHUBARB_CRISP);
        put(Content.ROASTED_ASPARAGUS, ItemNamesV2.ROASTED_ASPARAGUS);
        put(Content.ROASTED_RADISHES, ItemNamesV2.ROASTED_RADISHES);
        put(Content.ROASTED_SQUASH, ItemNamesV2.ROASTED_SQUASH);
        put(Content.ROASTED_TURNIPS, ItemNamesV2.ROASTED_TURNIPS);
        put(Content.STEAMED_BROCCOLI, ItemNamesV2.STEAMED_BROCCOLI);
        put(Content.STEAMED_GREEN_BEANS, ItemNamesV2.STEAMED_GREEN_BEANS);
        put(Content.STIR_FRY, ItemNamesV2.STEAMED_GREEN_BEANS);
        put(Content.STUFFED_ARTICHOKE, ItemNamesV2.STEAMED_GREEN_BEANS);
        put(Content.TOAST_SANDWICH, ItemNamesV2.STEAMED_GREEN_BEANS);
        put(Content.PUMPKIN_SOUP, ItemNamesV2.PUMPKIN_SOUP);
        put(Content.CABBAGE_ROLL, ItemNamesV2.CABBAGE_ROLL);
        put(Content.BORSCHT, ItemNamesV2.BORSCHT);
        put(Content.GOULASH, ItemNamesV2.GOULASH);
        put(Content.BEETROOT_SALAD, ItemNamesV2.BEETROOT_SALAD);
        put(Content.DEEP_FRIED_SHRIMP, ItemNamesV2.DEEP_FRIED_SHRIMP);
        put(Content.TUNA_ROLL, ItemNamesV2.TUNA_ROLL);
        put(Content.FRIED_CALAMARI, ItemNamesV2.FRIED_CALAMARI);
        put(Content.STEAMED_CLAMS, ItemNamesV2.STEAMED_CLAMS);
        put(Content.CRAB_LEGS, ItemNamesV2.CRAB_LEGS);
        put(Content.GRILLED_OYSTERS, ItemNamesV2.GRILLED_OYSTERS);
        put(Content.ANCHOVY_PIZZA, ItemNamesV2.ANCHOVY_PIZZA);
        put(Content.MASHED_POTATOES, ItemNamesV2.MASHED_POTATOES);
        put(Content.BAKED_CREPES, ItemNamesV2.BAKED_CREPES);
        put(Content.CROQUE_MADAME, ItemNamesV2.CROQUE_MADAME);
        put(Content.CROQUE_MONSIEUR, ItemNamesV2.CROQUE_MONSIEUR);
        put(Content.DAUPHINE_POTATOES, ItemNamesV2.DAUPHINE_POTATOES);
        put(Content.MACARON, ItemNamesV2.MACARON);
        put(Content.QUICHE, ItemNamesV2.MACARON);
        put(Content.SUNNY_SIDE_EGGS, ItemNamesV2.MACARON);
        put(Content.THE_BIG_BREAKFAST, ItemNamesV2.THE_BIG_BREAKFAST);
        put(Content.BIBIMBAP, ItemNamesV2.PICKLED_ONIONS);
        put(Content.TTEOKBOKKI, ItemNamesV2.TTEOKBOKKI);
        put(Content.BIBIM_NENGMYUM, ItemNamesV2.BIBIM_NENGMYUM);
        put(Content.EGG_FRIED_RICE, ItemNamesV2.EGG_FRIED_RICE);
        put(Content.FRIED_RICE, ItemNamesV2.FRIED_RICE);
        put(Content.VEGGIE_FRIED_RICE, ItemNamesV2.VEGGIE_FRIED_RICE);
        put(Content.SESAME_CHICKEN, ItemNamesV2.SESAME_CHICKEN);
        put(Content.ORANGE_CHICKEN, ItemNamesV2.ORANGE_CHICKEN);
        put(Content.PINEAPPLE_CHICKEN, ItemNamesV2.PINEAPPLE_CHICKEN);
        put(Content.TERYAKI_CHICKEN, ItemNamesV2.TERYAKI_CHICKEN);
    }};
    private final Map<Item, String> snacks = new HashMap<>() {{
        put(Content.APRICOT_JAM.asItem(), ItemNamesV2.APRICOT_JAM);
        put(Content.BLACKBERRY_JAM.asItem(), ItemNamesV2.BLACKBERRY_JAM);
        put(Content.BLUEBERRY_JAM.asItem(), ItemNamesV2.BLUEBERRY_JAM);
        put(Content.CHERRY_JAM.asItem(), ItemNamesV2.CHERRY_JAM);
        put(Content.ELDERBERRY_JAM.asItem(), ItemNamesV2.ELDERBERRY_JAM);
        put(Content.GRAPE_JAM.asItem(), ItemNamesV2.GRAPE_JAM);
        put(Content.PEACH_JAM.asItem(), ItemNamesV2.PEACH_JAM);
        put(Content.RASPBERRY_JAM.asItem(), ItemNamesV2.RASPBERRY_JAM);
        put(Content.STRAWBERRY_JAM.asItem(), ItemNamesV2.STRAWBERRY_JAM);
        put(Content.BEEF_JERKY, ItemNamesV2.BEEF_JERKY);
        put(Content.PORK_JERKY, ItemNamesV2.PORK_JERKY);
        put(Content.KALE_CHIPS, ItemNamesV2.KALE_CHIPS);
        put(Content.POTATO_CHIPS, ItemNamesV2.POTATO_CHIPS);
        put(Content.STEAMED_RICE, ItemNamesV2.STEAMED_RICE);
        put(Content.FRENCH_FRIES, ItemNamesV2.STEAMED_RICE);
        put(Content.SWEET_POTATO_FRIES, ItemNamesV2.STEAMED_RICE);
        put(Content.ONION_RINGS, ItemNamesV2.STEAMED_RICE);
        put(Content.DOUGHNUT, ItemNamesV2.STEAMED_RICE);
        put(Content.CUCUMBER_SALAD, ItemNamesV2.STEAMED_RICE);
        put(Content.CAESAR_SALAD, ItemNamesV2.CAESAR_SALAD);
        put(Content.LEAFY_SALAD, ItemNamesV2.LEAFY_SALAD);
        put(Content.FRUIT_SALAD, ItemNamesV2.FRUIT_SALAD);
        put(Content.VEGGIE_SALAD, ItemNamesV2.VEGGIE_SALAD);
        put(Content.PORK_AND_BEANS, ItemNamesV2.PORK_AND_BEANS);
        put(Content.OATMEAL, ItemNamesV2.OATMEAL);
        put(Content.LEEK_SOUP, ItemNamesV2.OATMEAL);
        put(Content.YOGHURT, ItemNamesV2.OATMEAL);
        put(Content.SAUCY_CHIPS, ItemNamesV2.SAUCY_CHIPS);
        put(Content.ROASTED_NUTS, ItemNamesV2.ROASTED_NUTS);
        put(Content.TRAIL_MIX, ItemNamesV2.TRAIL_MIX);
        put(Content.PROTEIN_BAR, ItemNamesV2.PROTEIN_BAR);
        put(Content.NOUGAT, ItemNamesV2.NOUGAT);
        put(Content.PUMPKIN_BARS, ItemNamesV2.PUMPKIN_BARS);
        put(Content.CORN_BREAD, ItemNamesV2.CORN_BREAD);
        put(Content.STEAMED_CRAB, ItemNamesV2.STEAMED_CRAB);
        put(Content.FRIED_FROG_LEGS, ItemNamesV2.FRIED_FROG_LEGS);
        put(Content.HASHED_BROWN, ItemNamesV2.HASHED_BROWN);
        put(Content.SAUSAGE, ItemNamesV2.MACARON);
        put(Content.PICKLED_CUCUMBER, ItemNamesV2.PICKLED_CUCUMBER);
        put(Content.PICKLED_BEETS, ItemNamesV2.PICKLED_BEETS);
        put(Content.PICKLED_RADISH, ItemNamesV2.PICKLED_RADISH);
        put(Content.PICKLED_GARLIC, ItemNamesV2.PICKLED_GARLIC);
        put(Content.PICKLED_ONIONS, ItemNamesV2.PICKLED_ONIONS);
        put(Content.PICKLED_GINGER, ItemNamesV2.PICKLED_ONIONS);
        put(Content.KIMCHI, ItemNamesV2.PICKLED_ONIONS);
        put(Content.SAUERKRAUT, ItemNamesV2.PICKLED_ONIONS);
        put(Content.PICKLED_ANCHOVIES, ItemNamesV2.PICKLED_ONIONS);
        put(Content.PICKLED_EGGS, ItemNamesV2.PICKLED_ONIONS);
    }};

    public CroptopiaHandbookBookProvider(@NonNull final PackOutput packOutput, CompletableFuture<Provider> lookupProvider) {
        super(packOutput, CroptopiaHandbook.MODID, "en_us", lookupProvider);
    }

    @Override
    protected void addBooks(Consumer<BookBuilder> consumer, HolderLookup.Provider provider) {
        BookBuilder bookBuilder = createBookBuilder("book", croptopiaItem("guide"), prefix("intro"))
            .setSubtitle(croptopiaAdvancement("getseed"))
            .setCustomBookItem(new ItemStackTemplate(Content.GUIDE))
            .setDontGenerateBook(true)
            .setShowProgress(false)
            .setUseBlockyFont(false)
            .setI18n(true);

        bookBuilder = addDeserts(bookBuilder);
        bookBuilder = addDrinks(bookBuilder);
        bookBuilder = addIngredients(bookBuilder);
        bookBuilder = addCooking(bookBuilder);
        bookBuilder = addMeals(bookBuilder);
        bookBuilder = addSnacks(bookBuilder);
        bookBuilder = addUtensils(bookBuilder);
        bookBuilder = addCrops(bookBuilder);

        bookBuilder.build(consumer);
    }

    private BookBuilder addDeserts(BookBuilder bookBuilder) {
        ItemStackTemplate cheese_cake = new ItemStackTemplate(Content.CHEESE_CAKE);
        CategoryBuilder category = bookBuilder.addCategory(
            "desserts",
            prefix("desserts.name"),
            prefix("desserts.desc"),
            cheese_cake
        )
        .setSortnum(categorySortNum++);

        desserts.forEach((item, name) -> {
            category.addEntry(
                "desserts/" + name,
                croptopiaItem(name),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(name))
            .build();
        });

        return category.build();
    }

    private BookBuilder addDrinks(BookBuilder bookBuilder) {
        ItemStackTemplate coffee = new ItemStackTemplate(Content.COFFEE);
        CategoryBuilder category = bookBuilder.addCategory(
            "drinks",
            prefix("drinks.name"),
            prefix("drinks.desc"),
            coffee
        )
        .setSortnum(categorySortNum++);

        drinks.forEach((item, name) -> {
            category.addEntry(
                "drinks/" + name,
                croptopiaItem(name),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(name))
            .build();
        });

        return category.build();
    }

    private BookBuilder addIngredients(BookBuilder bookBuilder) {
        ItemStackTemplate flour = new ItemStackTemplate(Content.FLOUR);
        CategoryBuilder category = bookBuilder.addCategory(
            "ingredients",
            prefix("ingredients.name"),
            prefix("ingredients.desc"),
            flour
        )
        .setSortnum(categorySortNum++);

        ingredients.forEach((item, name) -> {
            category.addEntry(
                "ingredients/" + name,
                croptopiaItem(name),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(name))
            .build();
        });

        return category.build();
    }

    private BookBuilder addCooking(BookBuilder bookBuilder) {
        ItemStackTemplate flour = new ItemStackTemplate(Items.SMOKER);
        List<String> ignoreCampfire = List.of(
            ItemNamesV2.WATER_BOTTLE,
            ItemNamesV2.SHRIMP,
            ItemNamesV2.CALAMARI,
            ItemNamesV2.YAM,
            ItemNamesV2.RAW_BACON,
            ItemNamesV2.ANCHOVY,
            ItemNamesV2.TUNA,
            ItemNamesV2.RAW_RAVAGER_MEAT
        );
        CategoryBuilder category = bookBuilder.addCategory(
                "cooking",
                prefix("cooking.name"),
                prefix("cooking.desc"),
                flour
            )
            .setSortnum(categorySortNum++);

        cookingRecipes.forEach((input, output) -> {
            Item item;
            String outputName;

            if (output == null) {
                item = Content.SALT.asItem();
                outputName = ItemNamesV2.SALT;
            }
            else {
                item = output.asItem();
                outputName = output.name();
            }

            EntryBuilder page = category.addEntry(
                "cooking/" + outputName,
                croptopiaItem(outputName),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++);

            if (!ignoreCampfire.contains(input)) {
                page.addCampfirePage(getCampfireRecipe(outputName)).build();
            }

            page.addSmokingPage(getSmokingRecipe(input, outputName)).build()
                .addSmeltingPage(getFurnaceRecipe(input, outputName)).build();

            if (outputName.contains(ItemNamesV2.COOKED_CALAMARI)) {
                page.addSmokingPage(getSmokingRecipe(ItemNamesV2.GLOWING_CALAMARI, outputName)).build()
                    .addSmeltingPage(getFurnaceRecipe(ItemNamesV2.GLOWING_CALAMARI, outputName)).build();
            }

        });


        return category.build();
    }

    private Identifier getSmokingRecipe(String input, String output) {
        return CroptopiaCommon.createIdentifier(output + "_from_smoking_" + input);
    }

    private Identifier getCampfireRecipe(String output) {
        return CroptopiaCommon.createIdentifier(output);
    }

    private Identifier getFurnaceRecipe(String input, String output) {
        return CroptopiaCommon.createIdentifier(output + "_from_" + input);
    }

    private BookBuilder addMeals(BookBuilder bookBuilder) {
        ItemStackTemplate hamburger = new ItemStackTemplate(Content.HAMBURGER);
        CategoryBuilder category = bookBuilder.addCategory(
            "meals",
            prefix("meals.name"),
            prefix("meals.desc"),
            hamburger
        )
        .setSortnum(categorySortNum++);

        meals.forEach((item, name) -> {
            category.addEntry(
                "meals/" + name,
                croptopiaItem(name),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(name))
            .build();
        });

        return category.build();
    }

    private BookBuilder addSnacks(BookBuilder bookBuilder) {
        ItemStackTemplate trailMix = new ItemStackTemplate(Content.TRAIL_MIX);
        CategoryBuilder category = bookBuilder.addCategory(
            "snacks",
            prefix("snacks.name"),
            prefix("snacks.desc"),
            trailMix
        )
        .setSortnum(categorySortNum++);

        snacks.forEach((item, name) -> {
            category.addEntry(
                "snacks/" + name,
                croptopiaItem(name),
                new ItemStackTemplate(item)
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(name))
            .build();
        });

        return category.build();
    }

    private BookBuilder addUtensils(BookBuilder bookBuilder) {
        ItemStackTemplate fryingPan = new ItemStackTemplate(Content.FRYING_PAN.asItem());
        CategoryBuilder category = bookBuilder.addCategory(
            "utensils",
            prefix("utensils.name"),
            prefix("utensils.desc"),
            fryingPan
        )
        .setSortnum(categorySortNum++);

        for (Utensil utensil : Utensil.copy()) {
            category.addEntry(
                "utensils/" + utensil.name(),
                croptopiaItem(utensil.name()),
                new ItemStackTemplate(utensil.asItem())
            )
            .setSortnum(entrySortNum++)
            .addCraftingPage(CroptopiaCommon.createIdentifier(utensil.name()))
            .build();
        }

        return category.build();
    }

    private BookBuilder addCrops(BookBuilder bookBuilder) {
        ItemStackTemplate kiwi = new ItemStackTemplate(Content.KIWI.asItem());
        CategoryBuilder category = bookBuilder.addCategory(
            "crops",
            prefix("crops.name"),
            prefix("crops.desc"),
            kiwi
        )
        .setSortnum(categorySortNum++);

        EntryBuilder cropsPlantsEntry = category.addEntry(
            "crops/crops",
            prefix("crops.crops.name"),
            new ItemStackTemplate(Content.EGGPLANT.getSeedItem())
        ).setSortnum(entrySortNum++);

        cropsPlantsEntry.addTextPage(prefix("crops.crops.details")).build();

        for (FarmlandCrop farmlandCrop : FarmlandCrop.FARMLAND_CROPS) {
            String name = farmlandCrop.name();

            if (name.contains("coffee_beans")) {
                name = "coffee";
            }
            else if (name.contains("tea_leaves")) {
                name = "tea";
            }

            String nameKey = croptopiaCrop(name);

            cropsPlantsEntry.addSpotlightPage(
                new ItemStackTemplate(farmlandCrop.asItem()),
                new ItemStackTemplate(farmlandCrop.asBlock().asItem()),
                new ItemStackTemplate(farmlandCrop.getSeedItem())
            ).setTitle(nameKey).build();
        }

        EntryBuilder cropsTreesEntry = category.addEntry(
            "crops/trees",
            prefix("crops.trees.name"),
            new ItemStackTemplate(Content.APPLE.getSaplingItem())
        ).setSortnum(entrySortNum++);

        cropsTreesEntry.addTextPage(prefix("crops.trees.details")).build();

        for (TreeCrop treeCrop : TreeCrop.TREE_CROPS) {
            String name = treeCrop.name();
            String nameKey = croptopiaCrop(name);

            cropsTreesEntry.addSpotlightPage(
                new ItemStackTemplate(treeCrop.asItem()),
                new ItemStackTemplate(treeCrop.getSaplingItem()),
                new ItemStackTemplate(treeCrop.getLeavesItem())
            ).setTitle(nameKey);

            cropsTreesEntry.build();
        }

        return category.build();
    }

    private String croptopiaCrop(String name) {
        return "block." + MiscNames.MOD_ID + "." + name + "_crop";
    }

    private String croptopiaItem(String name) {
        return "item." + MiscNames.MOD_ID + "." + name;
    }

    private String croptopiaAdvancement(String name) {
        return "advancements." + MiscNames.MOD_ID + "." + name + ".title";
    }

    private String prefix(String name) {
        return translationLoc + name;
    }

}

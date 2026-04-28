package croptopiahandbook.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import croptopiahandbook.CroptopiaHandbook;
import croptopiahandbook.data.book.CroptopiaHandbookBookProvider;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        if (System.getProperty(CroptopiaHandbook.MODID + ".common_datagen") != null) {
            configureCommonDatagen(pack);
        }
    }

    /*
     * Datagen common across all modloaders.
     */
    public static void configureCommonDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(CroptopiaHandbookBookProvider::new);
        pack.addProvider(CroptopiaHandbookLanguageProvider::new);
    }

}

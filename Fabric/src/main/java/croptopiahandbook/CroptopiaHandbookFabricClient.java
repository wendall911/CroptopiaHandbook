package croptopiahandbook;

import net.fabricmc.api.ClientModInitializer;

import croptopiahandbook.client.handbook.CustomSpotlightPage;

public class CroptopiaHandbookFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        CustomSpotlightPage.init();
    }

}

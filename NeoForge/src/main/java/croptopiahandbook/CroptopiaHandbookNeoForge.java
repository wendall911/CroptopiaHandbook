package croptopiahandbook;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

import technology.roughness.whitenoise.platform.Services;

import croptopiahandbook.client.handbook.CustomSpotlightPage;

@Mod(CroptopiaHandbook.MODID)
@EventBusSubscriber(modid = CroptopiaHandbook.MODID)
public class CroptopiaHandbookNeoForge {

    public CroptopiaHandbookNeoForge(IEventBus eventBus) {
        CroptopiaHandbook.init();

        if (Services.PLATFORM.isPhysicalClient()) {
            CustomSpotlightPage.init();
        }
    }

}

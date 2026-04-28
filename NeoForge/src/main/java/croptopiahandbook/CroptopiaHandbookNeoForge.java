package croptopiahandbook;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;

@Mod(CroptopiaHandbook.MODID)
@EventBusSubscriber(modid = CroptopiaHandbook.MODID)
public class CroptopiaHandbookNeoForge {

    public CroptopiaHandbookNeoForge(IEventBus eventBus) {
        CroptopiaHandbook.init();
    }

}

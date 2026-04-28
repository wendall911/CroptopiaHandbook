package croptopiahandbook.mixin;

import com.epherical.croptopia.GuideBookItem;

import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import croptopiahandbook.CroptopiaHandbook;
import handbook.api.HandbookAPI;
import handbook.common.book.Book;
import handbook.common.book.BookRegistry;

@Mixin(GuideBookItem.class)
public abstract class GuideBookItemMixin {

    @Inject(method = "use", at = @At("HEAD"), cancellable = true)
    public void ch$use(Level level, Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        if (player instanceof ServerPlayer sp) {
            Book book = BookRegistry.INSTANCE.books.get(Identifier.fromNamespaceAndPath(CroptopiaHandbook.MODID, "book"));

            if (book != null) {
                HandbookAPI.get().openBookGUI(sp, book.id);

                cir.setReturnValue(InteractionResult.PASS);
            }
        }
    }

}

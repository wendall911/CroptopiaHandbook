package croptopiahandbook.client.handbook;

import com.google.gson.annotations.SerializedName;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.core.HolderSet;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;

import croptopiahandbook.CroptopiaHandbook;
import handbook.api.IVariable;
import handbook.client.book.BookContentsBuilder;
import handbook.client.book.BookEntry;
import handbook.client.book.ClientBookRegistry;
import handbook.client.book.gui.BookTextRenderer;
import handbook.client.book.gui.GuiBook;
import handbook.client.book.gui.GuiBookEntry;
import handbook.client.book.page.abstr.PageWithText;

public class CustomSpotlightPage extends PageWithText {

    IVariable biomes;
    IVariable item;
    String title;
    @SerializedName("link_recipe") boolean linkRecipe;

    transient ItemStack[] stacks;
    transient BookTextRenderer textRenderOverride;
    transient MutableComponent textOverride = Component.empty();
    private MutableComponent biomeText = Component.empty();

    public static void init() {
        ClientBookRegistry registry = ClientBookRegistry.INSTANCE;

        registry.pageTypes.put(Identifier.fromNamespaceAndPath("croptopiahandbook", "spotlight"), CustomSpotlightPage.class);
    }

    @Override
    public void build(Level level, BookEntry entry, BookContentsBuilder builder, int pageNum) {
        super.build(level, entry, builder, pageNum);
        stacks = item.as(ItemStack[].class);

        if (biomes != null) {
            Registry<Biome> biomeRegistry = level.registryAccess().lookupOrThrow(Registries.BIOME);
            TagKey<Biome> tag = TagKey.create(biomeRegistry.key(), Identifier.parse(biomes.asString()));
            HolderSet<Biome> biomeHolderSet = biomeRegistry.getOrThrow(tag);

            biomeText.append(Component.literal("$(br)"));
            biomeHolderSet.stream()
                .forEach(id -> {
                    biomeText.append(Component.literal("$(br)"));
                    biomeText.append(Component.translatable(Util.makeDescriptionId("biome", Identifier.parse(id.getRegisteredName()))));
                });

            if (text == null) {
                text = IVariable.wrap("");
            }
            Component component = text.as(Component.class);

            textOverride.append(Component.translatable(component.getString())).append(biomeText);
        }

        if (linkRecipe) {
            for (ItemStack stack : stacks) {
                entry.addRelevantStack(builder, stack, pageNum);
            }
        }
    }

    @Override
    public void render(GuiGraphicsExtractor guiGraphics, int mouseX, int mouseY, float partialTicks) {
        int w = 66;
        int h = 26;
        Component toDraw;

        textRenderOverride = new BookTextRenderer(parent, textOverride, 0, getTextHeight());

        guiGraphics.blit(
            RenderPipelines.GUI_TEXTURED,
            book.craftingTexture,
            GuiBook.PAGE_WIDTH / 2 - w / 2,
            10,
            0,
            128 - h,
            w,
            h,
            128,
            256
        );

        if (title != null && !title.isEmpty()) {
            toDraw = i18nText(title);
        }
        else {
            toDraw = stacks[0].getHoverName();
        }

        parent.drawCenteredStringNoShadow(
            guiGraphics,
            toDraw.getVisualOrderText(),
            GuiBook.PAGE_WIDTH / 2,
            0,
            book.headerColor
        );
        if (stacks.length > 0) {
            parent.renderItemStack(
                guiGraphics,
                GuiBook.PAGE_WIDTH / 2 - 8,
                15,
                mouseX,
                mouseY,
                stacks[(parent.ticksInBook / 20) % stacks.length]
            );
        }

        if (shouldRenderText()) {
            textRenderOverride.extractRenderState(guiGraphics, mouseX, mouseY, partialTicks);
        }
    }

    @Override
    public int getTextHeight() {
        return 40;
    }

}
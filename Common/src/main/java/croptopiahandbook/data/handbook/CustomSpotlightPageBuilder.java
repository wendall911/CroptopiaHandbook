package croptopiahandbook.data.handbook;

import com.google.gson.JsonObject;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStackTemplate;

import handbook.api.data.AbstractPageBuilder;
import handbook.api.data.EntryBuilder;
import handbook.api.data.util.ItemStackHelper;
import handbook.api.data.util.TagKeyHelper;

public class CustomSpotlightPageBuilder extends AbstractPageBuilder<CustomSpotlightPageBuilder> {

    private String item;
    private String title;
    private Boolean linkRecipe;
    private String text;
    private String biomes;

    public CustomSpotlightPageBuilder(EntryBuilder parent, ItemStackTemplate... stacks) {
        super("croptopiahandbook:spotlight", parent);
        this.item = serializeStacks(stacks);
    }

    @SafeVarargs
    public CustomSpotlightPageBuilder(EntryBuilder parent, TagKey<Item>... tag) {
        super("croptopiahandbook:spotlight", parent);
        this.item = serializeTagKeys(tag);
    }

    private String serializeStacks(ItemStackTemplate[] stacks) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < stacks.length; i++) {
            sb.append(ItemStackHelper.serializeStack(stacks[i]));
            if (i < stacks.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    private String serializeTagKeys(TagKey<Item>[] tags) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tags.length; i++) {
            sb.append(TagKeyHelper.serializeTagKey(tags[i]));
            if (i < tags.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }


    @Override
    protected void serialize(JsonObject json) {
        json.addProperty("item", item);

        if (title != null) {
            json.addProperty("title", title);
        }
        if (linkRecipe != null) {
            json.addProperty("link_recipe", linkRecipe);
        }
        if (text != null) {
            json.addProperty("text", text);
        }
        if (biomes != null) {
            json.addProperty("biomes", biomes);
        }
    }

    public CustomSpotlightPageBuilder setTitle(String title) {
        this.title = title;

        return this;
    }

    public CustomSpotlightPageBuilder setLinkRecipe(Boolean linkRecipe) {
        this.linkRecipe = linkRecipe;

        return this;
    }

    public CustomSpotlightPageBuilder setText(String text) {
        this.text = text;

        return this;
    }

    public  CustomSpotlightPageBuilder setBiomes(String biomes) {
        this.biomes = biomes;

        return this;
    }

    @SafeVarargs
    public final CustomSpotlightPageBuilder addTag(TagKey<Item>... tags) {
        this.item = this.item + "," + serializeTagKeys(tags);

        return this;
    }

    public final CustomSpotlightPageBuilder addItem(ItemStackTemplate... stacks) {
        this.item = this.item + "," + serializeStacks(stacks);

        return this;
    }

}


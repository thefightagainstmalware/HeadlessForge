package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;

public class TileEntityBanner extends TileEntity
{
    private int baseColor;

    /** A list of all the banner patterns. */
    private NBTTagList patterns;
    private boolean field_175119_g;
    private List<TileEntityBanner.EnumBannerPattern> patternList;
    private List<EnumDyeColor> colorList;

    /**
     * This is a String representation of this banners pattern and color lists, used for texture caching.
     */
    private String patternResourceLocation;

    public void setItemValues(ItemStack stack)
    {
        this.patterns = null;

        if (stack.func_77942_o() && stack.func_77978_p().func_150297_b("BlockEntityTag", 10))
        {
            NBTTagCompound nbttagcompound = stack.func_77978_p().func_74775_l("BlockEntityTag");

            if (nbttagcompound.hasKey("Patterns"))
            {
                this.patterns = (NBTTagList)nbttagcompound.getTagList("Patterns", 10).func_74737_b();
            }

            if (nbttagcompound.func_150297_b("Base", 99))
            {
                this.baseColor = nbttagcompound.getInteger("Base");
            }
            else
            {
                this.baseColor = stack.getMetadata() & 15;
            }
        }
        else
        {
            this.baseColor = stack.getMetadata() & 15;
        }

        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = "";
        this.field_175119_g = true;
    }

    public void func_145841_b(NBTTagCompound compound)
    {
        super.func_145841_b(compound);
        func_181020_a(compound, this.baseColor, this.patterns);
    }

    public static void func_181020_a(NBTTagCompound p_181020_0_, int p_181020_1_, NBTTagList p_181020_2_)
    {
        p_181020_0_.func_74768_a("Base", p_181020_1_);

        if (p_181020_2_ != null)
        {
            p_181020_0_.func_74782_a("Patterns", p_181020_2_);
        }
    }

    public void func_145839_a(NBTTagCompound compound)
    {
        super.func_145839_a(compound);
        this.baseColor = compound.getInteger("Base");
        this.patterns = compound.getTagList("Patterns", 10);
        this.patternList = null;
        this.colorList = null;
        this.patternResourceLocation = null;
        this.field_175119_g = true;
    }

    /**
     * Allows for a specialized description packet to be created. This is often used to sync tile entity data from the
     * server to the client easily. For example this is used by signs to synchronise the text to be displayed.
     */
    public Packet getDescriptionPacket()
    {
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        this.func_145841_b(nbttagcompound);
        return new S35PacketUpdateTileEntity(this.pos, 6, nbttagcompound);
    }

    public int getBaseColor()
    {
        return this.baseColor;
    }

    public static int getBaseColor(ItemStack stack)
    {
        NBTTagCompound nbttagcompound = stack.getSubCompound("BlockEntityTag", false);
        return nbttagcompound != null && nbttagcompound.hasKey("Base") ? nbttagcompound.getInteger("Base") : stack.getMetadata();
    }

    /**
     * Retrieves the amount of patterns stored on an ItemStack. If the tag does not exist this value will be 0.
     */
    public static int getPatterns(ItemStack stack)
    {
        NBTTagCompound nbttagcompound = stack.getSubCompound("BlockEntityTag", false);
        return nbttagcompound != null && nbttagcompound.hasKey("Patterns") ? nbttagcompound.getTagList("Patterns", 10).func_74745_c() : 0;
    }

    public List<TileEntityBanner.EnumBannerPattern> getPatternList()
    {
        this.initializeBannerData();
        return this.patternList;
    }

    public NBTTagList func_181021_d()
    {
        return this.patterns;
    }

    public List<EnumDyeColor> getColorList()
    {
        this.initializeBannerData();
        return this.colorList;
    }

    public String func_175116_e()
    {
        this.initializeBannerData();
        return this.patternResourceLocation;
    }

    /**
     * Establishes all of the basic properties for the banner. This will also apply the data from the tile entities nbt
     * tag compounds.
     */
    private void initializeBannerData()
    {
        if (this.patternList == null || this.colorList == null || this.patternResourceLocation == null)
        {
            if (!this.field_175119_g)
            {
                this.patternResourceLocation = "";
            }
            else
            {
                this.patternList = Lists.<TileEntityBanner.EnumBannerPattern>newArrayList();
                this.colorList = Lists.<EnumDyeColor>newArrayList();
                this.patternList.add(TileEntityBanner.EnumBannerPattern.BASE);
                this.colorList.add(EnumDyeColor.byDyeDamage(this.baseColor));
                this.patternResourceLocation = "b" + this.baseColor;

                if (this.patterns != null)
                {
                    for (int i = 0; i < this.patterns.func_74745_c(); ++i)
                    {
                        NBTTagCompound nbttagcompound = this.patterns.func_150305_b(i);
                        TileEntityBanner.EnumBannerPattern tileentitybanner$enumbannerpattern = TileEntityBanner.EnumBannerPattern.getPatternByID(nbttagcompound.getString("Pattern"));

                        if (tileentitybanner$enumbannerpattern != null)
                        {
                            this.patternList.add(tileentitybanner$enumbannerpattern);
                            int j = nbttagcompound.getInteger("Color");
                            this.colorList.add(EnumDyeColor.byDyeDamage(j));
                            this.patternResourceLocation = this.patternResourceLocation + tileentitybanner$enumbannerpattern.getPatternID() + j;
                        }
                    }
                }
            }
        }
    }

    /**
     * Removes all the banner related data from a provided instance of ItemStack.
     */
    public static void removeBannerData(ItemStack stack)
    {
        NBTTagCompound nbttagcompound = stack.getSubCompound("BlockEntityTag", false);

        if (nbttagcompound != null && nbttagcompound.func_150297_b("Patterns", 9))
        {
            NBTTagList nbttaglist = nbttagcompound.getTagList("Patterns", 10);

            if (nbttaglist.func_74745_c() > 0)
            {
                nbttaglist.removeTag(nbttaglist.func_74745_c() - 1);

                if (nbttaglist.hasNoTags())
                {
                    stack.func_77978_p().func_82580_o("BlockEntityTag");

                    if (stack.func_77978_p().hasNoTags())
                    {
                        stack.func_77982_d((NBTTagCompound)null);
                    }
                }
            }
        }
    }

    public static enum EnumBannerPattern
    {
        BASE("base", "b"),
        SQUARE_BOTTOM_LEFT("square_bottom_left", "bl", "   ", "   ", "#  "),
        SQUARE_BOTTOM_RIGHT("square_bottom_right", "br", "   ", "   ", "  #"),
        SQUARE_TOP_LEFT("square_top_left", "tl", "#  ", "   ", "   "),
        SQUARE_TOP_RIGHT("square_top_right", "tr", "  #", "   ", "   "),
        STRIPE_BOTTOM("stripe_bottom", "bs", "   ", "   ", "###"),
        STRIPE_TOP("stripe_top", "ts", "###", "   ", "   "),
        STRIPE_LEFT("stripe_left", "ls", "#  ", "#  ", "#  "),
        STRIPE_RIGHT("stripe_right", "rs", "  #", "  #", "  #"),
        STRIPE_CENTER("stripe_center", "cs", " # ", " # ", " # "),
        STRIPE_MIDDLE("stripe_middle", "ms", "   ", "###", "   "),
        STRIPE_DOWNRIGHT("stripe_downright", "drs", "#  ", " # ", "  #"),
        STRIPE_DOWNLEFT("stripe_downleft", "dls", "  #", " # ", "#  "),
        STRIPE_SMALL("small_stripes", "ss", "# #", "# #", "   "),
        CROSS("cross", "cr", "# #", " # ", "# #"),
        STRAIGHT_CROSS("straight_cross", "sc", " # ", "###", " # "),
        TRIANGLE_BOTTOM("triangle_bottom", "bt", "   ", " # ", "# #"),
        TRIANGLE_TOP("triangle_top", "tt", "# #", " # ", "   "),
        TRIANGLES_BOTTOM("triangles_bottom", "bts", "   ", "# #", " # "),
        TRIANGLES_TOP("triangles_top", "tts", " # ", "# #", "   "),
        DIAGONAL_LEFT("diagonal_left", "ld", "## ", "#  ", "   "),
        DIAGONAL_RIGHT("diagonal_up_right", "rd", "   ", "  #", " ##"),
        DIAGONAL_LEFT_MIRROR("diagonal_up_left", "lud", "   ", "#  ", "## "),
        DIAGONAL_RIGHT_MIRROR("diagonal_right", "rud", " ##", "  #", "   "),
        CIRCLE_MIDDLE("circle", "mc", "   ", " # ", "   "),
        RHOMBUS_MIDDLE("rhombus", "mr", " # ", "# #", " # "),
        HALF_VERTICAL("half_vertical", "vh", "## ", "## ", "## "),
        HALF_HORIZONTAL("half_horizontal", "hh", "###", "###", "   "),
        HALF_VERTICAL_MIRROR("half_vertical_right", "vhr", " ##", " ##", " ##"),
        HALF_HORIZONTAL_MIRROR("half_horizontal_bottom", "hhb", "   ", "###", "###"),
        BORDER("border", "bo", "###", "# #", "###"),
        CURLY_BORDER("curly_border", "cbo", new ItemStack(Blocks.vine)),
        CREEPER("creeper", "cre", new ItemStack(Items.field_151144_bL, 1, 4)),
        GRADIENT("gradient", "gra", "# #", " # ", " # "),
        GRADIENT_UP("gradient_up", "gru", " # ", " # ", "# #"),
        BRICKS("bricks", "bri", new ItemStack(Blocks.brick_block)),
        SKULL("skull", "sku", new ItemStack(Items.field_151144_bL, 1, 1)),
        FLOWER("flower", "flo", new ItemStack(Blocks.red_flower, 1, BlockFlower.EnumFlowerType.OXEYE_DAISY.getMeta())),
        MOJANG("mojang", "moj", new ItemStack(Items.golden_apple, 1, 1));

        private String patternName;
        private String patternID;
        private String[] craftingLayers;
        private ItemStack patternCraftingStack;

        private EnumBannerPattern(String name, String id)
        {
            this.craftingLayers = new String[3];
            this.patternName = name;
            this.patternID = id;
        }

        private EnumBannerPattern(String name, String id, ItemStack craftingItem)
        {
            this(name, id);
            this.patternCraftingStack = craftingItem;
        }

        private EnumBannerPattern(String name, String id, String craftingTop, String craftingMid, String craftingBot)
        {
            this(name, id);
            this.craftingLayers[0] = craftingTop;
            this.craftingLayers[1] = craftingMid;
            this.craftingLayers[2] = craftingBot;
        }

        public String getPatternName()
        {
            return this.patternName;
        }

        public String getPatternID()
        {
            return this.patternID;
        }

        public String[] getCraftingLayers()
        {
            return this.craftingLayers;
        }

        public boolean hasValidCrafting()
        {
            return this.patternCraftingStack != null || this.craftingLayers[0] != null;
        }

        public boolean hasCraftingStack()
        {
            return this.patternCraftingStack != null;
        }

        public ItemStack getCraftingStack()
        {
            return this.patternCraftingStack;
        }

        public static TileEntityBanner.EnumBannerPattern getPatternByID(String id)
        {
            for (TileEntityBanner.EnumBannerPattern tileentitybanner$enumbannerpattern : values())
            {
                if (tileentitybanner$enumbannerpattern.patternID.equals(id))
                {
                    return tileentitybanner$enumbannerpattern;
                }
            }

            return null;
        }
    }
}

package net.minecraft.creativetab;

import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;

/**
 *
 */
public abstract class CreativeTabs extends Object {

    /**
     *
     */
    public static CreativeTabs[] creativeTabArray;

    /**
     *
     */
    public static final CreativeTabs tabBlock = null;

    /**
     *
     */
    public static final CreativeTabs tabDecorations = null;

    /**
     *
     */
    public static final CreativeTabs tabRedstone = null;

    /**
     *
     */
    public static final CreativeTabs tabTransport = null;

    /**
     *
     */
    public static final CreativeTabs tabMisc = null;

    /**
     *
     */
    public static final CreativeTabs tabAllSearch = null;

    /**
     *
     */
    public static final CreativeTabs tabFood = null;

    /**
     *
     */
    public static final CreativeTabs tabTools = null;

    /**
     *
     */
    public static final CreativeTabs tabCombat = null;

    /**
     *
     */
    public static final CreativeTabs tabBrewing = null;

    /**
     *
     */
    public static final CreativeTabs tabMaterials = null;

    /**
     *
     */
    public static final CreativeTabs tabInventory = null;

    /**
     *
     */
    private final int tabIndex;

    /**
     *
     */
    private final java.lang.String tabLabel;

    /**
     * Texture to use.
     */
    private java.lang.String theTexture;

    /**
     *
     */
    private boolean hasScrollbar;

    /**
     * Whether to draw the title in the foreground of the creative GUI
     */
    private boolean drawTitle;

    /**
     *
     */
    private EnumEnchantmentType[] enchantmentTypes;

    /**
     *
     */
    private ItemStack iconItemStack;

    /**
     *
     */
    public CreativeTabs(String label, int tabIndex) {
        this.tabLabel = label;
        this.tabIndex = tabIndex;
    }

    /**
     *
     */
    public CreativeTabs(int index,
                        String label) {
        this.tabIndex = index;
        this.tabLabel = label;
    }

    /**
     *
     */
    public int getTabIndex() {
        return 0;
    }

    /**
     *
     */
    public CreativeTabs setBackgroundImageName(String texture) {
        return null;
    }

    /**
     *
     */
    public String getTabLabel() {
        return null;
    }

    /**
     * Gets the translated Label.
     */
    public String getTranslatedTabLabel() {
        return null;
    }

    /**
     *
     */
    public ItemStack getIconItemStack() {
        return null;
    }

    /**
     *
     */
    public abstract Item getTabIconItem();

    /**
     *
     */
    public int getIconItemDamage() {
        return 0;
    }

    /**
     *
     */
    public String getBackgroundImageName() {
        return null;
    }

    /**
     *
     */
    public boolean drawInForegroundOfTab() {
        return true;
    }

    /**
     *
     */
    public CreativeTabs setNoTitle() {
        return null;
    }

    /**
     *
     */
    public boolean shouldHidePlayerInventory() {
        return true;
    }

    /**
     *
     */
    public CreativeTabs setNoScrollbar() {
        return null;
    }

    /**
     * returns index % 6
     */
    public int getTabColumn() {
        return 0;
    }

    /**
     * returns tabIndex &lt; 6
     */
    public boolean isTabInFirstRow() {
        return true;
    }

    /**
     * Returns the enchantment types relevant to this tab
     */
    public EnumEnchantmentType[] getRelevantEnchantmentTypes() {
        return null;
    }

    /**
     * Sets the enchantment types for populating this tab with enchanting books
     */
    public CreativeTabs setRelevantEnchantmentTypes(EnumEnchantmentType... types) {
        return null;
    }

    /**
     *
     */
    public boolean hasRelevantEnchantmentType(EnumEnchantmentType enchantmentType) {
        return true;
    }

    /**
     * only shows items which have tabToDisplayOn == this
     */
    public void displayAllReleventItems(java.util.List<ItemStack> p_78018_1_) {
        return;
    }

    /**
     * Adds the enchantment books from the supplied EnumEnchantmentType to the given list.
     */
    public void addEnchantmentBooksToList(java.util.List<ItemStack> itemList,
                                          EnumEnchantmentType... enchantmentType) {
        return;
    }

    /**
     *
     */
    public int getTabPage() {
        return 0;
    }

    /**
     *
     */
    public static int getNextID() {
        return 0;
    }

    /**
     * Determines if the search bar should be shown for this tab.
     * @return True to show the bar
     */
    public boolean hasSearchBar() {
        return true;
    }

    /**
     * Gets the width of the search bar of the creative tab, use this if your
     * creative tab name overflows together with a custom texture.
     * @return The width of the search bar, 89 by default
     */
    public int getSearchbarWidth() {
        return 0;
    }

}
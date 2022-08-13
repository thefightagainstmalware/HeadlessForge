package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.Map.Entry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentDurability;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.item.EntityItemFrame;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.event.HoverEvent;
import net.minecraft.init.Items;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.stats.StatList;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

public final class ItemStack
{
    public static final DecimalFormat DECIMALFORMAT = new DecimalFormat("#.###");

    /** Size of the stack. */
    public int field_77994_a;

    /**
     * Number of animation frames to go when receiving an item (by walking into it, for example).
     */
    public int animationsToGo;
    private Item item;

    /**
     * A NBTTagMap containing data about an ItemStack. Can only be used for non stackable items
     */
    private NBTTagCompound stackTagCompound;
    private int itemDamage;

    /** Item frame this stack is on, or null if not on an item frame. */
    private EntityItemFrame itemFrame;
    private Block canDestroyCacheBlock;
    private boolean canDestroyCacheResult;
    private Block canPlaceOnCacheBlock;
    private boolean canPlaceOnCacheResult;

    public ItemStack(Block blockIn)
    {
        this((Block)blockIn, 1);
    }

    public ItemStack(Block blockIn, int amount)
    {
        this((Block)blockIn, amount, 0);
    }

    public ItemStack(Block blockIn, int amount, int meta)
    {
        this(Item.func_150898_a(blockIn), amount, meta);
    }

    public ItemStack(Item itemIn)
    {
        this((Item)itemIn, 1);
    }

    public ItemStack(Item itemIn, int amount)
    {
        this((Item)itemIn, amount, 0);
    }

    public ItemStack(Item itemIn, int amount, int meta)
    {
        this.canDestroyCacheBlock = null;
        this.canDestroyCacheResult = false;
        this.canPlaceOnCacheBlock = null;
        this.canPlaceOnCacheResult = false;
        this.item = itemIn;
        this.field_77994_a = amount;
        this.itemDamage = meta;

        if (this.itemDamage < 0)
        {
            this.itemDamage = 0;
        }
    }

    public static ItemStack loadItemStackFromNBT(NBTTagCompound nbt)
    {
        ItemStack itemstack = new ItemStack();
        itemstack.readFromNBT(nbt);
        return itemstack.func_77973_b() != null ? itemstack : null;
    }

    private ItemStack()
    {
        this.canDestroyCacheBlock = null;
        this.canDestroyCacheResult = false;
        this.canPlaceOnCacheBlock = null;
        this.canPlaceOnCacheResult = false;
    }

    /**
     * Splits off a stack of the given amount of this stack and reduces this stack by the amount.
     */
    public ItemStack splitStack(int amount)
    {
        ItemStack itemstack = new ItemStack(this.item, amount, this.itemDamage);

        if (this.stackTagCompound != null)
        {
            itemstack.stackTagCompound = (NBTTagCompound)this.stackTagCompound.func_74737_b();
        }

        this.field_77994_a -= amount;
        return itemstack;
    }

    /**
     * Returns the object corresponding to the stack.
     */
    public Item func_77973_b()
    {
        return this.item;
    }

    /**
     * Called when the player uses this ItemStack on a Block (right-click). Places blocks, etc. (Legacy name:
     * tryPlaceItemIntoWorld)
     */
    public boolean onItemUse(EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        boolean flag = this.func_77973_b().onItemUse(this, playerIn, worldIn, pos, side, hitX, hitY, hitZ);

        if (flag)
        {
            playerIn.func_71029_a(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }

        return flag;
    }

    public float getStrVsBlock(Block blockIn)
    {
        return this.func_77973_b().getStrVsBlock(this, blockIn);
    }

    /**
     * Called whenever this item stack is equipped and right clicked. Returns the new item stack to put in the position
     * where this item is. Args: world, player
     */
    public ItemStack useItemRightClick(World worldIn, EntityPlayer playerIn)
    {
        return this.func_77973_b().onItemRightClick(this, worldIn, playerIn);
    }

    /**
     * Called when the item in use count reach 0, e.g. item food eaten. Return the new ItemStack. Args : world, entity
     */
    public ItemStack onItemUseFinish(World worldIn, EntityPlayer playerIn)
    {
        return this.func_77973_b().onItemUseFinish(this, worldIn, playerIn);
    }

    /**
     * Write the stack fields to a NBT object. Return the new NBT object.
     */
    void nop(){}
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        ResourceLocation resourcelocation = Item.field_150901_e.getNameForObject(this.item);
        if (this.item.getUnlocalizedName().equals("enchantedBook")) {
            nop();
        }
        nbt.func_74778_a("id", resourcelocation == null ? "minecraft:air" : resourcelocation.toString());
        nbt.setByte("Count", (byte)this.field_77994_a);
        nbt.setShort("Damage", (short)this.itemDamage);

        if (this.stackTagCompound != null)
        {
            nbt.func_74782_a("tag", this.stackTagCompound);
        }

        return nbt;
    }

    /**
     * Read the stack fields from a NBT object.
     */
    public void readFromNBT(NBTTagCompound nbt)
    {
        if (nbt.func_150297_b("id", 8))
        {
            this.item = Item.func_111206_d(nbt.getString("id"));
        }
        else
        {
            this.item = Item.getItemById(nbt.func_74765_d("id"));
        }

        this.field_77994_a = nbt.getByte("Count");
        this.itemDamage = nbt.func_74765_d("Damage");

        if (this.itemDamage < 0)
        {
            this.itemDamage = 0;
        }

        if (nbt.func_150297_b("tag", 10))
        {
            this.stackTagCompound = nbt.func_74775_l("tag");

            if (this.item != null)
            {
                this.item.updateItemStackNBT(this.stackTagCompound);
            }
        }
    }

    /**
     * Returns maximum size of the stack.
     */
    public int getMaxStackSize()
    {
        return this.func_77973_b().getItemStackLimit();
    }

    /**
     * Returns true if the ItemStack can hold 2 or more units of the item.
     */
    public boolean isStackable()
    {
        return this.getMaxStackSize() > 1 && (!this.isItemStackDamageable() || !this.isItemDamaged());
    }

    /**
     * true if this itemStack is damageable
     */
    public boolean isItemStackDamageable()
    {
        return this.item != null && (this.item.getMaxDamage() > 0 && (!this.func_77942_o() || !this.func_77978_p().getBoolean("Unbreakable")));
    }

    public boolean getHasSubtypes()
    {
        return this.item.getHasSubtypes();
    }

    /**
     * returns true when a damageable item is damaged
     */
    public boolean isItemDamaged()
    {
        return this.isItemStackDamageable() && this.itemDamage > 0;
    }

    public int getItemDamage()
    {
        return this.itemDamage;
    }

    public int getMetadata()
    {
        return this.itemDamage;
    }

    public void setItemDamage(int meta)
    {
        this.itemDamage = meta;

        if (this.itemDamage < 0)
        {
            this.itemDamage = 0;
        }
    }

    /**
     * Returns the max damage an item in the stack can take.
     */
    public int getMaxDamage()
    {
        return this.item.getMaxDamage();
    }

    /**
     * Attempts to damage the ItemStack with par1 amount of damage, If the ItemStack has the Unbreaking enchantment
     * there is a chance for each point of damage to be negated. Returns true if it takes more damage than
     * getMaxDamage(). Returns false otherwise or if the ItemStack can't be damaged or if all points of damage are
     * negated.
     */
    public boolean attemptDamageItem(int amount, Random rand)
    {
        if (!this.isItemStackDamageable())
        {
            return false;
        }
        else
        {
            if (amount > 0)
            {
                int i = EnchantmentHelper.getEnchantmentLevel(Enchantment.unbreaking.field_77352_x, this);
                int j = 0;

                for (int k = 0; i > 0 && k < amount; ++k)
                {
                    if (EnchantmentDurability.negateDamage(this, i, rand))
                    {
                        ++j;
                    }
                }

                amount -= j;

                if (amount <= 0)
                {
                    return false;
                }
            }

            this.itemDamage += amount;
            return this.itemDamage > this.getMaxDamage();
        }
    }

    /**
     * Damages the item in the ItemStack
     */
    public void damageItem(int amount, EntityLivingBase entityIn)
    {
        if (!(entityIn instanceof EntityPlayer) || !((EntityPlayer)entityIn).field_71075_bZ.field_75098_d)
        {
            if (this.isItemStackDamageable())
            {
                if (this.attemptDamageItem(amount, entityIn.func_70681_au()))
                {
                    entityIn.renderBrokenItemStack(this);
                    --this.field_77994_a;

                    if (entityIn instanceof EntityPlayer)
                    {
                        EntityPlayer entityplayer = (EntityPlayer)entityIn;
                        entityplayer.func_71029_a(StatList.objectBreakStats[Item.getIdFromItem(this.item)]);

                        if (this.field_77994_a == 0 && this.func_77973_b() instanceof ItemBow)
                        {
                            entityplayer.destroyCurrentEquippedItem();
                        }
                    }

                    if (this.field_77994_a < 0)
                    {
                        this.field_77994_a = 0;
                    }

                    this.itemDamage = 0;
                }
            }
        }
    }

    /**
     * Calls the corresponding fct in di
     */
    public void hitEntity(EntityLivingBase entityIn, EntityPlayer playerIn)
    {
        boolean flag = this.item.hitEntity(this, entityIn, playerIn);

        if (flag)
        {
            playerIn.func_71029_a(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }
    }

    /**
     * Called when a Block is destroyed using this ItemStack
     */
    public void onBlockDestroyed(World worldIn, Block blockIn, BlockPos pos, EntityPlayer playerIn)
    {
        boolean flag = this.item.onBlockDestroyed(this, worldIn, blockIn, pos, playerIn);

        if (flag)
        {
            playerIn.func_71029_a(StatList.objectUseStats[Item.getIdFromItem(this.item)]);
        }
    }

    /**
     * Check whether the given Block can be harvested using this ItemStack.
     */
    public boolean canHarvestBlock(Block blockIn)
    {
        return this.item.canHarvestBlock(blockIn);
    }

    public boolean interactWithEntity(EntityPlayer playerIn, EntityLivingBase entityIn)
    {
        return this.item.itemInteractionForEntity(this, playerIn, entityIn);
    }

    /**
     * Returns a new stack with the same properties.
     */
    public ItemStack copy()
    {
        ItemStack itemstack = new ItemStack(this.item, this.field_77994_a, this.itemDamage);

        if (this.stackTagCompound != null)
        {
            itemstack.stackTagCompound = (NBTTagCompound)this.stackTagCompound.func_74737_b();
        }

        return itemstack;
    }

    public static boolean areItemStackTagsEqual(ItemStack stackA, ItemStack stackB)
    {
        return stackA == null && stackB == null ? true : (stackA != null && stackB != null ? (stackA.stackTagCompound == null && stackB.stackTagCompound != null ? false : stackA.stackTagCompound == null || stackA.stackTagCompound.equals(stackB.stackTagCompound)) : false);
    }

    /**
     * compares ItemStack argument1 with ItemStack argument2; returns true if both ItemStacks are equal
     */
    public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB)
    {
        return stackA == null && stackB == null ? true : (stackA != null && stackB != null ? stackA.isItemStackEqual(stackB) : false);
    }

    /**
     * compares ItemStack argument to the instance ItemStack; returns true if both ItemStacks are equal
     */
    private boolean isItemStackEqual(ItemStack other)
    {
        return this.field_77994_a != other.field_77994_a ? false : (this.item != other.item ? false : (this.itemDamage != other.itemDamage ? false : (this.stackTagCompound == null && other.stackTagCompound != null ? false : this.stackTagCompound == null || this.stackTagCompound.equals(other.stackTagCompound))));
    }

    /**
     * Compares Item and damage value of the two stacks
     */
    public static boolean areItemsEqual(ItemStack stackA, ItemStack stackB)
    {
        return stackA == null && stackB == null ? true : (stackA != null && stackB != null ? stackA.isItemEqual(stackB) : false);
    }

    /**
     * compares ItemStack argument to the instance ItemStack; returns true if the Items contained in both ItemStacks are
     * equal
     */
    public boolean isItemEqual(ItemStack other)
    {
        return other != null && this.item == other.item && this.itemDamage == other.itemDamage;
    }

    public String getUnlocalizedName()
    {
        return this.item.getUnlocalizedName(this);
    }

    /**
     * Creates a copy of a ItemStack, a null parameters will return a null.
     */
    public static ItemStack copyItemStack(ItemStack stack)
    {
        return stack == null ? null : stack.copy();
    }

    public String toString()
    {
        return this.field_77994_a + "x" + this.item.getUnlocalizedName() + "@" + this.itemDamage;
    }

    /**
     * Called each tick as long the ItemStack in on player inventory. Used to progress the pickup animation and update
     * maps.
     */
    public void updateAnimation(World worldIn, Entity entityIn, int inventorySlot, boolean isCurrentItem)
    {
        if (this.animationsToGo > 0)
        {
            --this.animationsToGo;
        }

        this.item.onUpdate(this, worldIn, entityIn, inventorySlot, isCurrentItem);
    }

    public void onCrafting(World worldIn, EntityPlayer playerIn, int amount)
    {
        playerIn.addStat(StatList.objectCraftStats[Item.getIdFromItem(this.item)], amount);
        this.item.onCreated(this, worldIn, playerIn);
    }

    public boolean getIsItemStackEqual(ItemStack p_179549_1_)
    {
        return this.isItemStackEqual(p_179549_1_);
    }

    public int getMaxItemUseDuration()
    {
        return this.func_77973_b().getMaxItemUseDuration(this);
    }

    public EnumAction getItemUseAction()
    {
        return this.func_77973_b().getItemUseAction(this);
    }

    /**
     * Called when the player releases the use item button. Args: world, entityplayer, itemInUseCount
     */
    public void onPlayerStoppedUsing(World worldIn, EntityPlayer playerIn, int timeLeft)
    {
        this.func_77973_b().onPlayerStoppedUsing(this, worldIn, playerIn, timeLeft);
    }

    /**
     * Returns true if the ItemStack has an NBTTagCompound. Currently used to store enchantments.
     */
    public boolean func_77942_o()
    {
        return this.stackTagCompound != null;
    }

    /**
     * Returns the NBTTagCompound of the ItemStack.
     */
    public NBTTagCompound func_77978_p()
    {
        return this.stackTagCompound;
    }

    /**
     * Get an NBTTagCompound from this stack's NBT data.
     */
    public NBTTagCompound getSubCompound(String key, boolean create)
    {
        if (this.stackTagCompound != null && this.stackTagCompound.func_150297_b(key, 10))
        {
            return this.stackTagCompound.func_74775_l(key);
        }
        else if (create)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            this.func_77983_a(key, nbttagcompound);
            return nbttagcompound;
        }
        else
        {
            return null;
        }
    }

    public NBTTagList func_77986_q()
    {
        return this.stackTagCompound == null ? null : this.stackTagCompound.getTagList("ench", 10);
    }

    /**
     * Assigns a NBTTagCompound to the ItemStack, minecraft validates that only non-stackable items can have it.
     */
    public void func_77982_d(NBTTagCompound nbt)
    {
        this.stackTagCompound = nbt;
    }

    /**
     * returns the display name of the itemstack
     */
    public String getDisplayName()
    {
        String s = this.func_77973_b().getItemStackDisplayName(this);

        if (this.stackTagCompound != null && this.stackTagCompound.func_150297_b("display", 10))
        {
            NBTTagCompound nbttagcompound = this.stackTagCompound.func_74775_l("display");

            if (nbttagcompound.func_150297_b("Name", 8))
            {
                s = nbttagcompound.getString("Name");
            }
        }

        return s;
    }

    public ItemStack func_151001_c(String displayName)
    {
        if (this.stackTagCompound == null)
        {
            this.stackTagCompound = new NBTTagCompound();
        }

        if (!this.stackTagCompound.func_150297_b("display", 10))
        {
            this.stackTagCompound.func_74782_a("display", new NBTTagCompound());
        }

        this.stackTagCompound.func_74775_l("display").func_74778_a("Name", displayName);
        return this;
    }

    /**
     * Clear any custom name set for this ItemStack
     */
    public void clearCustomName()
    {
        if (this.stackTagCompound != null)
        {
            if (this.stackTagCompound.func_150297_b("display", 10))
            {
                NBTTagCompound nbttagcompound = this.stackTagCompound.func_74775_l("display");
                nbttagcompound.func_82580_o("Name");

                if (nbttagcompound.hasNoTags())
                {
                    this.stackTagCompound.func_82580_o("display");

                    if (this.stackTagCompound.hasNoTags())
                    {
                        this.func_77982_d((NBTTagCompound)null);
                    }
                }
            }
        }
    }

    /**
     * Returns true if the itemstack has a display name
     */
    public boolean hasDisplayName()
    {
        return this.stackTagCompound == null ? false : (!this.stackTagCompound.func_150297_b("display", 10) ? false : this.stackTagCompound.func_74775_l("display").func_150297_b("Name", 8));
    }

    public List<String> getTooltip(EntityPlayer playerIn, boolean advanced)
    {
        List<String> list = Lists.<String>newArrayList();
        String s = this.getDisplayName();

        if (this.hasDisplayName())
        {
            s = EnumChatFormatting.ITALIC + s;
        }

        s = s + EnumChatFormatting.RESET;

        if (advanced)
        {
            String s1 = "";

            if (s.length() > 0)
            {
                s = s + " (";
                s1 = ")";
            }

            int i = Item.getIdFromItem(this.item);

            if (this.getHasSubtypes())
            {
                s = s + String.format("#%04d/%d%s", new Object[] {Integer.valueOf(i), Integer.valueOf(this.itemDamage), s1});
            }
            else
            {
                s = s + String.format("#%04d%s", new Object[] {Integer.valueOf(i), s1});
            }
        }
        else if (!this.hasDisplayName() && this.item == Items.filled_map)
        {
            s = s + " #" + this.itemDamage;
        }

        list.add(s);
        int i1 = 0;

        if (this.func_77942_o() && this.stackTagCompound.func_150297_b("HideFlags", 99))
        {
            i1 = this.stackTagCompound.getInteger("HideFlags");
        }

        if ((i1 & 32) == 0)
        {
            this.item.addInformation(this, playerIn, list, advanced);
        }

        if (this.func_77942_o())
        {
            if ((i1 & 1) == 0)
            {
                NBTTagList nbttaglist = this.func_77986_q();

                if (nbttaglist != null)
                {
                    for (int j = 0; j < nbttaglist.func_74745_c(); ++j)
                    {
                        int k = nbttaglist.func_150305_b(j).func_74765_d("id");
                        int l = nbttaglist.func_150305_b(j).func_74765_d("lvl");

                        if (Enchantment.func_180306_c(k) != null)
                        {
                            list.add(Enchantment.func_180306_c(k).func_77316_c(l));
                        }
                    }
                }
            }

            if (this.stackTagCompound.func_150297_b("display", 10))
            {
                NBTTagCompound nbttagcompound = this.stackTagCompound.func_74775_l("display");

                if (nbttagcompound.func_150297_b("color", 3))
                {
                    if (advanced)
                    {
                        list.add("Color: #" + Integer.toHexString(nbttagcompound.getInteger("color")).toUpperCase());
                    }
                    else
                    {
                        list.add(EnumChatFormatting.ITALIC + StatCollector.translateToLocal("item.dyed"));
                    }
                }

                if (nbttagcompound.getTagId("Lore") == 9)
                {
                    NBTTagList nbttaglist1 = nbttagcompound.getTagList("Lore", 8);

                    if (nbttaglist1.func_74745_c() > 0)
                    {
                        for (int j1 = 0; j1 < nbttaglist1.func_74745_c(); ++j1)
                        {
                            list.add(EnumChatFormatting.DARK_PURPLE + "" + EnumChatFormatting.ITALIC + nbttaglist1.getStringTagAt(j1));
                        }
                    }
                }
            }
        }

        Multimap<String, AttributeModifier> multimap = this.getAttributeModifiers();

        if (!multimap.isEmpty() && (i1 & 2) == 0)
        {
            list.add("");

            for (Entry<String, AttributeModifier> entry : multimap.entries())
            {
                AttributeModifier attributemodifier = (AttributeModifier)entry.getValue();
                double d0 = attributemodifier.getAmount();

                if (attributemodifier.getID() == Item.itemModifierUUID)
                {
                    d0 += (double)EnchantmentHelper.func_152377_a(this, EnumCreatureAttribute.UNDEFINED);
                }

                double d1;

                if (attributemodifier.getOperation() != 1 && attributemodifier.getOperation() != 2)
                {
                    d1 = d0;
                }
                else
                {
                    d1 = d0 * 100.0D;
                }

                if (d0 > 0.0D)
                {
                    list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocalFormatted("attribute.modifier.plus." + attributemodifier.getOperation(), new Object[] {DECIMALFORMAT.format(d1), StatCollector.translateToLocal("attribute.name." + (String)entry.getKey())}));
                }
                else if (d0 < 0.0D)
                {
                    d1 = d1 * -1.0D;
                    list.add(EnumChatFormatting.RED + StatCollector.translateToLocalFormatted("attribute.modifier.take." + attributemodifier.getOperation(), new Object[] {DECIMALFORMAT.format(d1), StatCollector.translateToLocal("attribute.name." + (String)entry.getKey())}));
                }
            }
        }

        if (this.func_77942_o() && this.func_77978_p().getBoolean("Unbreakable") && (i1 & 4) == 0)
        {
            list.add(EnumChatFormatting.BLUE + StatCollector.translateToLocal("item.unbreakable"));
        }

        if (this.func_77942_o() && this.stackTagCompound.func_150297_b("CanDestroy", 9) && (i1 & 8) == 0)
        {
            NBTTagList nbttaglist2 = this.stackTagCompound.getTagList("CanDestroy", 8);

            if (nbttaglist2.func_74745_c() > 0)
            {
                list.add("");
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.canBreak"));

                for (int k1 = 0; k1 < nbttaglist2.func_74745_c(); ++k1)
                {
                    Block block = Block.func_149684_b(nbttaglist2.getStringTagAt(k1));

                    if (block != null)
                    {
                        list.add(EnumChatFormatting.DARK_GRAY + block.func_149732_F());
                    }
                    else
                    {
                        list.add(EnumChatFormatting.DARK_GRAY + "missingno");
                    }
                }
            }
        }

        if (this.func_77942_o() && this.stackTagCompound.func_150297_b("CanPlaceOn", 9) && (i1 & 16) == 0)
        {
            NBTTagList nbttaglist3 = this.stackTagCompound.getTagList("CanPlaceOn", 8);

            if (nbttaglist3.func_74745_c() > 0)
            {
                list.add("");
                list.add(EnumChatFormatting.GRAY + StatCollector.translateToLocal("item.canPlace"));

                for (int l1 = 0; l1 < nbttaglist3.func_74745_c(); ++l1)
                {
                    Block block1 = Block.func_149684_b(nbttaglist3.getStringTagAt(l1));

                    if (block1 != null)
                    {
                        list.add(EnumChatFormatting.DARK_GRAY + block1.func_149732_F());
                    }
                    else
                    {
                        list.add(EnumChatFormatting.DARK_GRAY + "missingno");
                    }
                }
            }
        }

        if (advanced)
        {
            if (this.isItemDamaged())
            {
                list.add("Durability: " + (this.getMaxDamage() - this.getItemDamage()) + " / " + this.getMaxDamage());
            }

            list.add(EnumChatFormatting.DARK_GRAY + ((ResourceLocation)Item.field_150901_e.getNameForObject(this.item)).toString());

            if (this.func_77942_o())
            {
                list.add(EnumChatFormatting.DARK_GRAY + "NBT: " + this.func_77978_p().getKeySet().size() + " tag(s)");
            }
        }

        return list;
    }

    public boolean hasEffect()
    {
        return this.func_77973_b().hasEffect(this);
    }

    public EnumRarity getRarity()
    {
        return this.func_77973_b().getRarity(this);
    }

    /**
     * True if it is a tool and has no enchantments to begin with
     */
    public boolean isItemEnchantable()
    {
        return this.func_77973_b().isItemTool(this) && !this.isItemEnchanted();
    }

    /**
     * Adds an enchantment with a desired level on the ItemStack.
     */
    public void func_77966_a(Enchantment ench, int level)
    {
        if (this.stackTagCompound == null)
        {
            this.func_77982_d(new NBTTagCompound());
        }

        if (!this.stackTagCompound.func_150297_b("ench", 9))
        {
            this.stackTagCompound.func_74782_a("ench", new NBTTagList());
        }

        NBTTagList nbttaglist = this.stackTagCompound.getTagList("ench", 10);
        NBTTagCompound nbttagcompound = new NBTTagCompound();
        nbttagcompound.setShort("id", (short)ench.field_77352_x);
        nbttagcompound.setShort("lvl", (short)((byte)level));
        nbttaglist.func_74742_a(nbttagcompound);
    }

    /**
     * True if the item has enchantment data
     */
    public boolean isItemEnchanted()
    {
        return this.stackTagCompound != null && this.stackTagCompound.func_150297_b("ench", 9);
    }

    public void func_77983_a(String key, NBTBase value)
    {
        if (this.stackTagCompound == null)
        {
            this.func_77982_d(new NBTTagCompound());
        }

        this.stackTagCompound.func_74782_a(key, value);
    }

    public boolean canEditBlocks()
    {
        return this.func_77973_b().canItemEditBlocks();
    }

    /**
     * Return whether this stack is on an item frame.
     */
    public boolean isOnItemFrame()
    {
        return this.itemFrame != null;
    }

    /**
     * Set the item frame this stack is on.
     */
    public void setItemFrame(EntityItemFrame frame)
    {
        this.itemFrame = frame;
    }

    /**
     * Return the item frame this stack is on. Returns null if not on an item frame.
     */
    public EntityItemFrame getItemFrame()
    {
        return this.itemFrame;
    }

    /**
     * Get this stack's repair cost, or 0 if no repair cost is defined.
     */
    public int getRepairCost()
    {
        return this.func_77942_o() && this.stackTagCompound.func_150297_b("RepairCost", 3) ? this.stackTagCompound.getInteger("RepairCost") : 0;
    }

    /**
     * Set this stack's repair cost.
     */
    public void setRepairCost(int cost)
    {
        if (!this.func_77942_o())
        {
            this.stackTagCompound = new NBTTagCompound();
        }

        this.stackTagCompound.func_74768_a("RepairCost", cost);
    }

    public Multimap<String, AttributeModifier> getAttributeModifiers()
    {
        Multimap<String, AttributeModifier> multimap;

        if (this.func_77942_o() && this.stackTagCompound.func_150297_b("AttributeModifiers", 9))
        {
            multimap = HashMultimap.<String, AttributeModifier>create();
            NBTTagList nbttaglist = this.stackTagCompound.getTagList("AttributeModifiers", 10);

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                NBTTagCompound nbttagcompound = nbttaglist.func_150305_b(i);
                AttributeModifier attributemodifier = SharedMonsterAttributes.readAttributeModifierFromNBT(nbttagcompound);

                if (attributemodifier != null && attributemodifier.getID().getLeastSignificantBits() != 0L && attributemodifier.getID().getMostSignificantBits() != 0L)
                {
                    multimap.put(nbttagcompound.getString("AttributeName"), attributemodifier);
                }
            }
        }
        else
        {
            multimap = this.func_77973_b().getItemAttributeModifiers();
        }

        return multimap;
    }

    public void setItem(Item newItem)
    {
        this.item = newItem;
    }

    /**
     * Get a ChatComponent for this Item's display name that shows this Item on hover
     */
    public IChatComponent func_151000_E()
    {
        ChatComponentText chatcomponenttext = new ChatComponentText(this.getDisplayName());

        if (this.hasDisplayName())
        {
            chatcomponenttext.func_150256_b().func_150217_b(Boolean.TRUE);
        }

        IChatComponent ichatcomponent = (new ChatComponentText("[")).func_150257_a(chatcomponenttext).func_150258_a("]");

        if (this.item != null)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            this.writeToNBT(nbttagcompound);
            ichatcomponent.func_150256_b().setChatHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_ITEM, new ChatComponentText(nbttagcompound.toString())));
            ichatcomponent.func_150256_b().func_150238_a(this.getRarity().rarityColor);
        }

        return ichatcomponent;
    }

    public boolean canDestroy(Block blockIn)
    {
        if (blockIn == this.canDestroyCacheBlock)
        {
            return this.canDestroyCacheResult;
        }
        else
        {
            this.canDestroyCacheBlock = blockIn;

            if (this.func_77942_o() && this.stackTagCompound.func_150297_b("CanDestroy", 9))
            {
                NBTTagList nbttaglist = this.stackTagCompound.getTagList("CanDestroy", 8);

                for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
                {
                    Block block = Block.func_149684_b(nbttaglist.getStringTagAt(i));

                    if (block == blockIn)
                    {
                        this.canDestroyCacheResult = true;
                        return true;
                    }
                }
            }

            this.canDestroyCacheResult = false;
            return false;
        }
    }

    public boolean canPlaceOn(Block blockIn)
    {
        if (blockIn == this.canPlaceOnCacheBlock)
        {
            return this.canPlaceOnCacheResult;
        }
        else
        {
            this.canPlaceOnCacheBlock = blockIn;

            if (this.func_77942_o() && this.stackTagCompound.func_150297_b("CanPlaceOn", 9))
            {
                NBTTagList nbttaglist = this.stackTagCompound.getTagList("CanPlaceOn", 8);

                for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
                {
                    Block block = Block.func_149684_b(nbttaglist.getStringTagAt(i));

                    if (block == blockIn)
                    {
                        this.canPlaceOnCacheResult = true;
                        return true;
                    }
                }
            }

            this.canPlaceOnCacheResult = false;
            return false;
        }
    }
}

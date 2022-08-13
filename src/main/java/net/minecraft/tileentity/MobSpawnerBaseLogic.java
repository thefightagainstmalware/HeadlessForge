package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.StringUtils;
import net.minecraft.util.WeightedRandom;
import net.minecraft.world.World;

public abstract class MobSpawnerBaseLogic
{
    /** The delay to spawn. */
    private int spawnDelay = 20;
    private String mobID = "Pig";
    private final List<MobSpawnerBaseLogic.WeightedRandomMinecart> minecartToSpawn = Lists.<MobSpawnerBaseLogic.WeightedRandomMinecart>newArrayList();
    private MobSpawnerBaseLogic.WeightedRandomMinecart randomEntity;

    /** The rotation of the mob inside the mob spawner */
    private double mobRotation;

    /** the previous rotation of the mob inside the mob spawner */
    private double prevMobRotation;
    private int minSpawnDelay = 200;
    private int maxSpawnDelay = 800;
    private int spawnCount = 4;

    /** Cached instance of the entity to render inside the spawner. */
    private Entity cachedEntity;
    private int maxNearbyEntities = 6;

    /** The distance from which a player activates the spawner. */
    private int activatingRangeFromPlayer = 16;

    /** The range coefficient for spawning entities around. */
    private int spawnRange = 4;

    /**
     * Gets the entity name that should be spawned.
     */
    private String getEntityNameToSpawn()
    {
        if (this.getRandomEntity() == null)
        {
            if (this.mobID != null && this.mobID.equals("Minecart"))
            {
                this.mobID = "MinecartRideable";
            }

            return this.mobID;
        }
        else
        {
            return this.getRandomEntity().entityType;
        }
    }

    public void setEntityName(String name)
    {
        this.mobID = name;
    }

    /**
     * Returns true if there's a player close enough to this mob spawner to activate it.
     */
    private boolean isActivated()
    {
        BlockPos blockpos = this.getSpawnerPosition();
        return this.getSpawnerWorld().isAnyPlayerWithinRangeAt((double)blockpos.func_177958_n() + 0.5D, (double)blockpos.func_177956_o() + 0.5D, (double)blockpos.func_177952_p() + 0.5D, (double)this.activatingRangeFromPlayer);
    }

    public void updateSpawner()
    {
        if (this.isActivated())
        {
            BlockPos blockpos = this.getSpawnerPosition();

            if (this.getSpawnerWorld().isRemote)
            {
                double d3 = (double)((float)blockpos.func_177958_n() + this.getSpawnerWorld().rand.nextFloat());
                double d4 = (double)((float)blockpos.func_177956_o() + this.getSpawnerWorld().rand.nextFloat());
                double d5 = (double)((float)blockpos.func_177952_p() + this.getSpawnerWorld().rand.nextFloat());
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d3, d4, d5, 0.0D, 0.0D, 0.0D, new int[0]);
                this.getSpawnerWorld().spawnParticle(EnumParticleTypes.FLAME, d3, d4, d5, 0.0D, 0.0D, 0.0D, new int[0]);

                if (this.spawnDelay > 0)
                {
                    --this.spawnDelay;
                }

                this.prevMobRotation = this.mobRotation;
                this.mobRotation = (this.mobRotation + (double)(1000.0F / ((float)this.spawnDelay + 200.0F))) % 360.0D;
            }
            else
            {
                if (this.spawnDelay == -1)
                {
                    this.resetTimer();
                }

                if (this.spawnDelay > 0)
                {
                    --this.spawnDelay;
                    return;
                }

                boolean flag = false;

                for (int i = 0; i < this.spawnCount; ++i)
                {
                    Entity entity = EntityList.createEntityByName(this.getEntityNameToSpawn(), this.getSpawnerWorld());

                    if (entity == null)
                    {
                        return;
                    }

                    int j = this.getSpawnerWorld().getEntitiesWithinAABB(entity.getClass(), (new AxisAlignedBB((double)blockpos.func_177958_n(), (double)blockpos.func_177956_o(), (double)blockpos.func_177952_p(), (double)(blockpos.func_177958_n() + 1), (double)(blockpos.func_177956_o() + 1), (double)(blockpos.func_177952_p() + 1))).expand((double)this.spawnRange, (double)this.spawnRange, (double)this.spawnRange)).size();

                    if (j >= this.maxNearbyEntities)
                    {
                        this.resetTimer();
                        return;
                    }

                    double d0 = (double)blockpos.func_177958_n() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * (double)this.spawnRange + 0.5D;
                    double d1 = (double)(blockpos.func_177956_o() + this.getSpawnerWorld().rand.nextInt(3) - 1);
                    double d2 = (double)blockpos.func_177952_p() + (this.getSpawnerWorld().rand.nextDouble() - this.getSpawnerWorld().rand.nextDouble()) * (double)this.spawnRange + 0.5D;
                    EntityLiving entityliving = entity instanceof EntityLiving ? (EntityLiving)entity : null;
                    entity.func_70012_b(d0, d1, d2, this.getSpawnerWorld().rand.nextFloat() * 360.0F, 0.0F);

                    if (entityliving == null || entityliving.getCanSpawnHere() && entityliving.isNotColliding())
                    {
                        this.spawnNewEntity(entity, true);
                        this.getSpawnerWorld().playAuxSFX(2004, blockpos, 0);

                        if (entityliving != null)
                        {
                            entityliving.spawnExplosionParticle();
                        }

                        flag = true;
                    }
                }

                if (flag)
                {
                    this.resetTimer();
                }
            }
        }
    }

    private Entity spawnNewEntity(Entity entityIn, boolean spawn)
    {
        if (this.getRandomEntity() != null)
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            entityIn.writeToNBTOptional(nbttagcompound);

            for (String s : this.getRandomEntity().nbtData.getKeySet())
            {
                NBTBase nbtbase = this.getRandomEntity().nbtData.getTag(s);
                nbttagcompound.func_74782_a(s, nbtbase.func_74737_b());
            }

            entityIn.func_70020_e(nbttagcompound);

            if (entityIn.field_70170_p != null && spawn)
            {
                entityIn.field_70170_p.func_72838_d(entityIn);
            }

            NBTTagCompound nbttagcompound2;

            for (Entity entity = entityIn; nbttagcompound.func_150297_b("Riding", 10); nbttagcompound = nbttagcompound2)
            {
                nbttagcompound2 = nbttagcompound.func_74775_l("Riding");
                Entity entity1 = EntityList.createEntityByName(nbttagcompound2.getString("id"), entityIn.field_70170_p);

                if (entity1 != null)
                {
                    NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                    entity1.writeToNBTOptional(nbttagcompound1);

                    for (String s1 : nbttagcompound2.getKeySet())
                    {
                        NBTBase nbtbase1 = nbttagcompound2.getTag(s1);
                        nbttagcompound1.func_74782_a(s1, nbtbase1.func_74737_b());
                    }

                    entity1.func_70020_e(nbttagcompound1);
                    entity1.func_70012_b(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, entity.field_70177_z, entity.field_70125_A);

                    if (entityIn.field_70170_p != null && spawn)
                    {
                        entityIn.field_70170_p.func_72838_d(entity1);
                    }

                    entity.func_70078_a(entity1);
                }

                entity = entity1;
            }
        }
        else if (entityIn instanceof EntityLivingBase && entityIn.field_70170_p != null && spawn)
        {
            if (entityIn instanceof EntityLiving)
            {
                ((EntityLiving)entityIn).func_180482_a(entityIn.field_70170_p.func_175649_E(new BlockPos(entityIn)), (IEntityLivingData)null);
            }

            entityIn.field_70170_p.func_72838_d(entityIn);
        }

        return entityIn;
    }

    private void resetTimer()
    {
        if (this.maxSpawnDelay <= this.minSpawnDelay)
        {
            this.spawnDelay = this.minSpawnDelay;
        }
        else
        {
            int i = this.maxSpawnDelay - this.minSpawnDelay;
            this.spawnDelay = this.minSpawnDelay + this.getSpawnerWorld().rand.nextInt(i);
        }

        if (this.minecartToSpawn.size() > 0)
        {
            this.setRandomEntity((MobSpawnerBaseLogic.WeightedRandomMinecart)WeightedRandom.getRandomItem(this.getSpawnerWorld().rand, this.minecartToSpawn));
        }

        this.func_98267_a(1);
    }

    public void readFromNBT(NBTTagCompound nbt)
    {
        this.mobID = nbt.getString("EntityId");
        this.spawnDelay = nbt.func_74765_d("Delay");
        this.minecartToSpawn.clear();

        if (nbt.func_150297_b("SpawnPotentials", 9))
        {
            NBTTagList nbttaglist = nbt.getTagList("SpawnPotentials", 10);

            for (int i = 0; i < nbttaglist.func_74745_c(); ++i)
            {
                this.minecartToSpawn.add(new MobSpawnerBaseLogic.WeightedRandomMinecart(nbttaglist.func_150305_b(i)));
            }
        }

        if (nbt.func_150297_b("SpawnData", 10))
        {
            this.setRandomEntity(new MobSpawnerBaseLogic.WeightedRandomMinecart(nbt.func_74775_l("SpawnData"), this.mobID));
        }
        else
        {
            this.setRandomEntity((MobSpawnerBaseLogic.WeightedRandomMinecart)null);
        }

        if (nbt.func_150297_b("MinSpawnDelay", 99))
        {
            this.minSpawnDelay = nbt.func_74765_d("MinSpawnDelay");
            this.maxSpawnDelay = nbt.func_74765_d("MaxSpawnDelay");
            this.spawnCount = nbt.func_74765_d("SpawnCount");
        }

        if (nbt.func_150297_b("MaxNearbyEntities", 99))
        {
            this.maxNearbyEntities = nbt.func_74765_d("MaxNearbyEntities");
            this.activatingRangeFromPlayer = nbt.func_74765_d("RequiredPlayerRange");
        }

        if (nbt.func_150297_b("SpawnRange", 99))
        {
            this.spawnRange = nbt.func_74765_d("SpawnRange");
        }

        if (this.getSpawnerWorld() != null)
        {
            this.cachedEntity = null;
        }
    }

    public void writeToNBT(NBTTagCompound nbt)
    {
        String s = this.getEntityNameToSpawn();

        if (!StringUtils.isNullOrEmpty(s))
        {
            nbt.func_74778_a("EntityId", s);
            nbt.setShort("Delay", (short)this.spawnDelay);
            nbt.setShort("MinSpawnDelay", (short)this.minSpawnDelay);
            nbt.setShort("MaxSpawnDelay", (short)this.maxSpawnDelay);
            nbt.setShort("SpawnCount", (short)this.spawnCount);
            nbt.setShort("MaxNearbyEntities", (short)this.maxNearbyEntities);
            nbt.setShort("RequiredPlayerRange", (short)this.activatingRangeFromPlayer);
            nbt.setShort("SpawnRange", (short)this.spawnRange);

            if (this.getRandomEntity() != null)
            {
                nbt.func_74782_a("SpawnData", this.getRandomEntity().nbtData.func_74737_b());
            }

            if (this.getRandomEntity() != null || this.minecartToSpawn.size() > 0)
            {
                NBTTagList nbttaglist = new NBTTagList();

                if (this.minecartToSpawn.size() > 0)
                {
                    for (MobSpawnerBaseLogic.WeightedRandomMinecart mobspawnerbaselogic$weightedrandomminecart : this.minecartToSpawn)
                    {
                        nbttaglist.func_74742_a(mobspawnerbaselogic$weightedrandomminecart.toNBT());
                    }
                }
                else
                {
                    nbttaglist.func_74742_a(this.getRandomEntity().toNBT());
                }

                nbt.func_74782_a("SpawnPotentials", nbttaglist);
            }
        }
    }

    public Entity func_180612_a(World worldIn)
    {
        if (this.cachedEntity == null)
        {
            Entity entity = EntityList.createEntityByName(this.getEntityNameToSpawn(), worldIn);

            if (entity != null)
            {
                entity = this.spawnNewEntity(entity, false);
                this.cachedEntity = entity;
            }
        }

        return this.cachedEntity;
    }

    /**
     * Sets the delay to minDelay if parameter given is 1, else return false.
     */
    public boolean setDelayToMin(int delay)
    {
        if (delay == 1 && this.getSpawnerWorld().isRemote)
        {
            this.spawnDelay = this.minSpawnDelay;
            return true;
        }
        else
        {
            return false;
        }
    }

    private MobSpawnerBaseLogic.WeightedRandomMinecart getRandomEntity()
    {
        return this.randomEntity;
    }

    public void setRandomEntity(MobSpawnerBaseLogic.WeightedRandomMinecart p_98277_1_)
    {
        this.randomEntity = p_98277_1_;
    }

    public abstract void func_98267_a(int id);

    public abstract World getSpawnerWorld();

    public abstract BlockPos getSpawnerPosition();

    public double getMobRotation()
    {
        return this.mobRotation;
    }

    public double getPrevMobRotation()
    {
        return this.prevMobRotation;
    }

    public class WeightedRandomMinecart extends WeightedRandom.Item
    {
        private final NBTTagCompound nbtData;
        private final String entityType;

        public WeightedRandomMinecart(NBTTagCompound tagCompound)
        {
            this(tagCompound.func_74775_l("Properties"), tagCompound.getString("Type"), tagCompound.getInteger("Weight"));
        }

        public WeightedRandomMinecart(NBTTagCompound tagCompound, String type)
        {
            this(tagCompound, type, 1);
        }

        private WeightedRandomMinecart(NBTTagCompound tagCompound, String type, int weight)
        {
            super(weight);

            if (type.equals("Minecart"))
            {
                if (tagCompound != null)
                {
                    type = EntityMinecart.EnumMinecartType.byNetworkID(tagCompound.getInteger("Type")).getName();
                }
                else
                {
                    type = "MinecartRideable";
                }
            }

            this.nbtData = tagCompound;
            this.entityType = type;
        }

        public NBTTagCompound toNBT()
        {
            NBTTagCompound nbttagcompound = new NBTTagCompound();
            nbttagcompound.func_74782_a("Properties", this.nbtData);
            nbttagcompound.func_74778_a("Type", this.entityType);
            nbttagcompound.func_74768_a("Weight", this.itemWeight);
            return nbttagcompound;
        }
    }
}

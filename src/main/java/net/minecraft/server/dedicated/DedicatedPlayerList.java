package net.minecraft.server.dedicated;

import com.mojang.authlib.GameProfile;
import java.io.IOException;
import net.minecraft.server.management.ServerConfigurationManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SideOnly(Side.SERVER)
public class DedicatedPlayerList extends ServerConfigurationManager
{
    private static final Logger LOGGER = LogManager.getLogger();

    public DedicatedPlayerList(DedicatedServer server)
    {
        super(server);
        this.setViewDistance(server.getIntProperty("view-distance", 10));
        this.maxPlayers = server.getIntProperty("max-players", 20);
        this.func_72371_a(server.getBooleanProperty("white-list", false));

        if (!server.func_71264_H())
        {
            this.func_152608_h().setLanServer(true);
            this.func_72363_f().setLanServer(true);
        }

        this.loadUserBansList();
        this.saveUserBanList();
        this.loadIpBanList();
        this.saveIpBanList();
        this.loadOpsList();
        this.readWhiteList();
        this.saveOpsList();

        if (!this.func_152599_k().getSaveFile().exists())
        {
            this.saveWhiteList();
        }
    }

    public void func_72371_a(boolean whitelistEnabled)
    {
        super.func_72371_a(whitelistEnabled);
        this.getServerInstance().setProperty("white-list", Boolean.valueOf(whitelistEnabled));
        this.getServerInstance().saveProperties();
    }

    public void func_152605_a(GameProfile profile)
    {
        super.func_152605_a(profile);
        this.saveOpsList();
    }

    public void func_152610_b(GameProfile profile)
    {
        super.func_152610_b(profile);
        this.saveOpsList();
    }

    public void func_152597_c(GameProfile profile)
    {
        super.func_152597_c(profile);
        this.saveWhiteList();
    }

    public void func_152601_d(GameProfile profile)
    {
        super.func_152601_d(profile);
        this.saveWhiteList();
    }

    /**
     * Either does nothing, or calls readWhiteList.
     */
    public void func_72362_j()
    {
        this.readWhiteList();
    }

    private void saveIpBanList()
    {
        try
        {
            this.func_72363_f().writeChanges();
        }
        catch (IOException ioexception)
        {
            LOGGER.warn((String)"Failed to save ip banlist: ", (Throwable)ioexception);
        }
    }

    private void saveUserBanList()
    {
        try
        {
            this.func_152608_h().writeChanges();
        }
        catch (IOException ioexception)
        {
            LOGGER.warn((String)"Failed to save user banlist: ", (Throwable)ioexception);
        }
    }

    private void loadIpBanList()
    {
        try
        {
            this.func_72363_f().readSavedFile();
        }
        catch (IOException ioexception)
        {
            LOGGER.warn((String)"Failed to load ip banlist: ", (Throwable)ioexception);
        }
    }

    private void loadUserBansList()
    {
        try
        {
            this.func_152608_h().readSavedFile();
        }
        catch (IOException ioexception)
        {
            LOGGER.warn((String)"Failed to load user banlist: ", (Throwable)ioexception);
        }
    }

    private void loadOpsList()
    {
        try
        {
            this.func_152603_m().readSavedFile();
        }
        catch (Exception exception)
        {
            LOGGER.warn((String)"Failed to load operators list: ", (Throwable)exception);
        }
    }

    private void saveOpsList()
    {
        try
        {
            this.func_152603_m().writeChanges();
        }
        catch (Exception exception)
        {
            LOGGER.warn((String)"Failed to save operators list: ", (Throwable)exception);
        }
    }

    private void readWhiteList()
    {
        try
        {
            this.func_152599_k().readSavedFile();
        }
        catch (Exception exception)
        {
            LOGGER.warn((String)"Failed to load white-list: ", (Throwable)exception);
        }
    }

    private void saveWhiteList()
    {
        try
        {
            this.func_152599_k().writeChanges();
        }
        catch (Exception exception)
        {
            LOGGER.warn((String)"Failed to save white-list: ", (Throwable)exception);
        }
    }

    public boolean canJoin(GameProfile profile)
    {
        return this.getServerInstance().getBooleanProperty("white-list", false) || this.func_152596_g(profile) || this.func_152599_k().isWhitelisted(profile);
    }

    public DedicatedServer getServerInstance()
    {
        return (DedicatedServer)super.getServerInstance();
    }

    public boolean func_183023_f(GameProfile p_183023_1_)
    {
        return this.func_152603_m().func_183026_b(p_183023_1_);
    }
}
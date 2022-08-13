package net.minecraft.client.resources;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import net.minecraft.client.resources.data.IMetadataSerializer;
import net.minecraft.client.resources.data.LanguageMetadataSection;
import net.minecraft.util.StringTranslate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LanguageManager implements IResourceManagerReloadListener
{
    private static final Logger logger = LogManager.getLogger();
    private final IMetadataSerializer theMetadataSerializer;
    private String currentLanguage;
    protected static final Locale currentLocale = new Locale();
    private Map<String, Language> languageMap = Maps.newHashMap();
    private Language lang;

    public LanguageManager(IMetadataSerializer theMetadataSerializerIn, String currentLanguageIn)
    {
        this.theMetadataSerializer = theMetadataSerializerIn;
        this.currentLanguage = currentLanguageIn;
        I18n.setLocale(currentLocale);
        this.lang = new Language("en_US", "US", "English", false);
    }

    public void parseLanguageMetadata(List<IResourcePack> p_135043_1_)
    {
        this.languageMap.clear();

        for (IResourcePack iresourcepack : p_135043_1_)
        {
            try
            {
                LanguageMetadataSection languagemetadatasection = (LanguageMetadataSection)iresourcepack.getPackMetadata(this.theMetadataSerializer, "language");

                if (languagemetadatasection != null)
                {
                    for (Language language : languagemetadatasection.getLanguages())
                    {
                        if (!this.languageMap.containsKey(language.func_135034_a()))
                        {
                            this.languageMap.put(language.func_135034_a(), language);
                        }
                    }
                }
            }
            catch (RuntimeException | IOException runtimeexception)
            {
                logger.warn((String)("Unable to parse metadata section of resourcepack: " + iresourcepack.getPackName()), (Throwable)runtimeexception);
            }
        }
    }

    public void func_110549_a(IResourceManager resourceManager)
    {
        List<String> list = Lists.newArrayList("en_US");

        if (!"en_US".equals(this.currentLanguage))
        {
            list.add(this.currentLanguage);
        }

        currentLocale.loadLocaleDataFiles(resourceManager, list);
        StringTranslate.replaceWith(currentLocale.properties);
    }

    public boolean isCurrentLocaleUnicode()
    {
        return currentLocale.isUnicode();
    }

    public boolean isCurrentLanguageBidirectional()
    {
        return this.func_135041_c() != null && this.func_135041_c().isBidirectional();
    }

    public void setCurrentLanguage(Language currentLanguageIn)
    {
        this.currentLanguage = currentLanguageIn.func_135034_a();
    }

    public Language func_135041_c()
    {
        return lang;
    }

    public SortedSet<Language> getLanguages()
    {
        return Sets.newTreeSet(this.languageMap.values());
    }
}

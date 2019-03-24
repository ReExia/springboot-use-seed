package com.example.pageadmin.generator;

import freemarker.cache.ClassTemplateLoader;
import freemarker.cache.NullCacheStorage;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.apache.commons.codec.Charsets;

import java.io.IOException;

public class FreeMarkerHelper {

    private static final Configuration CONFIGURATION = new Configuration(Configuration.VERSION_2_3_22);

    //制定模板加载路径
    static {
        ClassTemplateLoader classTemplateLoader = new ClassTemplateLoader(FreeMarkerHelper.class, "/generator");
        CONFIGURATION.setTemplateLoader(classTemplateLoader);
        CONFIGURATION.setDefaultEncoding(Charsets.UTF_8.name());
        CONFIGURATION.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        CONFIGURATION.setCacheStorage(NullCacheStorage.INSTANCE);
    }

    private FreeMarkerHelper(){
    }

    /**
     * 获取模板
     * @param templateName
     * @return
     * @throws IOException
     */
    public static Template getTemplate(String templateName) throws IOException{
        return CONFIGURATION.getTemplate(templateName);
    }

    public static void clearCache(){
        CONFIGURATION.clearTemplateCache();
    }



}

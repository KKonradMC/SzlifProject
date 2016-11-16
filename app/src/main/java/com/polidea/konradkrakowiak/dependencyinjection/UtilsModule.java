package com.polidea.konradkrakowiak.dependencyinjection;


import android.content.Context;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.polidea.konradkrakowiak.R;
import dagger.Module;
import dagger.Provides;
import javax.inject.Named;

@Module
public class UtilsModule {

    private static final String WITH_MEMORY = "withMemory";

    private static final String DEFAULT = "default";

    private Context context;

    UtilsModule(Context context) {
        this.context = context;
    }

    @Provides
    ImageLoader provideImageLoader(@Named(WITH_MEMORY) ImageLoaderConfiguration imageLoaderConfiguration) {
        final ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(imageLoaderConfiguration);
        return imageLoader;
    }

    @Provides
    @Named(DEFAULT)
    ImageLoaderConfiguration provideImageLoaderConfiguration() {
        return ImageLoaderConfiguration.createDefault(context);
    }

    @Provides
    @Named(WITH_MEMORY)
    ImageLoaderConfiguration provideImageLoaderConfigurationWithMemory(@Named(WITH_MEMORY) DisplayImageOptions displayImageOptions) {
        return new ImageLoaderConfiguration.Builder(context)
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
    }

    @Provides
    @Named(WITH_MEMORY)
    DisplayImageOptions provideDisplayImageOptions() {
        return new DisplayImageOptions
                .Builder()
                .showImageOnLoading(R.drawable.ic_launcher)
                .showImageForEmptyUri(R.drawable.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .cacheInMemory(true)
                .build();
    }

}

package com.polidea.konradkrakowiak.dependencyinjection;

import com.polidea.konradkrakowiak.SzlifApplication;
import com.polidea.konradkrakowiak.user.ui.UserDetailsActivity;
import com.polidea.konradkrakowiak.user.ui.UserListActivity;
import dagger.Component;
import javax.inject.Singleton;

@Singleton
@Component(modules = {RestModule.class, UtilsModule.class})
public interface SzlifAppComponent {

    final class Initializer {

        private Initializer() {

        }

        public static SzlifAppComponent init(SzlifApplication app) {
            return DaggerSzlifAppComponent.builder()
                    .utilsModule(new UtilsModule(app))
                    .build();
        }

    }

    void inject(SzlifApplication szlifApplication);

    void inject(UserListActivity userListActivity);

    void inject(UserDetailsActivity userDetailsActivity);
}

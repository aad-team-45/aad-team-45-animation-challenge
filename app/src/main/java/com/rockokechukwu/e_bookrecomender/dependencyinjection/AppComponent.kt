package com.rockokechukwu.e_bookrecomender.dependencyinjection

import android.app.Application
import com.rockokechukwu.e_bookrecomender.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Singleton component interface for the app. It ties all the modules together.
 * The component is used to connect objects to their dependencies.
 * Dagger will auto-generate DaggerAppComponent which is used for initialization at Application.
 */
@Singleton
@Component(
    modules = [
        // AndroidSupportInjectionModule is a class of Dagger and we don't need to create it.
        // If you want to use injection in fragment then you should use AndroidSupportInjectionModule.class else use AndroidInjectionModule.
        AndroidSupportInjectionModule::class,
        ViewModelModule::class, // TODO
        AppModule::class,
        MainActivityModule::class
    ]
)
interface AppComponent {

    @Component.Builder // Used for instantiation of a component.
    interface Builder {

        @BindsInstance // Bind our application instance to our Dagger graph.
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    // The application which is allowed to request the dependencies declared by the modules
    // (by means of the @Inject annotation) should be declared here with individual inject() methods.
    fun inject(app: App)
}
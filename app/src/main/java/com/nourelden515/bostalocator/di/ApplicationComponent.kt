package com.nourelden515.bostalocator.di

import android.content.Context
import com.nourelden515.bostalocator.ui.MainActivity
import com.nourelden515.bostalocator.ui.choosedeliveryarea.ChooseDeliveryAreaFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class,
        NetworkModule::class,
        RepositoryModule::class
    ]
)
interface ApplicationComponent {

    fun inject(activity: MainActivity)
    fun inject(fragment: ChooseDeliveryAreaFragment)


    @Component.Factory
    interface Factory {
        fun create(applicationModule: ApplicationModule): ApplicationComponent
    }

    companion object {
        fun create(context: Context): ApplicationComponent {
            return DaggerApplicationComponent.factory().create(ApplicationModule(context))
        }
    }
}
package com.rockokechukwu.e_bookrecomender.dependencyinjection

import android.app.Application
import androidx.room.Room
import com.rockokechukwu.e_bookrecomender.api.BookService
import com.rockokechukwu.e_bookrecomender.db.EbookDao
import com.rockokechukwu.e_bookrecomender.db.EbookDb
import com.rockokechukwu.e_bookrecomender.utilities.BASE_URL
import com.rockokechukwu.e_bookrecomender.utilities.LiveDataCallAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun provideBookService(): BookService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
            .create(BookService::class.java)
    }

    @Singleton
    @Provides
    fun provideDb(app: Application): EbookDb {
        return Room
            .databaseBuilder(app, EbookDb::class.java, "ebook.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideEbookDao(db: EbookDb): EbookDao {
        return db.ebookDao()
    }
}
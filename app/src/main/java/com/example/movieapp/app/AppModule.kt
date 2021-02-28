package com.example.movieapp.app

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.example.movieapp.BuildConfig
import com.example.movieapp.R
import com.example.movieapp.data.data_providers.local.LocalDataProvider
import com.example.movieapp.data.data_providers.local.LocalDataProviderImpl
import com.example.movieapp.data.data_providers.remote.RemoteDataProvider
import com.example.movieapp.data.repositories.MovieDetailRepositoryImpl
import com.example.movieapp.data.repositories.PopularMoviesRepositoryImpl
import com.example.movieapp.domain.repositories.MovieDetailRepository
import com.example.movieapp.domain.repositories.PopularMoviesRepository
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.cert.CertificateException
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application): Context {
        return application.applicationContext
    }

    @Singleton
    @Provides
    @Named(BASE_URL)
    fun provideBaseUrl(context: Context, localDataProvider: LocalDataProvider): String {
        return if (localDataProvider.isStage())
            context.getString(R.string.base_url_stage)
        else context.getString(R.string.base_url)
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences("myPrefs", Context.MODE_PRIVATE)
    }

    @Singleton
    @Provides
    fun provideRemoteDataProviderIdentity(
        @Named(BASE_URL) baseUrl: String,
        localDataProvider: LocalDataProvider
    ) : RemoteDataProvider {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            @Throws(CertificateException::class)
            override fun checkClientTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            @Throws(CertificateException::class)
            override fun checkServerTrusted(
                chain: Array<java.security.cert.X509Certificate>,
                authType: String
            ) {
            }

            override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> {
                return arrayOf()
            }
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, java.security.SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        val headerInterceptor = Interceptor {
            val buildInterceptor = it.request().newBuilder()
            if (localDataProvider.getToken().isNotEmpty())
                buildInterceptor.addHeader(
                    "Authorization",
                    "Bearer ${localDataProvider.getToken()}"
                )
            return@Interceptor it.proceed(buildInterceptor.build())
        }

        val builder = OkHttpClient()
            .newBuilder()
            .addInterceptor(headerInterceptor)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
        builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
        builder.hostnameVerifier(HostnameVerifier { _, _ -> true })

        if (BuildConfig.DEBUG) {
            builder.addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }

        val retrofit = Retrofit.Builder()
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create()
                )
            )
            .client(builder.build())
            .baseUrl(baseUrl)
            .build()
        return retrofit.create(RemoteDataProvider::class.java)
    }

    @Singleton
    @Provides
    fun provideLocalDataProvider(localDataProvider: LocalDataProviderImpl): LocalDataProvider {
        return localDataProvider
    }

    @Singleton
    @Provides
    fun providePopularMoviesRepository(popularMoviesRepository: PopularMoviesRepositoryImpl): PopularMoviesRepository = popularMoviesRepository

    @Singleton
    @Provides
    fun provideMovieDetailRepository(movieDetailRepository: MovieDetailRepositoryImpl): MovieDetailRepository = movieDetailRepository

}
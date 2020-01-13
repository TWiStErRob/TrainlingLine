package com.trainlingline.part_5_simple_use_of_scopes

import dagger.Binds
import dagger.Module
import okhttp3.OkHttpClient
import javax.inject.Inject

interface UserRepo {

    fun getUser(userId: String): User

}

data class User(val name: String)

class RemoteUserRepo @Inject constructor(
    private val okHttpClient: OkHttpClient
) : UserRepo {

    init {
        println("$okHttpClient")
    }

    override fun getUser(userId: String): User {
        // Pretend we have some okhttp code here
        return User("User")
    }
}


@Module
interface UserRepoModule {

    @Binds
    fun bindRepo(impl: RemoteUserRepo): UserRepo

}


package com.rsanchezdev.randomusercode.ui.detail

import androidx.lifecycle.SavedStateHandle
import com.rsanchezdev.randomusercode.di.UserDI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class DetailViewModelModule {

    @Provides
    @ViewModelScoped
    @UserDI
    fun provideUser(savedStateHandle: SavedStateHandle) =
        DetailFragmentArgs.fromSavedStateHandle(savedStateHandle).user

}
package com.rsanchezdev.randomusercode.ui.main

import app.cash.turbine.test
import com.rsanchezdev.domain.dto.RequestedItems
import com.rsanchezdev.domain.dto.mocks.sampleUser
import com.rsanchezdev.randomusercode.testrules.CoroutinesTestRule
import com.rsanchezdev.usecases.userslist.RequestUsersListUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runCurrent
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    @Mock
    lateinit var requestUsersListUseCase: RequestUsersListUseCase

    private lateinit var vm: MainViewModel

    private val requestedItems = RequestedItems(listOf(sampleUser))

    @Test
    fun `Progress is shown when screen starts and hidden when it finishes requesting beers`() =
        runTest {
            vm = buildViewModel()
            vm.onUiReady()
            vm.state.test {
                assertEquals(MainViewModel.UiState(), awaitItem())
                assertEquals(MainViewModel.UiState(loading = true), awaitItem())
                assertEquals(MainViewModel.UiState(requestedItems = requestedItems, loading = false), awaitItem())
                cancel()
            }
        }


    @Test
    fun `Users are requested when UI screen starts`() = runTest {
        vm = buildViewModel()
        vm.onUiReady()
        runCurrent()

        verify(requestUsersListUseCase).invoke()
    }

    private suspend fun buildViewModel(): MainViewModel {
        whenever(requestUsersListUseCase.invoke()).thenReturn(requestedItems)
        return MainViewModel(requestUsersListUseCase)
    }
}

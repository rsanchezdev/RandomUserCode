package com.rsanchezdev.randomusercode.ui.detail

import app.cash.turbine.test
import com.rsanchezdev.domain.dto.mocks.sampleUser
import com.rsanchezdev.randomusercode.testrules.CoroutinesTestRule
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private lateinit var vm: DetailViewModel

    private val user = sampleUser

    @Test
    fun `UI is updated with the user on start`() = runTest {
        vm = buildViewModel()
        vm.state.test {
            assertEquals(DetailViewModel.UiState(user = user), awaitItem())
            cancel()
        }
    }

    private fun buildViewModel(): DetailViewModel {
        return DetailViewModel(user)
    }
}
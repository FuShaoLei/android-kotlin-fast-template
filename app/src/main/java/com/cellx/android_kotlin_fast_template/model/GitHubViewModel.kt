package com.cellx.android_kotlin_fast_template.model
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cellx.android_kotlin_fast_template.api.GithubApi
import com.cellx.android_kotlin_fast_template.api.ServiceCreator
import com.cellx.android_kotlin_fast_template.api.TestService
import com.cellx.android_kotlin_fast_template.entity.Repo
import com.cellx.android_kotlin_fast_template.entity.TestData
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubViewModel : ViewModel() {

    private val _repositories = MutableLiveData<TestData>()
    val repositories: LiveData<TestData> = _repositories

    fun fetchRepositories() {
        viewModelScope.launch {
            try {
                val response = ServiceCreator.create<TestService>().get1()

                _repositories.value = response
            } catch (e: Exception) {
                Log.e("GitHubViewModel", "Error fetching repositories", e)
            }
        }
    }
}

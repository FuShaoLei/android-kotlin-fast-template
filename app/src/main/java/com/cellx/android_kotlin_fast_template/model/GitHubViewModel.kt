package com.cellx.android_kotlin_fast_template.model
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cellx.android_kotlin_fast_template.api.GithubApi
import com.cellx.android_kotlin_fast_template.entity.Repo
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class GitHubViewModel : ViewModel() {

    private val _repositories = MutableLiveData<List<Repo>>()
    val repositories: LiveData<List<Repo>> = _repositories

    fun fetchRepositories() {
        viewModelScope.launch {
            try {
                val response = GithubApi.createGithubApi().searchRepos("Android", 0, 20)


                _repositories.value = response.items
            } catch (e: Exception) {
                Log.e("GitHubViewModel", "Error fetching repositories", e)
            }
        }
    }
}

package com.example.desafio_android.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_android.api.InitRetrofit
import com.example.desafio_android.model.Repositories
import com.example.desafio_android.model.Repository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RepositoriesViewModel: ViewModel() {
    private val clientRepository by lazy { InitRetrofit.init() }
    private val _hasError = MutableLiveData<Boolean>()
    val  hasError: LiveData<Boolean> get() = _hasError

    private val _allRepositories: MutableLiveData<List<Repository>> = MutableLiveData()
    // private val _allRepositories: MutableLiveData<List<Repository>>() = MutableLiveData() <= esta genera error
    val  allRepositories: LiveData<List<Repository>> get() = _allRepositories


    fun getPaginatedRepositories(page: Int) {
        clientRepository.reposList(page).enqueue(object : Callback<Repositories> {
            override fun onResponse(call: Call<Repositories>, response: Response<Repositories>) {
                if (response.isSuccessful) {
                    _hasError.value = false
                    // Manejo de null
                    response.body()?.let {
                        _allRepositories.postValue(it.items)
                    }
                }
            }

            override fun onFailure(call: Call<Repositories>, t: Throwable) {
                Log.d("Error", t.message.toString())
                _hasError.value = true
            }
        })
    }
}
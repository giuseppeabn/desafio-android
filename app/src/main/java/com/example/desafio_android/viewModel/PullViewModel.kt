package com.example.desafio_android.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.desafio_android.api.InitRetrofit
import com.example.desafio_android.model.PullRequest
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PullViewModel : ViewModel() {

    private val _hasError = MutableLiveData<Boolean>()
    val  hasError: LiveData<Boolean> get() = _hasError

    private val _allPullRequest: MutableLiveData<List<PullRequest>> = MutableLiveData()
    val  allPullRequest: LiveData<List<PullRequest>> get() = _allPullRequest

    fun getPullRequests(owner: String, repositorio: String) {
        val clientPull by lazy { InitRetrofit.init() }
        val call = clientPull.getPullRequests(owner, repositorio)
        call.enqueue(object : Callback<List<PullRequest>> {

            override fun onResponse(
                call: Call<List<PullRequest>>,
                response: Response<List<PullRequest>>
            ) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        _allPullRequest.postValue(it)
                    }
                }
            }

            override fun onFailure(call: Call<List<PullRequest>>, t: Throwable) {
                Log.d("Error getPullRequests", t.message.toString())
                _hasError.value = true

            }

        })
    }
}
package com.lambdaschool.congressdata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log

import com.lambdaschool.congressdataapiaccess.CongressDao

object ProfileRepository {
    fun getProfile(id: String?): LiveData<CongresspersonProfile> {
        Log.i("Repository", "Retreiving Data")
        val profileLiveData = MutableLiveData<CongresspersonProfile>()

        id?.let {
            val profile = CongresspersonProfile(CongressDao.getMemberDetails(id))
            profileLiveData.value = profile
        }
        return profileLiveData
    }
}

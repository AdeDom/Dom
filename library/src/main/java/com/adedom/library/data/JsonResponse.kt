package com.adedom.library.data

import com.google.gson.annotations.SerializedName

data class JsonResponse(@SerializedName(KEY_RESULT) val result: String? = null)
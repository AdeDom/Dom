package com.adedom.library.data

import com.adedom.library.util.KEY_RESULT
import com.google.gson.annotations.SerializedName

data class JsonResponse(@SerializedName(KEY_RESULT) val result: String? = null)
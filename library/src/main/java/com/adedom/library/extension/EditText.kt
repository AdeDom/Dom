package com.adedom.library.extension

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

//if (mEtName.isEmpty(getString(R.string.error_room_name))) return
fun EditText.isEmpty(error: String): Boolean {
    if (this.text.toString().trim().isEmpty()) {
        this.requestFocus()
        this.error = error
        return true
    }
    return false
}

//mEtPassword.isLength(4, "error") -> return
fun EditText.isLength(length: Int, error: String = ""): Boolean {
    if (this.text.toString().trim().length < length) {
        this.requestFocus()
        this.error = error
        return true
    }
    return false
}

//mEtUsername.getContent()
fun EditText.getContent(): String = this.text.toString().trim()

//etSearch.textChanged { fetchPlayers(it) }
fun EditText.textChanged(afterTextChanged: (String) -> Unit) {
    this.addTextChangedListener(object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {}
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(editable: CharSequence?, p1: Int, p2: Int, p3: Int) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}

//mEtPassword.failed(getString(R.string.username_password_incorrect))
fun EditText.failed(message: String = "") {
    this.apply {
        requestFocus()
        error = message
    }
}

//mEtNewPassword.isMatching(
//    mEtRePassword,
//    getString("error")
//) -> return
fun EditText.isMatching(editText: EditText, error: String = ""): Boolean {
    if (this.getContent() != editText.getContent()) {
        editText.requestFocus()
        editText.error = error
        return true
    }
    return false
}

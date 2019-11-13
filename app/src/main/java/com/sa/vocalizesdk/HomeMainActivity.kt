package com.sa.vocalizesdk

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sdk.vocalize.Vocalize
import com.sdk.vocalize.VocalizeListener

class HomeMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        Vocalize.initialize(this@HomeMainActivity)

        // Get the action and data from the intent to handle it.
        val action: String? = intent?.action
        when (action) {
            // When the action is triggered by a deep-link, Intent.Action_VIEW will be used
            Intent.ACTION_VIEW -> callMethod(intent)

            // Otherwise start the app as you would normally do.
            else -> {

            }
        }
    }

    private fun callMethod(intent: Intent?) {
        Vocalize.searchKeyword(intent?.data, object : VocalizeListener {

            override fun onSuccess() {

            }

            override fun onError(error: String) {

            }
        })
    }
}

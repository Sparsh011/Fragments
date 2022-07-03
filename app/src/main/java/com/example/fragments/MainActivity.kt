package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        val fragment1: Button = findViewById(R.id.btnFragment1)
        val fragment2: Button = findViewById(R.id.btnFragment2)

//       NOTE - For a fragment to transition through the rest of its lifecycle, it must be added to a FragmentManager. The        FragmentManager is responsible for determining what state its fragment should be in and then moving them into that state.

//        NOTE - We want to replace our frame layout's content with either firstFragment or secondFragment. Doing so by -

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutFragment, firstFragment) // Replacing the frame layout with fragment initially so that when the app runs for the first time, firstFragment is what is seen first.
            commit() // committing the change that took place above.
        }

//        NOTE - Calling commit() doesn't perform the transaction immediately. Rather, the transaction is scheduled to run on the main UI thread as soon as it is able to do so. If necessary, however, you can call commitNow() to run the fragment transaction on your UI thread immediately.

        fragment1.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutFragment, firstFragment)
                addToBackStack(null) // If we press the back button (after changing the fragments several times), then it won't
                // close the app. If this line wasn't written, then our app would be closed. Now we will be taken to the
                // previous fragment.
                commit() // committing the change that took place above.
            }
        }
        fragment2.setOnClickListener{
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frameLayoutFragment, secondFragment)
                addToBackStack(null) // If we press the back button (after changing the fragments several times), then it won't
                // close the app. If this line wasn't written, then our app would be closed. Now we will be taken to the
                // previous fragment.
                commit() // committing the change that took place above.
            }
        }

    }
}
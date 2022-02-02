package com.simplelotto.myapplication

import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this) {}


        val adRequest = AdRequest.Builder().build()
        banner.loadAd(adRequest)
        banner.setAdListener(object : AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdFailedToLoad(adError: LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }
        })



        var lottryNumbers = arrayListOf(number1,number2,number3,number4,number5,number6)

        var CountDownTimer = object : CountDownTimer(3000,100 ) {
            override fun onFinish() {
            }

            override fun onTick(p0: Long) {
                lottryNumbers.forEach {
                    var randomNumber = (Math.random() * 45 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
        }



        lottery_button.setOnClickListener{
            if(lottery_button.isAnimating) {
                lottery_button.cancelAnimation()
                CountDownTimer.cancel()
            }else{
                lottery_button.playAnimation()
                CountDownTimer.start()
            }


        }
    }
}

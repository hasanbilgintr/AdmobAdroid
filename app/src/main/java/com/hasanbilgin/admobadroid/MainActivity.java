package com.hasanbilgin.admobadroid;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;

public class MainActivity extends AppCompatActivity {
    //eklendi
    private AdView mAdView;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*

        https://developers.google.com/admob/android/quick-start giderek
        -firebase admob larıda var ayriyetten benzer
        -sitede yazdığı üzere 3.2 android sürümü ve üssü olmalı
        -minsdk 19 ve üssü olucak
        -compilesdk 28 ve üssü olucak
        -admob hesabı açıcaz ve uygulamayı oraya kayıt etme
        -hem adsense ve geliştirici hesabı aynı mail üzerinde açılması tavsiye edilir
        -admob hesabına kaydolun için tıkladık
        -gmail girişi yapılır .ve kabul edip devam ediyoruz
        -dashboradttan sol üstte uygulamalar tarafına geldik
        --uygulama ekle diyoruz -> uygulama yayınlandıysa ona göre seçim yaıyoruz -> android seçtik -> user Matrics seçtik uygulamaverileri anliz tarzında devam .
        -sonra uygulama ca-app...... app id buluyoruz  kopyalıyoruz
        -buildgragle project gerekliler eklendi
        -buildgragle app/module gerekliler eklendi
        */
        //app admob id
        //"@string/com.google.android.gms.ads.APPLICATION_ID"

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        //reklamlar Banner,Interstital, Rewarded Interstitia ,Rewarded,Native advanced,App Open
        //banner (Afiş)-> Uygulama düzeninin bir kısmını kaplayan dikdörtgen reklamlardır. Bu reklamlar, belirli bir süre sonra otomatik olarak yenilenebilir. //dikdörtgen şeklinde ekran e altında yada en üstünde çıkan reklamladır.en çok kullanılandır
        //Interstital (geçiş)-> Seviye atlama gibi doğal bekleme ve geçiş anlarında gösterilen tam sayfa reklam biçimi. //tüm ekranı kaplayan reklamlardır. bir ekrandan ekrana geçerken bir üst seviyeye geçerken genelde çıkar
        //Rewarded Interstitial(Beta) (Ödüllü geçiş reklamı) ->BETADoğal bekleme veya geçiş anlarında reklam görüntüledikleri için kullanıcıları ödüllendiren tam sayfa reklam biçimi.
        //Rewarded (Ödüllü)- > Bir reklamı görüntülemeyi tercih eden kullanıcıları ödüllendiren tam sayfa reklam biçimi. Ödüllü geçiş reklamlarının aksine kullanıcılar reklamı görüntülemeyi tercih etmelidir.
        //Native/lokal advanced(yerel gelişmiş)-> Uygulamanızın görünümü ve genel havasıyla eşleşecek şekilde özelleştirilebilen reklam biçimidir. Bu reklamlar, uygulama içeriğinde satır içinde gösterilir.
        //App Open (Uygulama açıkken) -> Kullanıcılar uygulamanızı açtığında veya uygulamanıza döndüğünde görünen reklam biçimi. Reklam, yükleme ekranının üzerinde çıkar.



        /*
        -dashboradttan uygulamalar ve tüm uygulamalr seçilir ve reklam verilcek uygulama seçilir üste reklam birimi ekleyin yazar tıklanır
        -banner seçilir. ve her reklam id si bulunur amaç her ekrana ayrı ayrı getirmesi için ama aynı reklamı 5 6 ekrana getirilebilir ama tavsiye ayrı ayrıdır, isim verilir reklam birimi oluştur tıklanır
        -açılan ekranda üstteki app id yani manifeste yazdırdığımız iddir. alttaki ise banner id yani reklam idsidir
        //Banner ad id
        // @String/Banner_id
        -not alıp tamamlandı tıklıyoruz. ad id oluşturuluyor
         */


        /*
        TEST
        App Open test id
        ca-app-pub-3940256099942544/3419835294
        Adaptive Banner test id
        ca-app-pub-3940256099942544/9214589741
        Banner test id
        ca-app-pub-3940256099942544/6300978111
        Interstitial test id
        ca-app-pub-3940256099942544/1033173712
        Interstitial Video test id
        ca-app-pub-3940256099942544/8691691433
        Rewarded test id
        ca-app-pub-3940256099942544/5224354917
        Rewarded Interstitial test id
        ca-app-pub-3940256099942544/5354046379
        Native Advanced test id
        ca-app-pub-3940256099942544/2247696110
        Native Advanced Video test id
        ca-app-pub-3940256099942544/1044960115
         */
        //eklendi
        //reklamlar gerçek telefonda çalışıyor
        //banner
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                System.out.println("onAdClicked");
            }
            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                //reklam kapandığında
                System.out.println("onAdClosed");
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.
                //reklam yüklenemezse
                System.out.println("onAdFailedToLoad");
            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
                System.out.println("onAdImpression");
            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                //reklam yüklendiğinde
                System.out.println("onAdLoaded");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                //reklam açıldığında
                System.out.println("onAdOpened");
            }
        });


        //interstitial
        //admob tan reklam bildirimi açtırmak lazım
        //yukardaki gibi interstitial açılır id alınır
        // @String/interstitial_id
        //geri gelip tekrar çalıştırıldığında çalışmaz zaten önerilmiyorda
        AdRequest adRequest2 = new AdRequest.Builder().build();
        InterstitialAd.load(this, "ca-app-pub-3940256099942544/1033173712", adRequest2,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;
                        //Log.i(TAG, "onAdLoaded");
                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        //Log.d(TAG, loadAdError.toString());
                        mInterstitialAd = null;
                    }
                });

    }

    public void button2OnClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);

        if (mInterstitialAd != null) {
            mInterstitialAd.show(MainActivity.this);
        }

        mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback(){
            @Override
            public void onAdClicked() {
                // Called when a click is recorded for an ad.
                //Log.d(TAG, "Ad was clicked.");
                System.out.println("mInterstitialAd Ad was clicked.");
            }

            @Override
            public void onAdDismissedFullScreenContent() {
                // Called when ad is dismissed.
                // Set the ad reference to null so you don't show the ad a second time.
                //Log.d(TAG, "Ad dismissed fullscreen content.");
                System.out.println("mInterstitialAd Ad dismissed fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdFailedToShowFullScreenContent(AdError adError) {
                // Called when ad fails to show.
                //Log.e(TAG, "Ad failed to show fullscreen content.");
                System.out.println("mInterstitialAd Ad failed to show fullscreen content.");
                mInterstitialAd = null;
            }

            @Override
            public void onAdImpression() {
                // Called when an impression is recorded for an ad.
                //Log.d(TAG, "Ad recorded an impression.");
                System.out.println("mInterstitialAd Ad recorded an impression.");
            }

            @Override
            public void onAdShowedFullScreenContent() {
                // Called when ad is shown.
                //Log.d(TAG, "Ad showed fullscreen content.");
                System.out.println("mInterstitialAd Ad showed fullscreen content.");

            }
        });


    }
}
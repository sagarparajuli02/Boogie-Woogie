package com.sagar.boogiewoogienepal;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class Contestant extends AppCompatActivity {
    Toolbar toolbar;
    private InterstitialAd interstitial;
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contestant);
        AdRequest adRequest = new AdRequest.Builder().build();


// Prepare the Interstitial Ad
        interstitial = new InterstitialAd(Contestant.this);
// Insert the Ad Unit ID
        interstitial.setAdUnitId(getString(R.string.admob_interstitial_id));

        interstitial.loadAd(adRequest);
// Prepare an Interstitial Ad Listener
        interstitial.setAdListener(new AdListener() {
            public void onAdLoaded() {
                // Call displayInterstitial() function
                displayInterstitial();
            }
        });
       toolbar= (Toolbar)findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tabLayout);
        viewPager=(ViewPager )findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new FirstContestant(),"Aatish Jairu " );
        viewPagerAdapter.addFragments(new SecondContestant(),"Kabita Nepali " );
        viewPagerAdapter.addFragments(new ThirdConstestant(),"Malin Tamang " );
        viewPagerAdapter.addFragments(new FourthConstestant(),"Pragati Pun " );
        viewPagerAdapter.addFragments(new FifthConstestant(),"Pratisha Poudel " );
        viewPagerAdapter.addFragments(new SixthConstestant(),"Rabin Bhujel " );
        viewPagerAdapter.addFragments(new SeventhConstestant(),"Sagar magar " );
        viewPagerAdapter.addFragments(new EighthConstestant(),"Saroj Moktan " );
        viewPagerAdapter.addFragments(new NinthConstestant(),"Shristhi Maharjan " );
        viewPagerAdapter.addFragments(new TenthContestant(),"Shubham Bhujel " );
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void displayInterstitial() {
        if (interstitial.isLoaded()) {
            interstitial.show();
        }
    }
}

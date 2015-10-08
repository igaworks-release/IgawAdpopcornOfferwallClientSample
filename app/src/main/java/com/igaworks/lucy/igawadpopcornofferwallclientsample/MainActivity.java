package com.igaworks.lucy.igawadpopcornofferwallclientsample;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.igaworks.IgawCommon;
import com.igaworks.adpopcorn.IgawAdpopcorn;
import com.igaworks.adpopcorn.IgawAdpopcornExtension;
import com.igaworks.adpopcorn.interfaces.IAdPOPcornEventListener;
import com.igaworks.interfaces.IgawRewardItem;
import com.igaworks.interfaces.IgawRewardItemEventListener;


public class MainActivity extends ActionBarActivity {

    // Igaworks Common
    String tag = "Igaw";

    // Igaworks Adpopcorn Offerwall
    String usn;
    String encryptUsn;

    // Igaworks Adpopcorn Offerwall Optional
//    int RED_THEME = 0xff9d261c;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Your Code
        TelephonyManager manager =  (TelephonyManager)getSystemService(MainActivity.this.TELEPHONY_SERVICE);
        usn = manager.getDeviceId().toString();
        usn = usn+"a";
        encryptUsn = Base64.encodeToString(usn.getBytes(), 0);


        // Igaworks Common
        IgawCommon.startApplication(MainActivity.this);
        Log.d(tag, "startApplication ::: MainActivity");

        // Igaworks Adpopcorn Offerwall
        IgawCommon.setUserId(encryptUsn);
        Log.d(tag, "setUserId ::: " + encryptUsn);

        // Igaworks Adpopcorn Offerwall Client
        IgawCommon.setClientRewardEventListener(new IgawRewardItemEventListener() {
            @Override
            public void onGetRewardInfo(boolean isSuccese, String resultMessage, IgawRewardItem[] rewardItems) {
                Log.d(tag, "setClientRewardEventListener ::: onGetRewardInfo");

                if (isSuccese){
                    for (IgawRewardItem rewardItem : rewardItems){
                        Log.d(tag, "onGetRewardInfo.resultMessage ::: " + resultMessage);
                        Log.d(tag, "onGetRewardInfo.rewardItems.getCampaignKey ::: " + rewardItem.getCampaignKey());
                        Log.d(tag, "onGetRewardInfo.rewardItems.getCampaignTitle ::: " + rewardItem.getCampaignTitle());
                        Log.d(tag, "onGetRewardInfo.rewardItems.getRTID ::: " + rewardItem.getRTID());
                        Log.d(tag, "onGetRewardInfo.rewardItems.getRewardQuantity ::: " + rewardItem.getRewardQuantity());

                        /*
                         * Your Code
                         */

                        // Igaworks Adpopcorn Offerwall Client
                        rewardItem.didGiveRewardItem();
                        Log.d(tag, "onGetRewardInfo ::: didGiveRewardItem");
                    }
                }

            }

            @Override
            public void onDidGiveRewardItemResult(boolean isSuccess, String resultMsg, int resultCode, String completedRewardKey) {
                Log.d(tag, "setClientRewardEventListener ::: onDidGiveRewardItemResult");

                if (isSuccess){
                    Log.d(tag, "onDidGiveRewardItemResult.resultMsg ::: "+ resultMsg);
                    Log.d(tag, "onDidGiveRewardItemResult.resultCode ::: "+ resultCode);
                    Log.d(tag, "onDidGiveRewardItemResult.completedRewardKey ::: "+ completedRewardKey);

                    /*
                     * Your Code
                     */

                }

            }
        });

        // Igaworks Adpopcorn Offerwall Optional
        IgawAdpopcorn.setEventListener(MainActivity.this, new IAdPOPcornEventListener() {
            @Override
            public void OnClosedOfferWallPage() {
                Log.d(tag, "setEventListener ::: OnClosedOfferWallPage");

                // Igaworks Adpopcorn Offerwall Client
                IgawAdpopcornExtension.getClientPendingRewardItems(MainActivity.this);
                Log.d(tag, "OnClosedOfferWallPage ::: getClientPendingRewardItems");
            }
        });

        /*
         * Your Code
         */

        // Igaworks Adpopcorn Offerwall Optional
//        ApStyleManager.setThemeColor(RED_THEME);
//        ApStyleManager.setTextThemeColor(RED_THEME);
//        ApStyleManager.setRewardThemeColor(RED_THEME);
//        ApStyleManager.setRewardCheckThemeColor(RED_THEME);
//        ApStyleManager.setOfferwallTitle("Get Reward");
//        ApStyleManager.setOfferwallTitleColor(ApStyleManager.BLUE_THEME);


    }

      /*
       * Your Code
       */

    // Your Code
    public void openOfferWall(View view){
        Log.d(tag, "openOfferWall ::: Button Click");

        // Igaworks Adpopcorn Offerwall
        IgawAdpopcorn.openOfferWall(MainActivity.this);
        Log.d(tag, "openOfferWall");

        // Igaworks Adpopcorn Offerwall Optional
        IgawAdpopcorn.setSensorLandscapeEnable(MainActivity.this, true);
        Log.d(tag, "setSensorLandscapeEnable");

    }


    @Override
    protected void onResume() {
        super.onResume();

        // Igaworks Common
        IgawCommon.startSession(MainActivity.this);
        Log.d(tag, "startSession ::: MainActivity" );

        /*
         * Your Code
         */
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Igaworks Common
        IgawCommon.endSession();
        Log.d(tag, "endSession ::: MainActivity");

        /*
         * Your Code
         */
    }

}


package com.sagar.boogiewoogienepal;


import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class Home extends Fragment{
        Button btn;
        ProgressDialog pd;

        Context context;
        String SENT= "SMS_SENT";
        PendingIntent sentPI;
        BroadcastReceiver smsSENTReceiver;

        int MY_PERMISSIONS_REQUEST_SEND_SMS = 1;
        MaterialBetterSpinner spinner;
        customAdapterSpinner adapterSpinner;
        String[] names= {"Aatish jairu","Kabita Nepali","Malin Tamang","Pragati Pun","Pratisha Poudel","Rabin Bhujel","Sagar Magar","Saroj Moktan","Shristhi Maharjan","Shubham Bhujel"};
    public Home() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            getActivity().setTitle(R.string.app_name);

            return inflater.inflate(R.layout.fragment_home, container, false);
        }

        @Override
        public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);
            spinner= (MaterialBetterSpinner)view.findViewById(R.id.spinner);
            adapterSpinner = new customAdapterSpinner(getActivity(),names);
            spinner.setAdapter(adapterSpinner);
            btn = (Button) view.findViewById(R.id.button) ;



            sentPI= PendingIntent.getBroadcast(getContext(),0,new Intent(SENT),0);


            btn.setOnClickListener(new View.OnClickListener() {


                @Override
                public void onClick(View v) {

                   String name= spinner.getText().toString();
                   // String numbr=Integer.toString(number);
                    String numbr="35225";

                    if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(getActivity(),new String[]{Manifest.permission.SEND_SMS},
                                MY_PERMISSIONS_REQUEST_SEND_SMS);

                    }
                    else{
                        SmsManager sms= SmsManager.getDefault();
                        switch (name){

                            case "Aatish jairu":
                                String aatish= "01";
                                sms.sendTextMessage(numbr,null,aatish,sentPI,null);
                                SendMsg();
                                break;
                            case "Kabita Nepali":
                                String   ocean= "02";
                                sms.sendTextMessage(numbr,null,ocean,sentPI,null);
                                SendMsg();
                                break;
                            case "Malin Tamang":
                                String   malin= "03";
                                sms.sendTextMessage(numbr,null,malin,sentPI,null);
                                SendMsg();
                                break;
                            case "Pragati Pun":
                                String   pragati= "04";
                                sms.sendTextMessage(numbr,null,pragati,sentPI,null);
                                SendMsg();
                                break;
                            case "Pratisha Poudel":
                                String   pratisha= "05";
                                sms.sendTextMessage(numbr,null,pratisha,sentPI,null);
                                SendMsg();
                                break;
                            case "Rabin Bhujel":
                                String   rabin= "06";
                                sms.sendTextMessage(numbr,null,rabin,sentPI,null);
                                SendMsg();
                                break;
                            case "Sagar Magar":
                                String   sagar= "07";
                                sms.sendTextMessage(numbr,null,sagar,sentPI,null);
                                SendMsg();
                                break;
                            case "Saroj Moktan":
                                String   saroj= "08";
                                sms.sendTextMessage(numbr,null,saroj,sentPI,null);
                                SendMsg();
                                break;
                            case "Shristhi Maharjan":
                                String   shristhi= "09";
                                sms.sendTextMessage(numbr,null,shristhi,sentPI,null);
                                SendMsg();
                                break;
                            case "Shubham Bhujel":
                                String   shubham= "10";
                                sms.sendTextMessage(numbr,null,shubham,sentPI,null);
                                SendMsg();
                                break;
                            default:
                                Toast.makeText(getActivity(), "Please select one", Toast.LENGTH_LONG).show();
                        }

                    }


                }
                public void SendMsg(){
                    final ProgressDialog pd = new ProgressDialog(getActivity());
                    pd.setTitle("Sending Vote");
                    pd.setMessage("Please wait.....");
                    pd.setCancelable(false);
                    pd.show();
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            pd.dismiss();
                        }
                    },2000);


                }



            });

        }

    @Override
    public void onResume() {
        super.onResume();

        smsSENTReceiver= new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {

                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        Toast.makeText(context, "Your Vote is Sent successfully", Toast.LENGTH_LONG).show();
                        break;
                    case  SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                    Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                    break;
                    case  SmsManager.RESULT_ERROR_NO_SERVICE:
                        Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                        break;
                    case  SmsManager.RESULT_ERROR_NULL_PDU:
                        Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                        break;
                    case  SmsManager.RESULT_ERROR_RADIO_OFF:
                        Toast.makeText(context, "error", Toast.LENGTH_LONG).show();
                        break;
                }

            }
        };

        getContext().getApplicationContext().registerReceiver(smsSENTReceiver, new IntentFilter(SENT));
       // regist
    }
}

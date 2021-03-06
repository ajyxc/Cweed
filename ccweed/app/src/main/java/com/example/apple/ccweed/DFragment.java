package com.example.apple.ccweed;
/**
 * Created by caitlincoyiuto on 2017-09-23.
 */
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

//Dialog dialog=new Dialog(this,android.R.style.Theme_Black_NoTitleBar_Fullscreen)

public class DFragment extends DialogFragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.my_dialog, null);

        view.findViewById(R.id.lin1).setOnClickListener(mListener);
        view.findViewById(R.id.lin2).setOnClickListener(mListener);
        view.findViewById(R.id.lin3).setOnClickListener(mListener);

        //view.findViewById(R.id.button3).setOnClickListener(mListener);

//        LinearLayout lin1Block = (LinearLayout) view.findViewById(R.id.lin1);
//
//        lin1Block.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), TextDirection.class);
//                DFragment.this.startActivity(intent);
//            }
//        });
//
//        LinearLayout lin2Block = (LinearLayout) view.findViewById(R.id.lin2);
//        lin2Block.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), TextDirection2.class);
//                DFragment.this.startActivity(intent);
//            }
//        });

        return view;
    }

    private final View.OnClickListener mListener = new View.OnClickListener() {
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.lin1:
                    Intent intent1 = new Intent(getActivity(), TextDirection.class);
                    DFragment.this.startActivity(intent1);
                    break;
                case R.id.lin2:
                    Intent intent2 = new Intent(getActivity(), TextDirection.class);
                    DFragment.this.startActivity(intent2);
                    break;
                case R.id.lin3:
                    Intent intent3 = new Intent(getActivity(), TextDirection.class);
                    DFragment.this.startActivity(intent3);
                    break;
            }
        }
    };


    @Override
    public void onStart()
    {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null)
        {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.money:
                if (checked)
                    //Order by money
                    break;
            case R.id.time:
                if (checked)
                    //Order by time
                    break;
            case R.id.distance:
                if (checked)
                    //Order by distance
                    break;
        }
    }


    public void onButtonClick(View v){
        if(v.getId() == R.id.lin1)
        {Intent i = new Intent(getActivity(), TextDirection.class);
            startActivity(i);
        }}

}

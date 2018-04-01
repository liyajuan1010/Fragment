package com.example.administrator.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.administrator.myapplication.Fragment.OneFragment;
import com.example.administrator.myapplication.Fragment.ThreeFragment;
import com.example.administrator.myapplication.Fragment.TwoFragment;


public class DynamicActivity extends AppCompatActivity implements View.OnClickListener,CallBackValue {
    private Button btnOne,btnTwo,btnThree;
    private Fragment oneFragment,twoFragment,threeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic);
        btnOne=(Button)findViewById(R.id.btn_one);
        btnTwo=(Button)findViewById(R.id.btn_two);
        btnThree=(Button)findViewById(R.id.btn_three);

        btnOne.setOnClickListener(this);
        btnTwo.setOnClickListener(this);
        btnThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.btn_one:
                if (oneFragment==null){
                    oneFragment=new OneFragment();
                }
                fragmentTransaction.replace(R.id.container,oneFragment);
                break;
            case R.id.btn_two:
                if (twoFragment==null){
                    twoFragment=new TwoFragment();
                }
                fragmentTransaction.replace(R.id.container,twoFragment);
                break;
            case R.id.btn_three:
                if (threeFragment==null){
                    threeFragment=new ThreeFragment();
                }
                Bundle bundle=new Bundle();
                bundle.putString("key","Activity-->Fragment");
                threeFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.container,threeFragment);
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void sendValue(String str) {
        Toast.makeText(this,str,Toast.LENGTH_LONG).show();
    }
}

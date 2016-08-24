package com.github.stkent.fragmentanimationbugrepro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.github.stkent.fragmentanimationbugrepro.FragmentOne.OnFragmentOneClickListener;
import com.github.stkent.fragmentanimationbugrepro.FragmentTwo.OnFragmentTwoClickListener;

public class MainActivity extends AppCompatActivity implements OnFragmentOneClickListener, OnFragmentTwoClickListener {

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(0, 0)
                    .replace(R.id.fragment_container, new FragmentOne())
                    .commit();
        }
    }

    @Override
    public void onFragmentOneClick() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in_right, R.anim.no_op)
                .replace(R.id.fragment_container, new FragmentTwo())
                .commit();
    }

    @Override
    public void onFragmentTwoClick() {
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.no_op, R.anim.fade_out_right)
                .replace(R.id.fragment_container, new FragmentOne())
                .commit();
    }

}

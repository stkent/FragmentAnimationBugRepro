package com.github.stkent.fragmentanimationbugrepro;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentTwo extends Fragment {

    private OnFragmentTwoClickListener listener;

    @Override
    public void onAttach(final Context context) {
        super.onAttach(context);

        listener = (OnFragmentTwoClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(
            final LayoutInflater inflater,
            @Nullable final ViewGroup container,
            @Nullable final Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_two, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable final Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        view.findViewById(R.id.button_return_to_fragment_one).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                listener.onFragmentTwoClick();
            }
        });
    }

    public interface OnFragmentTwoClickListener {

        void onFragmentTwoClick();

    }

}

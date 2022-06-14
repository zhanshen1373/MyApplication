package com.panpass.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.panpass.myapplication.activity.RecyclerViewActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BlankFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BlankFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Button button;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BlankFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlankFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BlankFragment newInstance(String param1, String param2) {
        BlankFragment fragment = new BlankFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.e("www","onattach");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.e("www","oncreate");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.e("www","oncreateview");
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);
        Log.e("www",inflate.getClass().getSimpleName()+"---class");
        button = inflate.findViewById(R.id.button);

        button.setOnClickListener(v->
//                startActivityForResult(new Intent(this.getActivity(), RecyclerViewActivity.class),100)
                getActivity().findViewById(R.id.mmmmm).setVisibility(View.VISIBLE)
        );
        return inflate;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.e("www","onactivitycreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("www","onstart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("www","onresume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("www","onpause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("www","onstop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("www","ondestroyview");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("www","ondestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("www","ondetach");
    }

}
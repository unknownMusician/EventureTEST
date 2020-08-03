package com.example.soundofanimals;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.Objects;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnimalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnimalFragment extends Fragment {

    private static final String TAG = "";
    private ImageView dog, monkey;
    private MediaPlayer mp;
    Random random;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AnimalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnimalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnimalFragment newInstance(String param1, String param2) {
        AnimalFragment fragment = new AnimalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        random = new Random();

        try {
            monkey = Objects.requireNonNull(getView()).findViewById(R.id.monkey);
            dog = Objects.requireNonNull(getView()).findViewById(R.id.dog);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

        dog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dog.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.up_down_anim));
                MediaPlayer.create(getContext(), R.raw.dog).start();
            }
        });
        monkey.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                monkey.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.bounce_anim));
                int randomSound = random.nextInt(3);
                Log.d(TAG, "onClick: " + randomSound);

                switch (randomSound) {
                    case 0:
                        mp = MediaPlayer.create(getContext(), R.raw.monkey0);
                        break;
                    case 1:
                        mp = MediaPlayer.create(getContext(), R.raw.monkey1);
                        break;
                    case 2:
                        mp = MediaPlayer.create(getContext(), R.raw.monkey2);
                        break;
                }
                mp.start();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_animal, container, false);
    }
}
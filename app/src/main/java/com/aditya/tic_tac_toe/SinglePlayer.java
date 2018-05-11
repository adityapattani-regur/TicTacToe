package com.aditya.tic_tac_toe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class SinglePlayer extends Fragment {

    EditText playerName;
    Button startGame;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_singleplayer, container, false);
        playerName = view.findViewById(R.id.edt_single_name);
        startGame = view.findViewById(R.id.btn_single_begin);

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = playerName.getText().toString().trim();
                if(name.length() == 0) {
                    playerName.setError("Please provide a name");
                } else if (name.toLowerCase().equals("cpu")) {
                    playerName.setError("You cannot use this name");
                } else {
                    Intent intent = new Intent(getActivity(), GameActivity.class);
                    intent.putExtra("player1", name);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}

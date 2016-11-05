package com.tolgaduran.android.anket;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivityFragment extends Fragment {
    private RadioGroup group1;
    private boolean isGroup1Scored;
    private RadioGroup group2;
    private boolean isGroup2Scored;
    private RadioGroup group3;
    private boolean isGroup3Scored;
    private RadioGroup group4;
    private boolean isGroup4Scored;
    private RadioGroup group5;
    private boolean isGroup5Scored;
    private RadioGroup group6;
    private boolean isGroup6Scored;
    private RadioGroup group7;
    private boolean isGroup7Scored;
    private RadioGroup group8;
    private boolean isGroup8Scored;
    private RadioGroup group9;
    private boolean isGroup9Scored;
    private RadioGroup group10;
    private boolean isGroup10Scored;

    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4;
    private boolean checked11;

    private EditText editText;
    private boolean editTextScored;

    private Button resultBtn;
    private CheckBox answerBtn;

    int score;

    Context context;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_main_activity, container, false);

        initViews(rootView);
        initListeners();

        resultBtn.setEnabled(false);
        resultBtn.setVisibility(View.INVISIBLE);

        CompoundButton.OnCheckedChangeListener checker = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton cb, boolean b) {
                if (answerBtn.isChecked()) {
                    resultBtn.setEnabled(true);
                    resultBtn.setVisibility(View.VISIBLE);
                } else {
                    resultBtn.setEnabled(false);
                    resultBtn.setVisibility(View.INVISIBLE);
                }
            }
        };

        answerBtn.setOnCheckedChangeListener(checker);

        resultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        edittextQuestions();
                        onCheckedQuestion11();

                        if (score == 0) {
                            Toast.makeText(context, "You didn't know any question right!!!\nPlease try again!!!", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(context, "Score : " + score, Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
        return rootView;
    }

    private void initViews(View view) {
        score = 0;
        context = view.getContext();

        group1 = (RadioGroup) view.findViewById(R.id.q1_main);
        group2 = (RadioGroup) view.findViewById(R.id.q2_main);
        group3 = (RadioGroup) view.findViewById(R.id.q3_main);
        group4 = (RadioGroup) view.findViewById(R.id.q4_main);
        group5 = (RadioGroup) view.findViewById(R.id.q5_main);
        group6 = (RadioGroup) view.findViewById(R.id.q6_main);
        group7 = (RadioGroup) view.findViewById(R.id.q7_main);
        group8 = (RadioGroup) view.findViewById(R.id.q8_main);
        group9 = (RadioGroup) view.findViewById(R.id.q9_main);
        group10 = (RadioGroup) view.findViewById(R.id.q10_main);

        isGroup1Scored = false;
        isGroup2Scored = false;
        isGroup3Scored = false;
        isGroup4Scored = false;
        isGroup5Scored = false;
        isGroup6Scored = false;
        isGroup7Scored = false;
        isGroup8Scored = false;
        isGroup9Scored = false;
        isGroup10Scored = false;

        resultBtn = (Button) view.findViewById(R.id.resultBtn);

        editText = (EditText) view.findViewById(R.id.q11_answer);
        editTextScored = false;

        checked11 = false;
        checkBox1 = (CheckBox) view.findViewById(R.id.turkish);
        checkBox2 = (CheckBox) view.findViewById(R.id.kurdish);
        checkBox3 = (CheckBox) view.findViewById(R.id.laz);
        checkBox4 = (CheckBox) view.findViewById(R.id.hebrew);

        answerBtn = (CheckBox) view.findViewById(R.id.acceptAnswer);
    }

    private void initListeners() {
        group1.setOnCheckedChangeListener(groupButtonListener);
        group2.setOnCheckedChangeListener(groupButtonListener);
        group3.setOnCheckedChangeListener(groupButtonListener);
        group4.setOnCheckedChangeListener(groupButtonListener);
        group5.setOnCheckedChangeListener(groupButtonListener);
        group6.setOnCheckedChangeListener(groupButtonListener);
        group7.setOnCheckedChangeListener(groupButtonListener);
        group8.setOnCheckedChangeListener(groupButtonListener);
        group9.setOnCheckedChangeListener(groupButtonListener);
        group10.setOnCheckedChangeListener(groupButtonListener);
    }

    private void edittextQuestions() {
        String editTextQ = editText.getText().toString().toLowerCase().trim();

        if (!editTextScored) {
            if (editTextQ != null && !editTextQ.equals("")) {
                String answer = getResources().getString(R.string.q11_answer).toLowerCase().trim();
                if (editTextQ.equalsIgnoreCase(answer)) {
                    score++;
                    editTextScored = true;
                }
            }
        }
    }

    public void onCheckedQuestion11() {
        if (!checkBox1.isChecked() && !checkBox2.isChecked() && !checkBox3.isChecked() && checkBox4.isChecked() && !checked11) {
            score++;
            checked11 = true;
        }
    }

    private RadioGroup.OnCheckedChangeListener groupButtonListener = new RadioGroup.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            switch (i) {
                case R.id.q1_2:
                    if (!isGroup1Scored) {
                        score++;
                        isGroup1Scored = true;
                    } else {
                        isGroup1Scored = false;
                    }
                    break;
                case R.id.q2_3:
                    if (!isGroup2Scored) {
                        score++;
                        isGroup2Scored = true;
                    } else {
                        isGroup2Scored = false;
                    }
                    break;
                case R.id.q3_2:
                    if (!isGroup3Scored) {
                        score++;
                        isGroup3Scored = true;
                    } else {
                        isGroup3Scored = false;
                    }
                    break;
                case R.id.q4_4:
                    if (!isGroup4Scored) {
                        score++;
                        isGroup4Scored = true;
                    } else {
                        isGroup4Scored = false;
                    }
                    break;
                case R.id.q5_3:
                    if (!isGroup5Scored) {
                        score++;
                        isGroup5Scored = true;
                    } else {
                        isGroup5Scored = false;
                    }
                    break;
                case R.id.q6_2:
                    if (!isGroup6Scored) {
                        score++;
                        isGroup6Scored = true;
                    } else {
                        isGroup6Scored = false;
                    }
                    break;
                case R.id.q7_1:
                    if (!isGroup7Scored) {
                        score++;
                        isGroup7Scored = true;
                    } else {
                        isGroup7Scored = false;
                    }
                    break;
                case R.id.q8_3:
                    if (!isGroup8Scored) {
                        score++;
                        isGroup8Scored = true;
                    } else {
                        isGroup8Scored = false;
                    }
                    break;
                case R.id.q9_4:
                    if (!isGroup9Scored) {
                        score++;
                        isGroup9Scored = true;
                    } else {
                        isGroup9Scored = false;
                    }
                    break;
                case R.id.q10_4:
                    if (!isGroup10Scored) {
                        score++;
                        isGroup10Scored = true;
                    } else {
                        isGroup10Scored = false;
                    }
                    break;
            }
        }
    };
}

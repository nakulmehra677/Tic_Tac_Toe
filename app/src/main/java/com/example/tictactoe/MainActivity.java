package com.example.tictactoe;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    Boolean status = false;
    Button block1, block2, block3, block4, block5, block6, block7, block8, block9, restart;
    TextView result;
    char[] v = new char[9];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        block1 = findViewById(R.id.bt_block1);
        block2 = findViewById(R.id.bt_block2);
        block3 = findViewById(R.id.bt_block3);
        block4 = findViewById(R.id.bt_block4);
        block5 = findViewById(R.id.bt_block5);
        block6 = findViewById(R.id.bt_block6);
        block7 = findViewById(R.id.bt_block7);
        block8 = findViewById(R.id.bt_block8);
        block9 = findViewById(R.id.bt_block9);
        result = findViewById(R.id.tv_show_result);
        restart = findViewById(R.id.bt_restart_game);

        block1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[0] == '\0') {
                    char p = labelButton(0);
                    block1.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[1] == '\0') {
                    char p = labelButton(1);
                    block2.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[2] == '\0') {
                    char p = labelButton(2);
                    block3.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[3] == '\0') {
                    char p = labelButton(3);
                    block4.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[4] == '\0') {
                    char p = labelButton(4);
                    block5.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[5] == '\0') {
                    char p = labelButton(5);
                    block6.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[6] == '\0') {
                    char p = labelButton(6);
                    block7.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[7] == '\0') {
                    char p = labelButton(7);
                    block8.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        block9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ((status && i < 9) && v[8] == '\0') {
                    char p = labelButton(8);
                    block9.setText(Character.toString(p));
                    checkLine();
                    check_i();
                }
            }
        });

        // Restarts the game

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!status) {
                    status = true;
                    reset_settings();

                } else {
                    AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
                    build.setMessage("Do you want to restart game?")
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int u) {
                                    status = true;
                                    reset_settings();

                                }
                            }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int u) {

                        }
                    });


                    AlertDialog alert = build.create();
                    alert.show();
                }
                restart.setText(R.string.restart_button_text_in_middle_of_game);
            }
        });
    }

    private void checkLine() {
        if ((v[0] == v[1] && v[1] == v[2]) && v[0] != '\0') check_Winner(v[0]);
        else if ((v[3] == v[4] && v[4] == v[5]) && v[3] != '\0') check_Winner(v[3]);
        else if ((v[6] == v[7] && v[7] == v[8]) && v[6] != '\0') check_Winner(v[6]);
        else if ((v[0] == v[3] && v[3] == v[6]) && v[0] != '\0') check_Winner(v[0]);
        else if ((v[1] == v[4] && v[4] == v[7]) && v[1] != '\0') check_Winner(v[1]);
        else if ((v[2] == v[5] && v[5] == v[8]) && v[2] != '\0') check_Winner(v[2]);
        else if ((v[0] == v[4] && v[4] == v[8]) && v[0] != '\0') check_Winner(v[0]);
        else if ((v[2] == v[4] && v[4] == v[6]) && v[2] != '\0') check_Winner(v[2]);
    }

    private void check_Winner(char b) {
        if (b == 'O') result.setText(R.string.player_1_wins);
        else result.setText(R.string.player_2_wins);

        status = false;
        restart.setText(R.string.restart_button_text_initially);
    }

    private void check_i() {
        if (i >= 9 && status) {
            result.setText(R.string.draw);
            status = false;
            restart.setText(R.string.restart_button_text_initially);
        }
    }

    private char labelButton(int n) {
        if (i % 2 == 0) {
            i++;
            v[n] = 'O';
            return 'O';
        }
        i++;
        v[n] = 'X';
        return 'X';
    }

    private void reset_settings() {
        for (int j = 0; j < 9; j++) v[j] = '\0';
        i = 0;

        block1.setText("");
        block2.setText("");
        block3.setText("");
        block4.setText("");
        block5.setText("");
        block6.setText("");
        block7.setText("");
        block8.setText("");
        block9.setText("");

        result.setText("");
    }

}

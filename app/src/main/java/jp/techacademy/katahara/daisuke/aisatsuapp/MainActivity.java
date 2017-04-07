package jp.techacademy.katahara.daisuke.aisatsuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.TimePickerDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView mTextView;
    String Aisatsu; // あいさつ文を入れるパラメータ。

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button1);
        button1.setOnClickListener(this);

        mTextView = (TextView) findViewById(R.id.textView1);

    }

    @Override
    public void onClick (View view) {
        showTimePickerDialog();
    }

    private void showTimePickerDialog() {
        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // 念のためにログにも時刻を出す。
                      Log.d("UI_PARTS", String.valueOf(hourOfDay) + ":" + String.valueOf(minute));

                        Aisatsu = "";

                        if (hourOfDay >=2 && hourOfDay <= 9) {
                            Aisatsu = "「おはよう」";
                        } else if(hourOfDay >=10 && hourOfDay <=17) {
                            Aisatsu = "「こんにちは」";
                        } else {
                            Aisatsu = "「こんばんわ」";
                        }

                        mTextView.setText(Aisatsu);

                    }
                },
                13,
                0,
                true);

        timePickerDialog.show();

    }
}

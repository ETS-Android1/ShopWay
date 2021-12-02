package com.example.shopway.ui;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.shopway.R;

import org.jetbrains.annotations.NotNull;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class OrderStatusFragment extends Fragment {

    ProgressBar orderProgress;
    TextView orderTimer;
    CountDownTimer countDownTimer;
    int count = 0;

    @Override
    public void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    public View onCreateView(@NonNull @NotNull LayoutInflater inflater, @Nullable @org.jetbrains.annotations.Nullable ViewGroup container, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_order_status, container, false);
        orderProgress = view.findViewById(R.id.order_progress);
        orderTimer = view.findViewById(R.id.time_view);
        orderProgress.setProgress(0);
        int random = new Random().nextInt(3600001) + 1200000;
        countDownTimer = new CountDownTimer(random, 1) {
            @Override
            public void onTick(long millisUntilFinished) {

                String hour = timeFormatter( millisUntilFinished);
              orderTimer.setText("Thank you for Ordering! Your order should come in " + hour);
                if(count <random)
                {
                    count++;
                    orderProgress.incrementProgressBy(count);

                }



            }

            @Override
            public void onFinish() {
                orderTimer.setText("Your order should arrive now!");
            }
        };
        countDownTimer.start();

        return view;
    }

    private String timeFormatter(long milliSeconds) {

        String hour = String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milliSeconds),
                TimeUnit.MILLISECONDS.toMinutes(milliSeconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliSeconds)),
                TimeUnit.MILLISECONDS.toSeconds(milliSeconds) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliSeconds)));

        return hour;


    }
}

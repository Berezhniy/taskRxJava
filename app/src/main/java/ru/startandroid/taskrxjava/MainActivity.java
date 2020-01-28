package ru.startandroid.taskrxjava;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import ru.startandroid.taskrxjava.model.User;
import ru.startandroid.taskrxjava.utils.RxUtils;

public class MainActivity extends AppCompatActivity {

    public RxUtils mRxUtils;
    public ArrayList<User> mUserList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserList = (ArrayList<User>) RxUtils.addUsersInList();
        mRxUtils.newUsers();
    }

}

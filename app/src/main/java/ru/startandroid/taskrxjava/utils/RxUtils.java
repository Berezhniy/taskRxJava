package ru.startandroid.taskrxjava.utils;

import android.util.Log;
import java.util.ArrayList;
import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import ru.startandroid.taskrxjava.model.User;

public class RxUtils  {

    public static Disposable mListObservable;
    public static ArrayList<User> mUserList;

    @NonNull
    public static ArrayList<User> addUsersInList() {

        ArrayList<User> users = new ArrayList<User>();
        User user0 = new User("name1", "surname1", 1);
        User user1 = new User("name2", "surname2", 2);
        User user2 = new User("name3", "surname3", 3);
        User user3 = new User("name4", "surname4", 4);
        User user4 = new User("name5", "surname5", 5);
        User user5 = new User("name6", "surname6", 6);
        User user6 = new User("name7", "surname7", 7);
        User user7 = new User("name8", "surname8", 8);
        User user8 = new User("name9", "surname9", 9);
        User user9 = new User("name10", "surname10", 10);

        users.add(user0);
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        users.add(user5);
        users.add(user6);
        users.add(user7);
        users.add(user8);
        users.add(user9);


        for (User u : users
        ) {
            Log.d("myUser", u.toString());
        }
        return users;
    }

    public static void newUsers() {
        mUserList = addUsersInList();

        mListObservable = Observable.just(mUserList)
                .fromIterable(mUserList)
                .concatMap(u -> Observable.just(roadToRashaEnd(u)))
                .concatMap(u -> Observable.just(getUpdateAge(u)))
                .toList()
                .toObservable()
                .subscribe(u -> Log.d("MyNewUser", u.toString()),
                        throwable -> {
                        },
                        () -> Log.d("MyNewUser", " is complete"));
    }


    private static User roadToRashaEnd(User u) {
        u.setSurname(u.getSurname() + "ovich");
        return u;
    }
    private static User getUpdateAge(User u) {
        u.setAge(u.getAge() * 2);
        return u;
    }


}

package com.tranduc.smacthuctap.view.dataBinding;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import com.tranduc.smacthuctap.model.User;

public class DataBindingPresenter {
    private Context context;
    private DataBindingContact dataBindingContact;
    private User user;

    public DataBindingPresenter(Context context, DataBindingContact dataBindingContact) {
        this.context = context;
        this.dataBindingContact = dataBindingContact;

        user = new User();

        user.setName("duc");
        user.setEmail("tranduc17101999@gmail.com");

        dataBindingContact.updateUser(user);
    }

    @SuppressLint("WrongConstant")
    public void buttonOnClick() {
        Toast.makeText(context, "Button OnClick", 0).show();
    }

    @SuppressLint("WrongConstant")
    public void buttonOnClickWithParam() {
        Toast.makeText(context, "Button OnClick With Param: " + user.getName() + " " + user.getEmail(), 0).show();
    }

    @SuppressLint("WrongConstant")
    public boolean buttonOnClickLongPress() {
        Toast.makeText(context, "Button OnClick Long Press", 0).show();
        return false;
    }
}

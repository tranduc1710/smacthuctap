package com.tranduc.smacthuctap.view.dataBinding;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.tranduc.smacthuctap.R;
import com.tranduc.smacthuctap.databinding.ActivityDataBindingBinding;
import com.tranduc.smacthuctap.model.User;

public class DataBindingActivity extends AppCompatActivity implements DataBindingContact{
    private ActivityDataBindingBinding binding;
    private DataBindingPresenter dataBindingPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding);
        dataBindingPresenter = new DataBindingPresenter(this, this);

        binding.setMyClick(dataBindingPresenter);
    }

    @Override
    public void updateUser(User user) {
        binding.setUser(user);
    }
}

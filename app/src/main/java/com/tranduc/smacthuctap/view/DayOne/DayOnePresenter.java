package com.tranduc.smacthuctap.view.DayOne;

import android.content.Context;
import android.widget.CheckBox;

public class DayOnePresenter {
    private Context context;
    private DayOneContact dayOneContact;

    public DayOnePresenter(Context context, DayOneContact dayOneContact) {
        this.context = context;
        this.dayOneContact = dayOneContact;
    }

    public String checkConduct(CheckBox cbConductGood, CheckBox cbConductRather, CheckBox cbConductLeast){
        //set conduct
        if (cbConductGood.isChecked()){
            return "Good";
        }else if (cbConductRather.isChecked()){
            return "Rather";
        }else if (cbConductLeast.isChecked()){
            return "Least";
        }
        return "";
    }
}

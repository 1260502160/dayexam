package com.bawei.rikao18.home.presenter;

import android.util.Log;

import com.bawei.rikao18.MainActivity;
import com.bawei.rikao18.api.Api;
import com.bawei.rikao18.home.model.Modelmple;

public class PresenterImple implements PresenterInface,Modelmple.Modulnface{
    private final Modelmple modelmple;
    MainActivity mView;

    public PresenterImple(MainActivity mView) {
        this.mView = mView;
        modelmple = new Modelmple(this);
    }

    @Override
    public void getModelSuccess(String data) {

        mView.getViewData(data);
    }

    @Override
    public void getModelFailed() {

    }

    @Override
    public void getPresenterData() {

      modelmple.getModelData(Api.RV);

    }
}

package com.bawei.day20exam.shopping.presenter;

import com.bawei.day20exam.api.Api;
import com.bawei.day20exam.fragment.HomeFragment;
import com.bawei.day20exam.fragment.MyFragment;
import com.bawei.day20exam.shopping.model.CarModelmple;

public class CarPresenterImple implements ICarPresenterInface,CarModelmple.CarModelnface{
    private final CarModelmple carModelmple;
    MyFragment myFragment;

    public CarPresenterImple(MyFragment myFragment) {
        this.myFragment = myFragment;
        carModelmple = new CarModelmple(this);
    }

    @Override
    public void getCarSuccess(String data) {

        myFragment.getCarViewData(data);


    }

    @Override
    public void getCarFailed() {

    }

    @Override
    public void getCarPresenterData() {

        carModelmple.getCarModelData(Api.SHOPSHOW);
    }
}

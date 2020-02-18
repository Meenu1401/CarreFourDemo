package com.example.carrefourdemo;

import io.reactivex.observers.DisposableObserver;

public abstract class DisposableOnNextObserver<T> extends DisposableObserver<T> {
    public DisposableOnNextObserver() {
    }

    public void onError(Throwable e) {
        e.printStackTrace();
    }

    public void onComplete() {
    }
}

/*
 * Copyright (C) 2017 IMONT Technologies Limited
 *
 */
package io.imont.sdk.skelmir;

import rx.functions.Action1;
import rx.subjects.PublishSubject;
import rx.subjects.Subject;

public class RxMain {
    public static void main(String[] args) {

        final Subject<String, String> subj = PublishSubject.create();
        subj.subscribe(new Action1<String>() {
            @Override
            public void call(final String s) {
                System.out.println("String received " + s);
            }
        });

        subj.onNext("1");
        subj.onNext("2");
        subj.onNext("3");

        System.out.println("Has observers? " + subj.hasObservers());
    }
}

package com.example.admin.testingproject;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.ComponentNameMatchers.hasShortClassName;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtra;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by Admin on 10/25/2017.
 */

public class MainActivityTest {

    public static final String PACKAGE_NAME = "com.example.admin.testingproject";
    int first, second, result;

    @Before
    public void setup(){
        first = 10;
        second = 20;
        result = 30;
    }

    @Rule
    public IntentsTestRule<MainActivity> intentsActivityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void addition_isCorrect(){

        automateViews();

        onView(withId(R.id.tvText))
                .check(matches(withText(String.valueOf(result))));


    }

    private void automateViews() {
        onView(withId(R.id.etValOne)).perform(typeText(String.valueOf(first)), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.etValTwo)).perform(typeText(String.valueOf(second)), ViewActions.closeSoftKeyboard());

        onView(withId(R.id.btnPress))
                .perform(click());
    }

    @Test
    public void test_intent(){
        automateViews();

        onView(withId(R.id.btnPress2))
                .perform(click());

        intended(allOf(
                hasComponent(hasShortClassName(".Main2Activity")),
                toPackage(PACKAGE_NAME),
                hasExtra(MainActivity.RESULT_KEY, String.valueOf(result))
        ));
    }
}

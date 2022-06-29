package com.manny.espressoui

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @Test
    fun testActivity_inView() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.main)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.activity_main_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed())) // method 1

        Espresso.onView(withId(R.id.activity_main_title))
            .check(ViewAssertions.matches(ViewMatchers.withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE))) // method 2

        Espresso.onView(withId(R.id.button_next_activity))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        Espresso.onView(withId(R.id.activity_main_title))
            .check(ViewAssertions.matches(withText(R.string.text_mainactivity)))
    }

    @Test
    fun test_NavigationToSecondary(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).perform(click())

        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    @Test
    fun testNavigation_back_toMain(){
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

         // Scenario One
      //  onView(withId(R.id.button_back)).perform(click())


        // Scenario Two
        pressBack()

        // Both Scenarios are same

        onView(withId(R.id.main)).check(matches(isDisplayed()))

    }

}
package com.manny.espressoui

import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SecondaryActivityTest{
    /**
     * ActivityScenarioRule:
     * https://developer.android.com/reference/androidx/test/ext/junit/rules/ActivityScenarioRule.html
     */
    @get:Rule
    val activityRule = ActivityScenarioRule(SecondaryActivity::class.java)

    @Test
    fun testActivity_inView() {

        Espresso.onView(withId(R.id.secondary))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        // Notice this does not effect the next test
        activityRule.scenario.moveToState(Lifecycle.State.DESTROYED)
    }

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(withId(R.id.button_back))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {
        Espresso.onView(withId(R.id.activity_secondary_title))
            .check(ViewAssertions.matches(withText(R.string.text_secondaryactivity)))
    }

}
package com.example.tipcalculator

import androidx.core.content.MimeTypeFilter.matches
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.hamcrest.Matchers.containsString

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)
@Test
fun calculate_20_percent_tip(){
    onView(withId(R.id.cost_of_service_edit_text))
        .perform(typeText("50.00"))
    onView(withId(R.id.calculate))
        .perform(click())
    onView(withId(R.id.tip_amount))
        .check(matches(withText(containsString("₹10.00"))))
}
    @Test
    fun calculate_18_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
        onView(withId(R.id.good_18))
            .perform(click())
        onView(withId(R.id.calculate))
            .perform(click())
        onView(withId(R.id.tip_amount))
            .check(matches(withText(containsString("₹9.00"))))
    }
    @Test
    fun calculate_15_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
        onView(withId(R.id.okay_15))
            .perform(click())
        onView(withId(R.id.calculate))
            .perform(click())
        onView(withId(R.id.tip_amount))
            .check(matches(withText(containsString("₹8.00"))))
    }
}
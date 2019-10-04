package com.lambdaschool.congressdata

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.lambdaschool.congressdataapiaccess.CongressDao
import org.junit.Before
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@RunWith(AndroidJUnit4::class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class DetailsActivityUITest {

    private var MEM_ID = "B001306"

    @Rule
    @JvmField
    var activityTestRule = ActivityTestRule(DetailsActivity::class.java)

    @Test
    fun a_showName() {
        // Setup
        val congresspersonProfile = CongresspersonProfile(CongressDao.getMemberDetails(MEM_ID))
        val intent = Intent()
        intent.putExtra("id", congresspersonProfile.id)

        // Execute
        activityTestRule.launchActivity(intent)

        // Check
        onView(withId(R.id.profile_name)).check(matches(withText(congresspersonProfile.displayName)))
    }

    @Test
    fun b_showParty() {
        // Setup
        val congresspersonProfile = CongresspersonProfile(CongressDao.getMemberDetails(MEM_ID))
        val intent = Intent()
        intent.putExtra("id", congresspersonProfile.id)

        // Execute
        activityTestRule.launchActivity(intent)

        // Check
        onView(withId(R.id.profile_party)).check(matches(withText(congresspersonProfile.party)))
    }

    @Test
    fun c_showPhone() {
        // Setup
        val congresspersonProfile = CongresspersonProfile(CongressDao.getMemberDetails(MEM_ID))
        val intent = Intent()
        intent.putExtra("id", congresspersonProfile.id)

        // Execute
        activityTestRule.launchActivity(intent)

        // Check
        onView(withId(R.id.profile_phone)).check(matches(withText(congresspersonProfile.phone)))
    }
}
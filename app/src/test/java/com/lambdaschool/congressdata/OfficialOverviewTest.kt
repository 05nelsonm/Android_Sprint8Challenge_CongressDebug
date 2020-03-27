package com.lambdaschool.congressdata

import junit.framework.Assert.assertEquals
import org.junit.Test

class OfficialOverviewTest {

    val yesMiddleName = OfficialOverview("First", "Middle", "Last", "I", "MD", "0")
    val noMiddleName = OfficialOverview("First", "null", "Last", "I", "MD", "0")

    @Test
    fun testFor_Party_No_MiddleName() {
        // Setup
        val testParty = "I"

        // Execute
        val resultParty = noMiddleName.party

        // Check
        assertEquals(testParty, resultParty)
    }

    @Test
    fun testFor_Party_Yes_MiddleName() {
        // Setup
        val testParty = "I"

        // Execute
        val resultParty = yesMiddleName.party

        // Check
        assertEquals(testParty, resultParty)
    }

    @Test
    fun testFor_No_MiddleName() {
        // Setup
        val testName = "First Last"

        // Execute
        val resultName = noMiddleName.displayName

        // Check
        assertEquals(testName, resultName)
    }

    @Test
    fun testFor_Yes_MiddleName() {
        // Setup
        val testName = "First Middle Last"

        // Execute
        val resultName = yesMiddleName.displayName

        // Check
        assertEquals(testName, resultName)
    }

    @Test
    fun testFor_Id_No_MiddleName() {
        // Setup
        val testId = "0"

        // Execute
        val resultId = noMiddleName.id

        // Check
        assertEquals(testId, resultId)
    }

    @Test
    fun testFor_Id_Yes_MiddleName() {
        // Setup
        val testId = "0"

        // Execute
        val resultId = yesMiddleName.id

        // Check
        assertEquals(testId, resultId)
    }
}
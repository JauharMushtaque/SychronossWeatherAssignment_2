package com.example.synchronoss.test.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UtilityTest{
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun convertToCelcius() {
        var testTemp = Utility.convertToCelcius("307.46")
        assertEquals("34.31", testTemp)
    }
}
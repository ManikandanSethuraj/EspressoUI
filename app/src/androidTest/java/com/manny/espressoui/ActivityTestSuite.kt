package com.manny.espressoui

import org.junit.runner.RunWith
import org.junit.runners.Suite

/**
 * This files is used to run all the ActivityTests in One File
 */

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SecondaryActivity::class
)
class ActivityTestSuite

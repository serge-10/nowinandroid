/*
 * Copyright 2025 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.samples.apps.nowinandroid.ui.homeworks.homework16

import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import org.junit.Test

class MainScrenTestList : TestCase(Kaspresso.Builder.withComposeSupport ()) {

    @get:Rule

    val composeTestRule = createAndroidComposeRule<MainActivity>()

    val mainScreen = MainScreenTestList(composeTestRule)

    @OptIn(ExperimentalTestApi::class)
    @Test
    fun mainScreenListTest() = run {

        mainScreen.topics.childAt<TopicItem>(1) {
            icon.assertIsDisplayed()

            text {
                assertIsDisplayed()
                hasText("UI")
                performClick()
            }
        }

        mainScreen.news.childAt<NewsItem>(0) {
            title.assertIsDisplayed()
        }
    }
}
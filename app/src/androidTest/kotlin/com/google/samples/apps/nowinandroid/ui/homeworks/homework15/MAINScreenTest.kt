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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework15

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.components.composesupport.config.withComposeSupport
import com.kaspersky.kaspresso.kaspresso.Kaspresso
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import org.junit.Rule
import kotlin.test.Test

class MAINScreenTest: TestCase(
    Kaspresso.Builder.withComposeSupport() // Подключаем поддержку Compose
) {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    private val mainScreen = MAINScreen(composeTestRule)
    private val searchScreenItems = SearchScreen(composeTestRule)

    @Test
    fun checkMainScreenElements() = run {
        step("Проверяем кнопку поиска") {
            mainScreen.searchIcon.assertIsDisplayed()
            mainScreen.searchIcon.performClick()
        }

        step("Проверяем текстовое поле поиска") {
            searchScreenItems.searchTextField.assertIsDisplayed()
            searchScreenItems.searchTextField.performTextInput("Test")
        }

        step("Возвращаемся назад") {
            searchScreenItems.onBackIcon.assertIsDisplayed()
            searchScreenItems.onBackIcon.performClick()
        }

        step("Проверяем нижний тулбар и его кликабельность") {
            mainScreen.savedIcon.assertIsDisplayed()
            mainScreen.savedIcon.performClick()
            composeTestRule.waitForIdle()

            mainScreen.interestsIcon.assertIsDisplayed()
            mainScreen.interestsIcon.performClick()
            composeTestRule.waitForIdle()

            mainScreen.forYouIcon.assertIsDisplayed()
            mainScreen.forYouIcon.performClick()
            composeTestRule.waitForIdle()
        }
    }
}



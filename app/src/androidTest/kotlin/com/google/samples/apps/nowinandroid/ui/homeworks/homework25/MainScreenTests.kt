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

package com.google.samples.apps.nowinandroid.ui.homeworks.homework25

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import com.google.samples.apps.nowinandroid.MainActivity
import com.kaspersky.kaspresso.testcases.api.testcase.TestCase
import io.github.kakaocup.compose.rule.KakaoComposeTestRule
import org.junit.Rule
import kotlin.test.Test

class MainScreenTests: TestCase() {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()
    val namedMainScreen = NamedMainScreen(composeTestRule)

    @get: Rule
    val kakaoComposeTestRule = KakaoComposeTestRule(
        semanticsProvider = composeTestRule,
        useUnmergedTree = true,
    )

    @Test
    fun mainScreenTests() {
        run {
            namedMainScreen {
                checks {
                    isDisplayed(titleTopBar)
                }
                lazyHorizontalListItemNode(1) {
                    checks {
                        isDisplayed(topicIcon)
                    }
                    action {
                        click(toggleButton)
                    }
                }
            }
        }
    }
}
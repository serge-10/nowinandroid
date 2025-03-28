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

import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.theme.C
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.node.element.ComposeScreen

class MAINScreen(semanticsProvider: SemanticsNodeInteractionsProvider) :
    ComposeScreen<MAINScreen>(semanticsProvider) {

    val centerAlignedTopAppBar = KNode(semanticsProvider) {
        hasTestTag("niaTopAppBar")
    }

    val titleText = KNode(semanticsProvider) {
        hasTestTag(C.Upper_TITLE_TEXT)
        useUnmergedTree = true
    }

    val searchIcon = KNode(semanticsProvider) {
        hasTestTag(C.UPPER_SEARCH_ICON)
        useUnmergedTree = true
    }

    val settingIcon = KNode(semanticsProvider) {
        hasTestTag(C.UPPER_SETTINGS_ICON)
        useUnmergedTree = true
    }

    val forYouIcon = KNode(semanticsProvider) {
        hasTestTag("NiaNavItem")
        hasText("For you")
    }
    val savedIcon = KNode(semanticsProvider) {
        hasTestTag("NiaNavItem")
        hasText("Saved")
    }
    val interestsIcon = KNode(semanticsProvider) {
        hasTestTag("NiaNavItem")
        hasText("Interests")
    }
}


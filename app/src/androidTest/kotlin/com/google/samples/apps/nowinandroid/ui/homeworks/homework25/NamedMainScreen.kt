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

import com.google.samples.apps.nowinandroid.core.designsystem.C
import androidx.compose.ui.semantics.SemanticsNode
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteractionsProvider
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListItemPositionSemantics
import com.google.samples.apps.nowinandroid.core.designsystem.LazyListLengthSemantics
import com.kaspersky.components.composesupport.core.KNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListItemNode
import io.github.kakaocup.compose.node.element.lazylist.KLazyListNode

class NamedMainScreen(
    semanticsProvider: SemanticsNodeInteractionsProvider? = null,
) : NamedComposeScreen<NamedMainScreen>(semanticsProvider) {
    override val screenName: String = "NamedMainScreen"

    val titleTopBar = child<KNode> {
        hasTestTag(C.TOP_BAR_TITLE)
        useUnmergedTree = true
    }.name(withParent("Top App Bar"))

    val searchIcon = child<KNode> {
        hasTestTag(C.TOP_BAR_SEARCH_ICON)
        useUnmergedTree = true
    }

    val settingsIcon = child<KNode> {
        hasTestTag(C.TOP_SETTINGS_ICON)
        useUnmergedTree = true
    }

    val interestsItemHeader = child<KNode> {
        hasTestTag(C.INTERESTS_ITEM_HEADER)
        useUnmergedTree = true
    }

    val interestsIcon = child<KNode> {
        hasText("Interests")
    }

    val doneButton = child<KNode> {
        hasTestTag(C.DONE_BUTTON)
        useUnmergedTree = true
    }
    val lazyHorizontalList by lazy {
        KLazyListNode(
            semanticsProvider = semanticsProvider,
            viewBuilderAction = { hasTestTag("forYou:topicSelection") },
            itemTypeBuilder = {
                itemType(::LazyHorizontalListItemNode)
            },
            positionMatcher = { position ->
                SemanticsMatcher.expectValue(
                    LazyListItemPositionSemantics,
                    position,
                )
            },
            lengthSemanticsPropertyKey = LazyListLengthSemantics,
        ).name(withParent("List of topics"))
    }

    fun lazyHorizontalListItemNode(index: Int, function: LazyHorizontalListItemNode.() -> Unit) {
        lazyHorizontalList.invokeAtIndex(index, function)
    }

    val lazyVerticalList by lazy {
        KLazyListNode(
            semanticsProvider = semanticsProvider,
            viewBuilderAction = { hasTestTag("forYou:feed") },
            itemTypeBuilder = {
                itemType(::LazyVerticalListNode)
            },
            positionMatcher = { position ->
                SemanticsMatcher.expectValue(
                    LazyListItemPositionSemantics,
                    position,
                )
            },
            lengthSemanticsPropertyKey = LazyListLengthSemantics,
        ).name(withParent("Content"))
    }

    fun lazyVerticalListItemNode(index: Int, function: LazyVerticalListNode.() -> Unit) {
        lazyVerticalList.invokeAtIndex(index, function)
    }

    class LazyHorizontalListItemNode(
        semanticsNode: SemanticsNode,
        semanticsProvider: SemanticsNodeInteractionsProvider,
    ) : KLazyListItemNode<LazyHorizontalListItemNode>(semanticsNode, semanticsProvider) {
        val topicIcon by lazy {
            child<KNode> {
                hasTestTag(C.TOPIC_ICON)
            }.name(withParent("Icon"))
        }

        val text by lazy {
            child<KNode> {
                hasTestTag(C.TOPIC_TEXT)
            }.name(withParent("text"))
        }

        val toggleButton by lazy {
            child<KNode> {
                hasTestTag(C.TOPIC_TOGGLE)
            }.name(withParent("toggle"))
        }
    }

    class LazyVerticalListNode(
        semanticsNode: SemanticsNode,
        semanticsProvider: SemanticsNodeInteractionsProvider,
    ) : KLazyListItemNode<LazyVerticalListNode>(semanticsNode, semanticsProvider) {

        val title by lazy {
            child<KNode> {
                hasTestTag(C.HEADER_TITLE)
            }.name(withParent("header"))
        }

        val metadata by lazy {
            child<KNode> {
                hasTestTag(C.METADATA)
            }.name(withParent("metadata"))
        }
    }
}
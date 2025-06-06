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

import com.kaspersky.kaspresso.testcases.core.testcontext.TestContext

private val executorHashMap = mutableMapOf<String, StepsDSL<*>>()

val TestContext<*>.action: ActionSteps
    get() {
        val key = ActionSteps::class.java.name + this.hashCode()
        return executorHashMap.getOrPut(key) {
            ActionSteps(StepsExecutor(this))
        } as ActionSteps
    }

val TestContext<*>.checks: CheckSteps
    get() {
        val key = CheckSteps::class.java.name + this.hashCode()
        return executorHashMap.getOrPut(key) {
            CheckSteps(StepsExecutor((this)))
        } as CheckSteps
    }
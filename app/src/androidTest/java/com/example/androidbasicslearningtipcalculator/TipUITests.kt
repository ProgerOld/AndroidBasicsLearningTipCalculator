package com.example.androidbasicslearningtipcalculator

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performTextInput
import com.example.androidbasicslearningtipcalculator.ui.theme.AndroidBasicsLearningTipCalculatorTheme
import org.junit.Rule
import org.junit.Test
import java.text.NumberFormat

class TipUITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun calculate_20_percent_tip() {
        composeTestRule.setContent {
            AndroidBasicsLearningTipCalculatorTheme{
                TipTimeLayout()
            }
        }

        composeTestRule.onNodeWithText("Bill Amount").performTextInput("10") //Получаем поле и передаем ему значение
        composeTestRule.onNodeWithText("Tip Percentage").performTextInput("20") //Получаем поле и передаем ему значение

        val expectedTip = NumberFormat.getCurrencyInstance().format(2)
        composeTestRule.onNodeWithText("Tip Amount: $expectedTip").assertExists(
            "No node with this text was found."
        )

    }

}
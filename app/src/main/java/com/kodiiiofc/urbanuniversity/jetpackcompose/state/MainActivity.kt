package com.kodiiiofc.urbanuniversity.jetpackcompose.state

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kodiiiofc.urbanuniversity.jetpackcompose.state.ui.theme.StateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateTheme {
                Program()
            }
        }
    }
}

private val list = listOf(
    mapOf("ru" to "Бананы", "en" to "Bananas"),
    mapOf("ru" to "Яйца", "en" to "Eggs"),
    mapOf("ru" to "Курица", "en" to "Chicken"),
    mapOf("ru" to "Творог", "en" to "Cottage Cheese"),
    mapOf("ru" to "Йогурт", "en" to "Yogurt"),
    mapOf("ru" to "Пиво", "en" to "Beer"),
    mapOf("ru" to "Хлеб", "en" to "Bread"),
    mapOf("ru" to "Печенье", "en" to "Cookies"),
    mapOf("ru" to "Молоко", "en" to "Milk"),
    mapOf("ru" to "Яблоки", "en" to "Apples"),
    mapOf("ru" to "Помидоры", "en" to "Tomatoes"),
    mapOf("ru" to "Картофель", "en" to "Potatoes"),
    mapOf("ru" to "Кола", "en" to "Coke"),
    mapOf("ru" to "Сахар", "en" to "Sugar"),
    mapOf("ru" to "Соль", "en" to "Salt"),
    mapOf("ru" to "Масло", "en" to "Butter"),
    mapOf("ru" to "Рис", "en" to "Rice"),
    mapOf("ru" to "Макароны", "en" to "Pasta"),
    mapOf("ru" to "Кофе", "en" to "Coffee"),
    mapOf("ru" to "Чай", "en" to "Tea"),
    mapOf("ru" to "Лук", "en" to "Onion"),
    mapOf("ru" to "Чеснок", "en" to "Garlic"),
    mapOf("ru" to "Морковь", "en" to "Carrot"),
    mapOf("ru" to "Капуста", "en" to "Cabbage"),
    mapOf("ru" to "Грибы", "en" to "Mushrooms"),
    mapOf("ru" to "Виноград", "en" to "Grapes"),
    mapOf("ru" to "Апельсины", "en" to "Oranges"),
    mapOf("ru" to "Персики", "en" to "Peaches"),
    mapOf("ru" to "Груши", "en" to "Pears"),
    mapOf("ru" to "Клубника", "en" to "Strawberries"),
    mapOf("ru" to "Ананас", "en" to "Pineapple"),
    mapOf("ru" to "Кукуруза", "en" to "Corn"),
    mapOf("ru" to "Огурцы", "en" to "Cucumbers"),
    mapOf("ru" to "Перец", "en" to "Peppers"),
    mapOf("ru" to "Свекла", "en" to "Beets"),
    mapOf("ru" to "Шпинат", "en" to "Spinach"),
    mapOf("ru" to "Кабачки", "en" to "Zucchini"),
    mapOf("ru" to "Рыба", "en" to "Fish"),
    mapOf("ru" to "Креветки", "en" to "Shrimps"),
    mapOf("ru" to "Сосиски", "en" to "Sausages"),
    mapOf("ru" to "Бекон", "en" to "Bacon"),
    mapOf("ru" to "Мёд", "en" to "Honey"),
    mapOf("ru" to "Джем", "en" to "Jam"),
    mapOf("ru" to "Шоколад", "en" to "Chocolate"),
    mapOf("ru" to "Орехи", "en" to "Nuts"),
    mapOf("ru" to "Чипсы", "en" to "Chips"),
    mapOf("ru" to "Мороженое", "en" to "Ice Cream"),
    mapOf("ru" to "Кефир", "en" to "Kefir"),
    mapOf("ru" to "Какао", "en" to "Cocoa"),
    mapOf("ru" to "Сливки", "en" to "Cream")
)

private val TITLE = mapOf("ru" to "Список продуктов", "en" to "Grocery list")
private val BUTTON = mapOf("ru" to "Switch to English", "en" to "Переключить на Русский")

private val test = Pair(
    "ru" to "Яйца",
    "en" to "Eggs"
)

@Preview(showSystemUi = true)
@Composable
fun Program() {

    var language by rememberSaveable { mutableStateOf("ru") }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.background(Color.DarkGray).padding(16.dp).fillMaxWidth()) {
            Text(
                text = TITLE[language]!!,
                color = Color.White,
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                modifier = Modifier.fillMaxWidth())
        }
        LazyColumn(Modifier
            .fillMaxSize()
            .background(Color.Gray)
            .padding(16.dp)) {
            items(list) {
                Item(it[language]!!)
                Spacer(modifier = Modifier.fillParentMaxWidth().height(8.dp))
            }
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomEnd) {  Button(
        modifier = Modifier.padding(8.dp),
        colors = ButtonColors(
            Color.DarkGray,
            Color.White,
            Color.Gray,
            Color.DarkGray
        ),
        enabled = true,
        onClick = {
            if (language == "en") {
                language = "ru"
            } else language = "en"
        }) {
        Text(text = BUTTON[language]!!)
    } }


}

@Composable
fun Item(item: String) {
    Box(modifier = Modifier
        .clip(RoundedCornerShape(50))
        .background(Color.White)
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        Text(
            text = item,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
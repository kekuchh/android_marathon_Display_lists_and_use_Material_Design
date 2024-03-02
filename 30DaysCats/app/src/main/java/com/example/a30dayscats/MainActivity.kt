package com.example.a30dayscats

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.a30dayscats.model.CatDescription
import com.example.a30dayscats.model.CatsRepo
import com.example.a30dayscats.ui.theme.A30DaysCatsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            A30DaysCatsTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    A30DaysCats()
                }
            }
        }
    }
}

@Composable
private fun AppBar(modifier: Modifier) {
    Row (
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        ){
        Box(
            modifier = Modifier
                .height(60.dp)
                .padding(start = 16.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.app_icon_cat),
                contentDescription = "Cat Icon",
            )
        }
        Text(
            text = stringResource(R.string.app_name),
            style = MaterialTheme.typography.displayMedium,
            color = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.padding(start = 12.dp)
        )
    }
}

@Composable
private fun CatDescriptionsListView(
    catDescriptions: List<CatDescription>,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier.padding(top = 50.dp)
    ) {
        itemsIndexed(catDescriptions) { index, catDescription ->
            CatDescriptionListItem(
                index = index,
                catDescription = catDescription
            )
        }
    }
}

@Composable
private fun CatDescriptionListItem(
    index: Int,
    catDescription: CatDescription,
    modifier: Modifier = Modifier
) {
    var expanded by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = modifier.padding(10.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .animateContentSize(
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
        ) {
            Text(
                text = String.format(
                    "День %s",
                    stringResource(catDescription.nameRes)
                ),
                style = MaterialTheme.typography.displayMedium,
                modifier = Modifier.padding(start = 16.dp, bottom = 8.dp)
            )
            Image(
                painter = painterResource(catDescription.imageRes),
                contentDescription = null,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.height(150.dp).fillMaxWidth()
            )
            Row {
                Text(
                    text = stringResource(R.string.cat_description),
                    style = MaterialTheme.typography.displayMedium,
                    modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                )
                Spacer(modifier = Modifier.weight(1f))
                CatDescriptionItemButton(
                    expanded = expanded,
                    onClick = { expanded = !expanded }
                )
            }
            if (expanded) {
                Text(
                    text = stringResource(catDescription.instructionRes),
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                )
            }
        }
    }
}

@Composable
private fun CatDescriptionItemButton(
    expanded: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
            tint = MaterialTheme.colorScheme.onSurface,
            contentDescription = stringResource(R.string.expand_button_content_description)
        )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun A30DaysCats() {
    Scaffold(
        topBar = {
            AppBar(modifier = Modifier
                .height(40.dp)
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.primary)
            )
        }
    ) {
        CatDescriptionsListView(CatsRepo.catsDescriptions)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    A30DaysCatsTheme {
        A30DaysCats()
    }
}
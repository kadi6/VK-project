package com.kadico.details.presentation.appdetails


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kadico.core.AppNavigator
import com.kadico.details.R
import com.kadico.details.data.fake.AppInfo
import com.kadico.details.data.fake.listApps


@Composable
fun Showcase(
    modifier: Modifier = Modifier,
    navigator: AppNavigator,
) {

    val pagerState = rememberPagerState(pageCount = { 3 })

    Column(
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.showcase),
            modifier =  Modifier
        )

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .height(170.dp)
        ) { pageIndex ->

            val pageApps = listApps
                .drop(pageIndex * 3)
                .take(3)

            AppPage(
                apps = pageApps,
                navigator = navigator
            )
        }


    }
}


// Элемент приложение
@Composable
fun AppItem(
    item: AppInfo,
    navigator: AppNavigator,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = Color(0xFFEDF2F8))
            .height(130.dp)
            .clickable {
                navigator.navigateToApps()
            }
    ) {

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp, top = 8.dp),
            horizontalAlignment = Alignment.Start,
        ) {

            Icon(
                imageVector = item.iconApp,
                contentDescription = null,
                modifier = Modifier.size(48.dp),
                tint = MaterialTheme.colorScheme.secondary
            )


            Text(text = item.titleApp, style = MaterialTheme.typography.titleMedium)
            Text(
                text = item.categoryApp,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = item.descriptionApp,
                style = MaterialTheme.typography.bodySmall,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )


            // Полоса-разделитель
            HorizontalDivider(
                modifier = Modifier.padding(top = 16.dp),
                thickness = 1.dp,
                color = MaterialTheme.colorScheme.outlineVariant
            )
        }

    }
}


// Элемент страница
@Composable
fun AppPage(
    apps: List<AppInfo>,
    navigator: AppNavigator,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        apps.forEach { item ->
            AppItem(
                item = item,
                navigator = navigator,
                modifier = Modifier.weight(1f)
            )
        }
    }
}





@Preview
@Composable
fun PreviewShowcase() {
    Showcase(
        navigator = TODO()
    )
}
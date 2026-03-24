## jul-30-2025-SportsGamex-TradingView-Charts

One thing that puts Kotlin Multiplatform ahead of competitors like Flutter or React Native is its ability to implement platform specific features. We wanted to use `TradingView` charts on the client side. If we were using something like early stages Flutter, we would have had to wait for a library or package to support those charts. But thanks to KMP’s flexibility, we were able to use the official iOS and Android documentation from `TradingView` and build our feature, just like implementing it separately for each mobile platform.

Of course, this was a bit time consuming because it was essentially like implementing everything separately for each mobile platform. But I believe the time was absolutely worth it, because the implementation is fully native and any future changes will only require minor refactoring.

The charts that we needed were the famous `CandlerChart`, `LineChart`, `MiniGraph` and `MiniLineChart`. Each chart had its own data model and a `Composable` Api. But we managed all of them in a unified Api as an `expect` mechanism and we called it `TradinView`:

```
@Composable
expect fun TradingView(
    modifier: Modifier = Modifier,
    chartPoints: List<ChartPoint>,
    chartType: ChartType,
    timePeriod: TimePeriod,
    chartBackgroundColor: Color,
    axisLabelTextColor: Color,
    lineColor: Color,
    positiveColor: Color,
    negativeColor: Color,
    crossHairLabelBg: Color,
    dragLineColor: Color,
    gridLinesColor: Color,
    dateFormat: String,
    locale: String,
    localCurrencySymbol: String,
    isDarkMode: Boolean,
    onGraphState: (GraphState) -> Unit,
    onGraphDrag: (ChartPoint?) -> Unit
)

enum class GraphState {
    READY, PREPARING, ERROR
}
```

Of course, each property explains itself by its name, but as a reminder to myself, I’d like to include the Compose implementation of one of the charts here. This is the `MiniGraph`:

```
@Composable
fun MiniGraph(
    modifier: Modifier = Modifier,
    chartPoints: List<Float>,
    lineColor: Color
) {
    val zipList: List<Pair<Float, Float>> = chartPoints.zipWithNext()
    Row(modifier = modifier) {
        val max = chartPoints.max()
        val min = chartPoints.min()

        for (pair in zipList) {

            val fromValuePercentage = getValuePercentageForRange(pair.first, max, min)
            val toValuePercentage = getValuePercentageForRange(pair.second, max, min)

            Canvas(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                onDraw = {
                    val fromPoint = Offset(
                        x = 0f,
                        y = size.height.times(1 - fromValuePercentage)
                    ) // <-- Use times so it works for any available space
                    val toPoint =
                        Offset(
                            x = size.width,
                            y = size.height.times(1 - toValuePercentage)
                        ) // <-- Also here!

                    drawLine(
                        color = lineColor,
                        start = fromPoint,
                        end = toPoint,
                        strokeWidth = 3f
                    )
                })
        }
    }
}
```
package site.shadadman.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.ObjectFit
import com.varabyte.kobweb.compose.css.StyleVariable
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vw
import org.jetbrains.compose.web.dom.Div
import site.shadadman.SubheadlineTextStyle
import site.shadadman.components.layouts.PageLayoutData

// Container that has a tagline and grid on desktop, and just the tagline on mobile
val HeroContainerStyle = CssStyle {
    base { Modifier.fillMaxWidth().gap(2.cssRem) }
}

// A demo grid that appears on the homepage because it looks good
val HomeGridStyle = CssStyle.base {
    Modifier
        .gap(0.5.cssRem)
        .width(70.cssRem)
        .height(18.cssRem)
}

private val GridCellColorVar by StyleVariable<Color>()
val HomeGridCellStyle = CssStyle.base {
    Modifier
        .backgroundColor(GridCellColorVar.value())
        .boxShadow(blurRadius = 0.6.cssRem, color = GridCellColorVar.value())
        .borderRadius(1.cssRem)
}

@Composable
private fun GridCell(color: Color, row: Int, column: Int, width: Int? = null, height: Int? = null) {
    Div(
        HomeGridCellStyle.toModifier()
            .setVariable(GridCellColorVar, color)
            .gridItem(row, column, width, height)
            .toAttrs()
    )
}


@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    // 1. Lock height to viewport to prevent scrolling
    Box(Modifier.fillMaxSize()) {

        // 3. The "Shadow" overlay over the image
        Box(
            Modifier
                .fillMaxHeight()

                .backgroundColor(
                    when (ColorMode.current) {
                        ColorMode.LIGHT -> Colors.White.copy(alpha = 99)
                        ColorMode.DARK -> Colors.Black.copy(alpha = 99)
                    }
                )
        )

        Image(
            "/me.jpeg",
            "Shad Adman",
            Modifier
                .fillMaxHeight()
                .width(25.vw)
                .align(Alignment.CenterEnd)
                .objectFit(ObjectFit.Cover)
                .opacity(0.4)
        )



        Box(Modifier.fillMaxSize().padding(right = 15.vw)) {
            Column(
                Modifier.fillMaxHeight().maxWidth(70.percent),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Box(
                    Modifier
                        .backgroundColor(
                            when (ColorMode.current) {
                                ColorMode.LIGHT -> Colors.CadetBlue
                                ColorMode.DARK -> Colors.CadetBlue
                            }
                        )
                        .padding(2.cssRem)
                ) {
                    Div(SubheadlineTextStyle.toAttrs()) {
                        SpanText(
                            "This individual fell in love with coding when introduced to C++ during his student years. I did a lot of work with Android & Kotlin Multiplatform. Currently in my free time I love embedding low level languages like C, Rust & Zig with Kotlin & talking to hardware. A long background with onDevice AI using TFLite & PyTorch Mobile. I worked with HealthTech, Digital Retail, Trading & iGaming domains.",
                            Modifier
                                .fontSize(1.5.cssRem)
                                .lineHeight(1.6)
                                .textAlign(TextAlign.Justify)
                                .color(
                                    when (ColorMode.current) {
                                        ColorMode.LIGHT -> Colors.Black
                                        ColorMode.DARK -> Colors.White
                                    }
                                )
                        )
                    }
                }
            }
        }
    }
}

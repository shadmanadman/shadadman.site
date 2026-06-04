package site.shadadman.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.blur
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.foundation.layout.Arrangement
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.framework.annotations.DelicateApi
import com.varabyte.kobweb.silk.components.graphics.Image
import com.varabyte.kobweb.silk.components.text.SpanText
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.theme.breakpoint.rememberBreakpoint
import com.varabyte.kobweb.silk.style.toAttrs
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import com.varabyte.kobweb.silk.theme.colors.palette.background
import com.varabyte.kobweb.silk.theme.colors.palette.toPalette
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Div
import site.shadadman.SubheadlineTextStyle
import site.shadadman.components.layouts.PageLayoutData

val BackgroundGradientAnimation = Keyframes {
    0.percent { Modifier.styleModifier { backgroundPosition("0% 50%") } }
    50.percent { Modifier.styleModifier { backgroundPosition("100% 50%") } }
    100.percent { Modifier.styleModifier { backgroundPosition("0% 50%") } }
}

val AnimatedBackgroundStyle = CssStyle.base {
    val gradient = if (colorMode.isLight) {
        linearGradient(LinearGradient.Direction.ToRight) {
            add(Color.rgb(0xff9a9e))
            add(Color.rgb(0xfad0c4))
            add(Color.rgb(0xffd1ff))
            add(Color.rgb(0xa18cd1))
        }
    } else {
        linearGradient(LinearGradient.Direction.ToRight) {
            add(Color.rgb(0x0f0c29))
            add(Color.rgb(0x302b63))
            add(Color.rgb(0x24243e))
            add(Color.rgb(0x0f0c29))
        }
    }
    Modifier
        .fillMaxSize()
        .backgroundImage(gradient)
        .styleModifier {
            backgroundSize("400% 400%")
        }
        .animation(
            BackgroundGradientAnimation.toAnimation(
                duration = 15.s,
                iterationCount = AnimationIterationCount.Infinite,
                timingFunction = AnimationTimingFunction.EaseInOut,
            )
        )
}

val HeroImageStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .height(40.vh)
            .objectFit(ObjectFit.Cover)
            .opacity(0.3)
    }
    Breakpoint.MD {
        Modifier
            .fillMaxHeight()
            .width(40.vw)
            .height(100.percent)
            .opacity(0.4)
    }
}

val HeroContentStyle = CssStyle {
    base {
        Modifier
            .fillMaxWidth()
            .padding(2.cssRem)
            .zIndex(1)
    }
    Breakpoint.MD {
        Modifier
            .fillMaxHeight()
            .maxWidth(60.percent)
    }
}

val HeroTextStyle = CssStyle.base {
    Modifier
        .padding(2.cssRem)
        .borderRadius(1.cssRem)
        .backgroundColor(
            colorMode.toPalette().background.toRgb().copyf(alpha = 0.7f),
        )
        .backdropFilter(blur(4.px))
}


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

@OptIn(DelicateApi::class)
@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    val breakpoint = rememberBreakpoint()
    Box(AnimatedBackgroundStyle.toModifier()) {
        Image(
            "/me.jpeg",
            "Shad Adman",
            HeroImageStyle.toModifier()
                .align(if (breakpoint >= Breakpoint.MD) Alignment.CenterEnd else Alignment.TopCenter)
        )

        Column(
            HeroContentStyle.toModifier()
                .align(if (breakpoint >= Breakpoint.MD) Alignment.CenterStart else Alignment.BottomStart),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {
            Box(HeroTextStyle.toModifier()) {
                Div(SubheadlineTextStyle.toAttrs()) {
                    SpanText(
                        "I fell in love with coding when introduced to C++ during student years. I did a lot of work with Android & Kotlin Multiplatform. Currently in my free time I contribute to opensource. I love embedding low level languages with Kotlin & talking to hardware. A long background with onDevice AI using TFLite & PyTorch Mobile. I worked with HealthTech, Digital Retail, Trading & iGaming domains.",
                        Modifier
                            .fontSize(1.2.cssRem)
                            .lineHeight(1.6)
                            .textAlign(TextAlign.Justify)
                    )
                }
            }
        }
    }
}

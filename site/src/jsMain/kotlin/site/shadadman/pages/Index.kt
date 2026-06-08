package site.shadadman.pages

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.*
import com.varabyte.kobweb.compose.css.functions.linearGradient
import com.varabyte.kobweb.compose.css.functions.LinearGradient
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.graphics.Color
import com.varabyte.kobweb.compose.ui.graphics.Colors
import com.varabyte.kobweb.compose.ui.modifiers.*
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.core.data.add
import com.varabyte.kobweb.core.init.InitRoute
import com.varabyte.kobweb.core.init.InitRouteContext
import com.varabyte.kobweb.core.layout.Layout
import com.varabyte.kobweb.silk.style.CssStyle
import com.varabyte.kobweb.silk.style.animation.Keyframes
import com.varabyte.kobweb.silk.style.animation.toAnimation
import com.varabyte.kobweb.silk.style.base
import com.varabyte.kobweb.silk.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.style.toModifier
import com.varabyte.kobweb.silk.theme.colors.ColorMode
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.Source
import org.jetbrains.compose.web.dom.Video
import org.w3c.dom.HTMLVideoElement
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
        .borderRadius(1.cssRem)
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

val IntroVideoStyle = CssStyle {
    base {
        Modifier
            .width(110.percent)
            .minHeight(350.px)
            .borderRadius(1.cssRem)
            .cursor(Cursor.Pointer)
            .backgroundColor(Colors.Black)
            .objectFit(ObjectFit.Contain)
    }
    Breakpoint.MD {
        Modifier
            .width(90.percent)
            .minHeight(450.px)
            .borderRadius(2.cssRem)
    }
}

@InitRoute
fun initHomePage(ctx: InitRouteContext) {
    ctx.data.add(PageLayoutData("Home"))
}

@Page
@Layout(".components.layouts.PageLayout")
@Composable
fun HomePage() {
    Box(
        AnimatedBackgroundStyle.toModifier()
            .margin(top = (-4).cssRem, leftRight = (-1).cssRem) // Negate PageLayout padding
            .minHeight(100.vh),
        contentAlignment = Alignment.Center
    ) {
        Video(
            attrs = IntroVideoStyle.toModifier()
                .onClick { evt ->
                    val video = evt.target as HTMLVideoElement
                    if (video.paused) video.play() else video.pause()
                }
                .toAttrs {
                    // Standard attributes for autoplaying muted video
                    attr("autoplay", "")
                    attr("muted", "")
                    attr("playsinline", "")
                    ref { video ->
                        video.muted = false
                        video.autoplay = true
                        video.play().catch { /* browser blocked autoplay */ }
                        onDispose {}
                    }
                }
        ) {
            Source(
                attrs = Modifier.toAttrs {
                    attr("src", "/intro.mov")
                    attr("type", "video/mp4") // Most .mov files are mp4 compatible
                }
            )
            Source(
                attrs = Modifier.toAttrs {
                    attr("src", "/intro.mov")
                    attr("type", "video/quicktime")
                }
            )
        }
    }
}

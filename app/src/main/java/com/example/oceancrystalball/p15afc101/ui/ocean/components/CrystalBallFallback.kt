package com.example.oceancrystalball.p15afc101.ui.ocean.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.example.oceancrystalball.p15afc101.ui.theme.OceanColors

@Composable
fun CrystalBallFallback(
    rotationDegrees: Float,
    onRotationChange: (Float) -> Unit,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    val imageLoader = remember(context) {
        ImageLoader.Builder(context)
            .components { add(SvgDecoder.Factory()) }
            .build()
    }
    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(context)
            .data("file:///android_asset/ocean-crystal-ball.svg")
            .build(),
        imageLoader = imageLoader,
    )
    val drift = rememberInfiniteTransition(label = "ocean-drift")
    val bubbleOffset = drift.animateFloat(
        initialValue = 18f,
        targetValue = -18f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 6200, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse,
        ),
        label = "bubble-drift",
    )

    // design-style: design-surface crystal-ball-model
    Box(
        modifier = modifier
            .size(560.dp)
            .clip(RoundedCornerShape(280.dp))
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    onRotationChange(rotationDegrees + dragAmount.x * 0.18f)
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        BlueLightBeams(modifier = Modifier.fillMaxSize().alpha(0.55f))

        Image(
            painter = painter,
            contentDescription = "Transparent ocean world crystal ball with coral reef, tropical fish, turtle, glowing jellyfish, sea grass, shells, light beams and bubbles.",
            modifier = Modifier
                .size(width = 520.dp, height = 376.dp)
                .rotate(rotationDegrees * 0.08f),
            contentScale = ContentScale.Fit,
        )

        BubbleLayer(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = bubbleOffset.value.dp),
        )
    }
}

@Composable
private fun BlueLightBeams(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Top,
    ) {
        repeat(4) { index ->
            Box(
                modifier = Modifier
                    .size(width = (34 + index * 8).dp, height = 420.dp)
                    .rotate(-18f + index * 9f)
                    // design-style: design-surface bubble-a
                    .background(
                        Brush.verticalGradient(
                            listOf(
                                OceanColors.OceanGlow.copy(alpha = 0.34f),
                                OceanColors.DeepOcean.copy(alpha = 0f),
                            ),
                        ),
                    ),
            )
        }
    }
}

@Composable
private fun BubbleLayer(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        repeat(5) { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy((28 + row * 4).dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                repeat(3) { bubble ->
                    Box(
                        modifier = Modifier
                            .size((8 + ((row + bubble) % 3) * 6).dp)
                            .clip(CircleShape)
                            // design-style: design-surface bubble-b
                            .background(OceanColors.BubbleGlow.copy(alpha = 0.42f)),
                    )
                }
            }
        }
    }
}

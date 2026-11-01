package com.example.oceancrystalball.p15afc101.ui.ocean.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.oceancrystalball.p15afc101.ui.theme.OceanColors
import com.pico.spatial.ui.design.Button
import com.pico.spatial.ui.design.ButtonDefaults
import com.pico.spatial.ui.design.Chip
import com.pico.spatial.ui.design.Text
import com.pico.spatial.ui.foundation.material.backgroundMaterial
import com.pico.spatial.ui.platform.Material

@Composable
fun OceanInfoPanel(
    onResetView: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val panelShape = RoundedCornerShape(32.dp)

    Column(
        modifier = modifier
            .size(width = 300.dp, height = 392.dp)
            // design-style: attachment-material info-panel
            .clip(panelShape)
            .backgroundMaterial(
                enable = true,
                style = Material.Regular,
            )
            .padding(26.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            Text(
                text = "Ocean World Crystal Ball",
                fontSize = 24.sp,
                lineHeight = 32.sp,
                fontWeight = FontWeight.Bold,
                color = OceanColors.GlassHighlight,
            )
            Text(
                text = "A calming miniature reef sealed inside luminous glass.",
                fontSize = 15.sp,
                lineHeight = 22.sp,
                color = OceanColors.BubbleGlow,
            )
        }

        FlowRow(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            OceanChip("Coral reef")
            OceanChip("Sea turtle")
            OceanChip("Jellyfish glow")
            OceanChip("Soft bubbles")
        }

        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            HintText("Gently rotate the globe to inspect the reef from different sides.")
            HintText("Watch fish, bubbles and blue light beams move slowly for a healing display.")
            HintText("Use reset to return to the opening showcase pose.")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onResetView,
            modifier = Modifier.fillMaxWidth(),
            size = ButtonDefaults.Regular,
        ) {
            Text("Reset view")
        }
    }
}

@Composable
private fun OceanChip(label: String) {
    Chip(
        label = { Text(label, fontSize = 13.sp) },
        onClick = null,
    )
}

@Composable
private fun HintText(text: String) {
    Text(
        text = "• $text",
        fontSize = 13.sp,
        lineHeight = 19.sp,
        color = OceanColors.GlassHighlight,
    )
}

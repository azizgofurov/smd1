package uz.ttpu.composearchlab.ui.taste

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TastePickerBottomBar(
    likedCount: Int,
    required: Int,
    canContinue: Boolean,
    onContinueClick: () -> Unit,
    onSkipClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        shadowElevation = 8.dp,
        tonalElevation = 2.dp,
        modifier = modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier.size(48.dp)
                ) {
                    CircularProgressIndicator(
                        progress = { (likedCount.toFloat() / required).coerceAtMost(1f) },
                        modifier = Modifier.size(48.dp)
                    )
                    Text(
                        text = "$likedCount",
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = "Pick $required artists you like",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.weight(1f)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                TextButton(onClick = onSkipClick) {
                    Text("Later")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = onContinueClick,
                    enabled = canContinue
                ) {
                    Text("Continue")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TastePickerBottomBarZeroLikesPreview() {
    TastePickerBottomBar(
        likedCount = 0,
        required = 3,
        canContinue = false,
        onContinueClick = {},
        onSkipClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun TastePickerBottomBarTwoLikesPreview() {
    TastePickerBottomBar(
        likedCount = 2,
        required = 3,
        canContinue = false,
        onContinueClick = {},
        onSkipClick = {}
    )
}

@Preview(showBackground = true)
@Composable
fun TastePickerBottomBarThreeLikesPreview() {
    TastePickerBottomBar(
        likedCount = 3,
        required = 3,
        canContinue = true,
        onContinueClick = {},
        onSkipClick = {}
    )
}

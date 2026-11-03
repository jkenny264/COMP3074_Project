package ca.gbc.comp3074.kenny_john.comp3074_project
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun teamMember(name: String, role: String, image: Int) {
    Row(
        modifier = Modifier.padding(16.dp).fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = name + "'s Image"
        )

        Column(
            modifier = Modifier
                .padding(8.dp)
                .padding(8.dp)
        ) {
            Text(
                text = name,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = role,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun AboutScreen(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        MenuBar(modifier)

        Text(
            modifier = Modifier.fillMaxWidth().padding(top = 32.dp),
            text = "About Us",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp, top = 24.dp),
            text = "Our Team",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )
        teamMember("John Kenny", "Lead Developer", R.drawable.placeholder)
        teamMember("Derek Page", "Also Lead Developer", R.drawable.placeholder)

        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp, top = 24.dp),
            text = "Our Mission",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Text(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            text = stringResource(R.string.mission),
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    AboutScreen(modifier = Modifier)
}
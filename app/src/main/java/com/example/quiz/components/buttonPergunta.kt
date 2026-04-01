package com.example.quiz.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CheckboxDefaults.colors
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun BotaoDePergunta(
    value: String,
    selecionada: Boolean,
    correta: Boolean,
    resposta: String?,
    onClick: () -> Unit

) {
    OutlinedButton(
        onClick = { onClick() },
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = definirCorreta(selecionada, correta, resposta)
        ),
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(4.dp)
    ) {
        Text(
            text = value,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Start
        )
    }
}

fun definirCorreta(
    selecionada: Boolean,
    correta: Boolean,
    respostaSelecionada: String?
): Color {
    return when {
        // Se é a opção correta e a pergunta já foi respondida
        correta && respostaSelecionada != null -> Color.Green

        // Se é a opção selecionada e está errada
        selecionada && respostaSelecionada != null && !correta -> Color.Red

        // Caso contrário
        else -> Color.Transparent
    }
}

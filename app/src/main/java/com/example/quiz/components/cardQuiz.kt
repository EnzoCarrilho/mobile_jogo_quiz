package com.example.quiz.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.quiz.screens.quizScreen.QuizScreenViewModel

@Composable
fun cardQuiz(

    quizScreenViewModel: QuizScreenViewModel = viewModel()
) {

//    var respostaSelecionada by remember { mutableStateOf<String?>(null) }
//    val opcoes = listOf<String>("A", "B", "C", "D")
//    val correta = "C"

    val indice by quizScreenViewModel.indicePergunta.observeAsState(0)

    val respostaSelecionada by quizScreenViewModel.respostaSelecionada.observeAsState()

    val pergunta = quizScreenViewModel.perguntas[indice]

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),

        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = pergunta.textoPergunta
                )
            }

            Column(
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                pergunta.opcoes.forEach { opcao ->
                    BotaoDePergunta(
                        value = opcao,
                        selecionada = respostaSelecionada == opcao,
                        correta = opcao == pergunta.respostaCorreta,
                        resposta = respostaSelecionada,
                        onClick = {
                            quizScreenViewModel.selecionarResposta(opcao, pergunta.respostaCorreta)
                        }
                    )

                }
            }

        }





    }
}
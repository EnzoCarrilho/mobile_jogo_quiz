package com.example.quiz.screens.quizScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quiz.R
import com.example.quiz.components.cardQuiz

@Composable
fun quizScreen(
   navController: NavController,

    quizScreenViewModel: QuizScreenViewModel = viewModel()
) {
    val quizViewModel: QuizScreenViewModel = viewModel()

    val indice by quizScreenViewModel.indicePergunta.observeAsState(0)

    val pontuacao by quizScreenViewModel.pontuacao.observeAsState(0)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(234, 211, 172, 255))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "logo quiz",
                modifier = Modifier.size(80.dp)
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 60.dp)
                    .background(
                        Color(137, 189, 137, 255),
                        shape = RoundedCornerShape(6.dp)
                    )
                    .border(
                        width = 1.dp,
                        color = Color.Black,
                        shape = RoundedCornerShape(6.dp)
                    )
                    .height(38.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically

            ) {
                Text(
                    text = "Pergunta ${indice + 1} de 3",
                    modifier = Modifier
                        .padding(horizontal = 32.dp, vertical = 4.dp)

                )
            }


            cardQuiz(quizViewModel)

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = {

                        if (indice < 2) {
                            quizScreenViewModel.proximaPergunta(3)
                        } else {
                            navController.navigate("result/$pontuacao")
                        }
                    }
                ) {
                    if (indice < 2) {
                        Text("Próxima Pergunta")
                    } else {
                        Text("Finalizar Quiz")
                    }
                }
            }

        }

    }
}
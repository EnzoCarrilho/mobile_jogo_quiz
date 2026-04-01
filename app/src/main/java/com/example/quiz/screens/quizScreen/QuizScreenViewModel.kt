package com.example.quiz.screens.quizScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quiz.components.Pergunta

class QuizScreenViewModel: ViewModel() {

    private val _respostaSelecionadaState = MutableLiveData<String?>(null)
    private val _indicePerguntaState = MutableLiveData<Int>(0)
    private val _pontuacaoState = MutableLiveData<Int>(0)


    val indicePergunta: LiveData<Int> = _indicePerguntaState

    val respostaSelecionada: LiveData<String?> = _respostaSelecionadaState

    val pontuacao: LiveData<Int> = _pontuacaoState

    fun selecionarResposta(opcao: String, respostaCorreta: String) {
        if (_respostaSelecionadaState.value == null) {
            _respostaSelecionadaState.value = opcao

            if (opcao == respostaCorreta) {
                _pontuacaoState.value = (_pontuacaoState.value ?: 0) + 1
            }
        }
    }

    fun proximaPergunta(totalPerguntas: Int) {
        val atual = _indicePerguntaState.value ?: 0

        if (atual < totalPerguntas - 1) {
            _indicePerguntaState.value = atual + 1
            _respostaSelecionadaState.value = null
        }
    }


    val perguntas = listOf(
        Pergunta(
            "Qual a Capital da França?",
            listOf("Roma", "Paris", "Londres", "Tokio"),
            "Paris"
        ),
        Pergunta(
            "Onde se localiza Machu Picchu?",
            listOf("Peru", "Chile", "Argentina", "Colômbia"),
            "Peru"
        ),
        Pergunta(
            "Qual planeta é conhecido como planeta vermelho?",
            listOf("Júpiter", "Vênus", "Marte", "Mercurio"),
            "Marte"
        )
    )













}
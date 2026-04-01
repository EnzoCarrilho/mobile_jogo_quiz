package com.example.quiz.components

data class Pergunta(
    val textoPergunta:String,
    val opcoes: List<String>,
    val respostaCorreta: String
)
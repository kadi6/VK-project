package com.kadico.details.presentation.appdetails


sealed interface AppDetailsEvent {
    data object UnderDevelopment : AppDetailsEvent
}
package com.audronf.dndcompanion.ui.base

sealed class RequestStatus {
    object Finished : RequestStatus()
    object Loading : RequestStatus()
    object Failure : RequestStatus()
}

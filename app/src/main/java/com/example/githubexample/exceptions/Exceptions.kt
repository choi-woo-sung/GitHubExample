package com.example.githubexample.exceptions

class EmptyBodyException(message: String? = "") : Exception(message)

class NetworkFailureException(message: String? = "") : Exception(message)
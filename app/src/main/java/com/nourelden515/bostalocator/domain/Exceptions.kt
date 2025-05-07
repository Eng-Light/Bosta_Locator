package com.nourelden515.bostalocator.domain

open class LocatorException(message: String) : Exception(message)
open class NetworkException(message: String) : LocatorException(message)
class ServerException(message: String) : LocatorException(message)
class NotFoundException(message: String) : LocatorException(message)
class NoInternetException(message: String) : NetworkException(message)
class NullResultException(message: String) : LocatorException(message)
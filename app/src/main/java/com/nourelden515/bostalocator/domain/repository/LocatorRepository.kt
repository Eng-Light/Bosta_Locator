package com.nourelden515.bostalocator.domain.repository

import com.nourelden515.bostalocator.domain.NoInternetException
import com.nourelden515.bostalocator.domain.NotFoundException
import com.nourelden515.bostalocator.domain.NullResultException
import com.nourelden515.bostalocator.domain.ServerException
import com.nourelden515.bostalocator.domain.model.City
import org.json.JSONObject
import retrofit2.Response
import java.io.IOException
import java.net.UnknownHostException
import java.util.concurrent.TimeoutException

interface LocatorRepository {
    suspend fun getCities(
        countryId: String = "60e4482c7cb7d4bc4849c4d5"
    ): List<City>

    suspend fun <T> wrapApiResponse(
        function: suspend () -> Response<T>,
    ): T {
        try {
            val response = function()
            if (response.isSuccessful)
                return response.body() ?: throw NullResultException("No Data")
            else {
                val jObjError = JSONObject(
                    response.errorBody()!!.string()
                )
                val errorObject = jObjError["message"]
                throw when (response.code()) {
                    408 -> TimeoutException(errorObject.toString())
                    404 -> NotFoundException(errorObject.toString())
                    else -> {
                        ServerException(errorObject.toString())
                    }
                }
            }
        } catch (e: UnknownHostException) {
            throw NoInternetException(e.message.toString())
        } catch (e: TimeoutException) {
            throw NoInternetException(e.message.toString())
        } catch (e: IOException) {
            throw NoInternetException(e.message.toString())
        } catch (e: Exception) {
            throw ServerException(e.message.toString())
        }
    }
}
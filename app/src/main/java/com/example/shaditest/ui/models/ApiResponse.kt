package com.example.shaditest.ui.models
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class ApiResponse (
	@SerializedName("results") val results : List<Results>
	)
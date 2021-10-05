package com.example.calculator

import android.util.Log
import android.widget.Toast
import androidx.databinding.BaseObservable
import java.math.BigDecimal
import java.math.RoundingMode

private const val TAG = "CalculatorViewModel"

class CalculatorViewModel: BaseObservable(){
    private var inputFirst = ""
    private var inputSecond = ""
    private var inputThird = ""
    private var firstOperation: Operation? = null
    private var secondOperation: Operation? = null

    val showResult: String
    get() {
        return if (inputFirst.isEmpty()){
            "0"
        } else if(firstOperation != null && inputSecond.isEmpty()){
            inputFirst.NumberToString()
        } else if (firstOperation != null){
            inputSecond.NumberToString()
        }
        else if (secondOperation != null && inputThird.isEmpty()){
            inputSecond.NumberToString()
        }
        else if (secondOperation != null){
            inputThird.NumberToString()
        }
        else{
            inputFirst.NumberToString()
        }
    }

    val allClear: String
    get(){
        if (inputFirst.isBlank()){
            return "AC"
        }
        return "A"
    }

    fun onClickedNumber0(){
        Log.d(TAG, "onClickedNumber0: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "0"
        }
        else if(secondOperation != null){
            inputThird += "0"
        }
        else {
            inputFirst += "0"
        }

        notifyChange()
    }
    fun onClickedNumber1(){
        Log.d(TAG, "onClickedNumber1: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "1"
        }
        else if(secondOperation != null){
            inputThird += "1"
        }
        else {
            inputFirst += "1"
        }
        notifyChange()
    }
    fun onClickedNumber2(){
        Log.d(TAG, "onClickedNumber2: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "2"
        }
        else if(secondOperation != null){
            inputThird += "2"
        }
        else {
            inputFirst += "2"
        }
        notifyChange()
    }
    fun onClickedNumber3(){
        Log.d(TAG, "onClickedNumber3: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "3"
        }
        else if(secondOperation != null){
            inputThird += "3"
        }
        else {
            inputFirst += "3"
        }
        notifyChange()
    }
    fun onClickedNumber4(){
        Log.d(TAG, "onClickedNumber4: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "4"
        }
        else if(secondOperation != null){
            inputThird += "4"
        }
        else {
            inputFirst += "4"
        }
        notifyChange()
    }
    fun onClickedNumber5(){
        Log.d(TAG, "onClickedNumber5: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "5"
        }
        else if(secondOperation != null){
            inputThird += "5"
        }
        else {
            inputFirst += "5"
        }
        notifyChange()
    }
    fun onClickedNumber6(){
        Log.d(TAG, "onClickedNumber6: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "6"
        }
        else if(secondOperation != null){
            inputThird += "6"
        }
        else {
            inputFirst += "6"
        }
        notifyChange()
    }
    fun onClickedNumber7(){
        Log.d(TAG, "onClickedNumber7: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "7"
        }
        else if(secondOperation != null){
            inputThird += "7"
        }
        else {
            inputFirst += "7"
        }
        notifyChange()
    }
    fun onClickedNumber8(){
        Log.d(TAG, "onClickedNumber8: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "8"
        }
        else if(secondOperation != null){
            inputThird += "8"
        }
        else {
            inputFirst += "8"
        }
        notifyChange()
    }
    fun onClickedNumber9(){
        Log.d(TAG, "onClickedNumber9: ")
        if (firstOperation != null && secondOperation == null){
            inputSecond += "9"
        }
        else if(secondOperation != null){
            inputThird += "9"
        }
        else {
            inputFirst += "9"
        }
        notifyChange()
    }


    fun onClickedPlus(){
        Log.d(TAG, "onClickedPlus: ")
        var result = 0.0

        if (inputSecond.isNotBlank()){
            firstOperation?.let {
                result = when(it){
                    Operation.MULTIPLE ->{
                        inputFirst.toDouble() * inputSecond.toDouble()
                    }
                    Operation.DIVIDE ->{
                        inputFirst.toDouble() / inputSecond.toDouble()
                    }
                    Operation.MINUS ->{
                        inputFirst.toDouble() - inputSecond.toDouble()
                    }
                    Operation.PLUS ->{
                        inputFirst.toDouble() + inputSecond.toDouble()
                    }
                }
            }
            inputFirst = result.toString().NumberToString()
            inputSecond = ""
        }
        firstOperation = Operation.PLUS
        notifyChange()
    }
    fun onClickedMinus(){
        Log.d(TAG, "onClickedMinus: ")
        Log.d(TAG, "onClickedPlus: ")
        var result = 0.0
        if (inputSecond.isNotBlank()){
            firstOperation?.let {
                result = when(it){
                    Operation.MULTIPLE ->{
                        inputFirst.toDouble() * inputSecond.toDouble()
                    }
                    Operation.DIVIDE ->{
                        inputFirst.toDouble() / inputSecond.toDouble()
                    }
                    Operation.MINUS ->{
                        inputFirst.toDouble() - inputSecond.toDouble()
                    }
                    Operation.PLUS ->{
                        inputFirst.toDouble() + inputSecond.toDouble()
                    }
                }
            }
            inputFirst = result.toString().NumberToString()
            inputSecond = ""
        }

        firstOperation = Operation.MINUS
        notifyChange()
    }
    fun onClickedDivide(){
        if (inputSecond.isNotBlank() && (firstOperation != Operation.PLUS && firstOperation != Operation.MINUS) && secondOperation == null){
            val result = inputFirst.toDouble() / inputSecond.toDouble()
            inputFirst = result.toString().NumberToString()
            inputSecond = ""
            firstOperation = Operation.DIVIDE
            Log.d(TAG, "onClickedDivide: 1")
        }
        else if(inputSecond.isNotBlank() && (firstOperation == Operation.PLUS || firstOperation == Operation.MINUS) && secondOperation == null){
            secondOperation = Operation.DIVIDE
            Log.d(TAG, "onClickedDivide: 2")
        }
        else if(inputThird.isNotEmpty()){
            Log.d(TAG, "onClickedDivide: 3")
            calculate()
            secondOperation = null
            firstOperation = Operation.DIVIDE
        }
        else if (inputFirst.isNotEmpty()){
            Log.d(TAG, "onClickedDivide: 4")
            firstOperation = Operation.DIVIDE
        }
        notifyChange()
    }
    fun onClickedMultiply(){
        if (inputSecond.isNotBlank() && (firstOperation != Operation.PLUS && firstOperation != Operation.MINUS) && secondOperation == null){
            val result = inputFirst.toDouble() * inputSecond.toDouble()
            inputFirst = result.toString().NumberToString()
            inputSecond = ""
            firstOperation = Operation.MULTIPLE
            Log.d(TAG, "onClickedDivide: 1")
        }
        else if(inputSecond.isNotBlank() && (firstOperation == Operation.PLUS || firstOperation == Operation.MINUS) && secondOperation == null){
            secondOperation = Operation.MULTIPLE
            Log.d(TAG, "onClickedDivide: 2")
        }
        else if(inputThird.isNotEmpty()){
            Log.d(TAG, "onClickedDivide: 3")
            calculate()
            secondOperation = null
            firstOperation = Operation.MULTIPLE
        }
        else if (inputFirst.isNotEmpty()){
            Log.d(TAG, "onClickedDivide: 4")
            firstOperation = Operation.MULTIPLE
        }
        notifyChange()
    }


    fun onClickedAllClear(){

        if (firstOperation != null && secondOperation == null){
            if (inputSecond.isBlank()){
                firstOperation = null
            }
            inputSecond = ""
        }
        else if (secondOperation != null){
            if (inputThird.isBlank()){
                secondOperation == null
            }
            inputThird = ""
        }
        else{
            inputFirst = ""
        }
        notifyChange()
    }
    fun onClickedPercent(){
        Log.d(TAG, "onClickedMod: ")

        if (firstOperation != null && secondOperation == null){
            inputSecond = (inputSecond.toDouble() / 100).toString().NumberToString()
        }
        else if (secondOperation != null){
            inputThird = (inputThird.toDouble() / 100).toString().NumberToString()
        }
        else{
            inputFirst = (inputFirst.toDouble() / 100).toString().NumberToString()
        }
        notifyChange()
    }
    fun onClickedOnNegative(){
        when {
            secondOperation != null && secondOperation == null -> {
                inputSecond = (inputSecond.toDouble() * (-1)).toString().NumberToString()
            }
            secondOperation != null -> {
                inputThird = (inputThird.toDouble() * (-1)).toString().NumberToString()
            }
            else -> {
                inputFirst = (inputFirst.toDouble() * (-1)).toString().NumberToString()
            }
        }
        notifyChange()
    }
    fun onClickedComma(){
        when {
            firstOperation != null && secondOperation == null -> {
                if (inputSecond.isBlank()){
                    inputSecond +="0."
                }
                else{
                    inputSecond +="."
                }
            }
            secondOperation != null -> {
                if (inputThird.isBlank()){
                    inputThird +="0."
                }
                else{
                    inputThird +="."
                }
            }
            else -> {
                if (inputFirst.isBlank()){
                    inputFirst +="0."
                }
                else{
                    inputFirst +="."
                }
            }
        }

        notifyChange()
    }


    fun onClickedEqual(){
        calculate()
        notifyChange()
    }


    private fun calculate(){
        var result = 0.0
        secondOperation?.let {
            when(it){
                Operation.MULTIPLE ->{
                    result = inputSecond.toDouble() * inputThird.toDouble()
                }
                Operation.DIVIDE ->{
                    result = inputSecond.toDouble() / inputThird.toDouble()
                }
            }
        }
        if (secondOperation == null){
            result = inputSecond.toDouble()
        }
        firstOperation?.let {
            when(it){
                Operation.MINUS -> {
                    inputFirst = (inputFirst.toDouble() - result.toDouble()).toString().NumberToString()
                }
                Operation.PLUS -> {
                    inputFirst = (inputFirst.toDouble() + result.toDouble()).toString().NumberToString()
                }
                Operation.DIVIDE -> {
                    inputFirst = (inputFirst.toDouble() / result.toDouble()).toString().NumberToString()
                    Log.d(TAG, "calculate: DIVIDE")
                }
                Operation.MULTIPLE -> {
                    inputFirst = (inputFirst.toDouble() * result.toDouble()).toString().NumberToString()
                    Log.d(TAG, "calculate: MULTIPLE")
                }
            }
        }

        inputSecond = ""
        inputThird = ""
        firstOperation = null
        secondOperation = null
    }

    fun String.NumberToString() : String{
        val r = this.toDouble()
        val n = BigDecimal(r).setScale(2, RoundingMode.HALF_EVEN)
        if (this.length>9){
            return "0"
        }
        var s = n.toString()
        if (s[s.length-2] == '0'){
            s = s.substring(0,s.length-3)
        }
        return s
    }
}

enum class Operation{
    MINUS, PLUS, DIVIDE, MULTIPLE
}
package com.swensonhe.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        isAnagrams("Keep", "PeEk")
//        isAnagrams("Mother In Law", "Hitler Woman")
//        isAnagrams("Race", "C a r e")
//        isAnagrams("SiLeNt CAT", "LisTen AcT");
//        isAnagrams("Debit Card", "Bad Credit");
//        isAnagrams("School MASTER", "The ClassROOM");
//        isAnagrams("DORMITORY", "Dirty Room");
//        isAnagrams("ASTRONOMERS", "NO MORE STARS");
//        isAnagrams("Toss", "Shot");
//        isAnagrams("joy", "enjoy");

        println(recursiveFibonacci(1))
        println(recursiveFibonacci(2))
        println(recursiveFibonacci(3))
        println(recursiveFibonacci(4))
        println(recursiveFibonacci(5))
        println(recursiveFibonacci(6))
        println(recursiveFibonacci(7))
        println(recursiveFibonacci(8))
        println(recursiveFibonacci(9))
        println(recursiveFibonacci(20))
        println(recursiveFibonacci(50))
    }

    private fun isAnagrams(firstString: String, secondString: String): Boolean {
        println("$firstString and $secondString")
        val arr1 = firstString.replace("\\s".toRegex(), "")
                .toLowerCase(Locale.getDefault()).toCharArray()
        val arr2 = secondString.replace("\\s".toRegex(), "")
                .toLowerCase(Locale.getDefault()).toCharArray()

        if (arr1.size != arr2.size) {
            println("Not Anagrams")
            return false
        }

        Arrays.sort(arr1)
        Arrays.sort(arr2)

        return if (arr1.contentEquals(arr2)) {
            println("They are Anagrams")
            true
        } else {
            println("Not Anagrams")
            true
        }
    }

    private fun iterativeFibonacci(nIndex: Int): Long {
        if (nIndex <= 2) {
            return 1
        }

        var result: Long = 1
        var previousNumber: Long = 1
        var previousResult: Long = 0

        for (i in 3..nIndex) {
            previousResult = result

            result += previousNumber
            previousNumber = previousResult
        }

        return result
    }

    private fun recursiveFibonacci(n: Long): Long =
            if (n < 2) n else recursiveFibonacci(n - 1) + recursiveFibonacci(n - 2)
}
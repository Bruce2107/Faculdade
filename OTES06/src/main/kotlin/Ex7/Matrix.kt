package Ex7

import kotlin.math.roundToInt

open class Matrix(private val order: Int) {
    private var matrix = Array(order) { Array(order) { 0 } }

    fun setMatrix() {
        matrix = Array(order) { Array(order) { (Math.random() * 100).roundToInt() } }
    }

    open fun getMatrix(): Array<Array<Int>> {
        return matrix;
    }

    fun getOrder(): Int {
        return order
    }

    fun getDiagonalSup(): Array<Array<Int>> {
        val diagonalSup = getMatrix()
        for ((i, v) in matrix.withIndex()) {
            for((j,b) in v.withIndex()) {
                when {
                    i <= j -> continue
                    else -> diagonalSup[i][j] = -1
                }
            }
        }
        return diagonalSup
    }

    fun getDiagonalInf(): Array<Array<Int>> {
        val diagonalInf = getMatrix()
        for ((i, v) in matrix.withIndex()) {
            for((j,b) in v.withIndex()) {
                when {
                    i > j -> continue
                    else -> diagonalInf[i][j] = -1
                }
            }
        }
        return diagonalInf
    }
}
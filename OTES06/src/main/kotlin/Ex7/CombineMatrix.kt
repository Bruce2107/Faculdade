package Ex7

class CombineMatrix(private val matrixA: Matrix, private val matrixB: Matrix) : Matrix(matrixB.getOrder()) {
    private var matrix = Array(matrixA.getOrder()) { Array(matrixA.getOrder()) { 0 } }

    override fun getMatrix(): Array<Array<Int>> {
        combine()
        return matrix
    }

    private fun combine() {
        val valuesA = matrixA.getDiagonalSup()
        val valuesB = matrixB.getDiagonalInf()

        Array(matrixA.getOrder()) { i ->
            Array(matrixA.getOrder()) { j ->
                when {
                    i <= j -> matrix[i][j] = valuesA[i][j]
                    else -> matrix[i][j] = valuesB[i][j]
                }
            }
        }
    }
}
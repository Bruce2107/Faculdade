package Ex7

//class App {
fun main() {
    val matrixA = Matrix(4)
    matrixA.setMatrix()
    val matrixB = Matrix(4)
    matrixB.setMatrix()

    val matrixC = CombineMatrix(matrixA, matrixB)
    println("Matrix A")
    for (i in matrixA.getMatrix()) {
        println(i.contentToString())
    }
    println("Matrix B")
    for (i in matrixB.getMatrix()) {
        println(i.contentToString())
    }
    println("Matrix C")
    for (i in matrixC.getMatrix()) {
        println(i.contentToString())
    }

    println("Matrix C Sup")
    for (i in matrixC.getDiagonalSup()) {
        println(i.contentToString())
    }
}
//}
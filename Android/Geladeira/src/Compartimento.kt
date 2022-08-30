
abstract class Compartimento {
  private val lateinit Target targetControle
  abstract fun controleTemperatura() {
  
  }
  fun setTarget(target: Target) {
    this.targetControle = target
  }
}


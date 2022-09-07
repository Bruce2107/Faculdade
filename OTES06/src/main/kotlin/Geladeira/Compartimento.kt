abstract class Compartimento {
    protected abstract var targetControle: Target
    abstract fun controleTemperatura()

    fun setTarget(target: Target) {
        this.targetControle = target
    }
}


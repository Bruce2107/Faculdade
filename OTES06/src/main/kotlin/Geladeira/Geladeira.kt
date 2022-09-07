class Geladeira(list: ArrayList<Compartimento>) {
    private val compartimentos: ArrayList<Compartimento> = list
    fun cotroleTemperatura() {
        compartimentos.forEach {
            it.controleTemperatura()
        }
    }

    fun escolherTemperatura(target: Target) {
        compartimentos.forEach{
            it.setTarget(target)
        }
    }

}
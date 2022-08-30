

class Geladeira {
  private val compartimentos: ArrayList<Compartimento> = []
  fun cotroleTemperatura(){
    for(Compartimento c : compartimentos) {
      c.controleTemperatura()
    }
  }
  fun escolherTemperatura(target: Target){
    for(Compartimento c : compartimentos) {
      c.setTarget(target)
    }
  }

}
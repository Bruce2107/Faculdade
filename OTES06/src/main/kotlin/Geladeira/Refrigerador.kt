

class Refrigerador : Compartimento() {
  private val lateinit Sensor sensor

  override fun controleTemperatura() {
    if(sensor.getTemperaturaAtual() > this.targetControle) {

    }
  }
}
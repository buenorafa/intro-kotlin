/*
//////////////////////////
Leia o escopo do main para entender o que deverá ser feito na atividade;
//////////////////////////
*/

val materiasENotas = mutableMapOf<String, MutableList<Double>>()

/**
 * Adiciona uma disciplina no dicionário mutável,
 * Recebe um array de notas (opcional)
 * Retorna true se conseguiu, false se não.
 */
fun adicionarDisciplina(materia: String, notas: MutableList<Double> = mutableListOf()): Boolean {
    return materiasENotas.put(materia, notas) != null
}

/**
 * Adiciona uma nota à lista de notas de uma determinada matéria;
 * Retorna true se conseguiu adicionar, false se não conseguiu.
 */
fun adicionarNota(materia: String, nota: Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        notasDaMateria.add(nota)
        true
    } else {
        false
    }
}


/**
 *Mostra na tela todas as notas presentes em uma matéria, no seguinte formato:
 * Materia: {nome da materia}
 * Nota 1: 5.4 \n
 * Nota 2: 7.8 \n
 * ...
 * Nota n: 10.0 \n
 * \n
 * Média:  {5.4 + 7.8 + ... + 10.0 / n} \n [TO DO <////////]
 * \n
 * 
 * Caso não encontre a materia no map, mostre:
 * Materia {nome da materia} não encontrada \n
 * 
 * Caso não seja possível mostar as notas, mostre:
 * Não foi possível mostrar as notas da matéria {nome da materia} \n
 */
fun mostrarNotas(materia:String){

    if(!materiasENotas.containsKey(materia)){
        println("Materia $materia não encontrada")
    }
    else{
        val listaNotas = materiasENotas[materia]

        if (listaNotas != null) {
            var cont = 1
            var media = calcularMedia(listaNotas)
            println("Notas de $materia")
            println()
            for(nota:Double in listaNotas){
                println("Nota ${cont++}: $nota")
            }
            println()
            println("Média: $media")
            println()
        }
        else{
            println("Não foi possível mostrar as notas da matéria ${materia}")
        }
    }


}

/*Retorna a média obtida apartir de uma lista de notas */
fun calcularMedia(notas: List<Double>): Double{
    return  notas.sum() / notas.size
}


/**
 *Adiciona várias notas de uma só vez em uma matéria
 * retorne true se conseguiu adicionar, false se não consegiu.
 * */
fun adicionarVariasNotas(materia:String, vararg nota:Double): Boolean {
    val notasDaMateria = materiasENotas[materia]

    return if (notasDaMateria != null) {
        for(n in nota) {
            notasDaMateria.add(n)
        }
        true

    } else {
        false
    }
}




fun main(){
    // 1. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição possicional
    adicionarDisciplina("PDM", mutableListOf(10.0))

    // 2. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, através de atribuição nomeada
    adicionarDisciplina(materia="PWEB2", notas = mutableListOf(10.0))

    // 3. adicionarDisciplinas -> altere a função adicionarDisciplinas para que o parametro notas possua um valor padrão. Dica: utilize mutableListOf()
    //  Valor padrão vazio, para que seja possível adicionar discplina sem atribuir valor

    // 4. adicionarDisciplinas -> adicione 1 disciplina ao map materiasENotas, sem atribuir valores a notas
    adicionarDisciplina(materia = "Padrões de Projeto")
    
    // 5. adicionarNota -> adicione 3 notas para as 3 disciplinas
    adicionarVariasNotas("PDM", 10.00, 10.00, 10.00)
    adicionarVariasNotas("PWEB2", 10.00, 10.00, 10.00)
    adicionarVariasNotas("Padrões de Projeto", 10.00, 10.00, 10.00)
    
    // 6. mostrarNotas -> Mostre as notas das 3 disciplinas
    mostrarNotas("PDM")
    mostrarNotas("PWEB2")
    mostrarNotas("Padrões de Projeto")

    // 7. adicionarDisciplina -> adicione mais 1 disciplina
    adicionarDisciplina("Comércio Eletrônico")
    
    // 8. adicionarVariasNotas -> implemente o metodo adicionarVariasNotas();
    // ok
    // 9. adicionarVariasNotas -> adicione 3 notas para a disciplina que você acabou de criar
    adicionarVariasNotas("Comércio Eletrônico", 10.00, 10.0, 10.000)
    // 10. mostrarNotas -> mostre as notas da disciplina que você acabou de criar;
    mostrarNotas("Comércio Eletrônico")
    
    // Bônus: (Não vai ganhar nada, ou melhor mais ganhar mais conhecimento >:O)
    // Todas abaixo já foram feitas acima

    // 11: calcularMedia -> Implemente a função calcularMedia()

    // 12: calcularMedia -> calcule a media de 2 disciplinas

    // 13: mostrarNotas -> altere o mostrarNotas() para que ele mostre também a media das disciplinas
    
    // 14: mostrarNotas -> mostre as notas de 1 disciplina 

}
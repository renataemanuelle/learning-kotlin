fun main(args: Array<String>) {

    //Variaveis
    var nome = "Betty"
    var nome2 = "O meu também é Betty"
    var idade: Int = 57
    var aniversario: Boolean = true

    //Variaveis mutaveis
    var nome3 = "Renata"
    nome3 = "Renata Emanuelle"

    //Variaveis imutaveis
    val idade2 = 33
    // val y -- não dá pra inicializar sem atribuição ou definição de tipo
    val x:Int // é possível inicializar apenas com atribuição de tipo


    //Strings
    val frase = "Kotlin é uma linguagem"
    val caracteristica = "show!"

    val frasegrande = """posso escrever
        |um monte de coisa aqui
        |que o kotlin entende
        |como um texto grandao
        |lendo cada linha
        |como um paragrafo
    """.trimMargin()


    //Operador ternário"
    val valor = 10
    val str = if (valor == 10) "Sim" else "Não"


    //Operador Elvis ?:
    val test: Int? = null // "?" quer dizer que a variável pode ser nula
    val op: Int = test ?: 100 //se test for nula, use 100, senão use valor de test

    //Conceito nullSafe
    val str2: String? = "dgggggfg"
    str2?.length // "?" serve para indicar que o programa vai tratar o caso da variável ser nula
    // é o equivalente a if(str2 != null) ...
    //println(str2!!.length)  // "!!" indica que o programa não deve tratar o caso aqui - pode ser lançada exceçao de nullpointer

    //Função com parametro default
    endereco("", "", 20) //padrão
    endereco(cidade = "Rio de Janeiro") // não precisa usar todos os parametros
    endereco(numero = 19, cidade = "Rio de Janeiro") // é possível fazer chamadas fora de ordem, usando o nome dos parmetros


    //Saídas
    println("Olá mundo!")
    println("$frase $caracteristica")
    println("\n---Frase Grande---")
    println(frasegrande)
    println("\n---Chamar função---")
    println("O bonus é " + calculabonus(10, 20, 30))
    println("\n---Função de uma linha---")
    println(hello("Cayo"))
    println("\n---Retorno de boolean---")
    println("27: " +maiorDeIdade(27) + "; 10: " + maiorDeIdade(10))
    println("\n---Operador elvis---")
    println(op)
    println("\n---Null safe---")
    println(str2?.length)
    println("\n---Vararg---")
    media(10f, 8f)
    media(1f, 5f, 2f, 7f)
    println("\n---Vararg generic---")
    qualquerCoisa("Renata", 33, true, 18.5f)


}

fun calculabonus (a: Int, b:Int, c: Int) : Int {
    return a+b+c
}

//função de uma única linha
fun hello (nome: String) = "Olá, $nome"

//retorno de boolean
fun maiorDeIdade(idade: Int): Boolean {
    return idade >= 18
}

//atribuição de variável com if
fun calculaBonusSalario (cargo: String, salario: Float) : Float {
    val bonus: Float = if (cargo == "Coordenador") {  // : Float é opcional
        salario*1.2f
    } else if (cargo == "Gerente Junior") {
        salario*1.5f
    } else {
        salario*2
    }
    return bonus  // é possível usar return if... sem a atribuição de bonus
}

//fluxo when
fun operacao (a: Int, b: Int, c: String) : Int {
    when (c) { // é possível fazer o retorno direto no when
        "soma" -> return a+b
        "subtracao" -> return a-b
        else -> return 0
    }
}

//when com range (intervalo de valores : ..)
fun testaNumero (a: Int) : String {
    return when {
        a in 0..100 -> "Entre 0 e 100"
        else -> "Fora do intervalo 0 a 100"
    }
}

//for
fun loop () {
    for (i in 1..100 step 2) { // step: pula a quantidade definida
    }

    for (i in 100 downTo 0) { // conta do maior pro menor
    }
}

//parametros default - caso o usuário não passe o valor
fun endereco (rua: String = "", cidade: String, numero: Int = 0) {
}


//n parametros - vararg
fun media (vararg notas : Float) {
    //notas é uma lista de valores
    if (notas.isNotEmpty()) {
        var soma = 0f
        for (nota in notas) {
            soma += nota
        }
        println("A media é: ${soma/notas.size}")
    }
}

//n parametros generic
fun <T> qualquerCoisa (vararg coisas: T) {
    for (coisa in coisas) {
        println(coisa)
    }
}
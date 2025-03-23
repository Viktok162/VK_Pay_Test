import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun calcCom_1_1() {
        val amount: Int = 15000              //сумма перевода
        val source: String = "client"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_1_2() {
        val amount: Int = 15002              //сумма перевода
        val source: String = "client"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }

    @Test
    fun calcCom_2_1_1() {
        val amount: Int = 500              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_2_1_2() {
        val amount: Int = 150_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_2_2_1() {
        val amount: Int = 500              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_2_2_2() {
        val amount: Int = 150_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_2_3_1() {
        val amount: Int = 500              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_2_3_2() {
        val amount: Int = 150_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_2_4_1() {
        val amount: Int = 150              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_2_4_2() {
        val amount: Int = 150_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }

    @Test
    fun calcCom_3_1_1() {
        val amount: Int = 150_001          //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_3_1_2() {
        val amount: Int = 3000              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_3_1_3() {
        val amount: Int = 200              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(21, result)
    }
    @Test
    fun calcCom_3_2_1() {
        val amount: Int = 175_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_3_2_2() {
        val amount: Int = 301              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_3_2_3() {
        val amount: Int = 1              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(20, result)
    }
    @Test
    fun calcCom_3_3_1() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_3_3_2() {
        val amount: Int = 15_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(112, result)
    }
    @Test
    fun calcCom_3_3_3() {
        val amount: Int = 155              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(35, result)
    }
    @Test
    fun calcCom_3_4_1() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_3_4_2() {
        val amount: Int = 55_001              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(412, result)
    }
    @Test
    fun calcCom_3_4_3() {
        val amount: Int = 155              //сумма перевода
        val source: String = "card"       // исходная точка платежа
        val destination: String = "seller" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(35, result)
    }

    @Test
    fun calcCom_4_1_1() {
        val amount: Int = 15_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_4_1_2() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Master"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_4_2_1() {
        val amount: Int = 15_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_4_2_2() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Maestro"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_4_3_1() {
        val amount: Int = 15_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_4_3_2() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Visa"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
    @Test
    fun calcCom_4_4_1() {
        val amount: Int = 15_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_4_4_2() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }

    @Test
    fun calcCom_5_1() {
        val amount: Int = 155_001              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "client" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_5_2() {
        val amount: Int = 155              //сумма перевода
        val source: String = "seller"       // исходная точка платежа
        val destination: String = "anyUser" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }


    @Test
    fun calcCom_6_1() {
        val amount: Int = 155              //сумма перевода
        val source: String = "client"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(0, result)
    }
    @Test
    fun calcCom_6_2() {
        val amount: Int = 15001              //сумма перевода
        val source: String = "client"       // исходная точка платежа
        val destination: String = "card" // конечная точка платежа
        val typeCard: String = "Мир"     // тип карты: Master, Maestro, Visa, Мир

        val result = calculationCommission(amount, source, destination, typeCard)
        assertEquals(-1, result)
    }
}
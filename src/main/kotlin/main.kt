fun main() {
    val amount: Int = 299              //сумма перевода
    val source: String = "card"        // исходная точка платежа
    val destination: String = "seller" // конечная точка платежа
    val typeCard: String = "Master"    // тип карты: Master, Maestro, Visa, Мир
    /* Возможные варианты значений переменных (source, destination): client, anyUser, seller, card.
    Возможные сочетания переменных при вызове функции:
    1) card - client;
    2) client - card;
    3) client - seller;
    4) card - seller;
    5) seller - card;
    6) client - anyUser.     */

    val commission = calculationCommission(amount, source, destination, typeCard)
    if (commission < 0) println("Перевод отклонен, превышен лимит операций.")
    else println("Комиссия составляет $commission руб.")
}

fun calculationCommission(sum: Int, start: String, finish: String, typeCard: String): Int {
    
    val taxCardRate1 = 0.6  // ставка комиссии за перевод средств с карт Master, Maestro
    val taxCardFee1 = 20    // комиссия за перевод средств с карт Master, Maestro
    val taxCardRate2 = 0.75 // ставка комиссии за перевод средств с карт
    val taxCardFee2 = 35    // комиссия за перевод средств с карт
    val timeLimit = 15_000         // лимит перевода со счета VK Pay за один раз
    val monthLimitRemain = 40_000  // остаток лимита перевода со счета VK Pay в месяц
    val cardMonthLimitRemainMaster = 600_000  // остаток лимита перевода с карты Master в месяц
    val cardMonthLimitRemainMaestro = 600_000 // остаток лимита перевода с карты Maestro в месяц
    val cardMonthLimitRemainVisa = 600_000    // остаток лимита перевода с карты Visa в месяц
    val cardMonthLimitRemainMir = 600_000     // остаток лимита перевода с карты Мир в месяц
    val cardDayLimitRemainMaster = 150_000    // остаток лимита перевода с карты Master в день
    val cardDayLimitRemainMaestro = 150_000   // остаток лимита перевода с карты Maestro в день
    val cardDayLimitRemainVisa = 150_000      // остаток лимита перевода с карты Visa в день
    val cardDayLimitRemainMir = 150_000       // остаток лимита перевода с карты Мир в день

    when (start) {
        "client" -> if (sum <= monthLimitRemain && sum <= timeLimit)
            return 0
            else return -1

        "card" -> if (finish == "client") {
            when (typeCard) {
                "Master" -> if (sum <= cardMonthLimitRemainMaster && sum <= cardDayLimitRemainMaster)
                    return 0
                    else return -1
                "Maestro" -> if (sum <= cardMonthLimitRemainMaestro && sum <= cardDayLimitRemainMaestro)
                    return 0
                    else return -1
                "Visa" -> if (sum <= cardMonthLimitRemainVisa && sum <= cardDayLimitRemainVisa)
                    return 0
                    else return -1
                "Мир" -> if (sum <= cardMonthLimitRemainVisa && sum <= cardDayLimitRemainVisa)
                    return 0
                    else return -1
            }
        } else if (finish == "seller") {
            when (typeCard) {
                "Master" -> if (sum > cardMonthLimitRemainMaster || sum > cardDayLimitRemainMaster)
                    return -1
                    else if (sum in 300..75000)
                        return 0
                        else return (sum * taxCardRate1 / 100 + taxCardFee1).toInt()

                "Maestro" -> if (sum > cardMonthLimitRemainMaestro || sum > cardDayLimitRemainMaestro)
                    return -1
                    else if (sum in 300..75000)
                        return 0
                        else return (sum * taxCardRate1 / 100 + taxCardFee1).toInt()

                "Visa" -> if (sum > cardMonthLimitRemainVisa || sum > cardDayLimitRemainVisa)
                    return -1
                    else if (sum * taxCardRate2 / 100 > taxCardFee2)
                        return (sum * taxCardRate2 / 100).toInt()
                        else return taxCardFee2

                "Мир" -> if (sum > cardMonthLimitRemainMir || sum > cardDayLimitRemainMir)
                    return -1
                    else if (sum * taxCardRate2 / 100 > taxCardFee2)
                        return (sum * taxCardRate2 / 100).toInt()
                        else return taxCardFee2
            }
        }

        "seller" -> if (finish == "client") return 0 //println("Комиссия составляет 0 руб.")
            else if (finish == "card") {
                when (typeCard) {
                    "Master" -> if (sum <= cardMonthLimitRemainMaster && sum <= cardDayLimitRemainMaster)
                        return 0
                        else return -1
                    "Maestro" -> if (sum <= cardMonthLimitRemainMaestro && sum <= cardDayLimitRemainMaestro)
                        return 0
                        else return -1
                    "Visa" -> if (sum <= cardMonthLimitRemainVisa && sum <= cardDayLimitRemainVisa)
                        return 0
                        else return -1
                    "Мир" -> if (sum <= cardMonthLimitRemainMir && sum <= cardDayLimitRemainMir)
                        return 0
                        else return -1
                }
            }
    }
    return 0
}
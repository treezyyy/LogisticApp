package com.example.logisticapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.yoomoney.sdk.kassa.payments.Checkout.createTokenizeIntent
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.Amount
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentMethodType
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.PaymentParameters
import ru.yoomoney.sdk.kassa.payments.checkoutParameters.SavePaymentMethod
import java.math.BigDecimal
import java.util.Currency

class FinansisWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.finas_window)
    }
    fun startTokenize() {
        val paymentParameters = PaymentParameters(
                amount = Amount(BigDecimal.TEN, Currency.getInstance("RUB")),
                title = "Название товара",
                subtitle = "Описание товара",
                clientApplicationKey = "live_thisKeyIsNotReal", // ключ для клиентских приложений из личного кабинета ЮKassa
                shopId = "12345", // идентификатор магазина ЮKassa
                savePaymentMethod = SavePaymentMethod.OFF, // флаг выключенного сохранения платежного метода,
                paymentMethodTypes = setOf(PaymentMethodType.YOO_MONEY, PaymentMethodType.BANK_CARD, PaymentMethodType.SBERBANK), // передан весь список доступных методов оплаты
                customReturnUrl = "https://custom.redirect.url", // url страницы (поддерживается только https), на которую надо вернуться после прохождения 3ds.
                userPhoneNumber = "+79041234567", // номер телефона пользователя для автозаполнения поля номера телефона пользователя в SberPay. Поддерживаемый формат данных: "+7XXXXXXXXXX"
                authCenterClientId = "example_authCenterClientId" // идентификатор, полученный при регистрации приложения на сайте https://yookassa.ru
        )
        val intent = createTokenizeIntent(this, paymentParameters)
    //    startActivityForResult(intent, REQUEST_CODE_TOKENIZE)
    }
}
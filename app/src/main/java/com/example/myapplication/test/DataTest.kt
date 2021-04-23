package com.example.myapplication.test

import com.example.myapplication.dataClass.DataComments
import com.example.myapplication.dataClass.DataProduct


class DataTest {

    companion object {

        fun setDataRecycleCategory() = listOf(
            "لوازم خانگی",
            "لوازم ورزشی",
            "لوازم آرایشی",
            "پوشاک",
            "لوزام دیجیتال",
            "لوازم سفر",
            "لوازم آشپزخانه"
        )

        fun getDataComments(): List<DataComments> {
            val array = arrayListOf<DataComments>()

            for (item in 1..8) {
                array.add(
                    DataComments(
                        item,
                        "حسن باقری",
                        "واقعا کالای با کیفیتی است"

                    )
                )
            }
            return array
        }

        fun getDataProduct() =
            DataProduct(
                "1",
                "هنذفری بلوتوث",
                "http://hasanlo.ir/android/shop/img/newproduct/17.jpg",
                "185000",
                "true",
                "180000",
                "3.5",
                "شرکت های مختلفی در سطح جهان شروع به ساخت کالاهای متفاوت با نام و نشان های متفاوتی کرده اند که در این میان نام شرکت ها پر اوازه ایرانی نیز به گوش میرسد. در میان این همه برند خارجی و با کیفیت چه خوب است که گهگداری سری به برند های ایرانی و کارهایی که دست سازه های هنرمندان ایرانی به حساب می آید نیز رفته و آن ها را نیز نظاره کنیم. به راستی که چه زیباست اگر به جای تعریف از دیگری، خودمان تعریفی شویم.",
                "new_prodect"
            )
    }

}


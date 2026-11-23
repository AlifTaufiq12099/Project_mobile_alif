package com.example.aliftaufiq_3tib.data

import java.util.Locale

fun Long.toRupiah(): String = String.format(Locale.forLanguageTag("id-ID"), "Rp %,d", this)

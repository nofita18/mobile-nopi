package com.example.nopi_swirl.tugas_2

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.nopi_swirl.R

class SecondActivity : AppCompatActivity() {

    // Deklarasi komponen UI
    private lateinit var inputAlas: EditText
    private lateinit var inputTinggi: EditText
    private lateinit var inputSisi: EditText
    private lateinit var btnHitungSegitiga: Button
    private lateinit var btnHitungKubus: Button
    private lateinit var hasilSegitiga: TextView
    private lateinit var hasilKubus: TextView

    companion object {
        private const val TAG = "SecondActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Inisialisasi komponen
        initComponents()

        // Pasang event listener
        setupEventListeners()

        // Log info
        Log.d(TAG, "=== APLIKASI KALKULATOR DIMULAI ===")
        Log.d(TAG, "Package: com.example.tugas2")
        Log.d(TAG, "SecondActivity berhasil dimuat")

        // Toast selamat datang
        Toast.makeText(this, "Selamat datang di Kalkulator Bangun Datar & Ruang!", Toast.LENGTH_LONG).show()
        val title = intent.getStringExtra("TITLE")
        val desc = intent.getStringExtra("DESC")

        Toast.makeText(this, "$title - $desc", Toast.LENGTH_SHORT).show()
    }

    private fun initComponents() {
        inputAlas = findViewById(R.id.inputAlas)
        inputTinggi = findViewById(R.id.inputTinggi)
        inputSisi = findViewById(R.id.inputSisi)
        btnHitungSegitiga = findViewById(R.id.btnHitungSegitiga)
        btnHitungKubus = findViewById(R.id.btnHitungKubus)
        hasilSegitiga = findViewById(R.id.hasilSegitiga)
        hasilKubus = findViewById(R.id.hasilKubus)

        Log.d(TAG, "Inisialisasi komponen UI berhasil")
    }

    private fun setupEventListeners() {
        // Event listener untuk tombol hitung segitiga
        btnHitungSegitiga.setOnClickListener {
            Log.i(TAG, "========== TOMBOL HITUNG SEGITIGA DITEKAN ==========")
            hitungLuasSegitiga()
        }

        // Event listener untuk tombol hitung kubus
        btnHitungKubus.setOnClickListener {
            Log.i(TAG, "========== TOMBOL HITUNG KUBUS DITEKAN ==========")
            hitungVolumeKubus()
        }

        Log.d(TAG, "Event listeners berhasil dipasang")
    }

    /**
     * FUNGSI MENGHITUNG LUAS SEGITIGA
     * Rumus: Luas = 1/2 × alas × tinggi
     */
    private fun hitungLuasSegitiga() {
        try {
            // Ambil nilai dari EditText
            val alasText = inputAlas.text.toString().trim()
            val tinggiText = inputTinggi.text.toString().trim()

            Log.d(TAG, "Input Alas: '$alasText'")
            Log.d(TAG, "Input Tinggi: '$tinggiText'")

            // Validasi input kosong
            when {
                alasText.isEmpty() -> {
                    Toast.makeText(this, "❌ Alas tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "VALIDASI GAGAL: Alas kosong")
                    return
                }
                tinggiText.isEmpty() -> {
                    Toast.makeText(this, "❌ Tinggi tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "VALIDASI GAGAL: Tinggi kosong")
                    return
                }
            }

            // Konversi ke Double
            val alas = alasText.toDouble()
            val tinggi = tinggiText.toDouble()

            Log.d(TAG, "Konversi: alas=$alas, tinggi=$tinggi")

            // Validasi nilai positif
            when {
                alas <= 0 -> {
                    Toast.makeText(this, "❌ Alas harus lebih dari 0!", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "VALIDASI GAGAL: alas=$alas (<=0)")
                    return
                }
                tinggi <= 0 -> {
                    Toast.makeText(this, "❌ Tinggi harus lebih dari 0!", Toast.LENGTH_SHORT).show()
                    Log.w(TAG, "VALIDASI GAGAL: tinggi=$tinggi (<=0)")
                    return
                }
            }

            // Hitung luas segitiga
            val luas = 0.5 * alas * tinggi

            // Format hasil (2 angka desimal)
            val hasilText = String.format("📐 Hasil Luas Segitiga: %.2f cm²", luas)
            hasilSegitiga.text = hasilText

            // Tampilkan toast
            Toast.makeText(this, "✅ Luas Segitiga = %.2f cm²".format(luas), Toast.LENGTH_SHORT).show()

            // Log hasil
            Log.i(TAG, "PERHITUNGAN SUKSES: Luas Segitiga = $luas cm²")
            Log.i(TAG, "Rumus: 1/2 × $alas × $tinggi = $luas")

        } catch (e: NumberFormatException) {
            Log.e(TAG, "ERROR: Format angka tidak valid - ${e.message}")
            Toast.makeText(this, "⚠️ Masukkan angka yang valid (contoh: 10.5)", Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * FUNGSI MENGHITUNG VOLUME KUBUS
     * Rumus: Volume = sisi × sisi × sisi (sisi³)
     */
    private fun hitungVolumeKubus() {
        try {
            // Ambil nilai dari EditText
            val sisiText = inputSisi.text.toString().trim()

            Log.d(TAG, "Input Sisi: '$sisiText'")

            // Validasi input kosong
            if (sisiText.isEmpty()) {
                Toast.makeText(this, "❌ Sisi tidak boleh kosong!", Toast.LENGTH_SHORT).show()
                Log.w(TAG, "VALIDASI GAGAL: Sisi kosong")
                return
            }

            // Konversi ke Double
            val sisi = sisiText.toDouble()

            Log.d(TAG, "Konversi: sisi=$sisi")

            // Validasi nilai positif
            if (sisi <= 0) {
                Toast.makeText(this, "❌ Sisi harus lebih dari 0!", Toast.LENGTH_SHORT).show()
                Log.w(TAG, "VALIDASI GAGAL: sisi=$sisi (<=0)")
                return
            }

            // Hitung volume kubus
            val volume = sisi * sisi * sisi

            // Format hasil (2 angka desimal)
            val hasilText = String.format("📦 Hasil Volume Kubus: %.2f cm³", volume)
            hasilKubus.text = hasilText

            // Tampilkan toast
            Toast.makeText(this, "✅ Volume Kubus = %.2f cm³".format(volume), Toast.LENGTH_SHORT).show()

            // Log hasil
            Log.i(TAG, "PERHITUNGAN SUKSES: Volume Kubus = $volume cm³")
            Log.i(TAG, "Rumus: $sisi × $sisi × $sisi = $volume")

        } catch (e: NumberFormatException) {
            Log.e(TAG, "ERROR: Format angka tidak valid - ${e.message}")
            Toast.makeText(this, "⚠️ Masukkan angka yang valid (contoh: 5.5)", Toast.LENGTH_SHORT).show()
        }
    }
}
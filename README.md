# Crab Mod (Fabric) - Java Edition

Mod ini menambahkan mob Crab (mob yang batal rilis di Mob Vote 2023) ke Minecraft Java Edition,
menggunakan Fabric Loader.

Target: **Minecraft 1.21.10**, Fabric Loader 0.19.3+, Fabric API 0.138.4+1.21.10, Java 21.
(Disesuaikan dengan instance ZalithLauncher kamu: "1.21.10 Fabric 0.19.3".)

## Cara build (WAJIB dilakukan di PC, butuh internet)

1. Install **JDK 21** (Temurin/Adoptium direkomendasikan).
2. Buka folder project ini di **IntelliJ IDEA** (disarankan) atau terminal.
3. Jalankan:
   - Windows: `gradlew.bat build`
   - Mac/Linux: `./gradlew build`
4. Tunggu proses selesai (kali pertama akan download banyak dependency, bisa 5-15 menit).
5. Hasil file mod ada di: `build/libs/crabmod-1.0.0.jar`

> Catatan: repo ini belum menyertakan `gradlew`/`gradle-wrapper.jar` (perlu internet untuk
> generate). Kalau belum ada wrapper, jalankan dulu `gradle wrapper` (butuh Gradle terpasang),
> atau buka project di IntelliJ dan biarkan IDE yang mengurus wrapper-nya otomatis.

## Cara pasang ke HP (Zalith Launcher / Fabric)

1. Pastikan sudah install **Fabric Loader 0.19.3** untuk Minecraft 1.21.10 di launcher-mu (ZalithLauncher).
2. Pastikan juga sudah pasang **Fabric API 0.138.4+1.21.10** (mod dependency wajib).
3. Salin `crabmod-1.0.0.jar` hasil build ke folder `mods/` instance Minecraft di launcher.
4. Jalankan Minecraft seperti biasa.

## Isi mod
- Mob **Crab** (passive, muncul lewat spawn egg atau `/summon crabmod:crab`), bisa berenang,
  kabur dari pemain, jalan-jalan acak, breeding pakai Kelp.
- Item **Crab Claw** — hasil drop dari Crab (belum ada mekanik reach khusus seperti versi
  Bedrock; kalau mau, kasih tau nanti aku tambahkan pakai event Fabric API).
- Tekstur & warna disamakan dengan versi addon Bedrock supaya konsisten.

## Kalau build gagal
Karena kode ini ditulis tanpa proses compile-test langsung (lingkunganku tidak
punya akses internet untuk Gradle), ada kemungkinan kecil butuh penyesuaian minor
kalau ada API yang berubah di build Minecraft/Yarn tertentu. Kalau muncul error saat
build, screenshot error-nya dan kirim ke aku, nanti aku bantu perbaiki.

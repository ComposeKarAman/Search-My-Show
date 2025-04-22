# SearchMyShow 🎥🔍

SearchMyShow is an Android application that allows users to search for movies, TV shows, or series using the OMDB API. The app is built using **Kotlin**, **Jetpack Compose**, and **Retrofit** for seamless UI and network operations.

## ✨ Features

- 🔎 **Search** for movies, TV shows, or series by title.
- 🖼️ Display search results in a **grid layout** with movie posters and titles.
- ⚠️ **Error handling** for failed API requests.
- ⏳ **Loading indicator** while fetching data.

## 🛠️ Tech Stack

- **Kotlin**: Primary programming language.
- **Jetpack Compose**: For building the UI.
- **Retrofit**: For making network requests.
- **Coil**: For loading and displaying images.
- **ViewModel**: For managing UI-related data in a lifecycle-conscious way.

## 📋 Prerequisites

- 🖥️ Android Studio Meerkat | 2024.3.1 Patch 2 or later.
- 📱 Minimum SDK: 24
- 🎯 Target SDK: 35
- 🌐 Internet permission enabled in `AndroidManifest.xml`.

## 🚀 Setup Instructions

1. Clone the repository:
   ```bash
   git clone https://github.com/ComposeKarAman/SearchMyShow.git
   ```
2. Open the project in Android Studio.
3. Sync the Gradle files.
4. Run the app on an emulator or a physical device.

## 🔑 API Key

The app uses the OMDB API. Replace the `apikey` in `MovieViewModel.kt` with your own API key:
```kotlin
private val apikey = "your_api_key_here"
```

## 📦 Dependencies

The project uses the following dependencies:
- Retrofit: `com.squareup.retrofit2:retrofit:2.11.0`
- Gson Converter: `com.squareup.retrofit2:converter-gson:2.11.0`
- Coil: `io.coil-kt:coil-compose:2.4.0`
- Jetpack Compose libraries.

## 📸 Screenshots

| 🔍 Search Screen | 🎥 Results Grid |
|------------------|----------------|
| ![Search Screen](https://via.placeholder.com/150) | ![Results Grid](https://via.placeholder.com/150) |

## 📝 License

This project is licensed under the MIT License. See the `LICENSE` file for details.

---

🎉 **Enjoy exploring movies and shows with SearchMyShow!**

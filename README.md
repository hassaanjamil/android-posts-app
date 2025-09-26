# Sample Android Posts App

An open-source **Android Kotlin Jetpack Compose** sample that demonstrates how to build a modern posts feed backed by a REST API. The project showcases **Navigation 3**, **Koin dependency injection**, **Retrofit/OkHttp networking**, and a clean UI layer powered by **Material 3**. Clone it, run it, and ⭐️ star it if it inspires your next app!

## Table of Contents
- [Highlights](#highlights)
- [Architecture Overview](#architecture-overview)
- [Tech Stack](#tech-stack)
- [Project Structure](#project-structure)
- [Getting Started](#getting-started)
- [Local API Notes](#local-api-notes)
- [Roadmap Ideas](#roadmap-ideas)
- [Contributing](#contributing)

## Highlights
- 100% Kotlin with Jetpack Compose UI and Material 3 theming.
- Navigation orchestrated by the new Navigation 3 back stack with custom nav keys.
- Reactive UI fed by coroutines and immutable state collections.
- Koin modules wire up Retrofit, repositories, and ViewModels for quick DI bootstrapping.
- Retrofit + OkHttp + Gson deliver a simple, testable networking stack hitting `http://10.0.2.2:3000/posts` in the Android emulator.
- Modern Gradle setup (Kotlin DSL, version catalogs) ready for experimentation or production hardening.

## Architecture Overview
```
ApplicationPosts (starts Koin) ──> Koin Modules (network, repository, viewModel)
          │
          ├─> RetrofitClient (base networking layer)
          ├─> PostRepository (data access + mapping)
          └─> PostViewModel (state holder using coroutines)
                         │
                         └─> Compose UI (PostsMain ➜ PostsList ➜ PostDetail)
```

- **State Management:** `PostViewModel` exposes Compose-friendly state via `mutableStateListOf`, cleared and filled on each fetch.
- **Navigation:** `NavigationRoot` drives a back stack of `Screen` nav keys (`PostsList`, `PostDetail`), keeping state with Navigation 3 decorators.
- **UI Layer:** `PostsMain` consumes the ViewModel using `koinViewModel()` and renders list/detail composables with Material 3 components.

## Tech Stack
- Kotlin 2.1.10
- Jetpack Compose + Material 3
- Navigation 3 (runtime, UI, lifecycle ViewModel integration)
- Koin 3.5.6 for dependency injection (android + compose extensions)
- Retrofit 3 + OkHttp 5.1 with Gson converter
- Kotlinx Serialization (used for navigation key persistence)
- Coroutines + ViewModel scope

## Project Structure
```
app/
 ├─ src/main/java/com/hassanjamil/sampleandroidpostsapp
 │   ├─ ApplicationPosts.kt          # Koin bootstrap
 │   ├─ navigation/                  # NavigationRoot + Screen nav keys
 │   ├─ features/posts/              # Feature module
 │   │   ├─ data/                    # Repository + models
 │   │   └─ ui/                      # Compose screens + ViewModel
 │   └─ di/                          # Koin modules (network, repository, viewModel)
 └─ ...
```

## Getting Started
1. **Clone** the repository:
   ```bash
   git clone https://github.com/hassaanjamil/SampleAndroidPostsApp.git
   cd SampleAndroidPostsApp
   ```
2. **Start the local API** (any JSON server returning posts at `http://localhost:3000/posts`). When running on the Android emulator, this becomes `http://10.0.2.2:3000/posts`.
3. **Sync & Build** inside Android Studio (Giraffe+), or from the CLI:
   ```bash
   ./gradlew assembleDebug
   ```
4. **Run** the app on an emulator or device. Tap a card to view post details inside the Compose navigation flow.

### Requirements
- Android Studio Koala / latest stable tooling
- Android Gradle Plugin 8.10.0-beta01 or newer
- JDK 11+

## Local API Notes
- The sample expects a CRUD endpoint returning Post objects (`id`, `title`, `body`, `userId`).
- Need instant mock data? Spin up a JSON Server:
  ```bash
  npx json-server --watch db.json --port 3000
  ```
  with a `db.json` shaped like:
  ```json
  {
    "posts": [
      { "id": 1, "title": "Compose Rocks", "body": "Declarative UI on Android.", "userId": 1 }
    ]
  }
  ```

## Roadmap Ideas
- Offline caching with Room and Koin scopes.
- UI tests using Compose Testing APIs.
- Post creation/edit flows leveraging Navigation 3 scenes.
- Theme switching + responsive layouts with Material 3 adaptive libraries.

## Contributing
Pull requests, issues, and ideas for new features are always welcome. If this **Android Jetpack Compose + Koin retrofit sample** helps your project or saved you some time, please:

1. ⭐️ **Star the repo** to support continued development.
2. Share it with fellow Android developers exploring modern toolchains.

Happy coding!

# Sample Android Posts App

An open-source **Android Kotlin Jetpack Compose** sample that demonstrates how to build a modern posts feed backed by a REST API using a layered, test-ready **Clean Architecture** approach. The project showcases **Navigation 3**, **Koin dependency injection**, **Retrofit/OkHttp networking**, and a clean UI layer powered by **Material 3**. Clone it, run it, and ⭐️ star it if it inspires your next app!

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
- Reactive UI fed by coroutines, `StateFlow`, and immutable Compose state collections driven by domain use-cases.
- Koin modules wire up Retrofit, Room favorites, domain repositories, use cases, and presentation ViewModels.
- Retrofit + OkHttp + Gson deliver a simple, testable networking stack hitting `http://10.0.2.2:3000/posts` in the Android emulator.
- Post detail screen resolves author information on-demand by calling the user endpoint and observing a `StateFlow`-backed state holder.
- Modern Gradle setup (Kotlin DSL, version catalogs) ready for experimentation or production hardening.

## Architecture Overview
```
MyApplication (starts Koin)
        │
        ├─ data/di Modules (Retrofit, Room, repository implementations)
        ├─ domain/di Modules (use cases, repository contracts)
        └─ presentation ViewModels (consume use cases)
                │
                └─ Compose UI (Home ➜ PostsList ➜ PostDetail + Favorite/Profile scenes)
```

- **State Management:** `PostViewModel` (presentation layer) exposes Compose-friendly state via `mutableStateListOf` for posts and `StateFlow` for the selected author, relying on domain use-cases (`GetPosts`, `GetUserById`).
- **Navigation:** `RootGraph` + `NestedBottomBarGraph` drive the Navigation 3 back stack with serializable nav keys (`RootScreen`, `BottomBarScreen`).
- **UI Layer:** Composables use `koinViewModel()` helpers and themed Material 3 surfaces, while favorites toggle instantly via domain logic.

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
 │   ├─ MyApplication.kt             # Koin bootstrap
 │   ├─ data/                        # Infrastructure (Retrofit, Room, mappers, impl repos)
 │   │   ├─ di/                      # Network/DB/repository modules
 │   │   ├─ mapper/                  # DTO ↔ domain translators
 │   │   ├─ model/                   # Retrofit DTOs & Room entities
 │   │   └─ repositories/            # Post/User repository implementations
 │   ├─ domain/                      # Clean domain layer
 │   │   ├─ di/                      # Use-case module
 │   │   ├─ model/                   # `Post`, `User` entities (Serializable for Navigation)
 │   │   ├─ repository/              # Repository interfaces
 │   │   └─ usecase/                 # `GetPosts`, `GetUserById`, `GetFavoritePosts`, `ToggleFavoritePost`
 │   └─ presentation/                # UI + ViewModels
 │       ├─ navigation/              # RootGraph/NestedBottomBarGraph + nav keys
 │       └─ features/                # Feature-specific screens & ViewModels (home, favorites, profile, post detail)
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

  > For more details, have a look at my open source Rest API Project:
  https://github.com/hassaanjamil/npm-sample-posts-rest-api
Configure it, following the instructions and run the local server to make this android app works for you.

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

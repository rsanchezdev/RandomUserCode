# RandomUserCode
RandomUserCode is an app that recolects users from https://randomuser.me/

## Architecture
RandomUsercode is based on the MVVM architecture (View - DataBinding - ViewModel - Model).
The overall architecture of this project is composed of four layers:
- UI layer
- Use Cases layer
- Domain layer
- Data layer

Each layer has dedicated components and they have each different responsibilities.

## Tech Stack

- Minimum SDK level 24
- Kotlin based, Coroutines + Flow for asynchronous.
- Lifecycle: Observe Android lifecycles and handle UI states upon the lifecycle changes.
- ViewModel: Manages UI-related data holder and lifecycle aware. Allows data to survive configuration changes such as screen rotations.
- DataBinding: Binds UI components in your layouts to data sources in your app using a declarative format rather than programmatically.
- Hilt: for dependency injection.
- Retrofit2 & OkHttp3: Construct the REST APIs and paging network data.
- Turbine: A small testing library for kotlinx.coroutines Flow.
- Material-Components: Material design components for building ripple animation, and CardView.
- Glide: Loading images from network.
- JUnit & Mockito: for testing.

## Screenshots
<img src="https://github.com/rsanchezdev/RandomUserCode/assets/50987394/4a8bc677-cf60-4422-83f4-eea7207bf18b" alt="MainView" style="height: 30%; width:30%;"/>   <img src="https://github.com/rsanchezdev/RandomUserCode/assets/50987394/849e757b-740e-4c3d-9b85-25d653374bbe" alt="MainView Search" style="height: 30%; width:30%;"/>   <img src="https://github.com/rsanchezdev/RandomUserCode/assets/50987394/b59264fd-3f6b-4916-b2b7-605c3b605f68" alt="DetailView" style="height: 30%; width:30%;"/>



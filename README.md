# Clean Architecture - MyDictionary App

<img src="https://github.com/khasang12-khmt/CleanArch_DictionaryApp/assets/80106348/a8392811-eb52-4f5c-8a4e-76d0eb7b1553" alt="Your image title" width="500"/>

## Tech Stack
* Clean Architecture with MVVM and DI with Dagger2
* Modern UI with Jetpack Compose
* Local Database for Caching: Room and SQLite
* Remote API: Retrofit
* Reactive Programming: Flow and Coroutine
* Other: Offline Connection Check, Caching

## Screenshot

<img src="https://github.com/khasang12-khmt/CleanArch_DictionaryApp/assets/80106348/18fda7b6-b07d-48c1-820d-43711aabd65c" alt="Your image title" width="300"/>
<img src="https://github.com/khasang12-khmt/CleanArch_DictionaryApp/assets/80106348/641e3135-5bea-45da-bdb0-53b4eecbcb99" alt="Your image title" width="300"/>

## Architecture Details
![image](https://github.com/khasang12-khmt/CleanArch_DictionaryApp/assets/80106348/9b05ea38-d96d-4003-a0e4-d13c0616a21e)

* Core: Contains files and folders that are independent of Application. I implemented Resource.kt "sealed class" as Object Wrapper in the /util subfolder.
* Feature: Features should be separated as distinct folders, each of which would have three different layers (Data - Domain - Presentation)
  * Data: Contains Enterprise Logic - data classes that communicate directly to the DB (local) or API (remote)
    * Local: Contains DB connector, DAO queries and Converters (if your app has compound datatypes). Entity classes are also located in this folder and act as the mediator between DB models and data from other layers.
    * Remote: Contains API queries interface and DTO (Data Transfer Objects). DTOs act as the mediator between data from API and data from other layers.
    * Repository: A centralized class that implements all functions that other layers need from Data Layer. The function will then retrieve methods/ instances from local or remote folders to return the results.
    * Util: Contains some addition functions such as Parser.
  * Domain: Contains Application Logic that are described as use-cases
    * Model: Contains data classes that will be displayed to the UI.
    * Repository: Defines interfaces that Data layer should implement.
    * Use Case: Contains designed use cases that interacts with Repository to connect to Data Layer. Presentation Layer will need to call these classes to get data.
  * Presentation: Contains classes that will display the data to the end users. This layer comprises of UI files (Jetpack Compose) and ViewModels that interact with Use Cases.
* Other Root UI files: UI.Theme, MainActivity,..





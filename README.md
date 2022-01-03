# CreatureMon

The primary  purpose of CreatureMon is to demonstrate MVVM structure in an Android application with additional libraries and tools. 
That is the reason  why the application has such a simple UI. Below you can see the components that are used in the application.

## Meaning & Purpose of MVVM :dart:

MVVM(Model-View-ViewModel) is an architectural pattern which provides a key benefit: [Separation of Concerns](https://en.wikipedia.org/wiki/Separation_of_concerns).
 - Model: It holds the data of the application but it can't directly communicate with View. 
 - View: It holds the UI and informs the ViewModel about the user’s action. View observes the changes in the ViewModel and it is updated accordingly. Also,
 it is important that View shouldn't contain any kind of application logic.
 - ViewModel: It provides communication between View and Model/Repository as if a bridge. It is responsible for delivering the data, which is coming from Model to View. 
 ViewModel does not hold any kind of reference to the View as if "Context". Eventually, that makes testing easier since it doesn't require Android Framework for testing.  
 **Bonus**  
 - Repository: Even though it is optional Repository pattern is commonly used with MVVM in large projects. If we have multiple data sources such as local(RoomDB) and 
 remote(Retrofit) it is meaningful to use Repository since it manages multiple data sources. Basically Repository hides the details of how the data is eventually 
 stored or retrieved to and from the data source.  
 
 With lots of abstraction we can think of MVVM in such a way: Our friend(View/UI) wants to make dinner but needs ingredients(data) and he/she asks us to get the ingredients to him/her.
 We(ViewModel) go to market and ask the market owner(repository/model) about these ingredients. The market owner decides where he/she will provide and get these ingredients(RoomDB, 
 Retrofit, SharedPreferences...) and gives us(ViewModel) the ingredients(data). Eventually, we give the ingredients to our friend.  
 
 **Key Point:** Our friend doesn't know where we get the ingredients, he/she just prepares the dinner. We don't know where the market owner get the ingredients, 
 we just get them and give them to our friend.
 
 **Benefits**
  - Separation of Concerns
  - Easier testing
  - Easier maintainability
  - Easier UI updates
 
<img src="/readme_images/mvvm_structure.jpg" width="500" height="375">

## Libraries & Components :hammer_and_wrench:

- [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/)
- [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel)
- [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
- [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview)
  - [ItemTouchHelper](https://developer.android.com/reference/androidx/recyclerview/widget/ItemTouchHelper)
  - [EdgeEffectFactory](https://developer.android.com/reference/androidx/recyclerview/widget/RecyclerView.EdgeEffectFactory)
- [Data Binding](https://developer.android.com/topic/libraries/data-binding)
  - [Binding Adapters](https://developer.android.com/topic/libraries/data-binding/binding-adapters)
- [RoomDB](https://developer.android.com/training/data-storage/room)
  - [Type Converters](https://developer.android.com/training/data-storage/room/referencing-data)
- [Retrofit](https://square.github.io/retrofit/)
  - REST API: [The Rick and Morty API](https://rickandmortyapi.com)
- [Picasso](https://square.github.io/picasso/)

## File Structure :open_file_folder:

![file_structure](/readme_images/file_structure.png)






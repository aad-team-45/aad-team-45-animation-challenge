# aad-team-45-animation-challenge

## Introduction.
aad-team-45-animation-challenge is an ebook recommender android app that displays list of ebook on various IT fields base on a user preference. Users can add a book to his favourite list.
_______________________________________________________
## Functionality
The app is consisted of a Splash screen, ItTopicsFragment, listOfEbooksFragment and an EbookDetailsFragment.
#### ItTopicsFragment
This fragment displays some common core topics in programming.
#### ListOfEbooksFragment
This fragment displays the list of ebooks base on The topics the user selects from the ItTopicsFragment.
####  EbookDetailsFragment
This fragment displays the details of a book selected by the user.
_____________________________________________________________________________

# Structure
This app use **MVVM** (Model-View-ViewModel) pattern using Google's lifecycle Architecture components **LiveData, ViewModel, Room, Databinding**
#### Component interaction
The source of data is either from BookService or from our Database. Using MVVM we have various sections which are reflected by the packages.
* #### View: 
    Activity/Fragment in the **ui** package.
* #### Model:
    consist of the files in the following packages: *repository, api, db*. The app is meant to work offline too, using a NetworkBoundResource file which checks if we have local data else retrieve them from BookService.
* #### ViewModel: 



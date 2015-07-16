# LoaderExample
Example of how to use a Loader object in Android

1. init a loader with the LoaderManager (third parameter, your callbacks)
2. in the createLoader - return a Loader class
3. in the loader class itself - extends the Loader class and implement your network code in the background method
4. override the onStartLoading method in the Loader class and check if your network result allready exist. If not forceLoad the Loader.
(This must be done, otherwise without the ForceLoad the Loader wouldnt start and without the check, the Loader will allways be called, for let say an orientation change because you FORCEload the Loader.)
5. in the onfinish callback method, do what you want with the results. 



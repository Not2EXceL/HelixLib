**Helix Lib**
===================
This library is a compilation of  utilities and frameworks to be used in mainly Minecraft related plugins, however, there'll most likely be a non-Minecraft related branch as well.

##Authors
- Richmond Steele aka Not2EXceL, nasm
- Carter Gale aka Ktar5
- Stilldabomb

###Event System - Not2EXceL
This event system is designed for ease of triggering events and dispatching to a set of prioritized subscribers.  
Supports both annotated and direct subscription.
Has limited testing done for concurrency support, however it is implemented.  Note: the concurrency support follows an extremely basic model, and the system should be extended for any specific concurrency model

###Module System - Not2EXceL
This module system is in essence a plugin system.  However, due to conflicts with naming and utilization concurrently with another plugin system, the name had to be changed.
This allows modularity support throughout the application.  Currently the simple state only allows basic modules with little to no boilerplate functionality.  However, there is dynamic loading functionality to retrieve and load modules from within the running application and/or from external directories.

###ClassEnumerator - Not2EXceL
This class is of special importance in the module system.  However, its functionality is not limited to that.
Contains a series of utility methods to load and map classes from internal jars and/or external directories.
Loaded classes are mapped as such: package name -> a collection object housing classes

###Minecraft Utilities Branch - Ktar5
This array of utilities is directly for interfacing with Minecraft. It's functions help tremendously when going through simple, but annoyingly repetetive tasks such as commands. As well, it contains a load of less-used functions that are little hacks through the Minecraft code that are there for reference when needed, as to avoid recoding the systems.

# Assigment 2 Pokemon Object Hierarchy
## Due October, 10th
----
### Build an Object Oriented Pokemon Class Hierarchy

Okay, I may have gone a little overboard on how I wanted this to work. Because of that I've done part of the coding 
myself to give you something to start from. This will be a good experience for you to try to read someone else's code and
understand what it is doing.

Your task is to complete an Object Oriented Pokemon design for the Squirtle, Wartortle, Blastoise and the Charmander, Charmaleon, 
Charizard Pokemon species families. This is described by the UML diagram below. The UML image file is also in the 
repository as PokemonUMLDiagram.png

I have implemented everything in blue in the UML diagram. *Instructions continue below image*

![alt text][uml]
[uml]:https://github.com/ICSatKCC/PokemonObjectHierarchy/blob/master/PokemonUMLDiagram.png "Pokemon UML Diagram"

What is included in this repository:
 * Pokemon.java abstract superclass for all Pokemon species
 * Interfaces (representing Pokemon types):
   * FireType.java
   * FlyingType.java
   * GrassType.java
   * PoisonType.java
   * WaterType.java
   These only implement constants that hold two descriptors, color and type as a String and arrays that hold allowed fast and special attacks and their respective power values.

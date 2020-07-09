# Design Patterns Java Aplication
Java aplication for drawing shapes with the implementation of design patterns. 
The application is a project from the course Design Patterns.

Design patterns that were used:
1. MVC
2. Adapter - used for Hexagon shape
3. Command - used for Undo/Redo functionality
4. Prototype - used for Undo/Redo functionality
5. Strategy - used for saving the command log and saving the complete drawing
6. Observer - used for Edit/Delete buttons to move the shape along the z axis 

Shapes that you can draw:
* Point
* Line
* Circle
* Rectangle
* Donut
* Hexagon

You can also select multiple object, modify specific object and delete them.
Each command is recorded in the log. It is possible to save a log or an entire drawing.
There is a possibility to load command by command from the saved log (for that is used button Load Next)

![Image of Yaktocat](https://i.imgur.com/R8Bmq6s.png)

Adding shape:

![Image of Yaktocat](https://i.imgur.com/llapx1l.png)

Selection:

![Image of Yaktocat](https://i.imgur.com/tgcnyw1.png)

Modification:

![Image of Yaktocat](https://i.imgur.com/E1x8QI5.png)

Delete:

![Image of Yaktocat](https://i.imgur.com/HbhykKv.png)

Undo and log of commands:

![Image of Yaktocat](https://i.imgur.com/zulFKbY.png)

Saving painting/log:

![Image of Yaktocat](https://i.imgur.com/m2zktDP.png)

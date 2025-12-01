# Vector-Operations
A simple Java project for performing basic vector operations such as addition, subtraction, magnitude, dot product, and more. Clean code and easy to extend.

# Vector Operations (JavaFX Application)

A JavaFX application for performing vector operations in different coordinate systems. The project supports Cartesian, Cylindrical, and Spherical coordinate systems, and automatically converts all inputs to the Cartesian system before performing calculations.

## Features

* Multiple Coordinate Systems
* Coordinate Conversion
* Vector Operations
* JavaFX GUI
* Formatted Results
* Reset & Exit Buttons

## Supported Operations

Vector Addition and Vector Subtraction.

## Coordinate Systems

Each system has its own class and conversion logic.

## Project Structure

```
vector_operations/
│
├── Vector_Operations.java
├── Cartesian.java
├── Cylendrical.java
└── Spherical.java
```

## Example Conversion

### Cylindrical → Cartesian

```
double x = rho * Math.cos(Math.toRadians(45)) - phi * Math.sin(Math.toRadians(45));
double y = rho * Math.sin(Math.toRadians(45)) + phi * Math.cos(Math.toRadians(45));
double z = z;
```

### Spherical → Cartesian

```
double x = r * Math.sin(Math.toRadians(45)) * Math.cos(Math.toRadians(phi))
         + theta * Math.cos(Math.toRadians(45)) * Math.cos(Math.toRadians(phi))
         - phi * Math.sin(Math.toRadians(45));

double y = r * Math.sin(Math.toRadians(45)) * Math.sin(Math.toRadians(phi))
         + theta * Math.cos(Math.toRadians(45)) * Math.sin(Math.toRadians(phi))
         + phi * Math.cos(Math.toRadians(45));

double z = r * Math.cos(Math.toRadians(45)) - theta * Math.sin(Math.toRadians(45));
```
▶️ Running the Application
Requirements

JDK 17 or later
JavaFX SDK
Any IDE: IntelliJ, NetBeans, Eclipse

Run via Command Line
java --module-path /path/to/javafx/lib --add-modules javafx.controls Vector_Operations

📸 Screenshots (Optional)
If you want, send me screenshots and I’ll integrate them nicely here.

🛠️ Possible Future Enhancements

1. Add dot product & cross product
2. Add magnitude and angle calculations
3. Add better cylindrical and spherical conversion formulas
4. Add vector graphical visualization

📜 License

MIT License — free to use, modify, and distribute.

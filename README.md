# Drone Delivery Service

## Algorithm

The algorithm implemented in the solution is a Greedy Algorithm. The Greedy Algorithm makes the best local choice at each step in the hope that these choices will lead to a globally optimal solution. In this case, the algorithm selects the heaviest packages for each drone at each trip to minimize the number of trips.

## Approach

The approach taken in developing the solution is as follows:

1. Read the input file and split the data into drones and locations.
2. Create Drone objects with their maximum weight capacity.
3. Create Location objects with their respective package weights.
4. Sort the locations in descending order based on the package weight.
5. Iterate through the drones and perform deliveries until no more locations are left.
6. For each drone, in each trip, try to fit as many packages as possible without exceeding the drone's maximum weight capacity by selecting the heaviest packages first.
7. Print the output in the required format.

The assumptions made are:

1. The input file is formatted correctly.
2. Time and distance do not matter.
3. There is no maximum limit on the number of deliveries needed.

## Technical Dependencies and Libraries

The project solution does not rely on any external dependencies or libraries. It only uses standard Java libraries available in Java 11, such as `java.nio.file.Files` for reading the input file, `java.nio.file.Path` for defining the file path, and Java Streams API for processing the data.

To write, compile, and execute the code, you can use any Java IDE or text editor that supports Java 11, such as IntelliJ IDEA, Eclipse, or Visual Studio Code. To compile the code, use the Java 11 compiler `javac` with the command `javac DroneDeliveryService.java`, and to execute the compiled code, use the Java 11 runtime `java` with the command `java DroneDeliveryService`.

## Considerations about the input model
The input was changed. The file is already in the project (input.txt and input2.txt) which can be tested and switched changing in the class DroneDeliveryService. To run it, just run the same class.



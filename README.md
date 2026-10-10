# Week 8 — Inheritance and Polymorphism

Java solutions for the Week 8 Category C coding assignment and practice problems. Each program uses a common interface and different implementations to calculate each type's result, then processes the objects through a common reference.

## Coding Assignment

1. [Canteen Billing Counter](Assignment/M1/CanteenBilling.java)
2. [Campus Parking Charge Calculator](Assignment/M2/ParkingCharge.java)
3. [Hostel Electricity Bill](Assignment/M3/ElectricityBill.java)
4. [Festival Bonus Calculator](Assignment/M4/FestivalBonus.java)
5. [Streaming Plan Renewal Reminder](Assignment/M5/StreamingRenewal.java)

## Practice

1. [Payment System Fee Calculation](Practice/M1/PaymentFeeCalculator.java)
2. [Library Item Due Date Calculator](Practice/M2/LibraryDueDate.java)
3. [Delivery Fee Calculator](Practice/M3/DeliveryFeeCalculator.java)
4. [Examination Question Grader](Practice/M4/QuestionGrader.java)
5. [Public Transport Fare Calculator](Practice/M5/TransportFareCalculator.java)

## Compile and run

Open a terminal in the folder containing the chosen Java file. Example:

```bash
javac CanteenBilling.java
java CanteenBilling
```

Provide input in the format shown in the corresponding PDF. For questions with quoted text, keep the quotation marks around each text field.

## Practice PDF quiz answers

1. C — Polymorphism
2. A, B, C
3. C — Runtime method dispatch
4. C — Inheritance-based polymorphism
5. A, C, D
6. A, C
7. C
8. A
9. A, C
10. A, B, C

## Practice PDF concept answers

### 1. How inheritance reuses and extends behavior
Inheritance lets a specialized class receive common fields and methods from a base class. It can reuse methods as they are or override a method to change its behavior. For example, a base `Employee` class can store a name and provide a method, while `FullTimeEmployee` and `Intern` calculate bonuses differently.

### 2. The is-a relationship
An is-a relationship means an object of a derived class is a kind of its base class, such as a Car is a Vehicle. A genuine relationship makes substituting the derived object for the base type sensible. An incorrect relationship creates confusing, rigid designs.

### 3. Method overriding
Method overriding occurs when a derived class provides its own implementation of an inherited instance method with the same signature. For example, `FullTimeEmployee.calculateSalary()` and `ContractEmployee.calculateSalary()` can calculate pay using different rules.

### 4. Runtime polymorphism
Runtime polymorphism means the implementation is selected using the actual object type at runtime. If a `Vehicle` reference refers to a `Car`, calling an overridden method executes the `Car` version.

### 5. Polymorphic collections
A polymorphic collection stores objects of different derived classes using a shared base type, such as a `Vehicle[]` containing `Car` and `Motorcycle` objects. A loop can call the common method on every item, and each object performs its own implementation.

### 6. Polymorphism versus repeated conditionals
Repeated type checks require central code to know every concrete type and be updated whenever a type is added. Polymorphism moves each type's behavior into its own implementation, keeping the processing loop simpler and easier to extend.

### 7. Adding new derived types
A new payment type can extend `PaymentMethod` and override `calculateFee()`. A processor that calls this method on base-type references can handle the new type without changing its iteration logic.

### 8. Inherited versus overridden behavior
Inherited behavior is a method used from the base class without replacing its implementation. Overridden behavior is a derived class's own version of that method. A derived class inherits a method when the shared behavior is correct; it overrides it when its rules differ.

### 9. Why not inherit only for code reuse?
Inheritance implies an is-a relationship. Using it for unrelated classes creates tight coupling, exposes inappropriate behavior, and makes changes risky. Composition or a helper method is often better when one class merely uses another.

### 10. Vehicle rental example
A common `Rental` base class can store customer, duration, and common rental operations. `CarRental` and `TruckRental` can override cost calculation to account for car-specific or truck-specific rates and requirements. The system can process both through a `Rental` reference.
